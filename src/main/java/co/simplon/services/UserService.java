package co.simplon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import co.simplon.models.Conclusion;
import co.simplon.models.User;
import co.simplon.repositories.UserRepository;



@Service
public class UserService {

	//Cree automatique l'instance et/ou la classe demandé si necessaire
	@Autowired 
	private UserRepository userRepo;
	
	@Autowired
	private EntitiesFilterService filterService;

	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public void save (User user) {
		userRepo.save(user);
	}
	
	public List<User> findAll () {
		List <User> usersList = new ArrayList<>();
		//La requete findAll n'est meme pas a specifier dans UserDao
		Iterable <User> findAll = userRepo.findAll();
		for (User userTemp: findAll) {
			usersList.add(filterService.setFinalUser(userTemp));
		}
		return usersList;
	}
		
	  public User getConnect() {
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  String currentPrincipal = authentication.getName();
		  User user = userRepo.findByEmail(currentPrincipal);
		  User userFinal = filterService.setFinalUser(user);
		  return userFinal;
	  }
	  
	  public List<User> userListgetByRole (String string) {
		  Iterable <User> getByRoleTemp = userRepo.findByRoleName(string);
		  List <User> getByRole = new ArrayList<User>();
		  for (User userTemp : getByRoleTemp) {
			  getByRole.add(filterService.setFinalUser(userTemp));
		  }
		  return getByRole;
	  }
	  
		public List<User> getUserListWithoutConclusion(int diaryId,int promoId) {
			Iterable <User> getAllFromAPromo = userRepo.findByPromoId(promoId); 
			List <User> getWithoutConclusion = new ArrayList<User>();
			for (User userTemp : getAllFromAPromo){
						if (!userTemp.getConclusions().isEmpty()) {
							List<Conclusion> conclusionListTemp = userTemp.getConclusions();				
							List<Conclusion> conclusionListTemp2 = new ArrayList<Conclusion>();
							for (Conclusion conclusionTemp : conclusionListTemp) {
								if (conclusionTemp.getDiary().getId() == diaryId) {
									conclusionListTemp2.add(conclusionTemp);
								}
							}
							if (conclusionListTemp2.isEmpty()){
								getWithoutConclusion.add(filterService.setFinalUser(userTemp));
							}
						}
			}
		return getWithoutConclusion;
		}
	    
	  public void update(int id ,User user) {
		  User userFinal = userRepo.findOne(id);
		  userFinal = filterService.setFinalUser(user);
		  userRepo.save(userFinal);
	  }
	  
}