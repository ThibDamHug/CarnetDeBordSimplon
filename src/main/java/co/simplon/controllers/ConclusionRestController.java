package co.simplon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.models.Conclusion;
import co.simplon.services.ConclusionService;

//@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/conclusions")
public class ConclusionRestController {
	
	@Autowired
	private ConclusionService service;
	
	@PostMapping
	public Conclusion saveOne(@RequestBody Conclusion conclusion) {
		return service.saveOne(conclusion);
	}

}
