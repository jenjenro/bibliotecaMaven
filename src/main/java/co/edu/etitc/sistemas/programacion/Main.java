package co.edu.etitc.sistemas.programacion;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "co.edu.etitc.sistemas")
public class Main {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = SpringApplication.run(Main.class, args)) {
            ServicioBiblioteca servicio = context.getBean(ServicioBiblioteca.class);

            Libro libro1 = new Libro("El Quijote", LocalDateTime.now(), true, 
                                   "Miguel de Cervantes", "Planeta", "1605");
            Libro libro2 = new Libro("Cien Años de Soledad", LocalDateTime.now(), true,
                                   "Gabriel García Márquez", "Sudamericana", "1967");

            Periodico periodico1 = new Periodico("El Tiempo", LocalDateTime.now(), true,
                                   LocalDate.of(2024, 5, 1), "Casa Editorial El Tiempo");
            Periodico periodico2 = new Periodico("El Espectador", LocalDateTime.now(), true,
                                   LocalDate.of(2024, 4, 15), "CEDE");

            Computador computador1 = new Computador("Compu1", LocalDateTime.now(), true, 
                                   "HP", "Pavilion", "Windows 11");
            Computador computador2 = new Computador("Compu2", LocalDateTime.now(), true, 
                                   "Lenovo", "ThinkPad", "Ubuntu");

            servicio.agregar(libro1);
            servicio.agregar(libro2);
            servicio.agregar(periodico1);
            servicio.agregar(periodico2);
            servicio.agregar(computador1);
            servicio.agregar(computador2);

            System.out.println("\n=== Todos los recursos ===");
            servicio.obtenerTodos().forEach(System.out::println);

            String criterioBusqueda = "El";
            System.out.println("\n=== Buscando recursos con: '" + criterioBusqueda + "' ===");
            servicio.buscarRecursos(criterioBusqueda).forEach(System.out::println);

            System.out.println("\n=== Dando de baja un recurso ===");
            servicio.obtenerTodos().stream().findFirst().ifPresent(recurso -> {
                recurso.darDeBaja();
                servicio.agregar(recurso);
                System.out.println("Recurso dado de baja: " + recurso);
            });

            System.out.println("\n=== Estado final ===");
            servicio.obtenerTodos().forEach(System.out::println);
        }
    }
}
