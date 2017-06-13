package co.simplon.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.models.User;
/**
 * 
 * @author Franck Pesson
 *
 */
@Service
public class UserMapper {
	
	@Autowired
	
	PromoMapper promoMapper;

	private User mapPair(User pair) {
		User pairDTO = new User();
		pairDTO.setId(pair.getId());
		pairDTO.setFirstname(pair.getFirstname());
		pairDTO.setPromo(promoMapper.setPromoDTO(pair.getPromo()));
		return pairDTO;
	}
	
	public User mapSimpleUser (User user) {
		User userDTO = new User();
		userDTO.setId(user.getId());
		userDTO.setFirstname(user.getFirstname());
		userDTO.setLastname(user.getLastname());
		return userDTO;
	}

	public User mapUser(User user) {
		User userDTO = new User();
		userDTO.setId(user.getId());
		userDTO.setFirstname(user.getFirstname());
		userDTO.setLastname(user.getLastname());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		userDTO.setRole(user.getRole());
		if (user.getPromo() != null) {
			userDTO.setPromo(promoMapper.setPromoDTO(user.getPromo()));
		}
		if (user.getPair() != null) {
			userDTO.setPair(mapPair(user.getPair()));
		}
		return userDTO;
	}
	
	public User mapUserConnected(User user) {
		User userDTO = new User();
		userDTO.setId(user.getId());
		userDTO.setFirstname(user.getFirstname());
		userDTO.setLastname(user.getLastname());
		userDTO.setEmail(user.getEmail());
		userDTO.setRole(user.getRole());
		if (user.getPromo() != null) {
			userDTO.setPromo(promoMapper.setPromoConnectedDTO(user.getPromo()));
		}
		if (user.getPair() != null) {
			userDTO.setPair(mapPair(user.getPair()));
		}
		return userDTO;
	}
}
