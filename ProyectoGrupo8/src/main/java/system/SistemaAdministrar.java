/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system;

import concurso.Ciudad;
import concurso.Concurso;
import diseño.Mascota;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import person.Dueño;
import static person.Dueño.editarDueño;
import static system.Sistema.adminConcursos;

/**
 *
 * @author alexc
 */
public class SistemaAdministrar {

    public static void mostrarYAdministrarConcursos() {
        List<Concurso> concursos = null;
        Concurso.mostrarConcusos(concursos);
        adminConcursos();
    }

    public static void administarDueños() {
        ArrayList<Dueño> dueñoss = null;
        Dueño.mostrarDueños(dueñoss);
        System.out.println("1.Crear dueño\n" + "2.Editar dueño\n" + "3.Regresar al menú principal\n");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        sc.nextLine();
        switch (c) {

            case 1:
                System.out.println("Ingrese los datos del dueño: ");
                String ced = solicitarString("Ingrese número de cedula: ");
                String name = solicitarString("Ingrese el nombre: ");
                String apell = solicitarString("Ingrese apellido: ");
                String direcc = solicitarString("Ingrese dirección: ");
                String telf = solicitarString("Ingrese número de teléfono: ");
                String ciuda = solicitarString("Ingrese ciudad: ");
                String prov = solicitarString("Ingrese provincia: ");
                String mail = solicitarString("Ingrese email: ");

                Ciudad ciudad = new Ciudad(ciuda, prov);
                Dueño due = new Dueño(ced, name, apell, direcc, telf, ciudad, mail);
                dueñoss.add(due);

                System.out.println("Dueño registrado exitosamente:\n" + due);

                break;
            case 2:
                System.out.println("Editar Dueño");
                System.out.println("Ingrese un número de cédula: ");
                String cedul = sc.nextLine();
                editarDueño(cedul, dueñoss);
                break;

            case 3:
                System.out.println("Bienvenido al menú principal");
                break;

        }
    }

    public static void administarMascotas() {
        ArrayList<Mascota> mascotas = null;
        Mascota.mostrarMascotas(mascotas);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("1.Crear mascota\n" + "2.Eliminar mascota\n" + "3.Regresar al menú principal\n");
        Scanner sc=new Scanner(System.in);
        int c = sc.nextInt();
        sc.nextLine();
        switch (c) {
            case 1:
                crearMascota(sc, formatter, dueñoss, mascotas);
                break;
            case 2:
                eliminarMascota(sc, mascotas);
                break;
            case 3:
                System.out.println("Bienvenido al menú principal");
                break;
        }
    }

    

    public static void cargarDatos() {
        // Lógica para cargar los datos iniciales...
    }

    private static String solicitarString(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        return sc.nextLine();
    }

}
