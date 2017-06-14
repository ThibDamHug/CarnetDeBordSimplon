package co.simplon.CarnetDeBordSimplon;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.simplon.servicesimpl.AnswerService;
import co.simplon.servicesimpl.DiaryService;
import co.simplon.servicesimpl.PromoService;
import co.simplon.servicesimpl.RoleService;
import co.simplon.servicesimpl.UserService;

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
