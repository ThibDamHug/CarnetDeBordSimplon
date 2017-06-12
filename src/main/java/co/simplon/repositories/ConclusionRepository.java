package co.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.models.Conclusion;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@Repository
public interface ConclusionRepository extends CrudRepository<Conclusion, Integer> {

}
