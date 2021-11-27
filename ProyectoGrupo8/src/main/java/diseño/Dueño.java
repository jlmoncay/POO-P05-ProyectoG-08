/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseño;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Beatriz Quizhpi
 *
 */
public class Dueño extends Persona {

    private String cedula;
    private String apellido;

    public Dueño(String cedula, String nombre, String apellido, String direccion, String telefono, Ciudad ciudad, String email) {
        super(nombre, direccion, telefono, ciudad, email);
        this.cedula = cedula;
        this.apellido = apellido;

    }

    public static void mostrarDueños(ArrayList<Dueño> dueños) {
        System.out.println("Las dueños que se encuentran registradas son: " + dueños);
    }

    public static void editarDueño(String cedula, ArrayList<Dueño> dueños) {

        Scanner sc = new Scanner(System.in);
        int n = 0;
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
                            break;
                        case 2:
                            System.out.println("Ingrese su nuevo teléfono");
                            String telf = sc.nextLine();

                            d.setTelefono(telf);
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

    @Override
    public String toString() {
        return "Dueño{" + super.toString() + "cedula=" + cedula + ", apellido=" + apellido + '}';
    }

}
