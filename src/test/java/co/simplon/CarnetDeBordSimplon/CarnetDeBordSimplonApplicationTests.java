package co.simplon.CarnetDeBordSimplon;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.simplon.services.IAnswerService;
import co.simplon.services.IDiaryService;
import co.simplon.services.IPromoService;
import co.simplon.services.IRoleService;
import co.simplon.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarnetDeBordSimplonApplicationTests {
	
	@Autowired
	private IAnswerService answerService;
	
	@Test
	public void testGetByDiaryAndStudent () {
		int nbrAnswers = answerService.getByDiaryAndStudent(1, 1).size();
		Assert.assertEquals(10, nbrAnswers);
	}
	
	@Autowired
	private IDiaryService diaryService;
	
	@Test
	public void testGetNewDiariesByPromo () {
		int nbrDiaries = diaryService.getNewDiariesByPromo(1).size();
		Assert.assertEquals(1, nbrDiaries);
	}

	@Autowired
	private IPromoService promoService;
	
	@Test
	public void testfindAllPromos () {
		int nbrPromos = promoService.findAll().size();
		Assert.assertEquals(2, nbrPromos);
	}
	
	@Autowired
	private IRoleService roleService;
	
	@Test
	public void testFindAllRole () {
	 	int nbrRoles = roleService.findAll().size();
	 	Assert.assertEquals(4 ,nbrRoles);
	}

	@Autowired
	private IUserService userService;
	
	@Test
	public void testfindAllUsers () {
		int nbrUsers = userService.findAll().size();
		Assert.assertEquals(7, nbrUsers);
	}
}
