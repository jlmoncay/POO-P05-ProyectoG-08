/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseño;
import person.Dueño;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Andres
 */
public class Mascota {
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
    
    public static void crearMascota(ArrayList<Dueño> dueños, ArrayList<Mascota> mascotas){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
        //lazo for para verificar si el dueño ingresado se encuentra registrado en la lista
        Dueño dueñoR = null;
        for (Dueño d : dueños) {
            String cedula = d.getCedula();
            if (ceduDueño.equals(cedula)) {
                dueñoR = d;
            }

        }
        if (dueñoR.equals(null)) {
            System.out.println("No se ha encontrado la informacion, porfavor registre primero al dueño");
        } else {
            //validar que tipo es la mascota a registrar
            if (tipo.toUpperCase().equals("GATO")) {
                Mascota masc = new Mascota(nombre, TipoMascota.GATO, raza, formato, dueñoR);
                Mascota.registrarMascota(mascotas, masc);
            } else if (tipo.toUpperCase().equals("PERRO")) {
                Mascota masc = new Mascota(nombre, TipoMascota.PERRO, raza, formato, dueñoR);
                Mascota.registrarMascota(mascotas, masc);
            }

        }
    }
 
    public static void eliminarMascota(ArrayList<Mascota> mascotas) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Eliminar mascota");
        System.out.println("Ingrese la id de la Mascota a eliminar: ");
        int idMascotaEliminar = sc.nextInt();
        sc.nextLine();
        boolean bool = false;
        //lazo for para verificar si la mascota se encuentra en la lista para removerla o mostrar un mensaje de no encontrada
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
    }
    
    
    //metodo añadir la mascota a la lista junto a su id unico
    public static void registrarMascota(ArrayList<Mascota >mascotas, Mascota masc){
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
