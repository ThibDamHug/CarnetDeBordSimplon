package co.simplon.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.models.Role;
import co.simplon.repositories.RoleRepository;
import co.simplon.services.IRoleService;

/**
 * 
 * @author Damien Pradier
 *
 */
@Service
@Transactional
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository RoleRepo;
	
	public List<Role> findAll() {
		List<Role> result = new ArrayList<Role>();
		Iterable<Role> inter = RoleRepo.findAll();
		for (Role role : inter) {
			result.add(role);			
		}
		return result;
	}
}
