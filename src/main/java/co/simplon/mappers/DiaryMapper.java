package co.simplon.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.models.Diary;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@Service
public class DiaryMapper {
	
	@Autowired
	private ConclusionMapper conclusionMapper;
	
	public List<Diary> mapDiariesForFormateurToRead(Iterable<Diary> request) {
		List<Diary> result = new ArrayList<>();
		for (Diary diary : request) {
			if (!diary.getConclusions().isEmpty()) {
				Diary diaryDTO;
				diaryDTO = mapDiary(diary);
				diaryDTO.setConclusions(conclusionMapper.mapConclusionsForTeacher(diary.getConclusions()));
				result.add(diaryDTO);
			}
		}		
		return result;
	}
	
	public List<Diary> mapDiariesForOthersToRead(Iterable<Diary> request, int studentId) {
		List<Diary> result = new ArrayList<>();
		for (Diary diary : request) {
			if (!diary.getConclusions().isEmpty()) {
				Diary diaryDTO = mapDiary(diary);				 
				diaryDTO.setConclusions(conclusionMapper.mapConclusionsByStudentId(diary.getConclusions(), studentId));
				if (!diaryDTO.getConclusions().isEmpty()) {					
					result.add(diaryDTO);
				}			
			}
		}
		return result;
		
	}
	
	public Diary mapDiary(Diary diary) {	
		Diary diaryDTO = new Diary();					
		diaryDTO.setId(diary.getId());
		diaryDTO.setStartDate(diary.getStartDate());
		diaryDTO.setEndDate(diary.getEndDate());
		diaryDTO.setIntroduction(diary.getIntroduction());
		diaryDTO.setName(diary.getName());			
		return diaryDTO;
	}
}
