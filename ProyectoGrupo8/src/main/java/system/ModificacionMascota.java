/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system;

import diseño.Mascota;
import diseño.TipoMascota;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import person.Dueño;

/**
 *
 * @author alexc
 */
public class ModificacionMascota {

    private static void crearMascota(Scanner sc, DateTimeFormatter formatter, ArrayList<Dueño> dueñoss, ArrayList<Mascota> mascotas) {
        String nombre = solicitarNombreMascota(sc);
        String tipo = solicitarTipoMascota(sc);
        String raza = solicitarRazaMascota(sc);
        LocalDate formato = solicitarFechaMascota(sc, formatter);

        Dueño dueñoR = solicitarDueñoPorCedula(sc, dueñoss);
        if (dueñoR == null) {
            System.out.println("No se ha encontrado la información, por favor registre primero al dueño");
        } else {
            registrarMascota(nombre, tipo, raza, formato, dueñoR, mascotas);
        }
    }

    private static String solicitarNombreMascota(Scanner sc) {
        System.out.println("Ingrese el nombre de la mascota: ");
        return sc.nextLine();
    }

    private static String solicitarTipoMascota(Scanner sc) {
        System.out.println("Ingrese el tipo de mascota (Perro o Gato): ");
        return sc.nextLine();
    }

    private static String solicitarRazaMascota(Scanner sc) {
        System.out.println("Ingrese la raza de su mascota: ");
        return sc.nextLine();
    }

    private static LocalDate solicitarFechaMascota(Scanner sc, DateTimeFormatter formatter) {
        System.out.println("Ingrese la fecha de hoy en formato dd/mm/yyyy: ");
        String fech = sc.nextLine();
        return LocalDate.parse(fech, formatter);
    }
    
    private static Dueño solicitarDueñoPorCedula(Scanner sc, ArrayList<Dueño> dueñoss) {
        System.out.println("Ingrese la cedula del dueño de la mascota: ");
        String ceduDueño = sc.nextLine();
        return buscarDueñoPorCedula(ceduDueño, dueñoss);
    }

    private static Dueño buscarDueñoPorCedula(String cedula, ArrayList<Dueño> dueñoss) {
        for (Dueño d : dueñoss) {
            if (cedula.equals(d.getCedula())) {
                return d;
            }
        }
        return null;
    }

    private static void registrarMascota(String nombre, String tipo, String raza, LocalDate formato, Dueño dueñoR, ArrayList<Mascota> mascotas) {
        TipoMascota tipoMascota = tipo.toUpperCase().equals("GATO") ? TipoMascota.GATO : TipoMascota.PERRO;
        Mascota masc = new Mascota(nombre, tipoMascota, raza, formato, dueñoR);
        Mascota.registrarMascota(mascotas, masc);
    }

    private static void eliminarMascota(Scanner sc, ArrayList<Mascota> mascotas) {
        System.out.println("Eliminar mascota");
        System.out.println("Ingrese la id de la Mascota a eliminar: ");
        int idMascotaEliminar = sc.nextInt();
        sc.nextLine();

        boolean eliminada = false;
        Iterator<Mascota> iterator = mascotas.iterator();
        while (iterator.hasNext()) {
            Mascota m = iterator.next();
            if (m.getIdMascota() == idMascotaEliminar) {
                iterator.remove();
                System.out.println("Esa mascota ha sido eliminada");
                eliminada = true;
                break;
            }
        }

        if (!eliminada) {
            System.out.println("Esa mascota no se encuentra registrada");
        }
    }

}
