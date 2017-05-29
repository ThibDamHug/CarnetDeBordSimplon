package co.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	public Iterable<User> findByRoleName(String roleName);
	public User findByEmail(String email);
	public User findByEmailAndPassword(String email, String password);
	public Iterable<User> findByPromoId(int promoId);

}
