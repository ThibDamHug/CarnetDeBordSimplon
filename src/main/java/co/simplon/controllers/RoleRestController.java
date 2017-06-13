package co.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ImplServices.RoleService;
import co.simplon.constantes.SecurityRoleConstants;
import co.simplon.constantes.UriConstants;
import co.simplon.models.Role;
/**
 * 
 * @author Damien Pradier
 *
 */
@RestController
@RequestMapping(UriConstants.ROLES)
public class RoleRestController {
	 @Autowired RoleService roleService;
	
	 @PreAuthorize(SecurityRoleConstants.ADMIN)
	 @GetMapping
	 public List<Role> findAll() {
			return roleService.findAll();
		}
}
