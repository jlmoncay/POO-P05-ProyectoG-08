/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system;

import concurso.Concurso;
import concurso.EstadoConcurso;
import diseño.Mascota;
import diseño.TipoConcursante;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alexc
 */
public class Participante {

    public static void inscribirParticipante() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n-- Inscribir participante al concurso --");

        List<Concurso> concursosVigentes = new ArrayList<>();
        Iterable<Concurso> concursos = null;
        for (Concurso c : concursos) {
            if (c.getEstado() == EstadoConcurso.VIGENTE) {
                concursosVigentes.add(c);
                System.out.println(c);
            }
        }

        if (concursosVigentes.isEmpty()) {
            System.out.println("No hay concursos vigentes disponibles para inscripción.");
            return;
        }

        System.out.println("Ingrese el código del concurso al que desea inscribir a su mascota: ");
        int codigoConcur = sc.nextInt();
        sc.nextLine();

        Concurso concur = buscarConcursoPorCodigo(codigoConcur, concursosVigentes);
        if (concur == null) {
            System.out.println("El código de concurso ingresado no es válido.");
            return;
        }

        List<Mascota> mascotasDisponibles = obtenerMascotasPorTipo(concur.getDirigido());

        if (mascotasDisponibles.isEmpty()) {
            System.out.println("No hay mascotas disponibles para inscripción en este concurso.");
            return;
        }

        System.out.println("La lista de mascotas disponibles es la siguiente:");
        for (Mascota m : mascotasDisponibles) {
            System.out.println(m);
        }

        System.out.println("Ingrese el ID de la mascota a inscribir: ");
        int idMasc = sc.nextInt();
        sc.nextLine();

        Mascota mascotaSeleccionada = buscarMascotaPorId(idMasc, mascotasDisponibles);
        if (mascotaSeleccionada == null) {
            System.out.println("El ID de la mascota ingresado no es válido.");
            return;
        }

        concur.getMascotas().add(mascotaSeleccionada);
        mascotasParticiparon.add(mascotaSeleccionada);
        System.out.println("\nLa mascota ha sido inscrita exitosamente.");
    }

    private static Concurso buscarConcursoPorCodigo(int codigo, List<Concurso> concursos) {
        for (Concurso c : concursos) {
            if (c.getCodigo() == codigo) {
                return c;
            }
        }
        return null;
    }

    private static List<Mascota> obtenerMascotasPorTipo(TipoConcursante tipo) {
        List<Mascota> mascotasFiltradas = new ArrayList<>();
        Iterable<Mascota> mascotas = null;
        for (Mascota m : mascotas) {
            if (tipo == TipoConcursante.AMBOS || m.getTipo() == tipo) {
                mascotasFiltradas.add(m);
            }
        }
        return mascotasFiltradas;
    }

    private static Mascota buscarMascotaPorId(int id, List<Mascota> mascotas) {
        for (Mascota m : mascotas) {
            if (m.getIdMascota() == id) {
                return m;
            }
        }
        return null;
    }

}
