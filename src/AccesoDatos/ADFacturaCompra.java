package AccesoDatos;

//Anthony Rodriguez Valverde 23/082023

import Config.Config;
import Entidades.FacturaCompra;
import Entidades.Funcionarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ADFacturaCompra {
    //Atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
    //Constructor
    public ADFacturaCompra() throws Exception{
        try{
            String url = Config.getConnectionString();
            _cnn=DriverManager.getConnection(url);
            _mensaje="";
        }catch(Exception ex){
            throw ex;
        }
    }
    
    //Metodo para ingresar
    public int ingresar(FacturaCompra funcionario) throws SQLException{
       int resultado = -1;
       int resultado2;
        try {
            CallableStatement csp = _cnn.prepareCall("{call CrearFacturaCompra(?, ?)}");
        //Parametros de entrada
        csp.setInt(1, funcionario.getId_provedor());

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
            String sentencia = "SELECT ID_FACTURA,ID_PROVEEDOR,TOTAL_PAGO,FECHA_VENTA FROM FACTURA_COMPRA";
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
    
}//Fin de la clase ADFacturaCompra
