package is.hi.hopur12.repository;

import is.hi.hopur12.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
 * @author Atli Haraldsson
 * HBV501G - Háskóli Íslands
 * Repository fyrir User klasa.
 * Talar við Service klasa.
 */
public interface UserRepository extends JpaRepository<User,Long> {
	
	/*
	 * Vistar gögn í gagnagrunn
	 * Tekur User object og vistar í gagnagrunns töflu.
	 */
	User save(User user);
	
	/*
	 * Finnur alla  Users.
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	List<User> findAll();
	
	
	/*
	 * @name nafn notanda
	 * Finnur users eftir nafninu name
	 */
	List<User> findByName(String name);
}
