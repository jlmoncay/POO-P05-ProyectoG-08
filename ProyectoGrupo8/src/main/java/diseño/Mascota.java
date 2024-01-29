/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseño;
import person.Dueño;
import java.time.LocalDate;
import java.util.ArrayList;
import concurso.Observer;
/**
 *
 * @author Andres
 */
public class Mascota implements Observer {
    private String nombre;
    private TipoMascota tipo;
    private String raza;
    private LocalDate fechaNacimiento;
    private int idMascota;
    private static int idFinal;
    private Dueño dueño;

    public Mascota(String nombre, TipoMascota tipo, String raza, LocalDate fechaNacimiento, Dueño dueño) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.dueño = dueño;
    }
    
    
    
    public static void mostrarMascotas(ArrayList<Mascota> mascotas){
        System.out.println("Las mascotas que se encuentran registradas son: "+mascotas);
    }
    
    public int generarIdMascota(){
        return ++idFinal;
    }
    //metodo añadir la mascota a la lista junto a su id unico
    public static void registrarMascota(ArrayList<Mascota >mascotas, Mascota masc){
        int id = masc.generarIdMascota();
        masc.setIdMascota(id);
        masc.toString();
        mascotas.add(masc); 
    }
    
    @Override
    public void actualizar(String mensaje){
        System.out.println("Mascota " + nombre + "ha sido actualizada"+ mensaje);
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
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

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }
    @Override
    public String toString() {
        return "Mascota{" + "nombre =" + nombre + ", tipo =" + tipo + ", raza =" + raza + ", fecha nacimiento =" + fechaNacimiento + ", id =" + idMascota + ", dueño =" + dueño + '}';
        
    }
    
    
    
    
}
