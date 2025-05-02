package co.edu.etitc.sistemas.programacion;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("periodicos")
public class Periodico implements  Recurso {
    @Id
    private Integer id;
    private String nombre;
    private LocalDateTime fechaIngreso;
    private boolean activo;
    private LocalDate fechaPublicacion;
    private String editorial;

   

    public Periodico(String nombre, LocalDateTime fechaIngreso, boolean activo, LocalDate fechaPublicacion, String editorial) {
        
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.activo = activo;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Periodico() {
    }
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
    
    @Override
    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }
    @Override
    public boolean isActivo() {
        return activo;
    }
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
    public String getEditorial() {
        return editorial;
    }
    @Override
    public void darDeBaja() {
        this.activo = false;
    }
    @Override
    public String toString() {
        return "Periodico: " + "id " + id + ", nombre " + nombre + ", fechaIngreso " + fechaIngreso + ", activo " + activo + ", fechaPublicacion " + fechaPublicacion + ", editorial " + editorial + '.';
    }

    

}

