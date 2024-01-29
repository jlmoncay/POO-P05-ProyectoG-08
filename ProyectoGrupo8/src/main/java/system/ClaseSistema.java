/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system;

import static system.SistemaAdministrar.administarDueños;
import static system.SistemaAdministrar.administarMascotas;
import static system.SistemaAdministrar.mostrarYAdministrarConcursos;

/**
 *
 * @author alexc
 */
public class ClaseSistema {
    public static void mostrarMenuPrincipal() {
        System.out.println("\nBienvenidos al Sistema");
        System.out.println("1. Administrar Concursos");
        System.out.println("2. Administrar Dueños");
        System.out.println("3. Administrar Mascotas");
        System.out.println("4. Salir");
        System.out.println("Ingrese una opción: ");
    }
    
    
    public static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                mostrarYAdministrarConcursos();
                break;
            case 2:
                administarDueños();
                break;
            case 3:
                administarMascotas();
                break;
            case 4:
                break;
            default:
                System.out.println("Opción no válida. Ingrese nuevamente.");
        }
    }
    
}
