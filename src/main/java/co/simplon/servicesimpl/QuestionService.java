package co.simplon.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.models.Question;
import co.simplon.repositories.QuestionRepository;
import co.simplon.services.IQuestionService;
/**
 * 
 * @author Franck Pesson
 *
 */
@Service
public class QuestionService implements IQuestionService {

	@Autowired
	QuestionRepository questionRepo;

	public Iterable<Question> saveAll(List<Question> questions) {
			return questionRepo.save(questions);
	}
}
