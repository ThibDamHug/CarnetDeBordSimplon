package co.simplon.servicesI;

import java.util.List;

import co.simplon.models.User;

public interface UserServicesI {
	
	public User findByEmail(String email) ;
	
	public void save (User user);
	
	public List<User> findAll ();
	
	public User getConnect();
	
	public List<User> getByRoleDTO (String string);
	
	public List<User> withoutConclusion(int diaryId,int promoId);
	
	public void update(int id ,User user);

}