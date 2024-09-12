package org.example.dao;

import org.example.models.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioDAO implements InterfaceDAO {
    ConexionDB conn = new ConexionDB();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    ArrayList<Usuario> listaUsuario = new ArrayList<>();

    @Override
    public void insertar() throws SQLException {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Digite nombre de la persona: ");
            String nombre = in.nextLine();
            System.out.println("Digite apellido de la persona: ");
            String apellido = in.nextLine();
            System.out.println("Digite el número de tipo de identificación: ");
            System.out.println("1. Cédula ciudadania: ");
            System.out.println("2. Cédula extranjeria: ");
            System.out.println("3. Pasaporte: ");
            int idTipoDocumento = in.nextInt();
            in.nextLine();  // Consume el salto de línea pendiente
            System.out.println("Digite el número de documento de identidad: ");
            String numero = in.nextLine();
            System.out.println("Digite el email: ");
            String email = in.nextLine();
            System.out.println("Digite la dirección: ");
            String direccion = in.nextLine();
            System.out.println("Digite el número de telefono: ");
            String telefono = in.nextLine();
            System.out.println("Digite el número del rol: ");
            System.out.println("1. Administrador: ");
            System.out.println("2. Cliente: ");
            System.out.println("3. Vendedor: ");
            int idRol = in.nextInt();

            String sql = "INSERT INTO Usuario(`nombre`, `apellido`, `id_tipodocumento`, `numerodocumento`, `email`, `direccion`, `telefono`, `id_rol`) VALUES (?,?,?,?,?,?,?,?)";
            var stm = conn.conexion().prepareStatement(sql);
            stm.setString(1, nombre);
            stm.setString(2, apellido);
            stm.setInt(3, idTipoDocumento);
            stm.setString(4, numero);
            stm.setString(5, email);
            stm.setString(6, direccion);
            stm.setString(7, telefono);
            stm.setInt(8, idRol);
            int rs = stm.executeUpdate();

            if (rs > 0) {
                System.out.println("Registro insertado de forma correcta");
            } else {
                System.out.println("Fallo en la insercion");
            }
            in.close();
        }catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

    @Override
    public void eliminar() throws SQLException {
        Scanner in=new Scanner(System.in);

        System.out.print("Digite el id del usuario a eliminar: ");
        int id=in.nextInt();

        String sql="DELETE FROM Usuario WHERE id=?";
        var stm = conn.conexion().prepareStatement(sql);
        stm.setObject(1,id);
        int rs=stm.executeUpdate();

        if(rs>0){
            System.out.println("Registro eliminado");
        }
        else {
            System.out.println("Eiminacion fallida");
        }
        in.close();
    }

    @Override
    public void modificar() throws SQLException {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Digite la nueva direccion: ");
            String direccion=in.nextLine();
            System.out.println("Digite el ID del usuario a actualizar: ");
            int id= in.nextInt();
            String sql="UPDATE Usuario SET direccion=? WHERE id=?";
            var stm= conn.conexion().prepareStatement(sql);
            stm.setObject(1, direccion);
            stm.setObject(2,id);
            int rs = stm.executeUpdate();

            if(rs>0){
                System.out.println("Registro actualizado de forma correcta");
            }
            else{
                System.out.println("Fallo en la actualizacion");
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

    @Override
    public void listar() throws SQLException {
        String sql = "SELECT * FROM Usuario";
        pstm = conn.conexion().prepareStatement(sql);
        rs = pstm.executeQuery();

        while (rs.next()) {
            Usuario usuario = Usuario.load(rs);
            listaUsuario.add(usuario);
        }

        String usersFormatted = String.format("Usuarios: %s", listaUsuario);
        System.out.println(usersFormatted);
    }

    @Override
    public void buscar(String nombre) throws SQLException {
        String sql = "SELECT * FROM Usuario where nombre=?";
        pstm = conn.conexion().prepareStatement(sql);
        pstm.setObject(1, nombre);
        rs = pstm.executeQuery();

        while (rs.next()) {
            Usuario usuario = Usuario.load(rs);
            listaUsuario.add(usuario);
        }

        String usersFormatted = String.format("Usuario: %s", listaUsuario);
        System.out.println(usersFormatted);
    }
}
