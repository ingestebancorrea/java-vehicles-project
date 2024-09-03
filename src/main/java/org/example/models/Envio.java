package org.example.models;

import java.util.Date;

public class Envio {
    private int id;
    private int id_vehiculo;
    private int cantidad;
    private Date fecha;
    private String direccion;
    private int id_estado;

    public Envio(int id, int id_vehiculo, int cantidad, Date fecha, String direccion, int id_estado) {
        this.id = id;
        this.id_vehiculo = id_vehiculo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.direccion = direccion;
        this.id_estado = id_estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
}