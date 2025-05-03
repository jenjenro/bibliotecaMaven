package co.edu.etitc.sistemas.programacion;
import java.util.Collection;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodicoRepositorio extends CrudRepository<Periodico, Integer> {

    @Query("""
        SELECT * FROM periodico 
        WHERE nombre LIKE '%' || :criterio || '%' 
           OR editorial LIKE '%' || :criterio || '%' 
           OR fecha_publicacion::TEXT LIKE '%' || :criterio || '%'
    """)
    Collection<Periodico> findByCriteria(String criterio);
}