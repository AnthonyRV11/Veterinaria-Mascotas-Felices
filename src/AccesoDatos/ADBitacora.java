package AccesoDatos;

import Config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ADBitacora {
      //Atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
    //Constructor
    public ADBitacora() throws Exception{
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
            String sentencia = "SELECT ID_MOVIMIENTO,FECHA,HORA,DESCRIPCION_MOVIMIENTO FROM BITACORA";
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
    
}//Fin ADBitacora
