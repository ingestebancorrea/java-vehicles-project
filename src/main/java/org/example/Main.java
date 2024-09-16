package org.example;

import org.example.dao.*;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        VendedorDAO vendedorDAO = new VendedorDAO();
        ClienteDAO clienteDao = new ClienteDAO();
        AdministradorDAO administradorDao = new AdministradorDAO();
        EnvioDAO envioDao = new EnvioDAO();

        // usuarioDao.insertar();
        // usuarioDao.listar();
        // usuarioDao.eliminar();
        // usuarioDao.modificar();
        //usuarioDao.buscar();

         //vendedorDAO.insertar();
        //vendedorDAO.listar();
        //vendedorDAO.eliminar();
         //vendedorDAO.modificar();
        //vendedorDAO.buscar();
        //vendedorDAO.deshabilitar();

        //clienteDao.listar();
        //clienteDao.insertar();
        //clienteDao.modificar();
        //clienteDao.eliminar();
        //clienteDao.deshabilitar();
        //clienteDao.buscar();

//        administradorDao.listar();
//        administradorDao.insertar();
//        administradorDao.modificar();
//        administradorDao.eliminar();
//        administradorDao.listar();
//        administradorDao.buscar();

        envioDao.insertar();
    }
}