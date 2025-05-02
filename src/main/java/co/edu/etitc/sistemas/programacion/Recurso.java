package co.edu.etitc.sistemas.programacion;

import java.time.LocalDateTime;

public interface Recurso{
    
    String getNombre();
    LocalDateTime getFechaIngreso();
    boolean isActivo();
    void darDeBaja();
    @Override
    String toString();
}
   