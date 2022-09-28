package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

<<<<<<< HEAD
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByDescription(String description);
=======
/**
 * Created by jt on 6/13/17.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

>>>>>>> 28aac476a3c62e53b8296bf1b1b60342f53c6e0b
}
