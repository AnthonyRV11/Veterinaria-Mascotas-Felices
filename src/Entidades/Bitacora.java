package Entidades;

//Anthony Rodriguez Valverde

import java.sql.Date;
import java.sql.Time;

public class Bitacora {
   
    //Atributos
    private int id;
    private Date fecha;
    private Time hora;
    private String descripcion;
    
    //Constructores
     public Bitacora(int id, Date fecha, Time hora, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }
     
     public Bitacora() {
        this.id = 0;
        this.fecha = null;
        this.hora = null;
        this.descripcion = "";
    } 
     
    //Metodos de acceso
    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

      public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
     
}//Fin clase bitacora
