package co.simplon.ImplServices;

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

	public void saveQuestionsList(List<Question> questionsList) {
			questionRepo.save(questionsList);
	}
}
