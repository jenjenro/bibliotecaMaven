package co.edu.etitc.sistemas.programacion;

import java.util.Collection;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ComputadorRepositorio extends CrudRepository<Computador, Integer> {

    @Query("""
        SELECT * FROM computador 
        WHERE nombre LIKE '%' || :criterio || '%' 
           OR marca LIKE '%' || :criterio || '%' 
           OR modelo LIKE '%' || :criterio || '%' 
           OR sistema_operativo LIKE '%' || :criterio || '%'
    """)
    Collection<Computador> findByCriteria(String criterio);
}