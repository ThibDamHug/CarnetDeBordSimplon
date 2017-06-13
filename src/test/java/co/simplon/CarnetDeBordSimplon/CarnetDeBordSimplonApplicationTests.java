package co.simplon.CarnetDeBordSimplon;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.simplon.ImplServices.AnswerService;
import co.simplon.ImplServices.DiaryService;
import co.simplon.ImplServices.PromoService;
import co.simplon.ImplServices.QuestionService;
import co.simplon.ImplServices.RoleService;
import co.simplon.ImplServices.UserService;
import co.simplon.models.Question;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarnetDeBordSimplonApplicationTests {
	
	@Autowired
	private AnswerService answerService;
	
	@Test
	public void testGetByDiaryAndStudent () {
		int nbrAnswers = answerService.getByDiaryAndStudent(1, 1).size();
		Assert.assertEquals(10, nbrAnswers);
	}
	
//	@Autowired
//	private ConclusionService conclusionService;
//	
//	@Test
//	public void testsaveOneConclusion () {
//		Conclusion test = new Conclusion();
//		Diary diary = new Diary();
//		User user = new User ();
//		test.setId(1);
//		test.setContent("contenu de test");
//		test.setDiary(diaryId);
//		test.setUser(userId);
//		Conclusion conclusion = conclusionService.saveOne(test);
//		Assert.assertNotNull(conclusion);
//	}
	
	@Autowired
	private DiaryService diaryService;
	
	@Test
	public void testGetNewDiariesByPromo () {
		int nbrDiaries = diaryService.getNewDiariesByPromo(1).size();
		Assert.assertEquals(1, nbrDiaries);
	}

	@Autowired
	private PromoService promoService;
	
	@Test
	public void testfindAllPromos () {
		int nbrPromos = promoService.findAll().size();
		Assert.assertEquals(2, nbrPromos);
	}
	
	
//	TEST A FINIR QUAND LE QUESTIONSERVICE SERA TERMINE
//	
//	@Autowired
//	private QuestionService questionService;
//	
//	@Test
//	public void testSaveQuestionsList () {		
//		List<Question> test = new ArrayList<>();
//		Question question = new Question();
//		question.setContent("contenu des la question test");
//		test.add(question);
//		List<Question> result = questionService.saveQuestionsList(test);
//		Assert.assertNotNull(result);
//	}
	
	@Autowired
	private RoleService roleService;
	
	@Test
	public void testFindAllRole () {
	 	int nbrRoles = roleService.findAll().size();
	 	Assert.assertEquals(4 ,nbrRoles);
	}

	@Autowired
	private UserService userService;
	
	@Test
	public void testfindAllUsers () {
		int nbrUsers = userService.findAll().size();
		Assert.assertEquals(7, nbrUsers);
	}
}
