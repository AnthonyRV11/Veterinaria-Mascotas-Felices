package AccesoDatos;

//Anthony Rodriguez Valverde 23/082023

import Config.Config;
import Entidades.FacturaVenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ADFacturaVenta {
     //Atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
    //Constructor
    public ADFacturaVenta() throws Exception{
        try{
            String url = Config.getConnectionString();
            _cnn=DriverManager.getConnection(url);
            _mensaje="";
        }catch(Exception ex){
            throw ex;
        }
    }
    
    //Metodo para ingresar
    public int ingresar(FacturaVenta factura) throws SQLException{
       int resultado = -1;
       int resultado2;
        try {
            CallableStatement csp = _cnn.prepareCall("{call CrearFacturaVenta(?, ?)}");
        //Parametros de entrada
        csp.setInt(1, factura.getId_Cliente());

        //Preparar variables de salida
        csp.registerOutParameter(2, Types.INTEGER);
        resultado = csp.executeUpdate();

        //Recuperar parametros de salida
        resultado2 = csp.getInt(2);
        } catch (Exception e) {
            throw e;
        }
        finally{_cnn=null;}
        
        return resultado2;
    }//Metodo para ingresar
    
    
    //Listar
     public ResultSet Listar(String condicion,String orden) throws SQLException{
        ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_FACTURA,ID_CLIENTE,TOTAL_PAGO,FECHA_VENTA FROM FACTURA_VENTA";
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
    
    
}//Fin de la clase
