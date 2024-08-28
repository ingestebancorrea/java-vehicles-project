package org.example;

import org.example.models.Rol;
import org.example.models.TipoDocumento;
import org.example.models.Usuario;

public class Main {
    public static void main(String[] args) {
        Rol rol = new Rol(1,"Cliente","CL");
        TipoDocumento tipoDocumento = new TipoDocumento(1,"Cédula Ciudadanía","CC");
        Usuario user = new Usuario(1,"Esteban","Correa",tipoDocumento.getId(), "1007256470","esteban18101@hotmail.com","Portales de San Fernando", "3017173082", rol.getId(), true);

        System.out.println("User: " + user.getNombre() + " " +user.getApellido());
        System.out.println("Rol: " + rol.getName());
        System.out.println("Tipo Documento: " + tipoDocumento.getName());
    }
}