package co.simplon.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.models.Answer;
import co.simplon.repositories.AnswerRepository;
import co.simplon.services.IAnswerService;
/**
 * 
 * @author Damien Pradier
 *
 */
@Service
@Transactional
public class AnswerService implements IAnswerService {
	
	@Autowired
	private AnswerRepository repository;
	
	public List<Answer> getByDiaryAndStudent(int diaryId, int studentId) {
		Iterable<Answer> request = repository.findByUserId(studentId);
		List<Answer> result = filteringRequest(request, diaryId);
		if (result.size() == 10) {
			return result;
		} else {
			result = new ArrayList<>();			
		}
		return result;
	}
	
	public List<Answer> saveAll(List<Answer> answers) {
		List<Answer> result = new ArrayList<>();
		Iterable<Answer> request = repository.save(answers);
		for (Answer answer : request) {
			Answer answerDTO = filteringAnswer(answer);
			result.add(answerDTO);
		}
		return result;
	}
	
	private List<Answer> filteringRequest(Iterable<Answer> answers, int diaryId) {
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
	
	private Answer filteringAnswer(Answer answer) {
		Answer result = new Answer();
		result.setId(answer.getId());
		result.setContent(answer.getContent());
		return result;
	}

}
