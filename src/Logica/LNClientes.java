package Logica;

//Anthony Rodriguez Valverde 19/08/2023

import AccesoDatos.ADClientes;
import Entidades.Clientes;
import java.sql.ResultSet;

public class LNClientes {
    //Atributos
    private String _mensaje;
    
    //Metodos de acceso
    public String getMensaje() {
        return _mensaje;
    }
    
    //Llamar listar de la capa acceso a datos
    public ResultSet ListarClientes_Rs(String condicion,String orden) throws Exception{
        ResultSet rs = null;
        ADClientes adcliente;
        try {
            adcliente = new ADClientes();
            rs = adcliente.ListarClientes_RS(condicion, orden);
        } catch (Exception e) {
            throw e;
        }
        return rs;
    }//Fin listar clientes
    
    //Llamar al obtener cliente de la capa acceso a datos
    public Clientes obtenerCliente(String condicion) throws Exception{
        Clientes cliente;
        ADClientes cli;
        try {    
            cli = new ADClientes();
            cliente = cli.obtenerCliente(condicion);
            
            if(cliente.getExiste()){
                _mensaje="Cliente recuperado";
            }else{
                _mensaje="No existe este cliente en la base de datos";
            }
        } catch (Exception e) {
            throw e;
        }
        return cliente;
    }//Obtener cliente
    
    //Ingresar un cliente con SP
    public int IngresarCliente_SP(Clientes cliente) throws Exception{
        int resultado = 0;
        
        ADClientes adcliente;
        try {
            adcliente = new ADClientes();
            resultado = adcliente.ingresarCliente_SP(cliente);
            _mensaje = adcliente.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para ingresar un cliente con SP
    
     //Modificar un cliente con SP
    public int ActualizarCliente_SP(Clientes cliente) throws Exception{
        int resultado = 0;
        
        ADClientes adcliente;
        try {
            adcliente = new ADClientes();
            resultado = adcliente.actualizarCliente_SP(cliente);
            _mensaje = adcliente.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para actualizar un cliente con SP
    
     //Eliminar un cliente con SP
    public int EliminarCliente_SP(Clientes cliente) throws Exception{
        int resultado = 0;
        
        ADClientes adcliente;
        try {
            adcliente = new ADClientes();
            resultado = adcliente.EliminarCliente_SP(cliente);
            _mensaje = adcliente.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para eliminar con SP
    
}//Fin de la clase LNClientes
