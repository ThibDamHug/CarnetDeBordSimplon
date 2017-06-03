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

	protected List<Question> QuestionsList(List<Question> questionsList) {
		List<Question> QuestionsListFinal = new ArrayList<Question>();
		for (Question question : questionsList) {
			Question questionFinal = new Question();
			questionFinal.setId(question.getId());
			questionFinal.setContent(question.getContent());
			questionFinal.setRole(question.getRole());
			QuestionsListFinal.add(questionFinal);
		}
		return QuestionsListFinal;
	}

	///////////////////////////////////////// USer Mapper /////////////////////////////////////////

	protected User setFinalPair(User pair) {
		User userFinal = new User();
		userFinal.setId(pair.getId());
		userFinal.setFirstname(pair.getFirstname());
		userFinal.setPromo(setFinalPromo(pair.getPromo()));
		return userFinal;
	}

	protected User setFinalUser(User user) {
		User userFinal = new User();
		userFinal.setId(user.getId());
		userFinal.setFirstname(user.getFirstname());
		userFinal.setLastname(user.getLastname());
		userFinal.setPassword(user.getPassword());
		userFinal.setEmail(user.getEmail());
		userFinal.setRole(user.getRole());
		if (user.getPromo() != null) {
			userFinal.setPromo(setFinalPromo(user.getPromo()));
		}
		if (user.getPair() != null) {
			userFinal.setPair(setFinalPair(user.getPair()));
		}
		return userFinal;
	}
	///////////////////////////////////////// Promo Mapper /////////////////////////////////////////
	
	protected Promo setFinalPromo(Promo promo) {
		Promo finalPromo = new Promo();
		finalPromo.setId(promo.getId());
		finalPromo.setName(promo.getName());
		finalPromo.setStartDate(promo.getStartDate());
		finalPromo.setEndDate(promo.getEndDate());
		return finalPromo;
	}
}
