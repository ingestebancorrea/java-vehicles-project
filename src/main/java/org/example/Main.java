package org.example;

import org.example.models.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario user1 = new Usuario();
        user1.setId(1);
        user1.setNombre("Sergio");
        user1.setApellido("Prask");
        user1.setId_tipodocumento(1);
        user1.setNumerodocumento("455147664");
        user1.setEmail("sergio@gmail.com");
        user1.setDireccion("Parque heredia");
        user1.setTelefono("3218416645");
        user1.setId_rol(1);
        user1.setEstado(true);

        System.out.println("User1: " + user1.getNombre() + " " + user1.getApellido());

        Usuario user2 = new Usuario(1,"Esteban","Correa",1, "1007256470","esteban18101@hotmail.com","Portales de San Fernando", "3017173082", 1, true);
        System.out.println("User2: " + user2.getNombre() + " " +user2.getApellido());
    }
}