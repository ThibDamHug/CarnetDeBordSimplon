package co.simplon.ImplServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import co.simplon.mappers.UserMapper;
import co.simplon.models.Conclusion;
import co.simplon.models.User;
import co.simplon.repositories.UserRepository;
import co.simplon.services.IUserServices;

/**
 * 
 * @author Franck Pesson
 *
 */
@Service
public class UserService implements IUserServices {

	//Cree automatique l'instance et/ou la classe demandé si necessaire
	@Autowired 
	private UserRepository userRepo;
	
	@Autowired
	private UserMapper userMapper;

	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public void save (User user) {
		userRepo.save(user);
	}
	
	public List<User> findAll () {
		List <User> usersDTO = new ArrayList<>();
		//La requete findAll n'est meme pas a specifier dans UserDao
		Iterable <User> findAll = userRepo.findAll();
		for (User user: findAll) {
			usersDTO.add(userMapper.mapUser(user));
		}
		return usersDTO;
	}
		
	public User getUserConnected() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipal = authentication.getName();
		User user = userRepo.findByEmail(currentPrincipal);
		User userConnected = userMapper.mapUserConnected(user);
		return userConnected;
	}
	  
	public List<User> getByRoleDTO (String string) {
		Iterable <User> getByRole = userRepo.findByRoleName(string);
		List <User> getByRoleDTO = new ArrayList<User>();
		for (User user : getByRole) {
			getByRoleDTO.add(userMapper.mapUser(user));
		}
		return getByRoleDTO;
	}
	  
	public List<User> withoutConclusion(int diaryId,int promoId) {
		Iterable <User> fromAPromo = userRepo.findByPromoId(promoId); 
		List <User> withoutConclusionDTO = new ArrayList<User>();
		for (User user : fromAPromo){
			if (!user.getConclusions().isEmpty()) {
				List<Conclusion> conclusions = user.getConclusions();				
				List<Conclusion> conclusionsDTO = new ArrayList<Conclusion>();
				for (Conclusion conclusion : conclusions) {
					if (conclusion.getDiary().getId() == diaryId) {
						conclusionsDTO.add(conclusion);
					}
				}
				if (conclusionsDTO.isEmpty()){
					withoutConclusionDTO.add(userMapper.mapUser(user));
				}
			}
		}
		return withoutConclusionDTO;
	}
	    
	public void update(int id ,User user) {
		User userFinal = userRepo.findOne(id);
		userFinal = userMapper.mapUser(user);
		userRepo.save(userFinal);
	}
	  
}