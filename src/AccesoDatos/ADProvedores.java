package AccesoDatos;

//Anthony Rodriguez Valverde 20/08/2023

import Config.Config;
import Entidades.Provedores;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ADProvedores {
    
    //Atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
    //Constructor
    public ADProvedores() throws Exception{
        try{
            String url = Config.getConnectionString();
            _cnn=DriverManager.getConnection(url);
            _mensaje="";
        }catch(Exception ex){
            throw ex;
        }
    }
    
     ////Metodo para listar los provedores
    public ResultSet ListarProveedores_RS(String condicion,String orden) throws SQLException{
        ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_PROVEEDOR,NOMBRE,TELEFONO,CORREO FROM PROVEEDORES";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia,condicion);
            }
            if(!orden.equals("")){
                sentencia = String.format("%s order %s", sentencia,orden);
            }
            rs = stm.executeQuery(sentencia);
        } catch (SQLException ex) {
           throw ex;
        }
        finally{_cnn=null;}
        
        return rs;
    }//Fin metodo para listar provedores
    
    //Metodo para ingresar un provedor nuevo
    public int ingresarProvedor_SP(Provedores provedor) throws SQLException{
       int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call InsertarProveedor(?,?,?,?)}");
            //Parametros de entrada
            csp.setString(1, provedor.getNombre());
            csp.setString(2, provedor.getTelefono());
            csp.setString(3, provedor.getCorreo());
            csp.setString(4, "");
            
            //Preparar variables de salida
            //csp.registerOutParameter(1, Types.INTEGER);
            csp.registerOutParameter(4, Types.VARCHAR);
            resultado = csp.executeUpdate();
            
            //Recuperar parametros de salida
            _mensaje = csp.getString(4);
        } catch (Exception e) {
            throw e;
        }
        finally{_cnn=null;}
        
        return resultado;
    }//Metodo para ingresar provedor
    
    //Metodo para actualizar un provedor 
    public int ActualizarProvedor_SP(Provedores provedor) throws SQLException{
       int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call ActualizarProveedor(?,?,?,?,?)}");
            //Parametros de entrada
            csp.setInt(1, provedor.getId());
            csp.setString(2, provedor.getNombre());
            csp.setString(3, provedor.getTelefono());
            csp.setString(4, provedor.getCorreo());
            csp.setString(5, "");
            
            //Preparar variables de salida
            //csp.registerOutParameter(1, Types.INTEGER);
            csp.registerOutParameter(5, Types.VARCHAR);
            resultado = csp.executeUpdate();
            
            //Recuperar parametros de salida
            _mensaje = csp.getString(5);
        } catch (Exception e) {
            throw e;
        }
        finally{_cnn=null;}
        
        return resultado;
    }//Metodo para actualizar un provedor 
    
    //Metodo para obtener un provedor
     public Provedores obtenerProvedor(String condicion) throws SQLException{
        Provedores provedor = new Provedores();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_PROVEEDOR,NOMBRE,TELEFONO,CORREO FROM PROVEEDORES";
            if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s",sentencia,condicion);
            }
            rs=stm.executeQuery(sentencia);
            if (rs.next()) {
                provedor.setId(rs.getInt(1));
                provedor.setNombre(rs.getString(2));
                provedor.setTelefono(rs.getString(3));
                provedor.setCorreo(rs.getString(4));

            }
        } catch (Exception e) {throw e;}
        finally{_cnn = null;} 
        return provedor;
    }//metodo para obtener un provedor
     
    //Metodo para eliminar un provedor 
     public int eliminarProvedor(Provedores provedor) throws SQLException{
        int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call EliminarProveedor(?,?)}");
            //Parametros de entrada
            csp.setInt(1, provedor.getId());
            csp.setString(2, "");
            
            //Preparar variables de salida
            //csp.registerOutParameter(1, Types.INTEGER);
            csp.registerOutParameter(2, Types.VARCHAR);
            resultado = csp.executeUpdate();
            
            //Recuperar parametros de salida
            _mensaje = csp.getString(2);
        } catch (Exception e) {
            throw e;
        }
        finally{_cnn=null;}
        
        return resultado;
    }//Metodo para eliminar un provedor 
     
}//Fin de la clase ADProvedores
