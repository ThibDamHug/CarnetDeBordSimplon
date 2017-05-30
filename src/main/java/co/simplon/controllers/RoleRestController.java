package co.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.models.Role;
import co.simplon.services.RoleService;

@RestController
@RequestMapping(value="api/role")
public class RoleRestController {
	 @Autowired RoleService RoleService;
	 
	 @GetMapping
	 public List<Role> findAll() {
			return RoleService.findAll();
		}
}
