package Logica;

import AccesoDatos.ADBitacora;
import AccesoDatos.ADFuncionarios;
import java.sql.ResultSet;


//Anthony Rodriguez Valverde 25/08/2023
public class LNBitacora {
    
    //Cargar
    public ResultSet Listar(String condicion,String orden) throws Exception{
        ResultSet rs = null;
        ADBitacora ad;
        try {
            ad = new ADBitacora();
            rs = ad.Listar(condicion, orden);
        } catch (Exception e) {
            throw e;
        }
        return rs;
    }//Fin listar 
    
}//Fin LNBitacora
