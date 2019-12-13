package modelo;

public class AsistentesBean {

    private int id_asistente;
    private String nombre;
    private String apellido;
    private String dui;

    public AsistentesBean(int id_asistente) {
        this.id_asistente = id_asistente;
    }

    public AsistentesBean() {
    }

    public int getId_asistente() {
        return id_asistente;
    }

    public void setId_asistente(int id_asistente) {
        this.id_asistente = id_asistente;
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

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

}
