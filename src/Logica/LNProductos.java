package Logica;

//Anthony Rodriguez Valverde 20/08/2023

import AccesoDatos.ADProductos;
import Entidades.Productos;
import java.sql.ResultSet;


public class LNProductos {
    //Atributos
    private String _mensaje;
    
    //Metodos de acceso
    public String getMensaje() {
        return _mensaje;
    }
    
    //Ingresar un provedor con SP
    public int IngresarProducto_SP(Productos provedor) throws Exception{
        int resultado = 0;
        
        ADProductos adProvedor;
        try {
            adProvedor = new ADProductos();
            resultado = adProvedor.ingresarProducto_SP(provedor);
            _mensaje = adProvedor.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para ingresar un provedor con SP
    
    //Llamar listar de la capa acceso a datos
    public ResultSet ListarProductos_Rs(String condicion,String orden) throws Exception{
        ResultSet rs = null;
        ADProductos adproducto;
        try {
            adproducto = new ADProductos();
            rs = adproducto.ListarProductos_RS(condicion, orden);
        } catch (Exception e) {
            throw e;
        }
        return rs;
    }//Fin listar clientes
    
     //Llamar al obtener de la capa acceso a datos
    public Productos Obtener(String condicion) throws Exception{
        Productos producto;
        ADProductos pro;
        try {    
            pro = new ADProductos();
            producto = pro.obtenerProducto(condicion);
            
            if(producto.isExiste()){
                _mensaje="Producto recuperado";
            }else{
                _mensaje="No existe este producto en la base de datos";
            }
        } catch (Exception e) {
            throw e;
        }
        return producto;
    }//Obtener 
    
    //Eliminar
    public int Eliminar_SP(Productos producto) throws Exception{
        int resultado = 0;
        
        ADProductos adproducto;
        try {
            adproducto = new ADProductos();
            resultado = adproducto.eliminar(producto);
            _mensaje = adproducto.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Eliminar
    
    //Modificar
     public int ActualizarCliente_SP(Productos producto) throws Exception{
        int resultado = 0;
        
        ADProductos adProducto;
        try {
            adProducto = new ADProductos();
            resultado = adProducto.Actualizar(producto);
            _mensaje = adProducto.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//Metodo para Actualizar
    
}//Fin de la clase LNProductos
