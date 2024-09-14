package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    Connection con;
    private String dateBaseUrl = "jdbc:mysql://localhost:3306/vehicles_db";
    private String usuario = "root";
    private String clave = "";

    public Connection conexion() throws SQLException {
        con = DriverManager.getConnection(this.dateBaseUrl, this.usuario, this.clave);
        return con;
    }
}
