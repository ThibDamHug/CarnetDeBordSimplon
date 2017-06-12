package co.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.models.Diary;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@Repository
public interface DiaryRepository extends CrudRepository<Diary, Integer> {
	
	public Iterable<Diary> findByPromoId(int promoId);

}
