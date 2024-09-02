package org.example.models;

import java.util.Date;

public class Vendedor extends Usuario{
    private int id;
    private Date fecha_contratacion;
    private int comision;
    private int id_usuario;

    public Vendedor(int id, Date fecha_contratacion, int comision, int id_usuario) {
        this.id = id;
        this.fecha_contratacion = fecha_contratacion;
        this.comision = comision;
        this.id_usuario = id_usuario;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }
    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }
    public int getComision() {
        return comision;
    }
    public void setComision(int comision) {
        this.comision = comision;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
