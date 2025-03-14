package co.edu.etitc.sistemas.programacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class ComputadorRepositorio implements RecursoRepositorio<Computador> {
    private final List<Computador> computadores = new ArrayList<>();

    @Override
    public void agregarRecurso(Computador computador) {
        computadores.add(computador);
    }

    @Override
    public void eliminarRecurso(Computador computador) {
        computadores.remove(computador);
    }

    @Override
    public Collection<Computador> buscar(String criterio) {
        return computadores.stream()
                .filter(computador -> computador.coincideConCriterio(criterio))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Computador> obtenerTodos() {
        return computadores;
    }
}
