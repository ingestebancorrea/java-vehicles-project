package org.example.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Vendedor extends Usuario{
    private int id;
    private Date fecha_contratacion;
    private int comision;
    private int id_usuario;

    public Vendedor() {
    }

    public Vendedor(int id, Date fecha_contratacion, int comision, int id_usuario) {
        this.id = id;
        this.fecha_contratacion = fecha_contratacion;
        this.comision = comision;
        this.id_usuario = id_usuario;
    }

    public static Vendedor load(ResultSet rs) throws SQLException {
        Vendedor vendedor = new Vendedor();
        vendedor.id = rs.getInt("id");
        vendedor.fecha_contratacion = rs.getDate("fecha_contratacion");
        vendedor.id_usuario = rs.getInt("id_usuario");
        return vendedor;
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

    public String toString() {
        return String.format("id=%d, fecha_contratacion='%s', id_usuario='%s'", id, fecha_contratacion, id_usuario);
    }
}
