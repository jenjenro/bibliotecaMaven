package co.edu.etitc.sistemas.programacion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ServicioBiblioteca servicio = context.getBean(ServicioBiblioteca.class);

        servicio.agregar(new Libro("1984", LocalDateTime.now(), true, "George Orwell", "Blanco y negro SAS", "1949"));
        servicio.agregar(new Periodico("El Tiempo", LocalDate.now(), true, LocalDateTime.now(), "El Tiempo"));
        servicio.agregar(new Computador("Apple", "MacBook Pro", "macOS", true, LocalDateTime.now(), "MacBook Pro 2023"));

        AppName appName = context.getBean(AppName.class);

        appName.imprimirNombre();
        
        System.out.println("Recursos en la biblioteca:");
        servicio.obtenerTodos().forEach(System.out::println);

        String criterio = "1984";
        System.out.println("\nBuscando recursos que coincidan con: " + criterio);
        Collection<Recurso> recursosEncontrados = servicio.buscarRecursos(criterio);

        if (!recursosEncontrados.isEmpty()) {
            Recurso recursoAEliminar = recursosEncontrados.iterator().next();
            System.out.println("\nRecurso encontrado y eliminado: " + recursoAEliminar.getNombre());
            servicio.quitarRecurso(recursoAEliminar);
        } else {
            System.out.println("\nNo se encontraron recursos que coincidan con el criterio.");
        }

        System.out.println("\nRecursos en la biblioteca después de la eliminación:");
        servicio.obtenerTodos().forEach(System.out::println);
    }
}