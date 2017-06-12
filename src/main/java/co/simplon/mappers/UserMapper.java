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

	protected User setPairDTO(User pair) {
		User pairDTO = new User();
		pairDTO.setId(pair.getId());
		pairDTO.setFirstname(pair.getFirstname());
		pairDTO.setPromo(promoMapper.setPromoDTO(pair.getPromo()));
		return pairDTO;
	}
	
	protected User setSimpleUserDTO (User user) {
		User userDTO = new User();
		userDTO.setId(user.getId());
		userDTO.setFirstname(user.getFirstname());
		userDTO.setLastname(user.getLastname());
		return userDTO;
	}

	protected User setUserDTO(User user) {
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
			userDTO.setPair(setPairDTO(user.getPair()));
		}
		return userDTO;
	}
}
