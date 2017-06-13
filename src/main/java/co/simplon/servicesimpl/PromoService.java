package co.simplon.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.mappers.PromoMapper;
import co.simplon.models.Promo;
import co.simplon.repositories.PromoRepository;
import co.simplon.services.IPromoService;
/**
 * 
 * @author Damien Pradier
 *
 */
@Service
@Transactional
public class PromoService implements IPromoService {

	@Autowired
	private PromoRepository promoRepo;
	
	@Autowired
	private PromoMapper promoMapper;
	
	public List<Promo> findAll(){
		List<Promo> result = new ArrayList<Promo>();
		Iterable<Promo> inter = promoRepo.findAll();
		for(Promo promo : inter){
			result.add(promoMapper.setPromoDTO(promo));
		}
		return result;
	}
	
	public Promo savePromo(Promo promo){
		return promoRepo.save(promo);
	}
	
	public Promo updatePromo(Promo promo){
		return promoRepo.save(promo);
	}
}
