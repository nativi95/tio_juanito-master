package modelo;

public class ContratoBean {

    private int id_contrato;
    private double tarifa;
    private int periodo;

    public ContratoBean(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public ContratoBean() {
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

}
