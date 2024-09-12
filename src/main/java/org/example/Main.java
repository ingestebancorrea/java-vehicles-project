package org.example;

import org.example.dao.UsuarioDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO usuarioDao = new UsuarioDAO();

        // usuarioDao.insertar();
        // usuarioDao.listar();
        // usuarioDao.eliminar();
        // usuarioDao.modificar();
        usuarioDao.buscar("Emily");
    }
}