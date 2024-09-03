package org.example.models;

import java.util.Date;

public class Inventario {
    private int id;
    private int cantidad_disponible;
    private int id_vehículo;
    private Date fecha_actualizacion;

    public Inventario(int id, int cantidad_disponible, int id_vehículo, Date fecha_actualizacion) {
        this.id = id;
        this.cantidad_disponible = cantidad_disponible;
        this.id_vehículo = id_vehículo;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public int getId_vehículo() {
        return id_vehículo;
    }

    public void setId_vehículo(int id_vehículo) {
        this.id_vehículo = id_vehículo;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }
}