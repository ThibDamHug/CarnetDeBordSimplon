package co.simplon.services;

import java.util.List;

import co.simplon.models.Diary;

public interface IDiaryService {

	List<Diary> getDiariesWithQuestionsByPromo(int promoId);
	
	List<Diary> getNewDiariesByPromo(int promoId);
	
	List<Diary> getDiariesToEditByStudentId(String userRole, int promoId, int studentId);
	
	List<Diary> getForReading(int promoId);

}
