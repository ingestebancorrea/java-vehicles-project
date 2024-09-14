package org.example;

import org.example.dao.ClienteDAO;
import org.example.dao.EnvioDAO;
import org.example.dao.UsuarioDAO;
import org.example.dao.VendedorDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        VendedorDAO vendedorDAO = new VendedorDAO();
        ClienteDAO clienteDao = new ClienteDAO();
        EnvioDAO envioDao = new EnvioDAO();

        // usuarioDao.insertar();
        // usuarioDao.listar();
        // usuarioDao.eliminar();
        // usuarioDao.modificar();
        //usuarioDao.buscar();

        // vendedorDAO.insertar();
        // vendedorDAO.listar();
        // vendedorDAO.eliminar();
        // usuarioDao.modificar();
        //vendedorDAO.buscar();

        //clienteDao.listar();
        //clienteDao.insertar();
        //clienteDao.modificar();
        //clienteDao.eliminar();
        //clienteDao.deshabilitar();
        //clienteDao.buscar();

        envioDao.insertar();
    }
}