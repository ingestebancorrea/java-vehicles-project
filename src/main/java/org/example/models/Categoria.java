package org.example.models;

public class Categoria {
    private int id;
    private String name;
    private String alias;

    // Constructor
    public Categoria(int id, String name, String alias) {
        this.id = id;
        this.name = name;
        this.alias = alias;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
