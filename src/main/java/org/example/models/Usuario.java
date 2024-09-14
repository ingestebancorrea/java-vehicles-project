package org.example.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private int id_tipodocumento;
    private String numerodocumento;
    private String email;
    private String direccion;
    private String telefono;
    private int id_rol;
    private Boolean estado;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, int id_tipodocumento, String numerodocumento, String email, String direccion, String telefono, int id_rol, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_tipodocumento = id_tipodocumento;
        this.numerodocumento = numerodocumento;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_rol = id_rol;
        this.estado = estado;
    }

    public static Usuario load(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.id = rs.getInt("id");
        usuario.nombre = rs.getString("nombre");
        usuario.email = rs.getString("email");
        return usuario;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_tipodocumento() {
        return id_tipodocumento;
    }

    public void setId_tipodocumento(int id_tipodocumento) {
        this.id_tipodocumento = id_tipodocumento;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String toString() {
        return String.format("id=%d, nombre='%s', email='%s'", id, nombre, email);
    }
}
