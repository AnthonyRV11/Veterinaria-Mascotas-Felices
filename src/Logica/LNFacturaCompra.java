package Logica;

//Anthony Rodriguez Valverde 23/08/2023

import AccesoDatos.ADFacturaCompra;
import AccesoDatos.ADFacturaVenta;
import Entidades.FacturaCompra;
import java.sql.ResultSet;

public class LNFacturaCompra {
    //Atributos
    private String _mensaje;
    
    //Metodos de acceso
    public String getMensaje() {
        return _mensaje;
    }
    
    //Ingresar
    public int Ingresar(FacturaCompra factura) throws Exception{
        int resultado = 0;
        
        ADFacturaCompra ad;
        try {
            ad = new ADFacturaCompra();
            resultado = ad.ingresar(factura);
            //_mensaje = ad.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para ingresar
    
    //Llamar listar de la capa acceso a datos
    public ResultSet Listar(String condicion,String orden) throws Exception{
        ResultSet rs = null;
        ADFacturaCompra adcliente;
        try {
            adcliente = new ADFacturaCompra();
            rs = adcliente.Listar(condicion, orden);
        } catch (Exception e) {
            throw e;
        }
        return rs;
    }//Fin listar 
    
}//Fin clase LNFacturaCompra
