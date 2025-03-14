package co.edu.etitc.sistemas.programacion;
import java.util.Collection;

public interface  RecursoRepositorio < T extends Recurso > {
    void agregarRecurso(T recurso);
    void eliminarRecurso(T recurso);
    Collection<T> buscar(String criterio);
    Collection<T> obtenerTodos();
    
}
