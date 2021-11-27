/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseño;

/**
 *
 * @author Jorge Moncayo Paz
 */
public class Premio {

    private Auspiciante auspiciante;
    private String lugar;
    private String descripcion;

    public Premio(Auspiciante auspiciante, String lugar, String descripcion) {
        this.auspiciante = auspiciante;
        this.lugar = lugar;
        this.descripcion = descripcion;
    }

    public Auspiciante getAuspiciante() {
        return auspiciante;
    }

    public void setAuspiciante(Auspiciante auspiciante) {
        this.auspiciante = auspiciante;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Auspiciante: " + auspiciante + " | " + "Lugar: " + lugar + " | " + "Descripción: " + descripcion;
    }

}
