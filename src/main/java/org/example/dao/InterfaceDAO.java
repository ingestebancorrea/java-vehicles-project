package org.example.dao;

import java.sql.SQLException;
import java.text.ParseException;

public interface InterfaceDAO {
    public void insertar() throws SQLException, ParseException;
    public void eliminar() throws SQLException;
    public void modificar() throws SQLException;
    public void listar() throws SQLException;
    public void buscar() throws SQLException;
    public void deshabilitar() throws SQLException;
}
