package co.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.models.Promo;

@Repository
public interface PromoRepository extends CrudRepository<Promo, Integer> {

}
