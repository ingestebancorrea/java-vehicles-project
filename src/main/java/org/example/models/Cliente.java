package org.example.models;

public class Cliente extends Usuario {
    private int id;
    private int id_usuario;

    public Cliente(int id, int id_usuario) {
        this.id = id;
        this.id_usuario = id_usuario;
    }


    public int getId() {
        return id;
    }

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
