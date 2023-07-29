/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package concurso;

import diseño.Mascota;
import diseño.TipoConcursante;
import java.time.LocalDate;
import java.util.ArrayList;
import person.Auspiciante;

/**
 *
 * @author joelorrala
 */
public interface Builder {
     public void setFechaEvento(LocalDate fechaEvento);
     public void setHoraEvento(String horaEvento);
     public void setFechaInicioIns(LocalDate fechaInicioIns);
     public void setFechaCierreIns(LocalDate fechaCierreIns);
     public void setCiudad(Ciudad ciudad);
     public void addPremio(Premio premio);
     public void addAuspiciante(Auspiciante auspiciante);
     public void setDirigido(TipoConcursante dirigido);
     public void setEstado(EstadoConcurso estado);
     public void setMascotas(ArrayList<Mascota> mascotas);
     
}
