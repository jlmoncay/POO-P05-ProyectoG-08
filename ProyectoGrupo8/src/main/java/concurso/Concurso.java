/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurso;

import diseño.Mascota;
import diseño.TipoConcursante;
import diseño.TipoMascota;
import java.time.LocalDate;
import person.Auspiciante;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jorge Moncayo Paz
 */
public class Concurso {

    //Atributos de la clase.
    private String nombre;      //Nombre del concurso.
    private LocalDate fechaEvento;      //Fecha en la que se realizará el concurso.
    private String horaEvento;      //Hora en la que se realizará el concurso.
    private LocalDate fechaInicioIns;       //Fecha de inicio de las inscripciones del concurso.
    private LocalDate fechaCierreIns;       //Fecha de cierre de las inscripciones del concurso.
    private Ciudad ciudad;      //Ciudad donde se realizará el concurso.
    private List<Premio> premios = new ArrayList<Premio>();     //Lista que contiene los premios para los ganadores del concurso.
    private List<Auspiciante> auspiciantes = new ArrayList<Auspiciante>();      //Lista de los auspiciantes del concurso.
    private TipoConcursante dirigido;       //enum que representa los tipos de mascotas que pueden participar en el concurso.
    private EstadoConcurso estado;      //enum que representa si el concurso se encuentra vigente y si es un concurso pasado.
    private ArrayList<Mascota> mascotas;        //Lista de mascotas que están inscritas en el concurso.
    private int codigo;     //Código único para identificar al concurso.
    private static int idFinal;     //Variable de clase para ayudar a establecer la variable de instancia codigo.

    //Constuctor que inicializa las variables de instancia con los valores recibidos como parámetros.
    public Concurso(String nombre, LocalDate fechaEvento, String horaEvento, LocalDate fechaInicioIns, LocalDate fechaCierreIns, Ciudad ciudad, List<Premio> premios, List<Auspiciante> auspiciantes, TipoConcursante dirigido, EstadoConcurso estado, ArrayList<Mascota> mascotas) {
        this.nombre = nombre;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.fechaInicioIns = fechaInicioIns;
        this.fechaCierreIns = fechaCierreIns;
        this.ciudad = ciudad;
        this.premios = premios;
        this.auspiciantes = auspiciantes;
        this.dirigido = dirigido;
        this.estado = estado;
        this.mascotas = mascotas;
    }
    
    /**
     * 
     * @return Se suma 1 a la variable de clase idFinal cada vez que se llama al método, luego se retorna dicho valor.
     */
    public int generarIdFinal(){
        return ++idFinal;
    }
    
    /**
     * 
     * Este método añade un objeto de la clase Concurso a una lista donde están todos los concursos creados.
     * 
     * @param concursos Lista que contiene los concursos existentes.
     * @param c Objeto de tipo concurso.
     */
    public static void registrarConcurso(ArrayList<Concurso> concursos, Concurso c) {
        c.setCodigo(c.generarIdFinal());
        concursos.add(c);
        System.out.println("\nEl concurso ha sido creado con éxito.");
    }
    /**
     * Este método pide al usuario todos los datos necesarios para crear un concurso. Luego de ingresar los datos, se crea 
     * el nuevo concurso y se lo agrega a la lista de concursos existentes.
     */
    public static void crearConcurso(ArrayList<Concurso> concursos, ArrayList<Ciudad> ciudades, ArrayList<Premio> premios, ArrayList<Auspiciante> auspiciantes, ArrayList<Mascota> mascotas) {
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
    
        /**
     * Este método pide al usuario la información necesaria para inscribir una mascota a un concurso vigente.
     */
     public static void inscribirParticipante(ArrayList<Concurso> concursos, ArrayList<Mascota> mascotas, ArrayList<Mascota> mascotasParticiparon) {
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
                    indiceMasc = mascotas.indexOf(m);
                }
            }

            concur.getMascotas().add(mascotas.get(indiceMasc));
            mascotasParticiparon.add(mascotas.get(indiceMasc));
            System.out.println("\nLa mascota ha sido inscrita exitosamente.");

        } else {
            System.out.println("Primero registre un concurso vigente.");
        }
    }

    /**
     *
     * @return Retorna un String que contiene el nombre y el código del
     * concurso.
     */
    @Override
    public String toString() {
        return nombre + " | " + "Código: " + codigo;
    }

    //Getters & setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(String horaEvento) {
        this.horaEvento = horaEvento;
    }

    public LocalDate getFechaInicioIns() {
        return fechaInicioIns;
    }

    public void setFechaInicioIns(LocalDate fechaInicioIns) {
        this.fechaInicioIns = fechaInicioIns;
    }

    public LocalDate getFechaCierreIns() {
        return fechaCierreIns;
    }

    public void setFechaCierreIns(LocalDate fechaCierreIns) {
        this.fechaCierreIns = fechaCierreIns;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public EstadoConcurso getEstado() {
        return estado;
    }

    public void setEstado(EstadoConcurso estado) {
        this.estado = estado;
    }

    public List<Premio> getPremios() {
        return premios;
    }

    public List<Auspiciante> getAuspiciantes() {
        return auspiciantes;
    }

    public void setPremios(List<Premio> premios) {
        this.premios = premios;
    }

    public void setAuspiciantes(List<Auspiciante> auspiciantes) {
        this.auspiciantes = auspiciantes;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public TipoConcursante getDirigido() {
        return dirigido;
    }

    public void setDirigido(TipoConcursante dirigido) {
        this.dirigido = dirigido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdFinal() {
        return idFinal;
    }

    public void setIdFinal(int idFinal) {
        this.idFinal = idFinal;
    }

    /**
     * Este método recorre la lista de concursos existentes y mostrará la información de cada uno.
     * 
     * @param concursos Lista de los concursos existentes.
     */
    public static void mostrarConcusos(List<Concurso> concursos) {
        System.out.print("\n-- Bienvenido al menú de Administrar Concursos --\n");
        System.out.println("\nLos concursos existentes son: " + concursos);

    }

}
