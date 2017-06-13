package co.simplon.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.models.Conclusion;
import co.simplon.repositories.ConclusionRepository;
import co.simplon.services.IConclusionService;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@Service
@Transactional
public class ConclusionService implements IConclusionService {
	
	@Autowired
	private ConclusionRepository repository;
	
	@Override
	public Conclusion saveOne(Conclusion conclusion) {
		return repository.save(conclusion);
	}
}
