package co.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.errorenum.ErrorMessageEnum;
import co.simplon.exceptions.CustomException;
import co.simplon.models.Answer;
import co.simplon.services.AnswerService;

//@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/answers")
public class AnswerRestController {
	
	@Autowired
	AnswerService service;
	
	@GetMapping
	public List<Answer> getByDiaryAndStudent(@RequestParam int diaryId,
											@RequestParam int studentId) {
		return service.getByDiaryAndStudent(diaryId, studentId);
	}
	
	@PostMapping
	public List<Answer> saveAnswers(@RequestBody List<Answer> answers) {
		List<Answer> result = service.saveAll(answers);
		if (result.isEmpty()) {
			throw new CustomException(ErrorMessageEnum.CREATION);
		}
		return result;
	}

}
