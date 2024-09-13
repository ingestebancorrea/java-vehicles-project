package org.example.dao;



import org.example.models.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteDAO implements InterfaceDAO {
    ConexionDB conn = new ConexionDB();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    ArrayList<Cliente> listaClientes = new ArrayList<>();


    @Override
    public void listar() throws SQLException {
        String sql = "SELECT u.* FROM Usuario u JOIN Cliente c ON u.id = c.id_usuario WHERE u.id_rol = 2 AND u.estado = 1;";
        pstm = conn.conexion().prepareStatement(sql);
        rs = pstm.executeQuery();

        while (rs.next()) {
            Cliente cliente = Cliente.load(rs);
            listaClientes.add(cliente);
        }

        String clientesFormatted = String.format("Clientes: %s", listaClientes);
        System.out.println(clientesFormatted);
    }


    @Override
    public void insertar() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        // Solicitar información del cliente
        System.out.println("Digite nombre de la persona: ");
        String nombre = scanner.nextLine();
        System.out.println("Digite apellido de la persona: ");
        String apellido = scanner.nextLine();
        System.out.println("Digite el número de tipo de identificación: ");
        System.out.println("1. Cédula ciudadania: ");
        System.out.println("2. Cédula extranjeria: ");
        System.out.println("3. Pasaporte: ");
        int idTipoDocumento = scanner.nextInt();
        scanner.nextLine();  // Consume el salto de línea pendiente
        System.out.println("Digite el número de documento de identidad: ");
        String numero = scanner.nextLine();
        System.out.println("Digite el email: ");
        String email = scanner.nextLine();
        System.out.println("Digite la dirección: ");
        String direccion = scanner.nextLine();
        System.out.println("Digite el número de telefono: ");
        String telefono = scanner.nextLine();
        int idRol = 2;

        String sql = "INSERT INTO Usuario(`nombre`, `apellido`, `id_tipodocumento`, `numerodocumento`, `email`, `direccion`, `telefono`, `id_rol`, `estado`) VALUES (?,?,?,?,?,?,?,?,?)";

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
            pstm.setInt(8, idRol);
            pstm.setBoolean(9, true);

            int affectedRows = pstm.executeUpdate();

            if (affectedRows > 0) {
                // Obtener el id_usuario generado automáticamente
                ResultSet generatedKeys = pstm.getGeneratedKeys();
                System.out.println("generatedKeys "+ generatedKeys);
                if (generatedKeys.next()) {
                    int id_usuario = generatedKeys.getInt(1); // El ID generado para el usuario
                    System.out.println("Cliente insertado con éxito en Usuario. ID de usuario generado: " + id_usuario);

                    // insertar el id_usuario en la tabla Cliente
                    String sqlCliente = "INSERT INTO Cliente (id_usuario) VALUES (?)";

                    PreparedStatement pstmCliente = conn.conexion().prepareStatement(sqlCliente);
                    pstmCliente.setInt(1, id_usuario);

                    // Insertar en Cliente
                    int affectedRowsCliente = pstmCliente.executeUpdate();

                    if (affectedRowsCliente > 0) {
                        System.out.println("Cliente insertado con éxito en la tabla Cliente.");
                    } else {
                        System.out.println("Error al insertar en la tabla Cliente.");
                    }

                    pstmCliente.close();
                }
            } else {
                System.out.println("Error al insertar el cliente en Usuario.");
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

        System.out.print("Digite el id del cliente a eliminar: ");
        int id_usuario=in.nextInt();

        // Eliminar primero de la tabla Cliente
        String sqlCliente = "DELETE FROM Cliente WHERE id_usuario = ?";
        String sqlUsuario = "DELETE FROM Usuario WHERE id = ?";
        try {
            pstm = conn.conexion().prepareStatement(sqlCliente);
            pstm.setInt(1, id_usuario);

            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cliente eliminado con exito de la tabla Cliente.");

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
                System.out.println("Error al eliminar en la tabla Cliente.");
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

        // Solicitar el ID del usuario a desactivar
        System.out.println("Ingrese el ID del cliente que desea desactivar:");
        int id_usuario = scanner.nextInt();

        // Actualizar el estado del usuario a 0 (inactivo) en la tabla Usuario
        String sql = "UPDATE Usuario SET estado = 0 WHERE id = ? AND id_rol = 2";

        try {
            // Preparar y ejecutar la actualización
            pstm = conn.conexion().prepareStatement(sql);
            pstm.setInt(1, id_usuario);
            int affectedRows = pstm.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Cliente desactivado con éxito.");
            } else {
                System.out.println("Error al desactivar el cliente.");
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

        if (listaClientes.isEmpty()) {
            return;
        }

        System.out.println("Seleccione el ID del cliente que desea modificar:");
        int id_usuario = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nuevo nombre del cliente:");
        String nuevoNombre = scanner.nextLine();

        System.out.println("Ingrese la nueva dirección del cliente:");
        String nuevaDireccion = scanner.nextLine();

        // Sentencia SQL para hacer un UPDATE con un JOIN entre Usuario y Cliente
        String sql = "UPDATE Usuario u " +
                "JOIN Cliente c ON u.id = c.id_usuario " +
                "SET u.nombre = ?, u.direccion = ? " +
                "WHERE u.id = ?";
        try {
            pstm = conn.conexion().prepareStatement(sql);
            pstm.setString(1, nuevoNombre);
            pstm.setString(2, nuevaDireccion);
            pstm.setInt(3, id_usuario);

            int affectedRows = pstm.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Cliente modificado con éxito.");
            } else {
                System.out.println("Error: No se encontró el cliente con el ID proporcionado.");
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
    public void buscar(String nombre) throws SQLException {
        // SQL con JOIN y búsqueda por nombre
        String sql = "SELECT u.*" +
                "FROM Usuario u " +
                "JOIN Cliente c ON u.id = c.id_usuario " +
                "WHERE u.id_rol = 2 AND u.estado = 1 AND u.nombre LIKE ?";

        pstm = conn.conexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        rs = pstm.executeQuery();

        listaClientes.clear();

        // Mostrar los clientes encontrados
        System.out.println("Clientes encontrados:");
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setEmail(rs.getString("email"));
            cliente.setDireccion(rs.getString("direccion"));
            cliente.setTelefono(rs.getString("telefono"));

            listaClientes.add(cliente);  // Agregar a la lista

            // Mostrar la información del cliente
            System.out.println("Nombre: " + cliente.getNombre() + ", Apellido: "+ cliente.getApellido() + ", Email: " + cliente.getEmail() + ", Dirección: " + cliente.getDireccion() + ", Teléfono: " + cliente.getTelefono());
        }

        if (listaClientes.isEmpty()) {
            System.out.println("No se encontraron clientes con ese nombre.");
        }
    }


}
