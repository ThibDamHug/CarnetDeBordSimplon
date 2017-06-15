package co.simplon.services;

import java.util.List;


import co.simplon.models.User;
/**
 * 
 * @author Franck Pesson
 *
 */

public interface IUserService {
	
	public User findByEmail(String email) ;
	
	public User saveOne (User user);
	
	public List<User> findAll ();
	
	public User getConnected();
	
	public List<User> getByRoleDTO (String string);
	
	public List<User> getWithoutConclusionDTO(int diaryId,int promoId);
	
	public User update(int id ,User user);

}
