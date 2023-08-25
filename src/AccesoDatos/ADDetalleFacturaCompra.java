package AccesoDatos;

//Anthony Rodriguez Valverde 23/08/2023

import Config.Config;
import Entidades.DetalleFacturaCompra;
import Entidades.Funcionarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ADDetalleFacturaCompra {
    //Atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
    //Constructor
    public ADDetalleFacturaCompra() throws Exception{
        try{
            String url = Config.getConnectionString();
            _cnn=DriverManager.getConnection(url);
            _mensaje="";
        }catch(Exception ex){
            throw ex;
        }
    }
    
    //Metodo para ingresar
    public int Ingresar(DetalleFacturaCompra detalle) throws SQLException{
       int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call InsertarDetalleFacturaCompra(?,?,?)}");
            //Parametros de entrada
            csp.setInt(1, detalle.getId_factura());
            csp.setInt(2, detalle.getId_producto());
            csp.setInt(3, detalle.getCantidad());
            
            //Preparar variables de salida
            //csp.registerOutParameter(1, Types.INTEGER);
            //csp.registerOutParameter(8, Types.VARCHAR);
            resultado = csp.executeUpdate();
            
            //Recuperar parametros de salida
            //_mensaje = csp.getString(8);
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
            String sentencia = "SELECT ID_DETALLE_FACTURA_COMPRA,ID_FACTURA,ID_PRODUCTO,CANTIDAD_PRODUCTO,FECHA_VENTA,HORA FROM DETALLE_FACTURA_COMPRA";
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
     public DetalleFacturaCompra obtenerProducto(String condicion) throws SQLException{
        DetalleFacturaCompra detalle = new DetalleFacturaCompra();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_DETALLE_FACTURA_COMPRA,ID_FACTURA,ID_PRODUCTO,CANTIDAD_PRODUCTO,FECHA_VENTA,HORA FROM DETALLE_FACTURA_COMPRA";
            if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s",sentencia,condicion);
            }
            rs=stm.executeQuery(sentencia);
            if (rs.next()) {
                detalle.setId_Detalle(rs.getInt(1));
                detalle.setId_factura(rs.getInt(2));
                detalle.setId_producto(rs.getInt(3));
                detalle.setCantidad(rs.getInt(4));
                detalle.setFechaVenta(rs.getDate(5));
                detalle.setVenta(rs.getTime(6));
            }
        } catch (Exception e) {throw e;}
        finally{_cnn = null;} 
        return detalle;
    }//metodo para obtener 
     
    //Eliminar 
    public int Eliminar(DetalleFacturaCompra cliente) throws SQLException{
        int resultado = 0;
        try {
            String sentencia = "DELETE DETALLE_FACTURA_COMPRA WHERE ID_DETALLE_FACTURA_COMPRA = ?"; 
            PreparedStatement pstm = _cnn.prepareStatement(sentencia);
            pstm.setInt(1, cliente.getId_Detalle());
            resultado = pstm.executeUpdate();
            if(resultado>0){
                _mensaje = "Detalle eliminado";
            }
        } catch (Exception e) {
            throw e;
        }
        
        return resultado;
    }//Eliminar 
    
}//Fin de la clase ADDetalleFacturaCompra
