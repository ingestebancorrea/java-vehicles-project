package org.example.dao;

import org.example.models.Administrador;
import org.example.models.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdministradorDAO implements InterfaceDAO {
    ConexionDB conn = new ConexionDB();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    ArrayList<Usuario> listaAdmin = new ArrayList<>();


    @Override
    public void listar() throws SQLException {
        String sql = "SELECT u.* FROM Usuario u JOIN Administrador a ON u.id = a.id_usuario WHERE u.id_rol = 1 AND u.estado = 1;";
        pstm = conn.conexion().prepareStatement(sql);
        rs = pstm.executeQuery();

        while (rs.next()) {
            Administrador administrador = Administrador.load(rs);
            listaAdmin.add(administrador);
        }

        String adminFormatted = String.format("Administradores: %s", listaAdmin);
        System.out.println(adminFormatted);
    }


    @Override
    public void insertar() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        // Solicitar información del administrador
        System.out.println("Digite nombre de la persona: ");
        String nombre = scanner.nextLine();
        System.out.println("Digite apellido de la persona: ");
        String apellido = scanner.nextLine();
        System.out.println("Digite el número de tipo de identificación: ");
        System.out.println("1. Cédula ciudadania: ");
        System.out.println("2. Cédula extranjeria: ");
        System.out.println("3. Pasaporte: ");
        int idTipoDocumento = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite el número de documento de identidad: ");
        String numero = scanner.nextLine();
        System.out.println("Digite el email: ");
        String email = scanner.nextLine();
        System.out.println("Digite la dirección: ");
        String direccion = scanner.nextLine();
        System.out.println("Digite el número de telefono: ");
        String telefono = scanner.nextLine();
        int idRol = 1;

        String sql = "INSERT INTO Usuario(`nombre`, `apellido`, `id_tipodocumento`, `numerodocumento`, `email`, `direccion`, `telefono`, `registro`,`id_rol`, `estado`) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            // Preparar la sentencia SQL
            pstm = conn.conexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, nombre);
            pstm.setString(2, apellido);
            pstm.setInt(3, idTipoDocumento);
            pstm.setString(4, numero);
            pstm.setString(5, email);
            pstm.setString(6, direccion);
            pstm.setString(7, telefono);
            pstm.setDate(8, new java.sql.Date(System.currentTimeMillis()));
            pstm.setInt(9, idRol);
            pstm.setBoolean(10, true);

            int affectedRows = pstm.executeUpdate();

            if (affectedRows > 0) {
                // Obtener el id_usuario generado automáticamente
                ResultSet generatedKeys = pstm.getGeneratedKeys();
                System.out.println("generatedKeys "+ generatedKeys);
                if (generatedKeys.next()) {
                    int id_usuario = generatedKeys.getInt(1); // El ID generado para el usuario
                    System.out.println("Administrador insertado con éxito en Usuario. ID de usuario generado: " + id_usuario);

                    // insertar el id_usuario en la tabla Administrador
                    String sqlAdmin = "INSERT INTO Administrador (id_usuario) VALUES (?)";

                    PreparedStatement pstmAdmin = conn.conexion().prepareStatement(sqlAdmin);
                    pstmAdmin.setInt(1, id_usuario);

                    // Insertar en Administrador
                    int affectedRowsAdmin = pstmAdmin.executeUpdate();

                    if (affectedRowsAdmin > 0) {
                        System.out.println("Administrador insertado con éxito en la tabla Administrador.");
                    } else {
                        System.out.println("Error al insertar en la tabla Administrador.");
                    }

                    pstmAdmin.close();
                }
            } else {
                System.out.println("Error al insertar el administrador en Usuario.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                pstm.close();
            }
        }
    }


    @Override
    public void eliminar() throws SQLException {
        Scanner in=new Scanner(System.in);


        listar();

        if (listaAdmin.isEmpty()) {
            return;
        }

        System.out.print("Digite el id del Administrador a eliminar: ");
        int id_usuario=in.nextInt();

        // Eliminar primero de la tabla Administrador
        String sqlAdmin = "DELETE FROM Administrador WHERE id_usuario = ?";
        String sqlUsuario = "DELETE FROM Usuario WHERE id = ?";
        try {
            pstm = conn.conexion().prepareStatement(sqlAdmin);
            pstm.setInt(1, id_usuario);

            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Administrador eliminado con exito de la tabla Administrador.");

                //Eliminar de la tabla usuario
                pstm = conn.conexion().prepareStatement(sqlUsuario);
                pstm.setInt(1, id_usuario);
                int affectedRowsUsuario = pstm.executeUpdate();

                if (affectedRowsUsuario > 0) {
                    System.out.println("Usuario eliminado con exito de la tabla Usuario.");
                }else{
                    System.out.println("Error al eliminar en la tabla Usuario.");
                }
            }else {
                System.out.println("Error al eliminar en la tabla Administrador.");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pstm != null) {
                pstm.close();
            }
        }

    }

    @Override
    public void deshabilitar() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        listar();

        if (listaAdmin.isEmpty()) {
            return;
        }

        // Solicitar el ID del usuario a desactivar
        System.out.println("Ingrese el ID del administrador que desea desactivar:");
        int id_usuario = scanner.nextInt();

        // Actualizar el estado del usuario a 0 (inactivo) en la tabla Usuario
        String sql = "UPDATE Usuario SET estado = 0 WHERE id = ? AND id_rol = 1";

        try {
            // Preparar y ejecutar la actualización
            pstm = conn.conexion().prepareStatement(sql);
            pstm.setInt(1, id_usuario);
            int affectedRows = pstm.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Administrador desactivado con éxito.");
            } else {
                System.out.println("Error al desactivar el administrador.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                pstm.close();
            }
        }
    }


    @Override
    public void modificar() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        listar();

        if (listaAdmin.isEmpty()) {
            return;
        }

        System.out.println("Seleccione el ID del administrador que desea modificar:");
        int id_usuario = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nuevo nombre del administrador:");
        String nuevoNombre = scanner.nextLine();

        System.out.println("Ingrese la nueva dirección del administrador:");
        String nuevaDireccion = scanner.nextLine();

        // Sentencia SQL para hacer un UPDATE con un JOIN entre Usuario y Administrador
        String sql = "UPDATE Usuario u " +
                "JOIN Administrador a ON u.id = a.id_usuario " +
                "SET u.nombre = ?, u.direccion = ? " +
                "WHERE u.id = ?";
        try {
            pstm = conn.conexion().prepareStatement(sql);
            pstm.setString(1, nuevoNombre);
            pstm.setString(2, nuevaDireccion);
            pstm.setInt(3, id_usuario);

            int affectedRows = pstm.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Administrador modificado con éxito.");
            } else {
                System.out.println("Error: No se encontró el administrador con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                pstm.close();
            }
        }
    }


    @Override
    public void buscar() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite el nombre del administrador: ");
        String nombre = scanner.nextLine();
        // SQL con JOIN y búsqueda por nombre
        String sql = "SELECT u.*" +
                "FROM Usuario u " +
                "JOIN Administrador a ON u.id = a.id_usuario " +
                "WHERE u.id_rol = 1 AND u.estado = 1 AND u.nombre LIKE ?";

        pstm = conn.conexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        rs = pstm.executeQuery();

        listaAdmin.clear();

        // Mostrar los administradors encontrados
        System.out.println("Administradores encontrados:");
        while (rs.next()) {
            Administrador administrador = new Administrador();
            administrador.setNombre(rs.getString("nombre"));
            administrador.setApellido(rs.getString("apellido"));
            administrador.setEmail(rs.getString("email"));
            administrador.setDireccion(rs.getString("direccion"));
            administrador.setTelefono(rs.getString("telefono"));

            listaAdmin.add(administrador);  // Agregar a la lista

            // Mostrar la información del administrador
            System.out.println("Nombre: " + administrador.getNombre() + ", Apellido: "+ administrador.getApellido() + ", Email: " + administrador.getEmail() + ", Dirección: " + administrador.getDireccion() + ", Teléfono: " + administrador.getTelefono());
        }

        if (listaAdmin.isEmpty()) {
            System.out.println("No se encontraron administradors con ese nombre.");
        }
    }

}
