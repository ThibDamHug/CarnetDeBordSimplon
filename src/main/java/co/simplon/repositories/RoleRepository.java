package co.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
