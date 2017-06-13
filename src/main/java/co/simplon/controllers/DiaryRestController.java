package co.simplon.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.constantes.ErrorMessageEnum;
import co.simplon.constantes.RoleEnum;
import co.simplon.constantes.SecurityRoleConstants;
import co.simplon.constantes.UriConstants;
import co.simplon.exceptions.CustomException;
import co.simplon.models.Diary;
import co.simplon.services.DiaryService;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@RestController
@RequestMapping(UriConstants.DIARIES)
public class DiaryRestController {
	
	@Autowired
	private DiaryService service;
	
	@PreAuthorize(SecurityRoleConstants.TEACHER)
	@PostMapping
	public Diary saveOne(@Validated @RequestBody Diary diary) {
		
		Diary result = service.saveOne(diary);
		if (null == result) {
			throw new CustomException(ErrorMessageEnum.CREATION);
		}
		return result;
	}
	
	@PreAuthorize(SecurityRoleConstants.STUDENT + " or " + 
					SecurityRoleConstants.TEACHER + " or " +
					SecurityRoleConstants.TUTOR)
	@GetMapping
	public List<Diary> getAll(@RequestParam boolean read,
								@RequestParam String userRole,
								@RequestParam int promoId,
								@RequestParam Optional<Integer> studentId,
								@RequestParam Optional<Boolean> questions){
		List<Diary> result = new ArrayList<>();
		if (read) {
			if (RoleEnum.TEACHER.getName().equals(userRole)) {
				result = service.getForReading(promoId);
			} else if (studentId.isPresent()){
				result = service.getForReading(promoId, studentId.get());
			}
		} else if (RoleEnum.TEACHER.getName().equals(userRole) && questions.isPresent() && questions.get()){
			result = service.getDiariesWithQuestionsByPromo(promoId);			
		} else if (RoleEnum.TEACHER.getName().equals(userRole)) {
			result = service.getNewDiariesByPromo(promoId);
		} else if (studentId.isPresent()){		
			result = service.getDiariesToEditByStudentId(userRole, promoId, studentId.get());
		}
		return result;
	}
}
