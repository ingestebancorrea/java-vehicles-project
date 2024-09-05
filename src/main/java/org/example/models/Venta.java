package org.example.models;

public class Venta {
    private int id;
    private int id_tipopago;
    private Date fecha;
    private double precio;
    private int id_vehiculo;
    private int id_cliente;
    private int id_vendedor;

    // Constructor
    public Venta(int id, int id_tipopago, Date fecha, double precio, int id_vehiculo, int id_cliente, int id_vendedor) {
        this.id = id;
        this.id_tipopago = id_tipopago;
        this.fecha = fecha;
        this.precio = precio;
        this.id_vehiculo = id_vehiculo;
        this.id_cliente = id_cliente;
        this.id_vendedor = id_vendedor;
    }

    // Métodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_tipopago() {
        return id_tipopago;
    }

    public void setId_tipopago(int id_tipopago) {
        this.id_tipopago = id_tipopago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

}
