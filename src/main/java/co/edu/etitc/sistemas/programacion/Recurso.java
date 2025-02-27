package co.edu.etitc.sistemas.programacion;

import java.time.LocalDateTime;

public abstract class Recurso  {
    private String nombre;
    private LocalDateTime fechaIngreso;
    private boolean activo;

    public Recurso(boolean activo, LocalDateTime fechaIngreso, String nombre) {
        this.activo = activo;
        this.fechaIngreso = fechaIngreso;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public abstract void darDeBaja();

    public abstract boolean coincideConCriterio(String criterio);

    public abstract String toString();
    


    
}
