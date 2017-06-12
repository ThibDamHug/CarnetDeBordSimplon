package co.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.models.Question;
/**
 * 
 * @author Damien Pradier
 *
 */
@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

}
