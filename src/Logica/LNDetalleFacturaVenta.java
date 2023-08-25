package Logica;

//Anthony Rodriguez Valverde 20/08/2023

import AccesoDatos.ADDetalleFacturaCompra;
import AccesoDatos.ADDetalleFacturaVenta;
import Entidades.DetalleFacturaVenta;
import java.sql.ResultSet;


public class LNDetalleFacturaVenta {
    //Atributos
    private String _mensaje;
    
    //Metodos de acceso
    public String getMensaje() {
        return _mensaje;
    }
    
    //Ingresar 
    public int Ingresar(DetalleFacturaVenta de) throws Exception{
        int resultado = 0;
        
        ADDetalleFacturaVenta ad;
        try {
            ad = new ADDetalleFacturaVenta();
            resultado = ad.Ingresar(de);
            _mensaje = ad.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para ingresar 
    
    //Ingresar 2
    public int Ingresar2(DetalleFacturaVenta de) throws Exception{
        int resultado = 0;
        
        ADDetalleFacturaVenta ad;
        try {
            ad = new ADDetalleFacturaVenta();
            resultado = ad.Ingresar2(de);
            _mensaje = ad.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para ingresar 
    
     //Llamar listar de la capa acceso a datos
    public ResultSet Listar(String condicion,String orden) throws Exception{
        ResultSet rs = null;
        ADDetalleFacturaVenta ad;
        try {
            ad = new ADDetalleFacturaVenta();
            rs = ad.ListarP(condicion, orden);
        } catch (Exception e) {
            throw e;
        }
        return rs;
    }//Fin listar clientes
    
}//LNDetalleFacturaVenta
