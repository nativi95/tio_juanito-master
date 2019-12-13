package modelo;

public class ChoferesBean {

    private int id_chofer;
    private String nombre;
    private String apellido;
    private String dui;
    private String licencia;

    public ChoferesBean(int id_chofer) {
        this.id_chofer = id_chofer;
    }

    public ChoferesBean() {
    }

    public int getId_chofer() {
        return id_chofer;
    }

    public void setId_chofer(int id_chofer) {
        this.id_chofer = id_chofer;
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

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

}
