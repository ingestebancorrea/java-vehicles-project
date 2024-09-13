package org.example.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente extends Usuario {
    private int id;
    private int id_usuario;

    public Cliente() {
        super();
    }


    public Cliente(int id, String nombre, String apellido, int id_tipodocumento, String numeroDocumento, String email, String direccion, String telefono, int id_rol, int id_usuario) {
        super(id, nombre, apellido, id_tipodocumento, numeroDocumento, email, direccion, telefono, id_rol, true);  // Llama al constructor de Usuario
        this.id_usuario = id_usuario;
        this.id = id;
    }



    public static Cliente load(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();

        cliente.setId(rs.getInt("id"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setApellido(rs.getString("apellido"));
        cliente.setId_tipodocumento(rs.getInt("id_tipodocumento"));
        cliente.setNumerodocumento(rs.getString("numerodocumento"));
        cliente.setEmail(rs.getString("email"));
        cliente.setDireccion(rs.getString("direccion"));
        cliente.setTelefono(rs.getString("telefono"));
        cliente.setId_rol(rs.getInt("id_rol"));

        cliente.setId_usuario(rs.getInt("id"));

        return cliente;
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
                        "telefono='%s', " +
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
