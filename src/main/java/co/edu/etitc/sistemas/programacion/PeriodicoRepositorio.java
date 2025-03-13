package co.edu.etitc.sistemas.programacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class PeriodicoRepositorio implements RecursoRepositorio<Periodico> {
    private final List<Periodico> periodicos = new ArrayList<>();

    @Override
    public void agregarRecurso(Periodico periodico) {
        periodicos.add(periodico);
    }

    @Override
    public void eliminarRecurso(Periodico periodico) {
        periodicos.remove(periodico);
    }

    @Override
    public Collection<Periodico> buscar(String criterio) {
        return periodicos.stream()
                .filter(periodico -> periodico.getNombre().contains(criterio) || periodico.getEditorial().contains(criterio))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Periodico> obtenerTodos() {
        return periodicos;
    }
}