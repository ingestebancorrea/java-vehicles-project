package org.example.models;

public class Vehiculo {
    private int id;
    private String name;
    private int id_categoria;
    private String marca;
    private String placa;
    private int id_tipovehiculo;
    private double precio;
    private String especificaciones;
    private int id_ubicacion;
    private String modelo;
    private boolean estado;

    // Constructor
    public Vehiculo(int id, String name, int id_categoria, String marca, String placa, int id_tipovehiculo, double precio, String especificaciones, int id_ubicacion, String modelo, boolean estado) {
        this.id = id;
        this.name = name;
        this.id_categoria = id_categoria;
        this.marca = marca;
        this.placa = placa;
        this.id_tipovehiculo = id_tipovehiculo;
        this.precio = precio;
        this.especificaciones = especificaciones;
        this.id_ubicacion = id_ubicacion;
        this.modelo = modelo;
        this.estado = estado;
    }

    // Métodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getId_tipovehiculo() {
        return id_tipovehiculo;
    }

    public void setId_tipovehiculo(int id_tipovehiculo) {
        this.id_tipovehiculo = id_tipovehiculo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
