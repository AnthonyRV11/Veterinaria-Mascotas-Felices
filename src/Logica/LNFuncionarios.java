package Logica;

//Anthony Rodriguez Valverde 20/08/2023

import AccesoDatos.ADFuncionarios;
import Entidades.Funcionarios;
import java.sql.ResultSet;


public class LNFuncionarios {
    //Atributos
    private String _mensaje;
    
    //Metodos de acceso
    public String getMensaje() {
        return _mensaje;
    }
    
    //Ingresar
    public int Ingresar(Funcionarios funcionario) throws Exception{
        int resultado = 0;
        
        ADFuncionarios ad;
        try {
            ad = new ADFuncionarios();
            resultado = ad.ingresarProducto_SP(funcionario);
            _mensaje = ad.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para ingresar 
    
    //Cargar
    public ResultSet Listar(String condicion,String orden) throws Exception{
        ResultSet rs = null;
        ADFuncionarios ad;
        try {
            ad = new ADFuncionarios();
            rs = ad.Listar(condicion, orden);
        } catch (Exception e) {
            throw e;
        }
        return rs;
    }//Fin listar 
    
    //Obtener
     //Llamar al obtener de la capa acceso a datos
    public Funcionarios Obtener(String condicion) throws Exception{
        Funcionarios funcionario;
        ADFuncionarios fun;
        try {    
            fun = new ADFuncionarios();
            funcionario = fun.Obtener(condicion);
            
            if(funcionario.getExiste()){
                _mensaje="Funcionario recuperado";
            }else{
                _mensaje="No existe este funcionario en la base de datos";
            }
        } catch (Exception e) {
            throw e;
        }
        return funcionario;
    }//Obtener 
    
    //Eliminar
    public int Eliminar_SP(Funcionarios funcionario) throws Exception{
        int resultado = 0;
        
        ADFuncionarios ad;
        try {
            ad = new ADFuncionarios();
            resultado = ad.eliminar(funcionario);
            _mensaje = ad.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Eliminar
    
    //Modificar
     public int Actualizar(Funcionarios funcionario) throws Exception{
        int resultado = 0;
        
        ADFuncionarios ad;
        try {
            ad = new ADFuncionarios();
            resultado = ad.Actualizar(funcionario);
            _mensaje = ad.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para Actualizar

    
}//Fin de la clase LNFuncionarios
