package Logica;

//Anthony Rodriguez Valverde 20/08/2023

import AccesoDatos.ADDetalleFacturaCompra;
import Entidades.DetalleFacturaCompra;
import java.sql.ResultSet;

public class LNDetalleFacturaCompra {
    //Atributos
    private String _mensaje;
    
    //Metodos de acceso
    public String getMensaje() {
        return _mensaje;
    }
    
    //Ingresar
    public int Ingresar(DetalleFacturaCompra de) throws Exception{
        int resultado = 0;
        
        ADDetalleFacturaCompra ad;
        try {
            ad = new ADDetalleFacturaCompra();
            resultado = ad.Ingresar(de);
            _mensaje = ad.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para ingresar 
    
    //Llamar listar de la capa acceso a datos
    public ResultSet Listar(String condicion,String orden) throws Exception{
        ResultSet rs = null;
        ADDetalleFacturaCompra ad;
        try {
            ad = new ADDetalleFacturaCompra();
            rs = ad.ListarP(condicion, orden);
        } catch (Exception e) {
            throw e;
        }
        return rs;
    }//Fin listar clientes
    
    //Llamar al obtener cliente de la capa acceso a datos
    public DetalleFacturaCompra Obtener(String condicion) throws Exception{
        DetalleFacturaCompra detalle;
        ADDetalleFacturaCompra cli;
        try {    
            cli = new ADDetalleFacturaCompra();
            detalle = cli.obtenerProducto(condicion);
            
        } catch (Exception e) {
            throw e;
        }
        return detalle;
    }//Obtener cliente
    
     //Eliminar un cliente con SP
    public int Eliminar(DetalleFacturaCompra detalle) throws Exception{
        int resultado = 0;
        
        ADDetalleFacturaCompra ad;
        try {
            ad = new ADDetalleFacturaCompra();
            resultado = ad.Eliminar(detalle);
            _mensaje = ad.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para eliminar con SP
    
}//Fin de la clase LNDetalleFacturaCompra
