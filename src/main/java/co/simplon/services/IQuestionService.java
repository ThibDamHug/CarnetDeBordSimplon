package co.simplon.services;

import java.util.List;

import co.simplon.models.Question;

public interface IQuestionService {
	
	void saveQuestionsList(List<Question> questionsList);

}
