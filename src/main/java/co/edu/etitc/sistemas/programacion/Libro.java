package co.edu.etitc.sistemas.programacion;

import java.time.LocalDateTime;

public  class Libro extends Recurso {

    private String autor;
    private String editorial;
    private String anio;
    

    public Libro(String nombre, LocalDateTime fechaIngreso, boolean activo,String autor, String editorial, String anio) {
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

    public String getAnio() {
        return anio;
    }
    
}
