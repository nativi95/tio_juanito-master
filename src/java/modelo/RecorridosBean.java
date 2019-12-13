package modelo;

public class RecorridosBean {

    private int id_recorrido;
    private ModalidadesBean id_modalidad;
    private BarriosBean id_barrio;
    private ColegiosBean id_colegio;
    private EquiposBean id_equipo;

    public RecorridosBean(int id_recorrido) {
        this.id_recorrido = id_recorrido;
    }

    public RecorridosBean() {
    }

    public int getId_recorrido() {
        return id_recorrido;
    }

    public void setId_recorrido(int id_recorrido) {
        this.id_recorrido = id_recorrido;
    }

    public ModalidadesBean getId_modalidad() {
        return id_modalidad;
    }

    public void setId_modalidad(ModalidadesBean id_modalidad) {
        this.id_modalidad = id_modalidad;
    }

    public BarriosBean getId_barrio() {
        return id_barrio;
    }

    public void setId_barrio(BarriosBean id_barrio) {
        this.id_barrio = id_barrio;
    }

    public ColegiosBean getId_colegio() {
        return id_colegio;
    }

    public void setId_colegio(ColegiosBean id_colegio) {
        this.id_colegio = id_colegio;
    }

    public EquiposBean getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(EquiposBean id_equipo) {
        this.id_equipo = id_equipo;
    }

}
