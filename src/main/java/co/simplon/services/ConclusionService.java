package co.simplon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.models.Conclusion;
import co.simplon.repositories.ConclusionRepository;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@Service
@Transactional
public class ConclusionService {
	
	@Autowired
	private ConclusionRepository repository;
	
	public Conclusion saveOne(Conclusion conclusion) {
		return repository.save(conclusion);
	}

}
