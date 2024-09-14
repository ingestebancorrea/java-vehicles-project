package org.example.models;

public class Ubicacion {
    private int id;
    private String pais;
    private String ciudad;

    // Constructor
    public Ubicacion(int id, String pais, String ciudad) {
        this.id = id;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    // Métodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
