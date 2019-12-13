package modelo;

public class BarriosBean {

    private int id_barrio;
    private String nombre;

    public BarriosBean(int id_barrio) {
        this.id_barrio = id_barrio;
    }

    public BarriosBean() {
    }

    public int getId_barrio() {
        return id_barrio;
    }

    public void setId_barrio(int id_barrio) {
        this.id_barrio = id_barrio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
