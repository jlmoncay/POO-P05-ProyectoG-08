/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import diseño.Ciudad;
import diseño.Dueño;
import diseño.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Beatriz Quizhpi
 */
public class Sistema {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Dueño> dueñoss;

    public static void main(String[] args) {
        // TODO code application logic here

        dueñoss = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.println("Bienvenidos al Sistema");
            System.out.println("1.Administrar Concursos\n" + "2.Administar Dueños\n" + "3.Administar Mascotas\n" + "4.Salir");
            n = sc.nextInt();
            sc.nextLine();
            if (n == 1) {
                System.out.println("1.Crear concursos\n" + "2.Inscribir participante\n" + "3.Regresar al menú principal\n");
                int b = sc.nextInt();
                switch (b) {
                    case 1:
                        System.out.println("En caso 1");

                        break;

                    case 2:
                        System.out.println("En caso 2");

                        break;

                    case 3:
                        System.out.println("En caso 3");
                        break;

                }

            } else if (n == 2) {
                Dueño.mostrarDueños(dueñoss); 

                System.out.println("1.Crear dueño\n" + "2.Editar dueño\n" + "3.Regresar al menú principal\n");
                int c = sc.nextInt();
                sc.nextLine();
                switch (c) {
                    
                    case 1:
                        System.out.println("Ingrese los datos del dueño: ");
                        System.out.println("Ingrese número de cedula ");
                        String ced = sc.nextLine();
                        System.out.println("Ingrese el nombre:  ");

                        String name = sc.nextLine();
                        System.out.println("Ingrese apellido:  ");
                        String apell = sc.nextLine();
                        System.out.println("Ingrese dirección:  ");
                        String direcc = sc.nextLine();
                        System.out.println("Ingrese número de teléfono: ");
                        String telf = sc.nextLine();
                        System.out.println("Ingrese ciudad: ");
                        String ciud = sc.nextLine();
                        System.out.println("Ingrese provincia: ");
                        String prov = sc.nextLine();
                        System.out.println("Ingrese email: ");
                        String mail = sc.nextLine();
                        Ciudad ciudad = new Ciudad(ciud, prov);
                        Dueño due = new Dueño(ced, name, apell, direcc, telf, ciudad, mail);
                        due.toString();
                        dueñoss.add(due);

                        break;
                    case 2:
                        System.out.println("Editar Dueño");
                        System.out.println("Ingrese un número de cédula: ");
                        String cedul = sc.nextLine();


                        break;
                    case 3:
                        System.out.println("En caso 3d");
                        break;

                }

            }

        } while (n != 4);
        System.out.println("Adiós");

    }

}



