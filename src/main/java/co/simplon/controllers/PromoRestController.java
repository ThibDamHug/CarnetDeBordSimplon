package co.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.errorenum.ErrorMessageEnum;
import co.simplon.exceptions.CustomException;
import co.simplon.models.Promo;
import co.simplon.services.PromoService;
/**
 * 
 * @author Damien Pradier
 *
 */
@RestController
@RequestMapping(value = "api/promo")
public class PromoRestController {

	@Autowired
	PromoService service;

	@PreAuthorize("hasRole('ROLE_administrateur')")
	@GetMapping
	public List<Promo> findAll() {
		return service.findAll();
	}
	
	@PreAuthorize("hasRole('ROLE_administrateur')")
	@PostMapping
	public Promo save(@Validated @RequestBody Promo promo){
		Promo result;
		try {
			result = service.savePromo(promo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(ErrorMessageEnum.CREATION);
		}
		
		return result;
	}
	
	@PreAuthorize("hasRole('ROLE_administrateur')")
	@PutMapping
	public Promo update(@RequestBody Promo promo){
		return service.updatePromo(promo);
	}
}
