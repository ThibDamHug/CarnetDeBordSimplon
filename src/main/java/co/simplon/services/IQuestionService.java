package co.simplon.services;

import java.util.List;

import co.simplon.models.Question;

public interface IQuestionService {
	
	Iterable<Question> saveAll(List<Question> questionsList);

}
