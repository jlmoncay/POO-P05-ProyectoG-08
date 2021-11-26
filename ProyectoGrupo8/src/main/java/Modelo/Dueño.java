/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Beatriz Quizhpi
 * 
 */
public class Dueño extends Persona{
    private String cedula;
    private String apellido;
    static ArrayList<Dueño> dueños;
    
     public Dueño(String cedula, String nombre, String apellido, String direccion, String telefono, Ciudad ciudad, String email) {
        super(nombre, direccion, telefono, ciudad, email);
        this.cedula = cedula;
        this.apellido = apellido;
        dueños = new ArrayList<>();

    }
      public void mostrarDueños(ArrayList<Dueño> dueños) {
        System.out.println(dueños);

    }
      
      public Dueño crearDueño(String ced, String nomb, String apell, String direc, String tlf, Ciudad cd, String email){
       Dueño dueño= new Dueño(ced, nomb, apell,direc, tlf, cd, email); 
       dueños.add(dueño);
        
       return dueño; 
        
    }
      public void actualizarDueño(String cedula, ArrayList<Dueño> dueños) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        for (Dueño d : dueños) {
            if (d.getCedula().equals(cedula)) {
                System.out.println("¿Qué dato desea actualizar");
                while (n != 2) {
                    System.out.println("1.Dirección\n" + "2.Telefono\n" + "3.Ciudad\n" + "4.Email");
                    n = sc.nextInt();
                    sc.nextLine();
                    switch(n){
                        case 1: 
                            System.out.println("Ingrese su nueva dirección"); 
                            String direc= sc.nextLine(); 
                            
                            d.setDireccion(direc);
                        case 2: 
                            System.out.println("Ingrese su nuevo teléfono"); 
                            String telf= sc.nextLine(); 
                            
                            d.setTelefono(telf);
                        case 3: 
                            System.out.println("Ingrese ciudad"); 
                            String ciu= sc.nextLine(); 
                            Ciudad ciud= new Ciudad(ciu); 
                            d.setCiudad(ciud);
                            
                        case 4: 
                            System.out.println("Ingrese su email"); 
                            String mail = sc.nextLine(); 
                            
                           d.setEmail(mail);
                            
                            
                            
                            
                            
                    }
                    

                }
            }
        }
    }

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
    
    

    
}
