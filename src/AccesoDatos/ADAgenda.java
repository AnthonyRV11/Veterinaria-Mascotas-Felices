package AccesoDatos;

//Anthony Rodriguez Valverde 22/08/2023

import Config.Config;
import Entidades.Agenda;
import Entidades.Funcionarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ADAgenda {
    //Atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
    //Constructor
    public ADAgenda() throws Exception{
        try{
            String url = Config.getConnectionString();
            _cnn=DriverManager.getConnection(url);
            _mensaje="";
        }catch(Exception ex){
            throw ex;
        }
    }
    
    ////Metodo para listar
    public ResultSet Listar(String condicion,String orden) throws SQLException{
        ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT A.ID_AGENDA, A.ID_FUNCIONARIO, NOMBRE, A.FECHA, A.HORA_ENTRADA, A.HORA_SALIDA FROM AGENDA A JOIN FUNCIONARIOS F ON A.ID_FUNCIONARIO = F.ID_FUNCIONARIO ";
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
     public Agenda Obtener(String condicion) throws SQLException{
        Agenda agenda = new Agenda();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_AGENDA, ID_FUNCIONARIO, FECHA, HORA_ENTRADA, HORA_SALIDA FROM AGENDA";
            if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s",sentencia,condicion);
            }
            rs=stm.executeQuery(sentencia);
            if (rs.next()) {
                agenda.setId(rs.getInt(1));
                agenda.setId_Funcionario(rs.getInt(2));
                agenda.setFecha(rs.getDate(3));
                agenda.setHora_Entrada(rs.getTime(4));
                agenda.setHora_Salida(rs.getTime(5));
            }
        } catch (Exception e) {throw e;}
        finally{_cnn = null;} 
        return agenda;
    }//metodo para obtener 
     
     //Metodo para ingresar
    public int Ingresar(Agenda agenda) throws SQLException{
       int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call InsertarAgenda(?,?,?,?,?)}");
            //Parametros de entrada
            csp.setInt(1, agenda.getId_Funcionario());
            csp.setDate(2, agenda.getFecha());
            csp.setTime(3, agenda.getHora_Entrada());
            csp.setTime(4, agenda.getHora_Salida());
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
    }//Metodo para ingresar 
    
    //Metodo para eliminar 
     public int eliminar(Agenda agenda) throws SQLException{
        int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call BorrarAgenda(?,?)}");
            //Parametros de entrada
            csp.setInt(1, agenda.getId());
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
    
    
    
    
}//Fin de la clase ADAgenda
