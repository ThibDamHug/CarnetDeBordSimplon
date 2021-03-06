package co.simplon.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.constantes.ErrorMessageEnum;
import co.simplon.constantes.SecurityRoleConstants;
import co.simplon.constantes.UriConstants;
import co.simplon.exceptions.CustomException;
import co.simplon.models.User;
import co.simplon.services.IUserService;

/**
 * 
 * @author Franck Pesson
 *
 */
@RestController
@RequestMapping(UriConstants.USERS)
public class UserRestController {     

	  @Autowired
	  
	  private IUserService userService;
	   
	  //Permet de recuperer les utilisateurs en fonction des roles (mockup 4 et 5) ou en fonction d'une promo et d'un carnet (mockup 11)
	  //@RequestMapping(method=RequestMethod.GET)
	  @PreAuthorize(SecurityRoleConstants.ADMIN + " or " +
			  		SecurityRoleConstants.TEACHER)  
	  @GetMapping
	  public List<User> getUsers (	@RequestParam Optional<String> role,
			  						@RequestParam Optional<Integer> diaryId,
			  						@RequestParam Optional<Integer> promoId ) {
		  if (diaryId.isPresent() && promoId.isPresent()) {
			  return userService.getWithoutConclusionDTO(diaryId.get(), promoId.get());
		  } else if (role.isPresent()) {
			  return userService.getByRoleDTO(role.get()); 
		  } else {
			  return userService.findAll();
		  }
	  }
	  
	  //Permet de creer un utilisateur (mockup3)
	  @PreAuthorize(SecurityRoleConstants.ADMIN)
	  @PostMapping
	  public void createUser(@Validated @RequestBody User user) {
	     userService.saveOne(user);
	  }
	  
	  //Permet de modifier un utilisateur (mockup4 et 8)
	  @PreAuthorize(SecurityRoleConstants.ADMIN)
	  @PutMapping("/{id}")
	  public void updateUser(@PathVariable int id, @RequestBody User user) {
	     userService.update(id, user);
	  }
	  
	  //Permet de recuperer l'utilisateur connecte (mockup1)
	  @GetMapping("/connected")
	  public User getUserConnected() {

		  User result = userService.getConnected();

		  if (null == result) {
			  throw new CustomException(ErrorMessageEnum.FETCH);
		  }		  
		  return result;
	  }
	  
}