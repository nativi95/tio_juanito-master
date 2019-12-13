package modelo;

public class ModalidadesBean {

    private int id_modalidad;
    private String modalidad;

    public ModalidadesBean(int id_modalidad) {
        this.id_modalidad = id_modalidad;
    }

    public ModalidadesBean() {
    }

    public int getId_modalidad() {
        return id_modalidad;
    }

    public void setId_modalidad(int id_modalidad) {
        this.id_modalidad = id_modalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

}
