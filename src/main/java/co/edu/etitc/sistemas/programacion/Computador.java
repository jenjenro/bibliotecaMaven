package co.edu.etitc.sistemas.programacion;

import java.time.LocalDateTime;

public class Computador extends Recurso{

    private String marca;
    private String modelo;
    private String sistemaOperativo;
    private TipoComputador TipoComputador;

    public Computador(String marca, String modelo, String sistemaOperativo, boolean activo, LocalDateTime fechaIngreso, String nombre) {
        super(activo, fechaIngreso, nombre);
        this.marca = marca;
        this.modelo = modelo;
        this.sistemaOperativo = sistemaOperativo;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    
    


    
}
