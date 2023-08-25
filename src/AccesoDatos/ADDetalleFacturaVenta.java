package AccesoDatos;

import Config.Config;
import Entidades.DetalleFacturaVenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ADDetalleFacturaVenta {
    //Atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
    //Constructor
    public ADDetalleFacturaVenta() throws Exception{
        try{
            String url = Config.getConnectionString();
            _cnn=DriverManager.getConnection(url);
            _mensaje="";
        }catch(Exception ex){
            throw ex;
        }
    }
    
    //Ingresar producto
    //Metodo para ingresar
    public int Ingresar(DetalleFacturaVenta detalle) throws SQLException{
       int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call InsertarDetalleVentaProducto(?,?,?,?)}");
            //Parametros de entrada
            csp.setInt(1, detalle.getId_factura());
            csp.setInt(2, detalle.getId_producto());
            csp.setInt(3, detalle.getCantidad());
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
    }//Metodo para ingresar
    
    //Ingresar cita
    public int Ingresar2(DetalleFacturaVenta detalle) throws SQLException{
       int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call InsertarDetalleVentaServicio(?,?,?)}");
            //Parametros de entrada
            csp.setInt(1, detalle.getId_factura());
            csp.setInt(2, detalle.getId_producto());
            csp.setString(3, "");
            //Preparar variables de salida
            //csp.registerOutParameter(1, Types.INTEGER);
            csp.registerOutParameter(3, Types.VARCHAR);
            resultado = csp.executeUpdate();
            
            //Recuperar parametros de salida
            _mensaje = csp.getString(3);
        } catch (Exception e) {
            throw e;
        }
        finally{_cnn=null;}
        
        return resultado;
    }//Metodo para ingresar
    
    ////Metodo para listar
    public ResultSet ListarP(String condicion,String orden) throws SQLException{
        ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_DETALLE_FACTURA_VENTA,ID_FACTURA,ID_PRODUCTO,CANTIDAD_PRODUCTO,FECHA_VENTA,ID_CITA,HORA FROM DETALLE_FACTURA_VENTA";
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
    
}//ADDetalleFacturaVenta
