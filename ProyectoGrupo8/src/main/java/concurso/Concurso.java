/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurso;

import diseño.Mascota;
import diseño.TipoConcursante;
import java.time.LocalDate;
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
    private LocalDate fechaEvento;
    private String horaEvento;
    private LocalDate fechaInicioIns;
    private LocalDate fechaCierreIns;
    private Ciudad ciudad;
    //private String lugar;
    private List<Premio> premios = new ArrayList<Premio>();
    private List<Auspiciante> auspiciantes = new ArrayList<Auspiciante>();
    private TipoConcursante dirigido;
    private EstadoConcurso estado;
    private ArrayList<Mascota> mascotas;
    private int codigo;
    private static int idFinal;

    public Concurso(String nombre, LocalDate fechaEvento, String horaEvento, LocalDate fechaInicioIns, LocalDate fechaCierreIns, Ciudad ciudad, /*String lugar,*/ List<Premio> premios, List<Auspiciante> auspiciantes, TipoConcursante dirigido, EstadoConcurso estado, ArrayList<Mascota> mascotas) {
        this.nombre = nombre;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.fechaInicioIns = fechaInicioIns;
        this.fechaCierreIns = fechaCierreIns;
        this.ciudad = ciudad;
        //this.lugar = lugar;
        this.premios = premios;
        this.auspiciantes = auspiciantes;
        this.dirigido = dirigido;
        this.estado = estado;
        this.mascotas = mascotas;
    }
    
    public int generarIdFinal(){
        return ++idFinal;
    }
    
    public static void registrarConcurso(ArrayList<Concurso> concursos, Concurso c) {
        
        c.setCodigo(c.generarIdFinal());
        concursos.add(c);
        System.out.println("El concurso ha sido creado con éxito.");
    }
    
    
    
    @Override
    public String toString() {
        return nombre; //+ " | " + "Fecha del evento: " + fechaEvento + " | " + "Hora del evento: " + horaEvento + " | " + "Fecha de inicio de las inscripciones: " + fechaInicioIns + " | " + "Fecha de cierre de las inscripciones: " + fechaCierreIns + " | " + "Ciudad: " + ciudad + " | " /*+ "Lugar: " + lugar*/ + " | " + "Dirigido a: " + dirigido + " | " + "Estado del concurso: " + estado + " | " + "Código: " + codigo + " | " + "ID final: " + idFinal;
    }

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

    /*public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }*/

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

    public static void mostrarConcusos(List<Concurso> concursos) {
        System.out.print("\n-- Bienvenido al menú de Administrar Concursos --\n");
        System.out.println("\nLos concursos existentes son: " + concursos);

    }

    /*public void inscribirParticipante() {
        Scanner sc = new Scanner(System.in);
        System.out.println("A continuación inscribirá su mascota al concurso.");
        for ()
        
    }*/
    

}
