package org.example.dao;

import org.example.models.Cliente;
import org.example.models.Usuario;
import org.example.models.Vendedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class VendedorDAO implements InterfaceDAO {
    ConexionDB conn = new ConexionDB();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    ArrayList<Usuario> listaVendedor = new ArrayList<>();


    @Override
    public void insertar() throws SQLException, ParseException {
        Scanner scanner = new Scanner(System.in);

        // Solicitar información del vendedor
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
        int idRol = 3;

        String sql = "INSERT INTO Usuario(`nombre`, `apellido`, `id_tipodocumento`, `numerodocumento`, `email`, `direccion`, `telefono`, `registro`, `id_rol`, `estado`) VALUES (?,?,?,?,?,?,?,?,?,?)";


        // Date formatter to parse and format dates
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Digite la fecha de contratación del vendedor (DD/MM/YYYY): ");
        String fechaContratacionInput = scanner.nextLine();

        // Parse the input date
        Date fechaContratacionDate = inputFormat.parse(fechaContratacionInput);

        // Format the date to match MySQL's expected format
        String fechaContratacion = outputFormat.format(fechaContratacionDate);

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
                    System.out.println("Vendedor insertado con éxito en Usuario. ID de usuario generado: " + id_usuario);

                    // insertar el id_usuario en la tabla vendedor
                    String sqlCliente = "INSERT INTO Vendedor(`fecha_contratacion`, `id_usuario`) VALUES(?,?)";

                    PreparedStatement pstmVendedor = conn.conexion().prepareStatement(sqlCliente);
                    pstmVendedor.setString(1, fechaContratacion);
                    pstmVendedor.setInt(2, id_usuario);

                    // Insertar en Vendedor
                    int affectedRowsCliente = pstmVendedor.executeUpdate();

                    if (affectedRowsCliente > 0) {
                        System.out.println("Vendedor insertado con éxito en la tabla Cliente.");
                    } else {
                        System.out.println("Error al insertar en la tabla Vendedr.");
                    }

                    pstmVendedor.close();
                }
            } else {
                System.out.println("Error al insertar el vendedor en Usuario.");
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

        if (listaVendedor.isEmpty()) {
            return;
        }

        System.out.print("Digite el id del cliente a eliminar: ");
        int id_usuario=in.nextInt();

        // Eliminar primero de la tabla Cliente
        String sqlVendedor = "DELETE FROM Vendedor WHERE id_usuario = ?";
        String sqlUsuario = "DELETE FROM Usuario WHERE id = ?";
        try {
            pstm = conn.conexion().prepareStatement(sqlVendedor);
            pstm.setInt(1, id_usuario);

            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Vendedor eliminado con exito de la tabla Cliente.");

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
                System.out.println("Error al eliminar en la tabla Vendedor.");
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
    public void modificar() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        listar();

        if (listaVendedor.isEmpty()) {
            return;
        }

        System.out.println("Seleccione el ID del vendedor que desea modificar:");
        int id_usuario = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nuevo nombre del vendedor:");
        String nuevoNombre = scanner.nextLine();

        System.out.println("Ingrese la nueva dirección del vendedor:");
        String nuevaDireccion = scanner.nextLine();

        // Sentencia SQL para hacer un UPDATE con un JOIN entre Usuario y Vendedor
        String sql = "UPDATE Usuario u " +
                "JOIN Vendedor v ON u.id = v.id_usuario " +
                "SET u.nombre = ?, u.direccion = ? " +
                "WHERE u.id = ?";
        try {
            pstm = conn.conexion().prepareStatement(sql);
            pstm.setString(1, nuevoNombre);
            pstm.setString(2, nuevaDireccion);
            pstm.setInt(3, id_usuario);

            int affectedRows = pstm.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Vendedor modificado con éxito.");
            } else {
                System.out.println("Error: No se encontró el vendedoor con el ID proporcionado.");
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
    public void listar() throws SQLException {
        String sql = "SELECT u.*, v.fecha_contratacion FROM Usuario u JOIN Vendedor v ON u.id = v.id_usuario WHERE u.id_rol= 3 AND u.estado = 1";
        pstm = conn.conexion().prepareStatement(sql);
        rs = pstm.executeQuery();

        while (rs.next()) {
            Vendedor vendedor = Vendedor.load(rs);
            listaVendedor.add(vendedor);
        }

        String usersFormatted = String.format("Vendedor: %s", listaVendedor);
        System.out.println(usersFormatted);
    }

    @Override
    public void buscar() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite el nombre del vendedor: ");
        String nombre = scanner.nextLine();
        // SQL con JOIN y búsqueda por nombre
        String sql = "SELECT u.*, v.fecha_contratacion FROM Usuario u JOIN Vendedor v ON u.id = v.id_usuario WHERE u.id_rol = 3 AND u.estado = 1 AND u.nombre LIKE ?";

        pstm = conn.conexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        rs = pstm.executeQuery();

        listaVendedor.clear();

        // Mostrar los vendedores encontrados
        System.out.println("Vendedores encontrados:");
        while (rs.next()) {
            Vendedor vendedor = new Vendedor();

            vendedor.setNombre(rs.getString("nombre"));
            vendedor.setApellido(rs.getString("apellido"));
            vendedor.setEmail(rs.getString("email"));
            vendedor.setDireccion(rs.getString("direccion"));
            vendedor.setTelefono(rs.getString("telefono"));
            vendedor.setFecha_contratacion(rs.getDate("fecha_contratacion"));

            listaVendedor.add(vendedor);

            // Mostrar la información del vendedor
            System.out.println("Nombre: " + vendedor.getNombre() + ", Apellido: "+ vendedor.getApellido() + ", Email: " + vendedor.getEmail() + ", Dirección: " + vendedor.getDireccion() + ", Teléfono: " + vendedor.getTelefono() + ", Fecha contratacion: " + vendedor.getFecha_contratacion());
        }

        if (listaVendedor.isEmpty()) {
            System.out.println("No se encontraron clientes con ese nombre.");
        }
    }

    @Override
    public void deshabilitar() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        listar();

        if (listaVendedor.isEmpty()) {
            return;
        }

        // Solicitar el ID del usuario a desactivar
        System.out.println("Ingrese el ID del vendedor que desea desactivar:");
        int id_usuario = scanner.nextInt();

        // Actualizar el estado del usuario a 0 (inactivo) en la tabla Usuario
        String sql = "UPDATE Usuario SET estado = 0 WHERE id = ? AND id_rol = 3";

        try {
            // Preparar y ejecutar la actualización
            pstm = conn.conexion().prepareStatement(sql);
            pstm.setInt(1, id_usuario);
            int affectedRows = pstm.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Vendedor desactivado con éxito.");
            } else {
                System.out.println("Error al desactivar el vendedor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                pstm.close();
            }
        }
    }
}
