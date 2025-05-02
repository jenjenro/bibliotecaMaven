package co.edu.etitc.sistemas.programacion;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public class ServicioBiblioteca {

    private final LibroRepositorio repositorioLibros;
    private final PeriodicoRepositorio repositorioPeriodicos;
    private final ComputadorRepositorio repositorioComputadores;

    public ServicioBiblioteca(LibroRepositorio repositorioLibros,
                               PeriodicoRepositorio repositorioPeriodicos,
                               ComputadorRepositorio repositorioComputadores) {
        this.repositorioLibros = repositorioLibros;
        this.repositorioPeriodicos = repositorioPeriodicos;
        this.repositorioComputadores = repositorioComputadores;
    }

    public void agregar(Recurso recurso) {
        if (recurso instanceof Libro libro) {
            repositorioLibros.save(libro);
        } else if (recurso instanceof Periodico periodico) {
            repositorioPeriodicos.save(periodico);
        } else if (recurso instanceof Computador computador) {
            repositorioComputadores.save(computador);
        }
    }

    public void quitarRecurso(Recurso recurso) {
        if (recurso instanceof Libro libro) {
            repositorioLibros.delete(libro);
        } else if (recurso instanceof Periodico periodico) {
            repositorioPeriodicos.delete(periodico);
        } else if (recurso instanceof Computador computador) {
            repositorioComputadores.delete(computador);
        }
    }

    public Collection<Recurso> buscarRecursos(String criterio) {
        Collection<Recurso> resultados = new ArrayList<>();
        resultados.addAll(repositorioLibros.findByCriteria(criterio));
        resultados.addAll(repositorioPeriodicos.findByCriteria(criterio));
        resultados.addAll(repositorioComputadores.findByCriteria(criterio));
        return resultados;
    }

    public Collection<Recurso> obtenerTodos() {
        Collection<Recurso> resultados = new ArrayList<>();
        repositorioLibros.findAll().forEach(resultados::add);
        repositorioPeriodicos.findAll().forEach(resultados::add);
        repositorioComputadores.findAll().forEach(resultados::add);
        return resultados;
    }
}