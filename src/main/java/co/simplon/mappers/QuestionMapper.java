package co.simplon.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.models.Answer;
import co.simplon.models.Question;

/**
 * 
 * @author Franck Pesson
 *
 */

@Service
public class QuestionMapper {
	
	public Question mapQuestion(Question question) {
		Question questionDTO = new Question();
		questionDTO.setId(question.getId());
		questionDTO.setContent(question.getContent());
		return questionDTO;
	}
	
	public List<Question> mapQuestions(List<Question> questions) {
		List<Question> questionsDTO = new ArrayList<>();
		for (Question question : questions) {
			Question questionDTO = mapQuestion(question);
			questionsDTO.add(questionDTO);
		}
		return questionsDTO;
	}
	
	public List<Question> mapQuestionsToEdit(List<Question> questions,String userRole, int studentId) {
		List<Question> questionsDTO = new ArrayList<>();
		for (Question question : questions) {
			if (question.getRole().getName().equals(userRole) && !isAnswered(question, studentId)) {				
				Question questionDTO = mapQuestion(question);
				questionsDTO.add(questionDTO);				
			}
		}
		return questionsDTO;
	}
	
	private boolean isAnswered(Question question, int studentId) {		
		boolean result = false;
		for (Answer answer : question.getAnswers()) {
			if (answer.getUser().getId() == studentId) {
				result = true;
				break;
			}
		}
		return result;
	}

}
