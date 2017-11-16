package is.hi.hopur12.repository;

import is.hi.hopur12.model.Food;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/*
 * @author Atli Haraldsson
 * HBV501G - Háskóli Íslands
 * Repository fyrir User klasa.
 * Talar við Service klasa.
 */
public interface FoodRepository extends JpaRepository<Food,Long> {
	
	/*
	 * Vistar gögn í gagnagrunn
	 * Tekur User object og vistar í gagnagrunns töflu.
	 */
	Food save(Food food);
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	List<Food> findAll();
	
	/*
	 * @name nafn á notanda
	 * Finnur lista af nöfnum með nafnið name
	 */
	List<Food> findByName(String name);
	
	/*
	 * Finnur allan mat með snúnum lista
	 */
	List<Food> findAllByOrderByIdDesc();
	
	/*
	 * @id á Food objecti
	 * Skilar food objecti með það nafn
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
	 */
	@Override
	Food findOne(Long id);
	
}
