/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concurso;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edu-g
 */
public class MetodoConcurso {
    
    public static void registrarConcurso(ArrayList<Concurso> concursos, Concurso c) {
        c.setCodigo(c.generarIdFinal());
        concursos.add(c);
        System.out.println("\nEl concurso ha sido creado con éxito.");
    }
     
    public static void mostrarConcurso(List<Concurso> concursos) {
        System.out.print("\n-- Bienvenido al menú de Administrar Concursos --\n");
        System.out.println("\nLos concursos existentes son: " + concursos);
        
    }
}
