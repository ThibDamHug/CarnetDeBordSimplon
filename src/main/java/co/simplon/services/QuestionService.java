package co.simplon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.models.Question;
import co.simplon.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepo;

	public void saveQuestionsList(List<Question> questionsList) {
		for (Question question : questionsList) {
			questionRepo.save(question);
		}
	}

}
