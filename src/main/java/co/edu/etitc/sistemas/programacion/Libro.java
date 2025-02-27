package co.edu.etitc.sistemas.programacion;

import java.time.LocalDateTime;
import java.time.Year;

public  class Libro extends Recurso {

    private String autor;
    private String editorial;
    private Year anio;

    public Libro(Year anio, String autor, String editorial, boolean activo, LocalDateTime fechaIngreso, String nombre) {
        super(activo, fechaIngreso, nombre);
        this.anio = anio;
        this.autor = autor;
        this.editorial = editorial;
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

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public Year getAnio() {
        return anio;
    }
    
}
