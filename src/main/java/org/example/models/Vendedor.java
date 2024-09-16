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
        super();
    }


    public Vendedor(int id, String nombre, String apellido, int id_tipodocumento, String numeroDocumento, String email, String direccion, String telefono, int id_rol, int id_usuario, Date fecha_contratacion, boolean estado) {
        super(id, nombre, apellido, id_tipodocumento, numeroDocumento, email, direccion, telefono, id_rol, estado);
        this.id_usuario = id_usuario;
        this.id = id;
        this.fecha_contratacion = fecha_contratacion;
    }

    public static Vendedor load(ResultSet rs) throws SQLException {
        Vendedor vendedor = new Vendedor();
        vendedor.setId(rs.getInt("id"));
        vendedor.setFecha_contratacion(rs.getDate("fecha_contratacion"));
        vendedor.setNombre(rs.getString("nombre"));
        vendedor.setApellido(rs.getString("apellido"));
        vendedor.setId_tipodocumento(rs.getInt("id_tipodocumento"));
        vendedor.setNumerodocumento(rs.getString("numerodocumento"));
        vendedor.setEmail(rs.getString("email"));
        vendedor.setDireccion(rs.getString("direccion"));
        vendedor.setTelefono(rs.getString("telefono"));
        vendedor.setId_rol(rs.getInt("id_rol"));

        vendedor.setId_usuario(rs.getInt("id"));
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

    @Override
    public String toString() {
        return String.format(
                "{" +
                        "id=%d, " +
                        "nombre='%s', " +
                        "apellido='%s', " +
                        "id_tipodocumento=%d, " +
                        "numeroDocumento='%s', " +
                        "email='%s', " +
                        "direccion='%s', " +
                        "telefono='%s', " +
                        "fecha_contratacion='%s'" +
                        '}',
                getId(),
                getNombre(),
                getApellido(),
                getId_tipodocumento(),
                getNumerodocumento(),
                getEmail(),
                getDireccion(),
                getTelefono(),
                getFecha_contratacion()
        );
    }
}
