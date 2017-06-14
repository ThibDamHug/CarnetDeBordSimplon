package co.simplon.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.mappers.AnswerMapper;
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
	
	@Autowired
	private AnswerMapper answerMapper;
	
	public List<Answer> getByDiaryAndStudent(int diaryId, int studentId) {
		Iterable<Answer> request = repository.findByUserId(studentId);
		List<Answer> result = answerMapper.mapRequests(request, diaryId);
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
			Answer answerDTO = answerMapper.mapAnswers(answer);
			result.add(answerDTO);
		}
		return result;
	}

}
