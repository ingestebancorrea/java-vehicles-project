package org.example.models;

public class Pago {
    // Atributos
    private int id;
    private int idVenta;
    private int idTipoPago;
    private double monto;
    private int idEstado;

    // Constructor
    public Pago(int id, int idVenta, int idTipoPago, double monto, int idEstado) {
        this.id = id;
        this.idVenta = idVenta;
        this.idTipoPago = idTipoPago;
        this.monto = monto;
        this.idEstado = idEstado;
    }

    // Métodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

}
