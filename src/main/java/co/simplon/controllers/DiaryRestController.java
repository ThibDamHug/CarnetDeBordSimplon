package co.simplon.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.errorenum.ErrorMessageEnum;
import co.simplon.exceptions.CustomException;
import co.simplon.models.Diary;
import co.simplon.services.DiaryService;

//@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/diaries")
public class DiaryRestController {
	
	@Autowired
	private DiaryService service;
	
	//@Formateur
	@PostMapping
	public Diary saveOne(@RequestBody Diary diary) {
		
		Diary result = service.saveOne(diary);
		if (null == result) {
			throw new CustomException(ErrorMessageEnum.CREATION);
		}
		return result;
	}
	//@Formateur, @Tuteur, @Apprenant
	@GetMapping
	public List<Diary> getAll(@RequestParam Optional<Boolean> consulter,
								@RequestParam String userRole,
								@RequestParam int promoId,
								@RequestParam Optional<Integer> studentId,
								@RequestParam Optional<Boolean> questions){
		List<Diary> result = new ArrayList<>();
		if (consulter.isPresent()) {
			if ("formateur".equals(userRole)) {
				result = service.getForReading(promoId);
			} else if (studentId.isPresent()){
				result = service.getForReading(promoId, studentId.get());
			}
		} else if ("formateur".equals(userRole) && questions.isPresent()){
			result = service.getDiariesWithQuestionsByPromo(promoId);			
		} else if ("formateur".equals(userRole)) {
			result = service.getNewDiariesByPromo(promoId);
		} else if (studentId.isPresent()){		
			result = service.getDiariesToEditByStudentId(userRole, promoId, studentId.get());
		}
		return result;
	}
		
	//@Formateur, @Tuteur, @Apprenant
//	@GetMapping
//	public List<Diary> getAll(@RequestParam String userRole, @RequestParam int userId) {
//		return service.getAll(userRole, userId);
//	}
	

}
