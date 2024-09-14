package org.example.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EnvioDAO implements InterfaceDAO {
    ConexionDB conn = new ConexionDB();

    @Override
    public void insertar() throws SQLException {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Digite id del vehiculo: ");
            int idVehiculo = in.nextInt();
            in.nextLine(); // Consume the leftover newline
            System.out.println("Digite la cantidad: ");
            int cantidad = in.nextInt();
            in.nextLine(); // Consume the leftover newline
            System.out.println("Digite la fecha de envio (DD/MM/YYYY): ");
            String fechaEnvioInput = in.nextLine();
            System.out.println("Digite la dirección del envio: ");
            String direccion = in.nextLine();
            System.out.println("Digite id del estado del envio: ");
            int idEstado = in.nextInt();

            String fechaEnvio = formatDate(fechaEnvioInput);

            String sql = "INSERT INTO Envio (`id_vehiculo`, `cantidad`, `fecha`, `direccion`, `id_estado`) VALUES (?,?,?,?,?)";
            var stm = conn.conexion().prepareStatement(sql);
            stm.setInt(1, idVehiculo);
            stm.setInt(2, cantidad);
            stm.setString(3, fechaEnvio);
            stm.setString(4, direccion);
            stm.setInt(5, idEstado);

            int rs = stm.executeUpdate();

            if (rs > 0) {
                System.out.println("Registro insertado de forma correcta");
            } else {
                System.out.println("Fallo en la insercion");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            in.close(); // Asegúrate de cerrar el scanner
        }
    }

    private String formatDate(String fechaEnvioInput) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaDate = null;
        try {
            fechaDate = inputFormat.parse(fechaEnvioInput);
        } catch (ParseException e) {
            throw new RuntimeException("Formato de fecha inválido: " + e.getMessage());
        }

        return outputFormat.format(fechaDate);
    }

    @Override
    public void eliminar() throws SQLException {

    }

    @Override
    public void modificar() throws SQLException {

    }

    @Override
    public void listar() throws SQLException {

    }

    @Override
    public void buscar() throws SQLException {

    }

    @Override
    public void deshabilitar() throws SQLException {

    }
}
