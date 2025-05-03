package co.edu.etitc.sistemas.programacion;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("COMPUTADORES")
public class Computador implements  Recurso{
    @Id
    private Integer id;
    private String nombre;
    private LocalDateTime fechaIngreso;
    private boolean activo;
    private String marca;
    private String modelo;
    private String sistemaOperativo;
    private TipoComputador TipoComputador;

    public Computador() {
    }

    public Computador(String nombre, LocalDateTime fechaIngreso, boolean activo, String marca, String modelo, String sistemaOperativo) {
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;   
        this.activo = activo;
        this.marca = marca;
        this.modelo = modelo;
        this.sistemaOperativo = sistemaOperativo;
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
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }   
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }
    public TipoComputador getTipoComputador() {
        return TipoComputador;
    }
  
    @Override
    public void darDeBaja() {
        this.activo = false;
    }
    @Override

    public String toString() {
        return "Computador: " + "id " + id + ", nombre " + nombre + ", fechaIngreso " + fechaIngreso + ", activo " + activo + ", marca " + marca + ", modelo " + modelo + ", sistemaOperativo " + sistemaOperativo + '.';
 
}
}
