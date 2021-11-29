/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import concurso.Ciudad;
import concurso.Concurso;
import concurso.EstadoConcurso;
import concurso.Premio;
import person.Dueño;
import person.Persona;
import diseño.Mascota;
import diseño.TipoConcursante;
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
    private static ArrayList<Dueño> dueñoss = new ArrayList<>();
    private static ArrayList<Mascota> mascotas = new ArrayList<>();
    private static ArrayList<Concurso> concursos = new ArrayList<>();
    private static ArrayList<Ciudad> ciudades = new ArrayList<>();
    private static ArrayList<Auspiciante> auspiciantes = new ArrayList<>();
    private static ArrayList<Premio> premios = new ArrayList<>();
    private static ArrayList<Mascota> mascotasParticiparon = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here
        /*dueñoss = new ArrayList<>();
        mascotas = new ArrayList<>();
        concursos = new ArrayList<>();*/
        
        cargarDatos();
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
                adminConcursos();

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
                                Mascota.registrarMascota(mascotas, masc);
                            } else if (tipo.toUpperCase().equals("PERRO")) {
                                Mascota masc = new Mascota(nombre, TipoMascota.PERRO, raza, formato, dueñoR);
                                Mascota.registrarMascota(mascotas, masc);
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


    }
    
    public static void adminConcursos() {
        int opcion = menuAdminConcursos();
        switch (opcion) {
            case 1:
                crearConcurso();
                break;
            case 2:
                inscribirParticipante();
                break;
            case 3:
                break;          
            default:
                System.out.println("Ingrese una opción válida");
        }
    }
    
    public static int menuAdminConcursos() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.print("\n1. Crear concurso\n"
                    + "2. Inscribir participante\n"
                    + "3. Regresar al menú principal\n");
      
            System.out.println("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
        } while ((opcion < 1) || (opcion > 3));  
        return opcion;  
    }
    
    public static void crearConcurso() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("-- Crear concurso --");
        System.out.println("Ingrese el nombre del concurso: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la fecha en la que se realizará el concurso (dd/mm/yyyy): "); 
        String fechaEvento = sc.nextLine();
        System.out.println("Ingrese la hora en la que se realizará el concurso (hh:mm:ss): ");
        String horaEvento = sc.nextLine();
        System.out.println("Ingrese la fecha de inicio de las inscripciones (dd/mm/yyyy): ");
        String fechaInicioIns = sc.nextLine();
        System.out.println("Ingrese la fecha de cierre de las inscripciones (dd/mm/yyyy): ");
        String fechaCierreIns = sc.nextLine();
        System.out.println("Ingrese el nombre de la ciudad donde se realizará el concurso (Guayaquil - Quito - Cuenca): ");
        String nombreCiudad = sc.nextLine();
        Ciudad ciudad = null;
        for (Ciudad c : ciudades) {
            if (nombreCiudad.toLowerCase().equals(c.getNombre().toLowerCase())) {
                ciudad = c;
            }
        }
        TipoConcursante tipo;
        System.out.println("Ingrese el tipo de concursante que participará (GATO - PERRO - AMBOS): ");
        String tipoConcur = sc.nextLine().toUpperCase();
        if (tipoConcur.equals("AMBOS")) {
            tipo = TipoConcursante.AMBOS;
        } else if (tipoConcur.equals("GATO")) {
            tipo = TipoConcursante.GATO;
        } else {
            tipo = TipoConcursante.PERRO;
        }  
        EstadoConcurso estado;
        System.out.println("Ingrese el estado del concurso (PASADO - VIGENTE): ");
        String estadoConcur = sc.nextLine().toUpperCase();
        if (estadoConcur.equals("PASADO")) {
            estado = EstadoConcurso.PASADO;
        } else {
            estado = EstadoConcurso.VIGENTE;
        }    
        Concurso nuevoConcurso = new Concurso(nombre, LocalDate.parse(fechaEvento, formatter), horaEvento, LocalDate.parse(fechaInicioIns, formatter), LocalDate.parse(fechaCierreIns, formatter), ciudad, premios, auspiciantes, tipo, estado, mascotas);
        
        Concurso.registrarConcurso(concursos, nuevoConcurso);        
    }
    
    public static void inscribirParticipante() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n-- Inscribir participante al concurso --");
        System.out.println("Los concursos que se encuentran vigentes son: ");
        String continuar = "";
        for (Concurso c : concursos) {
            if (c.getEstado().equals(EstadoConcurso.VIGENTE)) {
                System.out.println(c);
                continuar = "S";
            } else if (continuar.equals("")) {
                System.out.println("Por el momento no hay concursos vigentes.");
            }
        }
        if (continuar.toLowerCase().equals("s")) {
            System.out.println("Ingrese el código del concurso donde desea inscribir a su mascota: ");
            int codigoConcur = sc.nextInt();
            sc.nextLine();
            Concurso concur = null;
            for (Concurso c : concursos) {
                if (c.getCodigo() == codigoConcur) {
                    concur = c;
                }
            }
            switch (concur.getDirigido()) {
                case PERRO:
                    System.out.println("La lista de mascotas es la siguiente: ");
                    for (Mascota m : mascotas) {
                        if (m.getTipo().equals(TipoMascota.PERRO)) {
                            System.out.println(m);
                        }
                    }
                    break;

                case GATO:
                    System.out.println("La lista de mascotas es la siguiente: ");
                    for (Mascota m : mascotas) {
                        if (m.getTipo().equals(TipoMascota.GATO)) {
                            System.out.println(m);
                        }
                    }
                    break;
                               
                default:
                    System.out.println("La lista de mascotas es la siguiente: ");
                    for (Mascota m : mascotas) {
                        System.out.println(m);
                    }
            }
            System.out.println("Ingrese el id de la mascota a inscribir: ");
            int codigoMasc = sc.nextInt();
            sc.nextLine();
            int indiceMasc = 0;
            for (Mascota m : mascotas) {
                if (m.getIdMascota() == codigoMasc) {
                    indiceMasc = m.getIdMascota();
                }
            }
            
            concur.getMascotas().add(mascotas.get(indiceMasc));
            mascotasParticiparon.add(mascotas.get(indiceMasc));
            System.out.println("\nLa mascota ha sido inscrita exitosamente.");
            
        } else {
            System.out.println("Primero registre un concurso vigente.");
        }
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
        
        Auspiciante.registrarAuspiciante(auspiciantes, ausp1);
        Auspiciante.registrarAuspiciante(auspiciantes, ausp2);
        Auspiciante.registrarAuspiciante(auspiciantes, ausp3);

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
        
        Mascota.registrarMascota(mascotas, masc1);
        Mascota.registrarMascota(mascotas, masc2);
        Mascota.registrarMascota(mascotas, masc3);
        Mascota.registrarMascota(mascotas, masc4);
        Mascota.registrarMascota(mascotas, masc5);
        Mascota.registrarMascota(mascotas, masc6);
        Mascota.registrarMascota(mascotas, masc7);
        Mascota.registrarMascota(mascotas, masc8);
        Mascota.registrarMascota(mascotas, masc9);
        Mascota.registrarMascota(mascotas, masc10);
    
        //Creación de 3 premios.
        Premio premio1 = new Premio(ausp1, "Primer lugar", "$500 y productos Dog Chow", masc1);
        Premio premio2 = new Premio(ausp2, "Segundo lugar", "$300 y productos Pro-can", masc5);
        Premio premio3 = new Premio(ausp3, "Tercer lugar", "$100 y productos Agripac", masc9);
        
        premios.add(premio1);
        premios.add(premio2);
        premios.add(premio3);
        
       //Creación de un concurso vigente.
       Concurso concursoVigente1 = new Concurso("Expo Pet 2021", LocalDate.parse("30/11/2021", formatter), "15:00:00", LocalDate.parse("05/11/2021", formatter), LocalDate.parse("10/11/2021", formatter), ciudad1, premios, auspiciantes, TipoConcursante.PERRO, EstadoConcurso.VIGENTE, mascotas);  
       Concurso.registrarConcurso(concursos, concursoVigente1);
       
       //Creación de un concurso pasado.
       ArrayList<Mascota> listaMascotas = new ArrayList<>();
       listaMascotas.add(masc1);
       listaMascotas.add(masc3);
       listaMascotas.add(masc5);
       listaMascotas.add(masc7);
       listaMascotas.add(masc9);
       Concurso concursoPasado = new Concurso("Insta Pet", LocalDate.parse("25/07/2019", formatter), "12:00:00", LocalDate.parse("15/06/2021", formatter), LocalDate.parse("22/07/2021", formatter), ciudad2, premios, auspiciantes, TipoConcursante.AMBOS, EstadoConcurso.PASADO, listaMascotas);
       Concurso.registrarConcurso(concursos, concursoPasado);     
    }
}
