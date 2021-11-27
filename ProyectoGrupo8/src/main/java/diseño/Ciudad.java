/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseño;

/**
 *
 * @author Beatriz Quizhpi
 */
public class Ciudad {
    private String nombre; 
    private String provincia; 

    public Ciudad(String nombre){
        this.nombre= nombre; 
    }
    public Ciudad(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    
}
