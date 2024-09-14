package org.example.dao;

import java.sql.SQLException;

public interface InterfaceDAO {
    public void insertar() throws SQLException;
    public void eliminar() throws SQLException;
    public void modificar() throws SQLException;
    public void listar() throws SQLException;
    public void buscar() throws SQLException;
    public void deshabilitar() throws SQLException;
}
