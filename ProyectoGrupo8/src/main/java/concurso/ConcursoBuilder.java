/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concurso;

import diseño.Mascota;
import diseño.TipoConcursante;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import person.Auspiciante;

/**
 *
 * @author joelorrala
 */
public class ConcursoBuilder implements Builder{
    private String nombre;
    private LocalDate fechaEvento;
    private String horaEvento;
    private LocalDate fechaInicioIns;
    private LocalDate fechaCierreIns;
    private Ciudad ciudad;
    private List<Premio> premios = new ArrayList<>();
    private List<Auspiciante> auspiciantes = new ArrayList<>();
    private TipoConcursante dirigido;
    private EstadoConcurso estado;
    private ArrayList<Mascota> mascotas;

    public ConcursoBuilder(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    @Override
    public void setHoraEvento(String horaEvento) {
        this.horaEvento = horaEvento;
  
    }

    @Override
    public void setFechaInicioIns(LocalDate fechaInicioIns) {
        this.fechaInicioIns = fechaInicioIns;
  
    }

    @Override
    public void setFechaCierreIns(LocalDate fechaCierreIns) {
        this.fechaCierreIns = fechaCierreIns;
      
    }

    @Override
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
     
    }

    @Override
    public void addPremio(Premio premio) {
        this.premios.add(premio);
       
    }

    @Override
    public void addAuspiciante(Auspiciante auspiciante) {
        this.auspiciantes.add(auspiciante);
       
    }

    @Override
    public void setDirigido(TipoConcursante dirigido) {
        this.dirigido = dirigido;

    }

    @Override
    public void setEstado(EstadoConcurso estado) {
        this.estado = estado;

    }

    @Override
    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;

    }

    public Concurso build() {
        return new Concurso(nombre, fechaEvento, horaEvento, fechaInicioIns, fechaCierreIns, ciudad, premios, auspiciantes, dirigido, estado, mascotas);
    }
}