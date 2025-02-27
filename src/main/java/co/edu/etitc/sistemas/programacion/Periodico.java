package co.edu.etitc.sistemas.programacion;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Periodico extends Recurso {

    private LocalDate fechaPublicacion;
    private String editorial;

    public Periodico(String editorial, LocalDate fechaPublicacion, boolean activo, LocalDateTime fechaIngreso, String nombre) {
        super(activo, fechaIngreso, nombre);
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public void darDeBaja() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean coincideConCriterio(String criterio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    
}
