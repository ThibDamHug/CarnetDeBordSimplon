package co.simplon.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.models.Answer;

/**
 * 
 * @author Pradier Damien
 *
 */
@Service
public class AnswerMapper {

	public List<Answer> mapRequests(Iterable<Answer> answers, int diaryId) {
		List<Answer> result = new ArrayList<>();
		for (Answer answer : answers) {
			if (answer.getQuestion().getDiary().getId() == diaryId) {
				Answer answerDTO = new Answer();
				answerDTO.setId(answer.getId());
				answerDTO.setContent(answer.getContent());
				result.add(answerDTO);
			}
		}
		return result;
	}
	
	public Answer mapAnswers(Answer answer) {
		Answer answerDTO = new Answer();
		answerDTO.setId(answer.getId());
		answerDTO.setContent(answer.getContent());
		return answerDTO;
	}
	
}
