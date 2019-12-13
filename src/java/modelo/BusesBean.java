package modelo;

public class BusesBean {

    private int id_bus;
    private String placa;
    private String marca;
    private String modelo;

    public BusesBean(int id_bus) {
        this.id_bus = id_bus;
    }

    public BusesBean() {
    }

    public int getId_bus() {
        return id_bus;
    }

    public void setId_bus(int id_bus) {
        this.id_bus = id_bus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
