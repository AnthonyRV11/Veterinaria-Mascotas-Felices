package AccesoDatos;

//Anthony Rodriguez Valverde 20/08/2023

import Config.Config;
import Entidades.Funcionarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;


public class ADFuncionarios {
    
    //Atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
    //Constructor
    public ADFuncionarios() throws Exception{
        try{
            String url = Config.getConnectionString();
            _cnn=DriverManager.getConnection(url);
            _mensaje="";
        }catch(Exception ex){
            throw ex;
        }
    }
    
    //Metodo para ingresar
    public int ingresarProducto_SP(Funcionarios funcionario) throws SQLException{
       int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call InsertarFuncionario(?,?,?,?,?,?,?,?)}");
            //Parametros de entrada
            csp.setString(1, funcionario.getNombre());
            csp.setString(2, funcionario.getApellido1());
            csp.setString(3, funcionario.getApellido2());
            csp.setString(4, funcionario.getCedula());
            csp.setString(5, funcionario.getPuesto());
            csp.setString(6, funcionario.getTelefono());
            csp.setString(7, funcionario.getCorreo());
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
    }//Metodo para ingresar
    
    ////Metodo para listar
    public ResultSet Listar(String condicion,String orden) throws SQLException{
        ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_FUNCIONARIO,NOMBRE,APELLIDO1,APELLIDO2,PUESTO,CEDULA,TELEFONO,CORREO FROM FUNCIONARIOS";
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
    }//Fin metodo para listar
    
    //Metodo para obtener
     public Funcionarios Obtener(String condicion) throws SQLException{
        Funcionarios funcionario = new Funcionarios("");
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_FUNCIONARIO,NOMBRE,APELLIDO1,APELLIDO2,PUESTO,CEDULA,TELEFONO,CORREO FROM FUNCIONARIOS";
            if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s",sentencia,condicion);
            }
            rs=stm.executeQuery(sentencia);
            if (rs.next()) {
                funcionario.setId(rs.getInt(1));
                funcionario.setNombre(rs.getString(2));
                funcionario.setApellido1(rs.getString(3));
                funcionario.setApellido2(rs.getString(4));
                funcionario.setPuesto(rs.getString(5));
                funcionario.setCedula(rs.getString(6));
                funcionario.setTelefono(rs.getString(7));
                funcionario.setCorreo(rs.getString(8));
            }
        } catch (Exception e) {throw e;}
        finally{_cnn = null;} 
        return funcionario;
    }//metodo para obtener 
    
     //Metodo para eliminar 
     public int eliminar(Funcionarios funcionario) throws SQLException{
        int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call BorrarFuncionario(?,?)}");
            //Parametros de entrada
            csp.setInt(1, funcionario.getId());
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
    }//Metodo para eliminar
     
    //Metodo para actualizar 
    public int Actualizar(Funcionarios funcionario) throws SQLException{
       int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call ActualizarFuncionario(?,?,?,?,?,?,?,?,?)}");
            //Parametros de entrada
            csp.setInt(1, funcionario.getId());
            csp.setString(2, funcionario.getNombre());
            csp.setString(3, funcionario.getApellido1());
            csp.setString(4, funcionario.getApellido2());
            csp.setString(5, funcionario.getCedula());
            csp.setString(6, funcionario.getPuesto());
            csp.setString(7, funcionario.getTelefono());
            csp.setString(8, funcionario.getCorreo());
            csp.setString(9, "");
            
            //Preparar variables de salida
            csp.registerOutParameter(9, Types.VARCHAR);
            resultado = csp.executeUpdate();
            
            //Recuperar parametros de salida
            _mensaje = csp.getString(9);
        } catch (Exception e) {
            throw e;
        }
        finally{_cnn=null;}
        
        return resultado;
    }//Metodo para actualizar 
    
}//Fin de la clase ADFuncionarios
