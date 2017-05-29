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

import co.simplon.users.User;
import co.simplon.usersservice.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {     

	  @Autowired
	  
	  private UserService userService;
	   
	  //Permet de recuperer les utilisateurs en fonction des roles (mockup 4 et 5) ou en fonction d'une promo et d'un carnet (mockup 11)
	  //@RequestMapping(method=RequestMethod.GET)
	  @PreAuthorize("hasRole('ROLE_administrateur')")  
	  @GetMapping
	  public List<User> getUsers (	@RequestParam Optional<String> role,
			  						@RequestParam Optional<Integer> diaryId,
			  						@RequestParam Optional<Integer> promoId ) {
		  if (diaryId.isPresent() && promoId.isPresent()) {
			  return userService.getUserListWithoutConclusion(diaryId.get(), promoId.get());
		  } else if (role.isPresent()) {
			  return userService.userListgetByRole(role.get()); 
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
	  public User userConnected() {
		  return userService.getConnect();
	  }
	  
}