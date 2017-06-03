package co.simplon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.models.Promo;
import co.simplon.models.Question;
import co.simplon.models.User;

@Service
public class MapperService {

	/////////////////////////////////////// Question Mapper /////////////////////////////////////////

	protected List<Question> setQuestionsDTO (List<Question> questionsList) {
		List<Question> questionsDTO = new ArrayList<Question>();
		for (Question question : questionsList) {
			Question questionFinal = new Question();
			questionFinal.setId(question.getId());
			questionFinal.setContent(question.getContent());
			questionFinal.setRole(question.getRole());
			questionsDTO.add(questionFinal);
		}
		return questionsDTO;
	}

	///////////////////////////////////////// USer Mapper /////////////////////////////////////////

	protected User setPairDTO(User pair) {
		User pairDTO = new User();
		pairDTO.setId(pair.getId());
		pairDTO.setFirstname(pair.getFirstname());
		pairDTO.setPromo(setPromoDTO(pair.getPromo()));
		return pairDTO;
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
			userDTO.setPromo(setPromoDTO(user.getPromo()));
		}
		if (user.getPair() != null) {
			userDTO.setPair(setPairDTO(user.getPair()));
		}
		return userDTO;
	}
	///////////////////////////////////////// Promo Mapper /////////////////////////////////////////
	
	protected Promo setPromoDTO (Promo promo) {
		Promo promoDTO = new Promo();
		promoDTO.setId(promo.getId());
		promoDTO.setName(promo.getName());
		promoDTO.setStartDate(promo.getStartDate());
		promoDTO.setEndDate(promo.getEndDate());
		return promoDTO;
	}
}
