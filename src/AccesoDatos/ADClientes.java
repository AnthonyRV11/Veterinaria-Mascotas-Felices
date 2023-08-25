package AccesoDatos;

//Anthony Rodriguez Valverde 18/08/2023
import Config.Config;
import Entidades.Clientes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ADClientes {
     //Atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
    //Constructor
    public ADClientes() throws Exception{
        try{
            String url = Config.getConnectionString();
            _cnn=DriverManager.getConnection(url);
            _mensaje="";
        }catch(Exception ex){
            throw ex;
        }
    }
    
    ////Metodo para listar los clientes
    public ResultSet ListarClientes_RS(String condicion,String orden) throws SQLException{
        ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_CLIENTE,NOMBRE,APELLIDO1,APELLIDO2,CEDULA,TELEFONO,CORREO FROM CLIENTES";
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
    }//Fin metodo para listar los clientes
    
    //Metodo para obtener un cliente
     public Clientes obtenerCliente(String condicion) throws SQLException{
        Clientes cliente = new Clientes();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_CLIENTE,NOMBRE,APELLIDO1,APELLIDO2,CEDULA,TELEFONO,CORREO FROM CLIENTES";
            if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s",sentencia,condicion);
            }
            rs=stm.executeQuery(sentencia);
            if (rs.next()) {
                cliente.setId(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido1(rs.getString(3));
                cliente.setApellido2(rs.getString(4));
                cliente.setCedula(rs.getString(5));
                cliente.setTelefono(rs.getString(6));
                cliente.setCorreo(rs.getString(7));
            }
        } catch (Exception e) {throw e;}
        finally{_cnn = null;} 
        return cliente;
    }//metodo para obtener un cliente
    
    //Metodo para ingresar un cliente nuevo
    public int ingresarCliente_SP(Clientes cliente) throws SQLException{
       int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call InsertarCliente(?,?,?,?,?,?,?)}");
            //Parametros de entrada
            csp.setString(1, cliente.getNombre());
            csp.setString(2, cliente.getApellido1());
            csp.setString(3, cliente.getApellido2());
            csp.setString(4, cliente.getCedula());
            csp.setString(5, cliente.getTelefono());
            csp.setString(6, cliente.getCorreo());
            csp.setString(7, "");
            
            //Preparar variables de salida
            //csp.registerOutParameter(1, Types.INTEGER);
            csp.registerOutParameter(7, Types.VARCHAR);
            resultado = csp.executeUpdate();
            
            //Recuperar parametros de salida
            _mensaje = csp.getString(7);
        } catch (Exception e) {
            throw e;
        }
        finally{_cnn=null;}
        
        return resultado;
    }//Metodo para ingresar cliente
    
    //Metodo para actualizar un cliente nuevo
    public int actualizarCliente_SP(Clientes cliente) throws SQLException{
       int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call ActualizarCliente(?,?,?,?,?,?,?,?)}");
            //Parametros de entrada
            csp.setInt(1, cliente.getId());
            csp.setString(2, cliente.getNombre());
            csp.setString(3, cliente.getApellido1());
            csp.setString(4, cliente.getApellido2());
            csp.setString(5, cliente.getCedula());
            csp.setString(6, cliente.getTelefono());
            csp.setString(7, cliente.getCorreo());
            csp.setString(8, "");
            
            //Preparar variables de salida
            //csp.registerOutParameter(1, Types.INTEGER);
            csp.registerOutParameter(8, Types.VARCHAR);
            resultado = csp.executeUpdate();
            
            //Recuperar parametros de salida
            _mensaje = csp.getString(8);
        } catch (Exception e) {
            throw e;
        }
        finally{_cnn=null;}
        
        return resultado;
    }//Metodo para actualizar cliente
    
     //Eliminar cliente con SP
    public int EliminarCliente_SP(Clientes cliente) throws SQLException{
       int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call EliminarCliente(?,?)}");
            //Parametros de entrada
            csp.setInt(1, cliente.getId());
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
    }//Eliminar cliente con SP
     
}//Fin de la clase ADClientes
