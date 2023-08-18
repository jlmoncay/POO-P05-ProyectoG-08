package person;

import concurso.Ciudad;
import java.util.ArrayList;
import person.Persona;

/**
 *
 * @author USER
 */
public class Auspiciante  {
    // variables de instancia
    private String paginaWeb; 
    private int codigoAuspiciante;
    private static int idFinal;
    private PersonalInfo personalInfo;
    
    // contructor
    
    public Auspiciante(String nombre, String direccion, String telefono, Ciudad ciudad, String email,String paginaWeb){ 
        this.paginaWeb= paginaWeb; 
        this.personalInfo = new PersonalInfo(nombre, direccion, telefono, ciudad, email);

        
    }
    // método que retor un int, este genera el codigo luego de aumentar  la variable id final 
    
    public int generarCodigo() {
        return ++idFinal;
    }
    
    //  Método que registra un auspiciante y llama al método generar codigo y es añadido al arrayList de auspiciantes. 
    public static void registrarAuspiciante(ArrayList<Auspiciante> auspiciantes, Auspiciante a) {
        a.setCodigoAuspiciante(a.generarCodigo());
        auspiciantes.add(a);
    }
    // getters y setters

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
// Método to string que muestra la información de un  objeto auspiciante
    @Override
    public String toString() {
        return "Auspiciante{" + personalInfo.toString() + ", paginaWeb=" + paginaWeb + ", codigoAuspiciante=" + codigoAuspiciante + '}';
    }
    
    
}