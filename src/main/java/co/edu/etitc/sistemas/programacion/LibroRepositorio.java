package co.edu.etitc.sistemas.programacion;

import java.util.Collection;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends CrudRepository<Libro, Integer> {

    @Query("""
        SELECT * FROM libros
        WHERE nombre LIKE '%' || :criterio || '%' 
           OR autor LIKE '%' || :criterio || '%' 
           OR editorial LIKE '%' || :criterio || '%' 
           OR anio LIKE '%' || :criterio || '%'
    """)
    Collection<Libro> findByCriteria(String criterio);

}