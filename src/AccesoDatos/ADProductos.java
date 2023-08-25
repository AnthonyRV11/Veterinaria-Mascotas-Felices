package AccesoDatos;

//Anthony Rodriguez Valverde 18/08/2023
import Config.Config;
import Entidades.Productos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ADProductos {
    //Atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
    //Constructor
    public ADProductos() throws Exception{
        try{
            String url = Config.getConnectionString();
            _cnn=DriverManager.getConnection(url);
            _mensaje="";
        }catch(Exception ex){
            throw ex;
        }
    }
    
    //Metodo para ingresar un producto nuevo
    public int ingresarProducto_SP(Productos producto) throws SQLException{
       int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call InsertarProducto(?,?,?,?)}");
            //Parametros de entrada
            csp.setString(1, producto.getNombre());
            csp.setDouble(2, producto.getPrecio_Compra());
            csp.setInt(3, producto.getCantidad());
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
    }//Metodo para ingresar producto
    
    ////Metodo para listar
    public ResultSet ListarProductos_RS(String condicion,String orden) throws SQLException{
        ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_PRODUCTO,NOMBRE,PRECIO_COMPRA,PRECIO_VENTA,CANTIDAD FROM PRODUCTOS";
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
     public Productos obtenerProducto(String condicion) throws SQLException{
        Productos producto = new Productos();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_PRODUCTO,NOMBRE,PRECIO_COMPRA,PRECIO_VENTA,CANTIDAD FROM PRODUCTOS";
            if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s",sentencia,condicion);
            }
            rs=stm.executeQuery(sentencia);
            if (rs.next()) {
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio_Compra(rs.getDouble(3));
                producto.setPrecio_Venta(rs.getDouble(4));
                producto.setCantidad(rs.getInt(5));
            
            }
        } catch (Exception e) {throw e;}
        finally{_cnn = null;} 
        return producto;
    }//metodo para obtener 
     
    //Metodo para eliminar 
     public int eliminar(Productos producto) throws SQLException{
        int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call BorrarProducto(?,?)}");
            //Parametros de entrada
            csp.setInt(1, producto.getId());
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
    public int Actualizar(Productos producto) throws SQLException{
       int resultado = -1;
        try {
            CallableStatement csp = _cnn.prepareCall("{call ActualizarProducto(?,?,?,?,?)}");
            //Parametros de entrada
            csp.setInt(1, producto.getId());
            csp.setString(2, producto.getNombre());
            csp.setDouble(3, producto.getPrecio_Compra());
            csp.setInt(4, producto.getCantidad());
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
    }//Metodo para actualizar 
    
    
}//Fin de la clase DAProductos
