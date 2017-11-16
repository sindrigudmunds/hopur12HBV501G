package is.hi.hopur12.repository;

import is.hi.hopur12.model.Nutrition;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


/*
 * @author Atli Haraldsson
 * HBV501G - Háskóli Íslands
 * Repository fyrir User klasa.
 * Talar við Service klasa.
 */
public interface NutritionRepository extends JpaRepository<Nutrition,Long> {
	
	/*
	 * Vistar gögn í gagnagrunn
	 * Tekur Nutrition object og vistar í gagnagrunns töflu.
	 */
	Nutrition save(Nutrition nutrition);
	
	/*
	 * @id á Nutrition objecti í DB
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
	 */
	@Override
	Nutrition findOne(Long id);
	
	/*
	 * notar id user objects, sem er linkaður @ManyToOne við Nutrition object
	 * til að finna Nutrition object tengd sér
	 */
	List<Nutrition> findByUserId(long user_id);

}
