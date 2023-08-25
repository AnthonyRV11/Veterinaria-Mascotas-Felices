
package AccesoDatos;

//Anthony Rodriguez Valverde 24/08/2023

import Config.Config;
import Entidades.Citas;
import Entidades.Funcionarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ADCitas {
     //Atributos
    private Connection _cnn;
    private String _mensaje;
    private int _id;
    
    public String getMensaje(){
        return _mensaje;
    }
    
    public int getId(){
        return _id;
    }
    
    //Constructor
    public ADCitas() throws Exception{
        try{
            String url = Config.getConnectionString();
            _cnn=DriverManager.getConnection(url);
            _mensaje="";
        }catch(Exception ex){
            throw ex;
        }
    }
    
   public int Ingresar(Citas cita) throws SQLException{
    int resultado = -1;
    try {
        CallableStatement csp = _cnn.prepareCall("{call InsertarCita(?,?,?,?,?,?,?)}");
        
        // Parámetros de entrada
        csp.setInt(1, cita.getIdAgenda());
        csp.setTime(2, cita.getHoraCita());
        csp.setInt(3, cita.getIdCliente());
        csp.setDouble(4, cita.getPrecioCita());
        csp.setString(5, cita.getDescripcion());
        
        // Parámetros de salida
        csp.setString(6, "");
        csp.registerOutParameter(6, Types.VARCHAR);
        
        csp.setInt(7, 0);
        csp.registerOutParameter(7, Types.INTEGER);
        
        resultado = csp.executeUpdate();
        
        // Recuperar parámetros de salida
        _mensaje = csp.getString(6);
        _id = csp.getInt(7);
    } catch (Exception e) {
        throw e;
    } finally {
        _cnn = null;
    }
    
    return resultado;
}

     
    //Listar
    public ResultSet Listar(String condicion,String orden) throws SQLException{
        ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_CITA,ID_AGENDA,ID_CLIENTE,HORA_CITA,COSTO,DESCRIPCION_CITA FROM CITAS";
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
    
    
}//Fin de la clase ADCitas
