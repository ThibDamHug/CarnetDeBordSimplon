package co.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.models.User;
/**
 * 
 * @author Franck Pesson
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
//	Permet de creer des methodes via Crud 	

	public Iterable<User> findByRoleName(String roleName);
	public User findByEmail(String email);
	public Iterable<User> findByPromoId(int promoId);
	
//	Permet de creer des methodes non comprise par Hibernate
//	@Query("select `firstname` from `Utilisateur`")
//	public List<String> findfirstname();

}
