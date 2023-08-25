package Entidades;

//Anthony Rodriguez Valverde 22/08/2023

import java.sql.Date;
import java.sql.Time;

public class Agenda {

    //Atributos
    private int id;
    private int id_Funcionario;
    private Date fecha;
    private Time hora_Entrada;
    private Time hora_Salida;
    private boolean existe;
    
    //Constructores
    public Agenda() {
        this.id = 0;
        this.id_Funcionario = 0;
        this.fecha = new Date(System.currentTimeMillis()); // Fecha actual
        this.hora_Entrada = new Time(System.currentTimeMillis()); // Hora actual
        this.hora_Salida = new Time(System.currentTimeMillis()); // Hora actual
        this.existe = false;
    }
    
    //Metodos de acceso
    //GETTER 
    public int getId() {
        return id;
    }

    public int getId_Funcionario() {
        return id_Funcionario;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora_Entrada() {
        return hora_Entrada;
    }

    public Time getHora_Salida() {
        return hora_Salida;
    }

    public boolean isExiste() {
        return existe;
    }
    
    //SETTER 
     public void setId(int id) {
        this.id = id;
    }

    public void setId_Funcionario(int id_Funcionario) {
        this.id_Funcionario = id_Funcionario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora_Entrada(Time hora_Entrada) {
        this.hora_Entrada = hora_Entrada;
    }

    public void setHora_Salida(Time hora_Salida) {
        this.hora_Salida = hora_Salida;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public void setDate(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setTime(Time time) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}//Fin de la clase agenda
