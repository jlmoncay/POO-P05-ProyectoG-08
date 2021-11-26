/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Auspiciante extends Persona {
    private String paginaWeb; 
    
    public Auspiciante( String nombre, String direccion, String telefono, Ciudad ciudad, String email,String paginaWeb){
        
        super(nombre, direccion, telefono, ciudad, email);
        this.paginaWeb= paginaWeb; 
        
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
    
}