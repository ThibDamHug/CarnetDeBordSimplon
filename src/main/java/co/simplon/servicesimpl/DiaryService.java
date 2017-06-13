package co.simplon.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.mappers.DiaryMapper;
import co.simplon.mappers.QuestionMapper;
import co.simplon.models.Diary;
import co.simplon.models.Question;
import co.simplon.repositories.DiaryRepository;
import co.simplon.services.IDiaryService;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@Service
@Transactional
public class DiaryService implements IDiaryService {
	
	@Autowired
	private DiaryRepository repository;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private DiaryMapper diaryMapper;
		
	public Diary saveOne(Diary diary) {
		return repository.save(diary);
	}
	
	@Override
	public List<Diary> getDiariesWithQuestionsByPromo(int promoId) {
		List<Diary> result = new ArrayList<>();
		Iterable<Diary> request = repository.findByPromoId(promoId);		
		for (Diary diary : request) {
			if (!diary.getQuestions().isEmpty()) {
				Diary diaryDTO = diaryMapper.mapDiary(diary);
				diaryDTO.setQuestions(questionMapper.mapQuestions(diary.getQuestions()));
				result.add(diaryDTO);
			}
		}
		return result;
	}
	@Override
	public List<Diary> getNewDiariesByPromo(int promoId) {		
		Iterable<Diary> request = repository.findByPromoId(promoId);		
		return diaryMapper.getEmptyDiaries(request);
	}
	
	@Override
	public List<Diary> getDiariesToEditByStudentId(String userRole, int promoId, int studentId) {
		List<Diary> result = new ArrayList<>();
		Iterable<Diary> request = repository.findByPromoId(promoId);	
		for (Diary diary : request) {
			List<Question> questionsDTO = questionMapper.mapQuestionsToEdit(diary.getQuestions(), userRole, studentId);
			if (!questionsDTO.isEmpty()) {
				Diary diaryDTO = diaryMapper.mapDiary(diary);
				diaryDTO.setQuestions(questionsDTO);
				result.add(diaryDTO);
			}
		}
		return result;
	}
	@Override
	public List<Diary> getForReading(int promoId) {		
		Iterable<Diary> request = repository.findByPromoId(promoId);					
		return diaryMapper.mapDiariesForFormateurToRead(request);
	}
	public List<Diary> getForReading(int promoId, int studentId) {
		Iterable<Diary> request = repository.findByPromoId(promoId);		
		return diaryMapper.mapDiariesForOthersToRead(request, studentId);
	}
	
//	private List<Conclusion> filteringConclusionsForFormateur(List<Conclusion> conclusions) {
//		List<Conclusion> result = new ArrayList<>();
//		for (Conclusion conclusion : conclusions) {
//			Conclusion conclusionDTO = conclusionMapper.mapConclusion(conclusion);			
//			result.add(conclusionDTO);
//		}
//		return result;
//	}
//	
//	private List<Conclusion> filteringConclusionsByStudentId(List<Conclusion> conclusions, int studentId) {
//		List<Conclusion> result = new ArrayList<>();
//		for (Conclusion conclusion : conclusions) {
//			if (conclusion.getUser().getId() == studentId) {
//				Conclusion conclusionDTO = conclusionMapper.mapConclusion(conclusion);
//				result.add(conclusionDTO);
//			}				
//		}
//		return result;
//	}
//	
//	private List<Diary> filteringDiariesForFormateurRead(Iterable<Diary> request) {
//		List<Diary> result = new ArrayList<>();
//		for (Diary diary : request) {
//			if (!diary.getConclusions().isEmpty()) {
//				Diary diaryDTO;
//				diaryDTO = filteringDiary(diary);
//				diaryDTO.setConclusions(filteringConclusionsForFormateur(diary.getConclusions()));
//				result.add(diaryDTO);
//			}
//		}		
//		return result;
//	}
//	
//	private List<Diary> filteringDiariesForOtherToRead(Iterable<Diary> request, int studentId) {
//		List<Diary> result = new ArrayList<>();
//		for (Diary diary : request) {
//			if (!diary.getConclusions().isEmpty()) {
//				Diary diaryDTO = filteringDiary(diary);				 
//				diaryDTO.setConclusions(filteringConclusionsByStudentId(diary.getConclusions(), studentId));
//				if (!diaryDTO.getConclusions().isEmpty()) {					
//					result.add(diaryDTO);
//				}			
//			}
//		}
//		return result;
//		
//	}
//	
//	private Diary filteringDiary(Diary diary) {	
//		Diary diaryDTO = new Diary();					
//		diaryDTO.setId(diary.getId());
//		diaryDTO.setStartDate(diary.getStartDate());
//		diaryDTO.setEndDate(diary.getEndDate());
//		diaryDTO.setIntroduction(diary.getIntroduction());
//		diaryDTO.setName(diary.getName());			
//		return diaryDTO;
//	}
//	
//	private List<Diary> getEmptyDiaries(Iterable<Diary> request) {
//		List<Diary> result = new ArrayList<>();
//		for (Diary diary : request) {
//			if (diary.getQuestions().isEmpty()) {
//				Diary diaryDTO = filteringDiary(diary);
//				result.add(diaryDTO);
//			}
//		}
//		return result;
//	}
	
//	private List<Question> filteringQuestions(List<Question> questions) {
//		List<Question> result = new ArrayList<>();
//		for (Question question : questions) {
//			Question questionDTO = filteringQuestion(question);
//			result.add(questionDTO);
//		}
//		return result;
//	}
	
//	private Question filteringQuestion(Question question) {
//		Question result = new Question();
//		result.setId(question.getId());
//		result.setContent(question.getContent());
//		return result;
//	}
	
//	private List<Question> filteringQuestionsToEdit(List<Question> questions,String userRole, int studentId) {
//		List<Question> result = new ArrayList<>();
//		for (Question question : questions) {
//			if (question.getRole().getName().equals(userRole) && !isAnswered(question, studentId)) {				
//				Question questionDTO = filteringQuestion(question);
//				result.add(questionDTO);				
//			}
//		}
//		return result;
//	}
	
//	private boolean isAnswered(Question question, int studentId) {		
//		boolean result = false;
//		for (Answer answer : question.getAnswers()) {
//			if (answer.getUser().getId() == studentId) {
//				result = true;
//				break;
//			}
//		}
//		return result;
//	}
		
//	private Conclusion filteringConclusion(Conclusion conclusion) {
//		Conclusion result = new Conclusion();
//		result.setId(conclusion.getId());
//		result.setContent(conclusion.getContent());
//		result.setUser(userMapper.mapSimpleUser(conclusion.getUser()));
//		return result;
//	}
}
