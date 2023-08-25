package Logica;

//Anthony Rodriguez Valverde 24/08/2023

import AccesoDatos.ADClientes;
import AccesoDatos.ADFacturaVenta;
import Entidades.FacturaVenta;
import java.sql.ResultSet;

public class LNFacturaVenta {
    //Atributos
    private String _mensaje;
    
    //Metodos de acceso
    public String getMensaje() {
        return _mensaje;
    }
    
    //Ingresar
    public int Ingresar(FacturaVenta factura) throws Exception{
        int resultado = 0;
        
        ADFacturaVenta ad;
        try {
            ad = new ADFacturaVenta();
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
        ADFacturaVenta adcliente;
        try {
            adcliente = new ADFacturaVenta();
            rs = adcliente.Listar(condicion, orden);
        } catch (Exception e) {
            throw e;
        }
        return rs;
    }//Fin listar 
    
}//Fin de la clase LNFacturaVenta
