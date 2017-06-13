package co.simplon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.constantes.ErrorMessageEnum;
import co.simplon.constantes.UriConstants;
import co.simplon.exceptions.CustomException;
import co.simplon.models.Conclusion;
import co.simplon.servicesimpl.ConclusionService;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@RestController
@RequestMapping(UriConstants.CONCLUSIONS)
public class ConclusionRestController {
	
	@Autowired
	private ConclusionService service;
	
	@PostMapping
	public Conclusion saveOne(@Validated @RequestBody Conclusion conclusion) {
		Conclusion result = service.saveOne(conclusion);
		if (null == result) {
			throw new CustomException(ErrorMessageEnum.CREATION);
		}
		return result;
	}
}
