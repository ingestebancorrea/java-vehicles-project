package org.example.dao; // Declaramos que este código pertenece al paquete 'org.example.dao'.

import java.sql.SQLException; // Importamos la clase SQLException para manejar errores de SQL.
import java.text.ParseException; // Importamos la clase ParseException para manejar errores de análisis de texto.

public interface InterfaceDAO { // Definimos una interfaz llamada InterfaceDAO.

    /**
     * Inserta un nuevo registro en la base de datos.
     * @throws SQLException Si ocurre un error relacionado con SQL.
     * @throws ParseException Si ocurre un error al analizar la entrada de datos.
     */
    public void insertar() throws SQLException, ParseException;

    /**
     * Elimina un registro existente de la base de datos.
     * @throws SQLException Si ocurre un error relacionado con SQL.
     */
    public void eliminar() throws SQLException;

    /**
     * Modifica un registro existente en la base de datos.
     * @throws SQLException Si ocurre un error relacionado con SQL.
     */
    public void modificar() throws SQLException;

    /**
     * Lista todos los registros en la base de datos.
     * @throws SQLException Si ocurre un error relacionado con SQL.
     */
    public void listar() throws SQLException;

    /**
     * Busca un registro específico en la base de datos.
     * @throws SQLException Si ocurre un error relacionado con SQL.
     */
    public void buscar() throws SQLException;

    /**
     * Deshabilita un registro en lugar de eliminarlo.
     * @throws SQLException Si ocurre un error relacionado con SQL.
     */
    public void deshabilitar() throws SQLException;
}
