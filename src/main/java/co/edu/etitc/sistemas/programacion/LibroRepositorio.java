package co.edu.etitc.sistemas.programacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component 
public class LibroRepositorio implements RecursoRepositorio<Libro> {
    private List<Libro> libros = new ArrayList<>();
    
    @Override
    public void agregarRecurso(Libro recurso) {
        libros.add(recurso);
    }
    
    @Override
    public void eliminarRecurso(Libro recurso) {
        libros.remove(recurso);
    }
    
    @Override
    public Collection<Libro> buscar(String criterio) {
        return libros.stream()
                .filter(libro -> libro.coincideConCriterio(criterio))
                .collect(Collectors.toList());
    }
    
    @Override
    public Collection<Libro> obtenerTodos() {
        return libros;
    }
}