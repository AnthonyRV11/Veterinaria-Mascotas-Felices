package Logica;

//Anthony Rodriguez Valverde 19/08/2023

import AccesoDatos.ADAgenda;
import AccesoDatos.ADCitas;
import Entidades.Citas;
import java.sql.ResultSet;




public class LNCitas {
    //Atributos
    private String _mensaje;
    private int _id;
    
    //Metodos de acceso
    public String getMensaje() {
        return _mensaje;
    }
    
    public int getId(){
        return _id;
    }
    
    //Ingresar
    public int Ingresar(Citas cita) throws Exception{
        int resultado = 0;
        
        ADCitas ad;
        try {
            ad = new ADCitas();
            resultado = ad.Ingresar(cita);
            _mensaje = ad.getMensaje();
            _id = ad.getId();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para ingresar 
    
    //Cargar
    public ResultSet Listar(String condicion,String orden) throws Exception{
        ResultSet rs = null;
        ADCitas ad;
        try {
            ad = new ADCitas();
            rs = ad.Listar(condicion, orden);
        } catch (Exception e) {
            throw e;
        }
        return rs;
    }//Fin listar 
    
}//Fin de la clase LNCitas
