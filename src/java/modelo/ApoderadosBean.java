package modelo;

public class ApoderadosBean {

    private int id_apoderado;
    private String nombre;
    private String apellido;
    private String dui;
    private String telefono;
    private UsuarioBean id_usuario;
    private int id_contrato;

    public ApoderadosBean(int id_apoderado) {
        this.id_apoderado = id_apoderado;
    }

    public ApoderadosBean() {
    }

    public int getId_apoderado() {
        return id_apoderado;
    }

    public void setId_apoderado(int id_apoderado) {
        this.id_apoderado = id_apoderado;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public UsuarioBean getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(UsuarioBean id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

}
