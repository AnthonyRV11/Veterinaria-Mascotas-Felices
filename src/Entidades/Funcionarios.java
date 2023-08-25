package Entidades;

//Anthony Rodriguez Valverde 18/08/2023
public class Funcionarios extends Persona{

    //Hereda todos los atributos de la clase persona
    //Atributos
    String puesto;
    
    //Constructores
    public Funcionarios(int id,String puesto, String nombre, String apellido1, String apellido2, String cedula, String telefono, String correo, boolean existe) {
        super(id, nombre, apellido1, apellido2, cedula, telefono, correo, existe);
        this.puesto = puesto;
    }
    
    public Funcionarios(String puesto) {
        this.puesto = puesto;
    }
    
    //Metodos de acceso
    
    //Gettter
    public String getPuesto() {
        return puesto;
    }
    
    //Setter
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    //Los metodos abstractos se implementan en la capa acceso a datos

}
