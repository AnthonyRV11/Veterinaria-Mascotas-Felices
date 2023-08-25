package Logica;

//Anthony Rodriguez Valverde 20/08/2023

import AccesoDatos.ADClientes;
import AccesoDatos.ADProvedores;
import Entidades.Provedores;
import java.sql.ResultSet;

public class LNProvedores {
    //Atributos
    private String _mensaje;
    
    //Metodos de acceso
    public String getMensaje() {
        return _mensaje;
    }
    
     //Llamar listar de la capa acceso a datos
    public ResultSet ListarProveedores_Rs(String condicion,String orden) throws Exception{
        ResultSet rs = null;
        ADProvedores adprovedor;
        try {
            adprovedor = new ADProvedores();
            rs = adprovedor.ListarProveedores_RS(condicion, orden);
        } catch (Exception e) {
            throw e;
        }
        return rs;
    }//Fin listar proveedores
    
    //Ingresar un provedor con SP
    public int IngresarCliente_SP(Provedores provedor) throws Exception{
        int resultado = 0;
        
        ADProvedores adProvedor;
        try {
            adProvedor = new ADProvedores();
            resultado = adProvedor.ingresarProvedor_SP(provedor);
            _mensaje = adProvedor.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para ingresar un provedor con SP
    
    //Actualizar un provedor con SP
    public int ActualizarCliente_SP(Provedores provedor) throws Exception{
        int resultado = 0;
        
        ADProvedores adProvedor;
        try {
            adProvedor = new ADProvedores();
            resultado = adProvedor.ActualizarProvedor_SP(provedor);
            _mensaje = adProvedor.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para Actualizar un provedor con SP
    
    //Llamar al obtener provedor de la capa acceso a datos
    public Provedores obtenerProvedor(String condicion) throws Exception{
        Provedores provedor;
        ADProvedores pro;
        try {    
            pro = new ADProvedores();
            provedor = pro.obtenerProvedor(condicion);
            
            if(provedor.isExiste()){
                _mensaje="Provedor recuperado";
            }else{
                _mensaje="No existe este cliente en la base de datos";
            }
        } catch (Exception e) {
            throw e;
        }
        return provedor;
    }//Obtener provedor
    
    //Eliminar un cliente con SP
    public int EliminarCliente_SP(Provedores provedor) throws Exception{
        int resultado = 0;
        
        ADProvedores adprovedores;
        try {
            adprovedores = new ADProvedores();
            resultado = adprovedores.eliminarProvedor(provedor);
            _mensaje = adprovedores.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para eliminar con SP
    
}//Fin de la clase LNProvedores
