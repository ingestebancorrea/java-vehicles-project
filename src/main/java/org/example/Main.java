package org.example;

import org.example.models.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Rol rol = new Rol(1,"Cliente","CL");
        TipoDocumento tipoDocumento = new TipoDocumento(1,"Cédula Ciudadanía","CC");
        Usuario user = new Usuario(1,"Esteban","Correa",tipoDocumento.getId(), "1007256470","esteban18101@hotmail.com","Portales de San Fernando", "3017173082", rol.getId(), true);
        EstadoEnvio estadoEnvio = new EstadoEnvio(1,"en transito", "TRA");
        Envio envio = new Envio(1,1,1, new Date(), "la victoria", estadoEnvio.getId());

        System.out.println("Envio: " + envio.getDireccion());
        System.out.println("User: " + user.getNombre() + " " +user.getApellido());
        System.out.println("Rol: " + rol.getName());
        System.out.println("Tipo Documento: " + tipoDocumento.getName());
    }
}