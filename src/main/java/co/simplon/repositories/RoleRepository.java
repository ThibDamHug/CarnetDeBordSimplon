package co.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.models.Role;
/**
 * 
 * @author Damien Pradier
 *
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
