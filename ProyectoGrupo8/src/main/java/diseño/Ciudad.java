/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseño;
import java.util.ArrayList;
/**
 *
 * @author Beatriz Quizhpi
 */
public class Ciudad {

    private String nombre;
    private String provincia;
    private int codigo;
    private static int codigoFinal;
    

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }
    
    public int generarCodigo() {
        return ++codigoFinal;
    }
    
    public static void mostrarCiudades(ArrayList<Ciudad> ciudades){
        System.out.println("Ciudades: "+ciudades);
    }
    
    public void registrarCiudad(ArrayList<Ciudad>ciudades, Ciudad c){
        int id = c.generarCodigo();
        c.setCodigo(id);
        c.toString();
        ciudades.add(c); 
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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public static void setCodigoFinal(int codigoFinal) {
        Ciudad.codigoFinal = codigoFinal;
    }
    
    

    @Override
    public String toString() {
        return nombre;
    }
    

}
