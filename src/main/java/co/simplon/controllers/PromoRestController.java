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

import co.simplon.constantes.ErrorMessageEnum;
import co.simplon.constantes.SecurityRoleConstants;
import co.simplon.constantes.UriConstants;
import co.simplon.exceptions.CustomException;
import co.simplon.models.Promo;
import co.simplon.servicesimpl.PromoService;
/**
 * 
 * @author Damien Pradier
 *
 */
@RestController
@RequestMapping(UriConstants.PROMOS)
public class PromoRestController {

	@Autowired
	PromoService service;

	@PreAuthorize(SecurityRoleConstants.ADMIN)
	@GetMapping
	public List<Promo> findAll() {
		return service.findAll();
	}
	
	@PreAuthorize(SecurityRoleConstants.ADMIN)
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
	
	@PreAuthorize(SecurityRoleConstants.ADMIN)
	@PutMapping
	public Promo update(@RequestBody Promo promo){
		return service.updatePromo(promo);
	}
}
