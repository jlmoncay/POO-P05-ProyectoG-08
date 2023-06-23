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
     * @return Retorna un String que contiene el nombre y el código del concurso.
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

}
