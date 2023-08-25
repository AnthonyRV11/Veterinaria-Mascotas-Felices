package Entidades;

//Anthony Rodriguez Valverde 24/08/2023

import java.sql.Time;

public class Citas {
    
    //Atributos
    private int idCitas;
    private int idAgenda;
    private int idCliente;
    private Time horaCita;
    private double precioCita;
    private String Descripcion;
    private boolean existe;
    
    //Constructores
    public Citas(int idCitas, int idAgenda, int idCliente, Time horaCita, double precioCita, String Descripcion, boolean existe) {
        this.idCitas = idCitas;
        this.idAgenda = idAgenda;
        this.idCliente = idCliente;
        this.horaCita = horaCita;
        this.precioCita = precioCita;
        this.Descripcion = Descripcion;
        this.existe = existe;
    }
    
    public Citas() {
        this.idCitas = 0;
        this.idAgenda = 0;
        this.idCliente = 0;
        this.horaCita = null;
        this.precioCita = 0.0;
        this.Descripcion = "";
        this.existe = false;
    }
    
    //Metodos de acceso
    public int getIdCitas() {
        return idCitas;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Time getHoraCita() {
        return horaCita;
    }

    public double getPrecioCita() {
        return precioCita;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public boolean isExiste() {
        return existe;
    }
    
    public void setIdCitas(int idCitas) {
        this.idCitas = idCitas;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setHoraCita(Time horaCita) {
        this.horaCita = horaCita;
    }

    public void setPrecioCita(double precioCita) {
        this.precioCita = precioCita;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
    
    
}//Fin de la clase Citas
