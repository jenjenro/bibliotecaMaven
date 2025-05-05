package co.edu.etitc.sistemas.programacion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppName {
     @Value("${app.name}")
    private String nombreAplicacion;

    public void imprimirNombre() {
        System.out.println("Nombre de la aplicación: " + nombreAplicacion);
    }
}
