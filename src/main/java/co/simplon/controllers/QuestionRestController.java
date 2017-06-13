package co.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ImplServices.QuestionService;
import co.simplon.constantes.SecurityRoleConstants;
import co.simplon.constantes.UriConstants;
import co.simplon.models.Question;
/**
 * 
 * @author Franck Pesson
 *
 */
@RestController
@RequestMapping(UriConstants.QUESTIONS)
public class QuestionRestController {

	@Autowired
	QuestionService questionService;

	// Permet de sauvegarder une liste de questions(mockup 11)
	@PreAuthorize(SecurityRoleConstants.ADMIN)
	@PostMapping
	public void createUser(@Validated @RequestBody List<Question> questionsList) {
		questionService.saveQuestionsList(questionsList);
	}

}
