/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import concurso.Ciudad;

/**
 *
 * @author Beatriz Quizhpi
 */
public class Persona {
    
    // variables de instancia
    
    private PersonalInfo personalInfo;
    // constructor

    public Persona(String nombre, String direccion, String telefono, Ciudad ciudad, String email) {
        this.personalInfo = new PersonalInfo(nombre, direccion, telefono, ciudad, email);
    }

    // Método to string que muestra la información del objeto de la clase persona
    @Override
    public String toString() {
        return "Persona{" + personalInfo.toString() + '}';
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    
}
