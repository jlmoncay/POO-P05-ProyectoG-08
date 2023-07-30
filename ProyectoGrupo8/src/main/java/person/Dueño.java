/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import concurso.Ciudad;
import person.Persona;
import java.util.ArrayList;
import java.util.Scanner;
import concurso.Observer;

/**
 *
 * @author Beatriz Quizhpi
 *
 */
public class Dueño extends Persona {
    // variables de instancia
    private ArrayList<Observer> observadores = new ArrayList<>();

    private String cedula;
    private String apellido;
    //constructor 

    public Dueño(String cedula, String nombre, String apellido, String direccion, String telefono, Ciudad ciudad, String email) {
        super(nombre, direccion, telefono, ciudad, email);
        this.cedula = cedula;
        this.apellido = apellido;

    }
    // método mostrarDueños  que recibe una arraylist del tipo dueño e imprime el arraylist

    public static void mostrarDueños(ArrayList<Dueño> dueños) {
        System.out.println("Las dueños que se encuentran registradas son: " + dueños);
    }
    
    /* método editarDueño recibe el string cédula y un arraylist del tipo dueño, si el string cedula coincide con la cédula de un objeto dueño pasa actuliza los datos 
     de lo contrario muestra un mensaje de error*/
   
    public void agregarObservador(Observer observador){
        observadores.add(observador);
    }
    
    public void eliminarObservador(Observer observador){
        observadores.remove(observador);
    }
    
    public static void editarDueño(String cedula, ArrayList<Dueño> dueños) {

        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean control = false;
        do{
        
            for (Dueño d : dueños) {
                

                if (d.getCedula().equals(cedula)) {
                     

                    do {
                        System.out.println("¿Qué dato desea actualizar?");
                        System.out.println("1.Dirección\n" + "2.Telefono\n" + "3.Ciudad\n" + "4.Email\n" + "5. Salir\n");
                        n = sc.nextInt();
                        sc.nextLine();
                        switch (n) {
                            case 1:
                                System.out.println("Ingrese su nueva dirección");
                                String direc = sc.nextLine();

                                d.setDireccion(direc);
                                
                                for(Observer observador: d.observadores){
                                    observador.actualizar("Direccion actualizada: "+direc);
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese su nuevo teléfono");
                                String telf = sc.nextLine();

                                d.setTelefono(telf);
                                for(Observer observador: d.observadores){
                                    observador.actualizar("Teléfono actualizada: "+telf);
                                }
                                break;
                            case 3:
                                System.out.println("Ingrese ciudad");
                                String ciu = sc.nextLine();
                                Ciudad ciud = new Ciudad(ciu);
                                d.setCiudad(ciud);
                                break;

                            case 4:
                                System.out.println("Ingrese su email");
                                String mail = sc.nextLine();

                                d.setEmail(mail);
                                break;

                        }
                    } while (n != 5);
                    System.out.println("Edición Finalizada");
                    System.out.println(d.toString());

                }
            }
        }while(control==true); 
        System.out.println("El número ingresado no ha sido encontrado");
        }
        
    
        
    
    // getters y setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
// Método to string para mostrar información del objeto dueño en el que también se llama al método to string de la clase padre
    @Override
    public String toString() {
        return "Dueño{" + super.toString() + "cedula=" + cedula + ", apellido=" + apellido + '}';
    }

}