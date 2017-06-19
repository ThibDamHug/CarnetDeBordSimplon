package co.simplon.servicesimpl;

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
import co.simplon.services.IUserService;

/**
 * 
 * @author Franck Pesson
 *
 */
@Service
public class UserService implements IUserService {

	//Cree automatique l'instance et/ou la classe demandé si necessaire
	@Autowired 
	private UserRepository userRepo;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	@Override
	public User saveOne (User user) {
		return userRepo.save(user);
	}
	
	@Override
	public List<User> findAll () {
		List <User> usersDTO = new ArrayList<>();
		//La requete findAll n'est meme pas a specifier dans UserDao
		Iterable <User> findAll = userRepo.findAll();
		for (User user: findAll) {
			usersDTO.add(userMapper.mapUser(user));
		}
		return usersDTO;
	}
	
	@Override
	public User getConnected() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipal = authentication.getName();
		User user = userRepo.findByEmail(currentPrincipal);
		User userConnected = userMapper.mapUserConnected(user);
		return userConnected;
	}
	
	@Override
	public List<User> getByRoleDTO (String string) {
		Iterable <User> getByRole = userRepo.findByRoleName(string);
		List <User> getByRoleDTO = new ArrayList<>();
		for (User user : getByRole) {
			getByRoleDTO.add(userMapper.mapUser(user));
		}
		return getByRoleDTO;
	}
	 
	@Override
	public List<User> getWithoutConclusionDTO(int diaryId,int promoId) {
		Iterable <User> fromAPromo = userRepo.findByPromoId(promoId); 
		List <User> getUsersWithoutConclusionDTO = new ArrayList<>();
		for (User user : fromAPromo){
			if (!user.getConclusions().isEmpty()) {
				List<Conclusion> conclusions = user.getConclusions();				
				List<Conclusion> conclusionsDTO = new ArrayList<>();
				for (Conclusion conclusion : conclusions) {
					if (conclusion.getDiary().getId() == diaryId) {
						conclusionsDTO.add(conclusion);
					}
				}
				if (conclusionsDTO.isEmpty()){
					getUsersWithoutConclusionDTO.add(userMapper.mapUser(user));
				}
			}
		}
		return getUsersWithoutConclusionDTO;
	}
	    
	@Override
	public User update(int id ,User user) {
		User userFinal = userRepo.findOne(id);
		userFinal = userMapper.mapUser(user);
		return userRepo.save(userFinal);
	}
}