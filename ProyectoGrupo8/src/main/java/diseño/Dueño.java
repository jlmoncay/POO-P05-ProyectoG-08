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
