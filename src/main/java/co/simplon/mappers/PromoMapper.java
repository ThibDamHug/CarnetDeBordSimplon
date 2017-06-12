package co.simplon.mappers;

import org.springframework.stereotype.Service;

import co.simplon.models.Promo;
/**
 * 
 * @author Franck Pesson
 *
 */
@Service
public class PromoMapper {

	protected Promo setPromoDTO (Promo promo) {
		Promo promoDTO = new Promo();
		promoDTO.setId(promo.getId());
		promoDTO.setName(promo.getName());
		promoDTO.setStartDate(promo.getStartDate());
		promoDTO.setEndDate(promo.getEndDate());
		return promoDTO;
	}
}
