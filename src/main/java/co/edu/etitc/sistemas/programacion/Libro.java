package co.edu.etitc.sistemas.programacion;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("LIBROS")
public class Libro implements Recurso {
    @Id
    private Integer id;
    private String nombre;
    private LocalDateTime fechaIngreso;
    private boolean activo;
    private String autor;
    private String editorial;
    private String anio;
    



    public Libro(String nombre, LocalDateTime fechaIngreso, boolean activo,String autor, String editorial, String anio) {
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;   
        this.activo = activo;
        this.anio = anio;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Libro(){} 

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String getNombre() {
    return nombre;
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
   //indico copilot que debian implementarse pero no aparecen en el diagrama de flujo
    @Override
    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    @Override
    public boolean isActivo() {
        return activo;
    }

    @Override
    public void darDeBaja() {
        this.activo = false;
    }
//este si
    @Override
    public String toString() {
        return "Libro{" + "id " + id + ", nombre " + nombre + ", fechaIngreso " + fechaIngreso + ", activo " + activo + ", autor " + autor + ", editorial " + editorial + ", year " + anio + '}';
    }
 
}
