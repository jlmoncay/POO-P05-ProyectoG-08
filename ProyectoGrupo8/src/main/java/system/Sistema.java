package system;

import concurso.Ciudad;
import concurso.Concurso;
import static concurso.Concurso.crearConcurso;
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
import static system.ClaseSistema.mostrarMenuPrincipal;
import static system.ClaseSistema.procesarOpcion;
import static system.Participante.inscribirParticipante;
import static system.SolicitarDatos.crearConcurso;

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
        int opcion;
        Scanner sc = new Scanner(System.in);

        do {
            mostrarMenuPrincipal();
            opcion = sc.nextInt();
            sc.nextLine();
            procesarOpcion(opcion);
        } while (opcion != 4);

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

    /**
     * Este método muestra el menú de Administrar Concursos y le pide al usuario
     * una opción para luego retornarla.
     *
     * @return Retorna la opción ingresada por el usuario.
     */
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

    /**
     * Este método pide al usuario todos los datos necesarios para crear un
     * concurso. Luego de ingresar los datos, se crea el nuevo concurso y se lo
     * agrega a la lista de concursos existentes.
     */
    /**
     * Este método pide al usuario la información necesaria para inscribir una
     * mascota a un concurso vigente.
     */
    /**
     * Este método carga los datos iniciales que se solicitaron en las
     * indicaciones del proyecto. Crea tres ciudades, tres auspiciantes, diez
     * dueños de mascotas, diez mascotas, tres premios, un concurso pasado y un
     * concurso vigente.
     */
    public static void cargarDatos() {
        //Creación de las 3 ciudades.
        cargarCiudades();
        cargarAuspiciantes();
        cargarDueños();
        cargarMascotas();
        cargarPremios();
        cargarConcursos();
    }
    
    private static void cargarCiudades() {
        Ciudad ciudad1 = new Ciudad("Guayaquil", "Guayas");
        Ciudad ciudad2 = new Ciudad("Quito", "Pichincha");
        Ciudad ciudad3 = new Ciudad("Cuenca", "Azuay");
        ArrayList<Ciudad> ciudades = null;

        Ciudad.registrarCiudad(ciudades, ciudad1);
        Ciudad.registrarCiudad(ciudades, ciudad2);
        Ciudad.registrarCiudad(ciudades, ciudad3);
    }

    private static void cargarAuspiciantes() {
        Auspiciante ausp1 = new Auspiciante("Dog Chow", "Urdesa Central", "0942578812", ciudades.get(0), "dogchow@gmail.com", "https://www.purina-latam.com/ec/dogchow");
        Auspiciante ausp2 = new Auspiciante("Pro-can", "Cumbayá", "0967731564", ciudades.get(1), "procan@gmail.com", "https://www.procan.com.ec/");
        Auspiciante ausp3 = new Auspiciante("Agripac", "Totoracocha", "0930696638", ciudades.get(2), "agripac@gmail.com", "https://agripac.com.ec/");
        ArrayList<Auspiciante> auspiciantes;

        Auspiciante.registrarAuspiciante(auspiciantes, ausp1);
        Auspiciante.registrarAuspiciante(auspiciantes, ausp2);
        Auspiciante.registrarAuspiciante(auspiciantes, ausp3);
    }

    private static void cargarDueños() {
        // Creación y registro de dueños
        // ...
    }

    private static void cargarMascotas() {
        // Creación y registro de mascotas
        // ...
    }

    private static void cargarPremios() {
        // Creación y registro de premios
        // ...
    }

    private static void cargarConcursos() {
        // Creación y registro de concursos
        // ...
    }
}
