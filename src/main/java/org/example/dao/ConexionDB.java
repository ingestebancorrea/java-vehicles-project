package org.example.dao; // Declaramos que este código pertenece al paquete 'org.example.dao'.

import java.sql.Connection; // Importamos la clase Connection para manejar conexiones a la base de datos.
import java.sql.DriverManager; // Importamos la clase DriverManager para establecer conexiones a la base de datos.
import java.sql.SQLException; // Importamos la clase SQLException para manejar errores de SQL.

public class ConexionDB { // Definimos la clase ConexionDB para gestionar la conexión a la base de datos.
    Connection con; // Declara una variable de tipo Connection para almacenar la conexión.

    // URL de conexión a la base de datos, incluye el tipo de base de datos, la ubicación y el nombre de la base de datos.
    private String dateBaseUrl = "jdbc:mysql://localhost:3306/vehicles_db";

    // Credenciales para la conexión a la base de datos.
    private String usuario = "root"; // Nombre de usuario de la base de datos.
    private String clave = ""; // Contraseña de la base de datos.

    /**
     * Establece una conexión con la base de datos.
     * @return un objeto Connection que representa la conexión a la base de datos.
     * @throws SQLException Si ocurre un error al intentar establecer la conexión.
     */
    public Connection conexion() throws SQLException {
        // Intentamos establecer la conexión utilizando DriverManager.
        con = DriverManager.getConnection(this.dateBaseUrl, this.usuario, this.clave);
        return con; // Retornamos la conexión establecida.
    }
}
