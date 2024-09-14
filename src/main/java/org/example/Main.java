package org.example;

import org.example.dao.UsuarioDAO;
import org.example.dao.VendedorDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        VendedorDAO vendedorDAO = new VendedorDAO();

        // usuarioDao.insertar();
        //usuarioDao.listar();
        // usuarioDao.eliminar();
        // usuarioDao.modificar();
        // usuarioDao.buscar();

        // vendedorDAO.insertar();
        //vendedorDAO.listar();
        //vendedorDAO.modificar();
        // vendedorDAO.buscar();
        vendedorDAO.eliminar();
    }
}