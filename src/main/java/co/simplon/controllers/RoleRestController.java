package co.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.models.Role;
import co.simplon.services.RoleService;
/**
 * 
 * @author Damien Pradier
 *
 */
@RestController
@RequestMapping(value="api/role")
public class RoleRestController {
	 @Autowired RoleService RoleService;
	
	 @PreAuthorize("hasRole('ROLE_administrateur')")
	 @GetMapping
	 public List<Role> findAll() {
			return RoleService.findAll();
		}
}
