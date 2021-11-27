/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 *
 * @author Andres
 */
public class Mascota {
    private String nombre;
    private TipoMascota tipo;
    private String raza;
    private LocalDateTime fechaInicio;
    private int idMascota;
    private static int idFinal;
    private Dueño dueño;

    public Mascota(String nombre, TipoMascota tipo, String raza, LocalDateTime fechaInicio, int idMascota, Dueño dueño) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.fechaInicio = fechaInicio;
        this.idMascota = idMascota;
        this.dueño = dueño;
    }
    
    public void mostrarMascotas(ArrayList<Mascota> mascotas){
        System.out.println("Las mascotas que se encuentran registradas son: "+mascotas);
    }
    public Mascota registrarMascota(String nombre,TipoMascota tipo, String raza, LocalDateTime fechaInicio, int idMascota, Dueño dueño){
        return new Mascota(nombre,tipo,raza,fechaInicio,idMascota,dueño);
    }
    
    public int generarCodigo(int idFinal){
        return idFinal++;
    }
    
    public void eliminarMascota(ArrayList<Mascota> mascotas, int idMascota){
        for(Mascota m: mascotas){
            int id = m.getIdMascota();
            if (id==idMascota) {
                mascotas.remove(m);
            }else{
                System.out.println("Esa mascota no se encuentra registrada");
            }   
        }
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

    public LocalDateTime getFechaInicio() {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(TipoMascota tipo) {
        this.tipo = tipo;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public static void setIdFinal(int idFinal) {
        Mascota.idFinal = idFinal;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }
    
    
    
    
    
}
