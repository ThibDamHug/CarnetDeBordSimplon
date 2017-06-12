package co.simplon.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.errorenum.ErrorMessageEnum;
import co.simplon.exceptions.CustomException;
import co.simplon.models.User;
import co.simplon.servicesI.UserServicesI;

/**
 * 
 * @author Franck Pesson
 *
 */
@RestController
@RequestMapping("api/users")
public class UserRestController {     

	  @Autowired
	  
	  private UserServicesI userService;
	   
	  //Permet de recuperer les utilisateurs en fonction des roles (mockup 4 et 5) ou en fonction d'une promo et d'un carnet (mockup 11)
	  //@RequestMapping(method=RequestMethod.GET)
	  @PreAuthorize("hasAnyRole('ROLE_administrateur,ROLE_formateur')")  
	  @GetMapping
	  public List<User> getUsers (	@RequestParam Optional<String> role,
			  						@RequestParam Optional<Integer> diaryId,
			  						@RequestParam Optional<Integer> promoId ) {
		  if (diaryId.isPresent() && promoId.isPresent()) {
			  return userService.withoutConclusion(diaryId.get(), promoId.get());
		  } else if (role.isPresent()) {
			  return userService.getByRoleDTO(role.get()); 
		  } else {
			  return userService.findAll();
		  }
	  }
	  
	  //Permet de creer un utilisateur (mockup3)
	  @PreAuthorize("hasRole('ROLE_administrateur')")
	  @PostMapping
	  public void createUser(@RequestBody User user) {
	     userService.save(user);
	  }
	  
	  //Permet de modifier un utilisateur (mockup4 et 8)
	  @PreAuthorize("hasRole('ROLE_administrateur')")
	  @PutMapping("/{id}")
	  public void updateUser(@PathVariable int id, @RequestBody User user) {
	     userService.update(id, user);
	  }
	  
	  //Permet de recuperer l'utilisateur connecte (mockup1)
	  @GetMapping("/connected")
	  public User getUserConnected() {
		  User result = userService.getUserConnected();
		  if (null == result) {
			  throw new CustomException(ErrorMessageEnum.FETCH);
		  }		  
		  return result;
	  }
	  
}