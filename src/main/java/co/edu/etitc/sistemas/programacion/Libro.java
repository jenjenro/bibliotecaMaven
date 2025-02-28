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
    public boolean coincideConCriterio(String criterio) {
        return super.coincideConCriterio(criterio) || autor.contains(criterio) || editorial.contains(criterio) || anio.contains(criterio);
    }

    @Override
    public String toString() {
        return "Libro{" + "autor=" + autor + ", editorial=" + editorial + ", anio=" + anio + '}';
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
