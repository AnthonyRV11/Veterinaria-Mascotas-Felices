package Logica;

//Anthony Rodriguez Valverde 19/08/2023

import AccesoDatos.ADAgenda;
import Entidades.Agenda;
import java.sql.ResultSet;


public class LNAgenda {
    //Atributos
    private String _mensaje;
    
    //Metodos de acceso
    public String getMensaje() {
        return _mensaje;
    }
    
    //Cargar
    public ResultSet Listar(String condicion,String orden) throws Exception{
        ResultSet rs = null;
        ADAgenda ad;
        try {
            ad = new ADAgenda();
            rs = ad.Listar(condicion, orden);
        } catch (Exception e) {
            throw e;
        }
        return rs;
    }//Fin listar 
    
    //Obtener
     //Llamar al obtener de la capa acceso a datos
    public Agenda Obtener(String condicion) throws Exception{
        Agenda agenda;
        ADAgenda fun;
        try {    
            fun = new ADAgenda();
            agenda = fun.Obtener(condicion);
            
            if(agenda.isExiste()){
                _mensaje="Agenda recuperada";
            }else{
                _mensaje="No existe esta agenda en la base de datos";
            }
        } catch (Exception e) {
            throw e;
        }
        return agenda;
    }//Obtener 
    
    //Ingresar
    public int Ingresar(Agenda agenda) throws Exception{
        int resultado = 0;
        
        ADAgenda ad;
        try {
            ad = new ADAgenda();
            resultado = ad.Ingresar(agenda);
            _mensaje = ad.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para ingresar 
    
     //Eliminar
    public int Eliminar_SP(Agenda agenda) throws Exception{
        int resultado = 0;
        
        ADAgenda ad;
        try {
            ad = new ADAgenda();
            resultado = ad.eliminar(agenda);
            _mensaje = ad.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Eliminar
    
    
}//Fin de la clase LNAgenda
