package org.example;

import org.example.dao.ClienteDAO;
import org.example.dao.UsuarioDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO usuarioDao = new UsuarioDAO();

        // usuarioDao.insertar();
        // usuarioDao.listar();
        // usuarioDao.eliminar();
        // usuarioDao.modificar();
        //usuarioDao.buscar("Emily");

        ClienteDAO clienteDao = new ClienteDAO();

        //clienteDao.listar();
        //clienteDao.insertar();
        //clienteDao.modificar();
        //clienteDao.eliminar();
        //clienteDao.deshabilitar();
        clienteDao.buscar("Yeizer");
    }
}