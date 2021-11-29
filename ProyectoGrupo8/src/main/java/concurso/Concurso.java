/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurso;

import diseño.TipoConcursante;
import person.Auspiciante;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jorge Moncayo Paz
 */
public class Concurso {

    private String nombre;
    private LocalDateTime fechaEvento;
    private LocalDateTime horaEvento;
    private LocalDateTime fechaInicioIns;
    private LocalDateTime fechaCierreIns;
    private Ciudad ciudad;
    private String lugar;
    //private List<Premio> premios;
    //private List<Auspiciante> auspiciantes;
    private TipoConcursante dirigido;
    private EstadoConcurso estado;
    private int codigo;
    private int idFinal;

    public Concurso(String nombre, LocalDateTime fechaEvento, LocalDateTime horaEvento, LocalDateTime fechaInicioIns, LocalDateTime fechaCierreIns, Ciudad ciudad, String lugar, /*List<Premio> premios, List<Auspiciante> auspiciantes,*/ TipoConcursante dirigido, EstadoConcurso estado, int codigo, int idFinal) {
        this.nombre = nombre;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.fechaInicioIns = fechaInicioIns;
        this.fechaCierreIns = fechaCierreIns;
        this.ciudad = ciudad;
        this.lugar = lugar;
        //this.premios = premios;
        //this.auspiciantes = auspiciantes;
        this.dirigido = dirigido;
        this.estado = estado;
        this.codigo = codigo;
        this.idFinal = idFinal;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | " + "Fecha del evento: " + fechaEvento + " | " + "Hora del evento: " + horaEvento + " | " + "Fecha de inicio de las inscripciones: " + fechaInicioIns + " | " + "Fecha de cierre de las inscripciones: " + fechaCierreIns + " | " + "Ciudad: " + ciudad + " | " + "Lugar: " + lugar + " | " + "Dirigido a: " + dirigido + " | " + "Código: " + codigo + " | " + "ID final: " + idFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDateTime fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public LocalDateTime getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(LocalDateTime horaEvento) {
        this.horaEvento = horaEvento;
    }

    public LocalDateTime getFechaInicioIns() {
        return fechaInicioIns;
    }

    public void setFechaInicioIns(LocalDateTime fechaInicioIns) {
        this.fechaInicioIns = fechaInicioIns;
    }

    public LocalDateTime getFechaCierreIns() {
        return fechaCierreIns;
    }

    public void setFechaCierreIns(LocalDateTime fechaCierreIns) {
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /*public List<Premio> getPremios() {
        return premios;
    }

    public List<Auspiciante> getAuspiciantes() {
        return auspiciantes;
    }*/

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

    public static void mostrarConcusos(List<Concurso> concursos) {
        System.out.print("\n-- Bienvenido al menú de Administrar Concursos --\n");
        System.out.println("Los concursos existentes son: " + concursos);

    }

    public static void adminConcursos() {
        
        int opcion = menuAdminConcursos();

        switch (opcion) {
            case 1:
                System.out.println("En caso 1");
                System.out.println("Ingrese los datos del concurso:");

                break;

            case 2:
                System.out.println("En caso 2");

                break;

            case 3:
                //System.out.println("Bienvenido al menú principal");
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

        sc.close();
        
        return opcion;  
    }
    
    public void crearConcurso(ArrayList<Concurso> concursos){
        Scanner sc = new Scanner(System.in);
        System.out.println("A continuación ingresará los datos del concurso.");
        System.out.print("Ingrese el nombre del concurso: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la fecha en la que se realizará el evento (dd/mm/yyyy): "); 
        String fechaEvento = sc.nextLine();
        System.out.println("Ingrese la hora en la que se realizará el evento (hh:mm:ss): ");
        String horaEvento = sc.nextLine();
        System.out.println("Ingrese la fecha de inicio de las inscripciones (dd/mm/yyyy): ");
        String fechaInicioIns = sc.nextLine();
        System.out.println("Ingrese la fecha de cierre de las inscripciones (dd/mm/yyyy): ");
        String fechaCierreIns = sc.nextLine();
        System.out.println("Ingrese el nombre de la ciudad donde se realizará el concurso: ");
        String nombreCiudad = sc.nextLine();
        System.out.println("Ingrese el lugar donde se realizará el concurso: ");
        String lugar = sc.nextLine();
        
        
        
        sc.close();
    }
    

}
