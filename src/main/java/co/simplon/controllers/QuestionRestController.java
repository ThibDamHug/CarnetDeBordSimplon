package co.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.diaries.Question;
import co.simplon.diariesservice.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionRestController {
	
		@Autowired
		QuestionService questionService;
		
		//Permet de sauvegarder une liste de questions(mockup 11)
	  	@PostMapping
	  	public void createUser(@RequestBody List<Question> questionsList) {
	  		questionService.saveQuestionsList(questionsList);
	  	}
	
}
