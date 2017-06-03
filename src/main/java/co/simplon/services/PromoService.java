package co.simplon.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.models.Promo;
import co.simplon.repositories.PromoRepository;

@Service
@Transactional
public class PromoService {

	@Autowired
	private PromoRepository promoRepo;
	
	@Autowired
	private MapperService mapperService;
	
	public List<Promo> findAll(){
		List<Promo> result = new ArrayList<Promo>();
		Iterable<Promo> inter = promoRepo.findAll();
		for(Promo promo : inter){
			result.add(mapperService.setPromoDTO(promo));
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
