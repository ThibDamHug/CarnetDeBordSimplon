package co.simplon.services;

import java.util.List;

import co.simplon.models.Answer;

public interface IAnswerService {
	
	List<Answer> getByDiaryAndStudent(int diaryId, int studentId);
	
	List<Answer> saveAll(List<Answer> answers);

}
