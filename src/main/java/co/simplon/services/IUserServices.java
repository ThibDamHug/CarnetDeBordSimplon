package co.simplon.services;

import java.util.List;


import co.simplon.models.User;
/**
 * 
 * @author Franck Pesson
 *
 */

public interface IUserServices {
	
	public User findByEmail(String email) ;
	
	public void save (User user);
	
	public List<User> findAll ();
	
	public User getUserConnected();
	
	public List<User> getByRoleDTO (String string);
	
	public List<User> withoutConclusion(int diaryId,int promoId);
	
	public void update(int id ,User user);

}