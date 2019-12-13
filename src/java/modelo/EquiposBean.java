package modelo;

public class EquiposBean {

    private int id_equipo;
    private BusesBean id_bus;
    private ChoferesBean id_chofer;
    private AsistentesBean id_asistente;

    public EquiposBean(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public EquiposBean() {
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public BusesBean getId_bus() {
        return id_bus;
    }

    public void setId_bus(BusesBean id_bus) {
        this.id_bus = id_bus;
    }

    public ChoferesBean getId_chofer() {
        return id_chofer;
    }

    public void setId_chofer(ChoferesBean id_chofer) {
        this.id_chofer = id_chofer;
    }

    public AsistentesBean getId_asistente() {
        return id_asistente;
    }

    public void setId_asistente(AsistentesBean id_asistente) {
        this.id_asistente = id_asistente;
    }

}
