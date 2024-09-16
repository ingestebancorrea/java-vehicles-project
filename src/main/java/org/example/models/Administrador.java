package org.example.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrador extends Usuario{
    private int id;
    private int id_usuario;

    public Administrador() {
        super();
    }


    public Administrador(int id, String nombre, String apellido, int id_tipodocumento, String numeroDocumento, String email, String direccion, String telefono, int id_rol, int id_usuario, boolean estado) {
        super(id, nombre, apellido, id_tipodocumento, numeroDocumento, email, direccion, telefono, id_rol, estado);
        this.id_usuario = id_usuario;
        this.id = id;
    }



    public static Administrador load(ResultSet rs) throws SQLException {
        Administrador administrador = new Administrador();

        administrador.setId(rs.getInt("id"));
        administrador.setNombre(rs.getString("nombre"));
        administrador.setApellido(rs.getString("apellido"));
        administrador.setId_tipodocumento(rs.getInt("id_tipodocumento"));
        administrador.setNumerodocumento(rs.getString("numerodocumento"));
        administrador.setEmail(rs.getString("email"));
        administrador.setDireccion(rs.getString("direccion"));
        administrador.setTelefono(rs.getString("telefono"));
        administrador.setId_rol(rs.getInt("id_rol"));

        administrador.setId_usuario(rs.getInt("id"));

        return administrador;
    }



    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
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
                        "telefono='%s'" +
                        '}',
                getId(),
                getNombre(),
                getApellido(),
                getId_tipodocumento(),
                getNumerodocumento(),
                getEmail(),
                getDireccion(),
                getTelefono()
        );
    }

}
