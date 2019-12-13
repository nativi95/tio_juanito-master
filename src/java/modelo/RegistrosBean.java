package modelo;

import java.time.LocalTime;
import java.util.Date;

public class RegistrosBean {

    private int id_registro;
    private RecorridosBean id_recorrido;
    private Date fecha;
    private LocalTime hora_salida;
    private LocalTime hora_llegada;
    private double km_salida;
    private double km_llegada;
    private String comentarios;

    public RegistrosBean(int id_registro) {
        this.id_registro = id_registro;
    }

    public RegistrosBean() {
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public RecorridosBean getId_recorrido() {
        return id_recorrido;
    }

    public void setId_recorrido(RecorridosBean id_recorrido) {
        this.id_recorrido = id_recorrido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    public LocalTime getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(LocalTime hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public double getKm_salida() {
        return km_salida;
    }

    public void setKm_salida(double km_salida) {
        this.km_salida = km_salida;
    }

    public double getKm_llegada() {
        return km_llegada;
    }

    public void setKm_llegada(double km_llegada) {
        this.km_llegada = km_llegada;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}
