package org.example.models;

public class Administrador extends Usuario{
    private int id;
    private int id_usuario;

    public Administrador(int id, int id_usuario) {
        this.id = id;
        this.id_usuario = id_usuario;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

}
