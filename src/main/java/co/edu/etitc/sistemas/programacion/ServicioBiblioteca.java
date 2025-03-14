package co.edu.etitc.sistemas.programacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioBiblioteca {
    private final RecursoRepositorio<Libro> repositorioLibros;
    private final RecursoRepositorio<Periodico> repositorioPeriodicos;
    private final RecursoRepositorio<Computador> repositorioComputadores;

    @Autowired
    public ServicioBiblioteca(RecursoRepositorio<Libro> repositorioLibros,
                             RecursoRepositorio<Periodico> repositorioPeriodicos,
                             RecursoRepositorio<Computador> repositorioComputadores) {
        this.repositorioLibros = repositorioLibros;
        this.repositorioPeriodicos = repositorioPeriodicos;
        this.repositorioComputadores = repositorioComputadores;
    }

    public void agregar(Recurso recurso) {
        if (recurso instanceof Libro) {
            repositorioLibros.agregarRecurso((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            repositorioPeriodicos.agregarRecurso((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            repositorioComputadores.agregarRecurso((Computador) recurso);
        } else {
            throw new IllegalArgumentException("Tipo de recurso no soportado");
        }
    }

    public void quitarRecurso(Recurso recurso) {
        if (recurso instanceof Libro) {
            repositorioLibros.eliminarRecurso((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            repositorioPeriodicos.eliminarRecurso((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            repositorioComputadores.eliminarRecurso((Computador) recurso);
        } else {
            throw new IllegalArgumentException("Tipo de recurso no soportado");
        }
    }

    public Collection<Recurso> buscarRecursos(String criterio) {
        List<Recurso> resultados = new ArrayList<>();
        resultados.addAll((Collection<? extends Recurso>) repositorioLibros.buscar(criterio));
        resultados.addAll((Collection<? extends Recurso>) repositorioPeriodicos.buscar(criterio));
        resultados.addAll((Collection<? extends Recurso>) repositorioComputadores.buscar(criterio));
        return resultados;
    }


    public Collection<Recurso> obtenerTodos() {
        List<Recurso> todosLosRecursos = new ArrayList<>();
        todosLosRecursos.addAll((Collection<? extends Recurso>) repositorioLibros.obtenerTodos());
        todosLosRecursos.addAll((Collection<? extends Recurso>) repositorioPeriodicos.obtenerTodos());
        todosLosRecursos.addAll((Collection<? extends Recurso>) repositorioComputadores.obtenerTodos());
        return todosLosRecursos;
    }
}