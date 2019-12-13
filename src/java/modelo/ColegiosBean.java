package modelo;

import java.io.InputStream;

public class ColegiosBean {

    private int id_colegio;
    private String nombre;
    private String direcion;
    private InputStream foto;
    

    public ColegiosBean(int id_colegio) {
        this.id_colegio = id_colegio;
    }

    public ColegiosBean() {
    }

    public int getId_colegio() {
        return id_colegio;
    }

    public void setId_colegio(int id_colegio) {
        this.id_colegio = id_colegio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

}
