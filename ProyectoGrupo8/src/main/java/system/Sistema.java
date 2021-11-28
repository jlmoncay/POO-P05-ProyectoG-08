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
import person.Auspiciante;

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
    private static ArrayList<Ciudad> ciudades;
    private static ArrayList<Auspiciante> auspiciantes;

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

        } while (n != 4);
        System.out.println("Adiós");

        sc.close();

    }

    public static void cargarDatos() {
        //Creación de las 3 ciudades.
        Ciudad ciudad1 = new Ciudad("Guayaquil", "Guayas");
        Ciudad ciudad2 = new Ciudad("Quito", "Pichincha");
        Ciudad ciudad3 = new Ciudad("Cuenca", "Azuay");

        Ciudad.registrarCiudad(ciudades, ciudad1);
        Ciudad.registrarCiudad(ciudades, ciudad2);
        Ciudad.registrarCiudad(ciudades, ciudad3);

        //Creación de los 3 auspiciantes.
        Auspiciante ausp1 = new Auspiciante("Dog Chow", "Urdesa Central", "0942578812", ciudad1, "dogchow@gmail.com", "https://www.purina-latam.com/ec/dogchow");
        Auspiciante ausp2 = new Auspiciante("Pro-can", "Cumbayá", "0967731564", ciudad2, "procan@gmail.com", "https://www.procan.com.ec/");
        Auspiciante ausp3 = new Auspiciante("Agripac", "Totoracocha", "0930696638", ciudad3, "agripac@gmail.com", "https://agripac.com.ec/");

        auspiciantes.add(ausp1);
        auspiciantes.add(ausp2);
        auspiciantes.add(ausp3);

        //Creación de 10 dueños de mascotas
        Dueño dueño1 = new Dueño("0941782564", "Jorge", "Moncayo", "Ceibos", "0936748871", ciudad1, "jorgemoncayo@gmail.com");
        Dueño dueño2 = new Dueño("0986785432", "Aurora", "Quizhpi", "Urdesa", "0977456311", ciudad1, "auroraquizhpi@gmail.com");
        Dueño dueño3 = new Dueño("0973786473", "Andrés", "Borbor", "Vía a la Costa", "0989967542", ciudad1, "andresborbor@gmail.com");
        Dueño dueño4 = new Dueño("0941137845", "Gladys", "Carrillo", "Barrio Centenario", "0975643898", ciudad1, "gladyscarrillo@gmail.com");
        Dueño dueño5 = new Dueño("0985627563", "Stefany", "Farías", "Cumbayá", "0974572123", ciudad2, "stefanyfarias@gmail.com");
        Dueño dueño6 = new Dueño("0923679153", "Rubén", "Icaza", "Bellavista", "0967832564", ciudad2, "rubenicaza@gmail.com");
        Dueño dueño7 = new Dueño("0912347458", "Rocío", "Mera", "Cotocollao", "0975643298", ciudad2, "rociomera@gmail.com");
        Dueño dueño8 = new Dueño("0972563245", "Rodolfo", "Paz", "Totoracocha", "0963826113", ciudad3, "rodolfopaz@gmail.com");
        Dueño dueño9 = new Dueño("0923784624", "Cecilia", "Mera", "Challuabamba", "0974629942", ciudad3, "ceciliamera@gmail.com");
        Dueño dueño10 = new Dueño("0934682564", "Verónica", "Duarte", "Yanuncay", "0952684627", ciudad3, "veronicaduarte@gmail.com");

        dueñoss.add(dueño1);
        dueñoss.add(dueño2);
        dueñoss.add(dueño3);
        dueñoss.add(dueño4);
        dueñoss.add(dueño5);
        dueñoss.add(dueño6);
        dueñoss.add(dueño7);
        dueñoss.add(dueño8);
        dueñoss.add(dueño9);
        dueñoss.add(dueño10);

        //Creación de las 10 mascotas.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       
        Mascota masc1 = new Mascota("Copito", TipoMascota.PERRO, "Bulldog", LocalDate.parse("05/12/2001", formatter), dueño1);
        Mascota masc2 = new Mascota("Hachiko", TipoMascota.PERRO, "Akita", LocalDate.parse("12/04/2005", formatter), dueño2);
        Mascota masc3 = new Mascota("Rex", TipoMascota.PERRO, "Poodle", LocalDate.parse("25/01/2010", formatter), dueño3);
        Mascota masc4 = new Mascota("Pluto", TipoMascota.PERRO, "Pug", LocalDate.parse("07/11/2015", formatter), dueño4);
        Mascota masc5 = new Mascota("Snoppy", TipoMascota.PERRO, "San Bernardo", LocalDate.parse("20/03/2012", formatter), dueño5);
        Mascota masc6 = new Mascota("Milo", TipoMascota.GATO, "Siberiano", LocalDate.parse("18/07/2018", formatter), dueño6);
        Mascota masc7 = new Mascota("Kitty", TipoMascota.GATO, "Persa", LocalDate.parse("28/09/2017", formatter), dueño7);
        Mascota masc8 = new Mascota("Luna", TipoMascota.GATO, "Siamés", LocalDate.parse("06/03/2020", formatter), dueño8);
        Mascota masc9 = new Mascota("Tom", TipoMascota.GATO, "Ragdoll", LocalDate.parse("04/04/2007", formatter), dueño9);
        Mascota masc10 = new Mascota("Ruby", TipoMascota.GATO, "Angora", LocalDate.parse("13/06/2021", formatter), dueño10);
        
        mascotas.add(masc1);
        mascotas.add(masc2);
        mascotas.add(masc3);
        mascotas.add(masc4);
        mascotas.add(masc5);
        mascotas.add(masc6);
        mascotas.add(masc7);
        mascotas.add(masc8);
        mascotas.add(masc9);
        mascotas.add(masc10);
        
        
    }

}
