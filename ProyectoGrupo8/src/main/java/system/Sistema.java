/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import concurso.Ciudad;
import concurso.Concurso;
import person.Dueño;
import person.Persona;
import diseño.Mascota;
import diseño.TipoMascota;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Beatriz Quizhpi
 */
public class Sistema {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Dueño> dueñoss;
    private static ArrayList<Mascota> mascotas;
    private static ArrayList<Concurso> concursos;

    public static void main(String[] args) {
        // TODO code application logic here
        dueñoss = new ArrayList<>();
        mascotas = new ArrayList<>();
        concursos = new ArrayList<>();
        Mascota.setIdFinal(mascotas.size());
        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.println("\nBienvenidos al Sistema");
            System.out.println("1.Administrar Concursos\n" + "2.Administar Dueños\n" + "3.Administar Mascotas\n" + "4.Salir");
            System.out.println("Ingrese una opción: ");
            n = sc.nextInt();
            sc.nextLine();
            
            if (n == 1) {
                
                Concurso.mostrarConcusos(concursos);
                Concurso.adminConcursos();

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
                        String ciuda = sc.nextLine();
                        System.out.println("Ingrese provincia: ");
                        String prov = sc.nextLine();
                        System.out.println("Ingrese email: ");
                        String mail = sc.nextLine();
                        Ciudad ciudad = new Ciudad(ciuda, prov);
                        Dueño due = new Dueño(ced, name, apell, direcc, telf, ciudad, mail);
                        due.toString();
                        dueñoss.add(due);

                        break;
                    case 2:
                        System.out.println("Editar Dueño");
                        System.out.println("Ingrese un número de cédula: ");
                        String cedul = sc.nextLine();
                        Dueño.editarDueño(cedul, dueñoss);

                        break;
                    case 3:
                        System.out.println("Bienvenido al menú principal");
                        break;

                }

            } else if (n == 3) {
                Mascota.mostrarMascotas(mascotas);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                System.out.println("1.Crear mascota\n" + "2.Eliminar mascota\n" + "3.Regresar al menú principal\n");
                int c = sc.nextInt();
                sc.nextLine();
                switch (c) {
                    case 1:
                        System.out.println("Ingrese el nombre de la mascota: ");
                        String nombre = sc.nextLine();
                        System.out.println("Ingrese el tipo de mascota (Perro o Gato): ");
                        String tipo = sc.nextLine();
                        System.out.println("Ingrese la raza de su mascota: ");
                        String raza = sc.nextLine();
                        System.out.println("Ingrese la fecha de hoy en formato dd/mm/yyyy: ");
                        String fech = sc.nextLine();
                        LocalDate formato = LocalDate.parse(fech, formatter);
                        System.out.println("Ingrese la cedula del dueño de la mascota: ");
                        String ceduDueño = sc.nextLine();

                        Dueño dueñoR = null;
                        for (Dueño d : dueñoss) {
                            String cedula = d.getCedula();
                            if (ceduDueño.equals(cedula)) {
                                dueñoR = d;
                            }
                            System.out.println(dueñoR.getCedula());
                        }
                        if (dueñoR.equals(null)) {
                            System.out.println("No se ha encontrado la informacion, porfavor registre primero al dueño");
                            break;
                        } else {

                            if (tipo.toUpperCase().equals("GATO")) {
                                Mascota masc = new Mascota(nombre, TipoMascota.GATO, raza, formato, dueñoR);
                                masc.registrarMascota(mascotas, masc);
                            } else if (tipo.toUpperCase().equals("PERRO")) {
                                Mascota masc = new Mascota(nombre, TipoMascota.PERRO, raza, formato, dueñoR);
                                masc.registrarMascota(mascotas, masc);
                            }

                        }
                        break;
                    case 2:

                        System.out.println("Eliminar mascota");
                        System.out.println("Ingrese la id de la Mascota a eliminar: ");
                        int idMascotaEliminar = sc.nextInt();
                        sc.nextLine();
                        boolean bool = false;
                        for (Mascota m : mascotas) {

                            int id = m.getIdMascota();
                            if (id == idMascotaEliminar) {
                                mascotas.remove(m);
                                System.out.println("Esa mascota ha sido eliminada");
                                bool = true;
                                break;
                            } else {
                                bool = false;
                            }
                        }
                        if (bool == false) {
                            System.out.println("Esa mascota no se encuentra registrada");
                        }

                        break;
                    case 3:
                        System.out.println("Bienvenido al menú principal");
                        break;

                }
            }

        } while (n!= 4);
            System.out.println("Adiós");

        sc.close();

    }
    
   
    
}
    
    

    

    

