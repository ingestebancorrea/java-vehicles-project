package org.example.dao;

import org.example.models.Usuario;
import org.example.models.Vendedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void insertar() throws SQLException {
        Scanner in = new Scanner(System.in);

        // Date formatter to parse and format dates
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            System.out.println("Digite la fecha de contratación del vendedor (DD/MM/YYYY): ");
            String fechaContratacionInput = in.nextLine();

            // Parse the input date
            Date fechaContratacionDate = inputFormat.parse(fechaContratacionInput);

            // Format the date to match MySQL's expected format
            String fechaContratacion = outputFormat.format(fechaContratacionDate);

            System.out.println("Digite la comisión recibida: ");
            int comision = in.nextInt();

            System.out.println("Digite el id usuario: ");
            int idUsuario = in.nextInt();

            String sql = "INSERT INTO Vendedor(`fecha_contratacion`, `comision`, `id_usuario`) VALUES(?,?,?)";
            PreparedStatement stm = conn.conexion().prepareStatement(sql);
            stm.setString(1, fechaContratacion);
            stm.setInt(2, comision);
            stm.setInt(3, idUsuario);

            int rs = stm.executeUpdate();

            if (rs > 0) {
                System.out.println("Registro insertado de forma correcta");
            } else {
                System.out.println("Fallo en la inserción");
            }
        }catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

    @Override
    public void eliminar() throws SQLException {
        Scanner in=new Scanner(System.in);

        System.out.print("Digite el id del vendedor a eliminar: ");
        int id=in.nextInt();

        String sql="DELETE FROM Vendedor WHERE id=?";
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

            System.out.println("Digite la nueva comisión del vendedor: ");
            int comision = in.nextInt();
            System.out.println("Digite el ID del vendedor a actualizar: ");
            int id= in.nextInt();

            String sql="UPDATE Vendedor SET comision=? WHERE id=?";
            var stm= conn.conexion().prepareStatement(sql);
            stm.setObject(1, comision);
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
        String sql = "SELECT * FROM Vendedor";
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
        Scanner in = new Scanner(System.in);
        System.out.println("Digite el id de usuario: ");
        int idUsuario = in.nextInt();

        String sql = "SELECT * FROM Vendedor where id_usuario=?";
        pstm = conn.conexion().prepareStatement(sql);
        pstm.setObject(1, idUsuario);
        rs = pstm.executeQuery();

        while (rs.next()) {
            Vendedor vendedor = Vendedor.load(rs);
            listaVendedor.add(vendedor);
        }

        String usersFormatted = String.format("Vendedor: %s", listaVendedor);
        System.out.println(usersFormatted);
    }

    @Override
    public void deshabilitar() throws SQLException {

    }
}
