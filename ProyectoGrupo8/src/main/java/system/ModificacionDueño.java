/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system;

import concurso.Ciudad;
import java.util.ArrayList;
import java.util.Scanner;
import person.Dueño;

/**
 *
 * @author alexc
 */
public class ModificacionDueño {

    private static void editarDueño(String cedula, ArrayList<Dueño> dueñoss) {
        Dueño dueñoAEditar = buscarDueñoPorCedula(cedula, dueñoss);
        if (dueñoAEditar != null) {
            solicitarDatosDueño(dueñoAEditar);
        } else {
            System.out.println("No se encontró el dueño con la cédula ingresada.");
        }
    }

    private static Dueño buscarDueñoPorCedula(String cedula, ArrayList<Dueño> dueñoss) {
        for (Dueño dueño : dueñoss) {
            if (dueño.getCedula().equals(cedula)) {
                return dueño;
            }
        }
        return null;
    }

    private static void solicitarDatosDueño(Dueño dueño) {

        Scanner sc = new Scanner(System.in);
        dueño.setNombre(solicitarString("Ingrese el nombre: "));
        dueño.setApellido(solicitarString("Ingrese apellido: "));
        dueño.setDireccion(solicitarString("Ingrese dirección: "));
        dueño.setTelefono(solicitarString("Ingrese número de teléfono: "));
        dueño.setCiudad(solicitarCiudad());
        dueño.setEmail(solicitarString("Ingrese email: "));

    }

    private static String solicitarString(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        return sc.nextLine();
    }

    private static Ciudad solicitarCiudad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese ciudad: ");
        String ciudad = sc.nextLine();

        System.out.println("Ingrese provincia: ");
        String provincia = sc.nextLine();

        return new Ciudad(ciudad, provincia);
    }

}
