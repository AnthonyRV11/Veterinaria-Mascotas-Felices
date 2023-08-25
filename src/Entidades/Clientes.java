package Entidades;

//Anthony Rodriguez Valverde 18/08/2023
public class Clientes extends Persona{
    //Hereda todos los atributos de la clase persona
    
    //Constructores
    public Clientes(int id, String nombre, String apellido1, String apellido2, String cedula, String telefono, String correo,boolean existe) {
        super(id, nombre, apellido1, apellido2, cedula, telefono, correo, existe);
    }

    public Clientes(){
    }
    
    //Los metodos abstractos se implementan en la capa acceso a datos
}
