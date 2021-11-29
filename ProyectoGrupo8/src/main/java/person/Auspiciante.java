/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import concurso.Ciudad;
import java.util.ArrayList;
import person.Persona;

/**
 *
 * @author USER
 */
public class Auspiciante extends Persona {
    private String paginaWeb; 
    private int codigoAuspiciante;
    private static int idFinal;
    
    public Auspiciante(String nombre, String direccion, String telefono, Ciudad ciudad, String email,String paginaWeb){ 
        super(nombre, direccion, telefono, ciudad, email);
        this.paginaWeb= paginaWeb; 
        
    }
    
    public int generarCodigo() {
        return ++idFinal;
    }
    
    public static void registrarAuspiciante(ArrayList<Auspiciante> auspiciantes, Auspiciante a) {
        a.setCodigoAuspiciante(a.generarCodigo());
        auspiciantes.add(a);
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getCodigoAuspiciante() {
        return codigoAuspiciante;
    }

    public static int getIdFinal() {
        return idFinal;
    }

    public void setCodigoAuspiciante(int codigoAuspiciante) {
        this.codigoAuspiciante = codigoAuspiciante;
    }
    
}