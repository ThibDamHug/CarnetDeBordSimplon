package co.simplon.services;

import java.util.List;

import co.simplon.models.Promo;

public interface IPromoService {
	
	List<Promo> findAll();
	
	Promo savePromo(Promo promo);
	
	Promo updatePromo(Promo promo);

}
