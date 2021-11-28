/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseño;
import person.Dueño;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Andres
 */
public class Mascota {
    private String nombre;
    private TipoMascota tipo;
    private String raza;
    private LocalDate fechaInicio;
    private int idMascota;
    private static int idFinal;
    private Dueño dueño;

    public Mascota(String nombre, TipoMascota tipo, String raza, LocalDate fechaInicio,Dueño dueño) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.fechaInicio = fechaInicio;
        this.dueño = dueño;
    }
    
    
    
    public static void mostrarMascotas(ArrayList<Mascota> mascotas){
        System.out.println("Las mascotas que se encuentran registradas son: "+mascotas);
    }
    
    public int generarIdMascota(){
        return ++idFinal;
    }
    
    public void registrarMascota(ArrayList<Mascota >mascotas, Mascota masc){
        int id = masc.generarIdMascota();
        masc.setIdMascota(id);
        masc.toString();
        mascotas.add(masc); 
    }
    
    //getters
    public String getNombre() {
        return nombre;
    }

    public TipoMascota getTipo() {
        return tipo;
    }

    public String getRaza() {
        return raza;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public static int getIdFinal() {
        return idFinal;
    }

    public Dueño getDueño() {
        return dueño;
    }
    
    //setters

    public static void setIdFinal(int idFinal) {
        Mascota.idFinal = idFinal;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(TipoMascota tipo) {
        this.tipo = tipo;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }
    @Override
    public String toString() {
        return "Mascota{" + "nombre =" + nombre + ", tipo =" + tipo + ", raza =" + raza + ", fecha inscripcion =" + fechaInicio + ", id =" + idMascota + ", dueño =" + dueño + '}';
        
    }
    
    
    
    
}
