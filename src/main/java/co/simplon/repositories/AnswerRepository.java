package co.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.models.Answer;
/**
 * 
 * @author Damien Pradier
 *
 */
@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {
	
	public Iterable<Answer> findByUserId(int studentId);

}
