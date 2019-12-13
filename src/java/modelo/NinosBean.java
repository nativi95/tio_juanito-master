package modelo;

import java.time.LocalTime;

public class NinosBean {

    private int id_nino;
    private String nombre;
    private String apellido;
    private boolean disponibilidad;
    private String direcion;
    private LocalTime salida;
    private LocalTime llegada;
    private ApoderadosBean id_apoderado;

    public NinosBean(int id_nino) {
        this.id_nino = id_nino;
    }

    public NinosBean() {
    }

    public int getId_nino() {
        return id_nino;
    }

    public void setId_nino(int id_nino) {
        this.id_nino = id_nino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public LocalTime getSalida() {
        return salida;
    }

    public void setSalida(LocalTime salida) {
        this.salida = salida;
    }

    public LocalTime getLlegada() {
        return llegada;
    }

    public void setLlegada(LocalTime llegada) {
        this.llegada = llegada;
    }

    public ApoderadosBean getId_apoderado() {
        return id_apoderado;
    }

    public void setId_apoderado(ApoderadosBean id_apoderado) {
        this.id_apoderado = id_apoderado;
    }
    
  

}
