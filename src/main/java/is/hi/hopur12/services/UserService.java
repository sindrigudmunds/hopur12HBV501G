package is.hi.hopur12.services;

import is.hi.hopur12.model.*;
import java.util.List;

/*
 * @author Atli Haraldsson
 * HBV501G - Háskóli Íslands
 * Interface að survice klasa UserService
 * 
 */
public interface UserService {
	
	/*
	 *@u er user object
	 * breytir currUser undir UserService í u
	 */
	public void setCurrUser(User u);
	
	/*
	 * @return active User object
	 * í UserService klasa
	 */
	public User getCurrUser();
	
	/*
	 * Vistar gögn í gagnagrunni
	 * @user er model af taginu User.
	 */
	public User save(User u);
	
	/*
	 * Reiknar út æskilegt BMR úr uppgefnum gögnum
	 * @u er User model.
	 */
	public void calcBMR(UserDetails u);
	
	/*
	 * Reiknar æskilegt magn af proteini per dag.
	 * @bmr er BMR gildi sem fæst úr calcBMR()
	 */
	public int calcProtein(int bmr);
	
	/*
	 * Reiknar æskilegt magn af proteini per dag
	 * @bmr er BMR gildi sem fæst úr calcBMR()
	 */
	public int calcCarbs(int bmr);
	
	/*
	 * Reiknar æskilegt magn af fitu per dag
	 * @bmr er BMR gildi sem fæst úr calcBMR()
	 */
	public int calcFat(int bmr);
	
	/*
	 * Býr til nýtt Nutrition object sem er embeddad í User object
	 * @bmr er BMR gildi sem fæst úr calcBMR()
	 */
	public Nutrition calcAll();
	
	/*
	 * @nutrition er nutrition object
	 * Vistar nutrition object í NutritionRepository
	 */
	public Nutrition saveNutrition(Nutrition nutrition);
	
	/*
	 * Tekur tillit til hreyfingar aðila og finnur endanlegt BMR
	 * @bmr er BMR gildi sem fæst úr calcBMR()
	 * @u er user object.
	 */
	public void checkWorkout(UserDetails u, int bmr);
	
	
	/*
	 * @user_id id á active user
	 * Finnur öll þau Nutrition object sem eru linkuð við active user
	 */
	public List<Nutrition> findByUserId(long user_id);
	
	/*
	 * @name nafn notanda
	 * @password lykilorð notnda
	 * Finnur hvort til sé í DB User með
	 * Þetta nafn og password
	 */
	public Boolean authUser(String name, String password);
	
	
	/*
	 * @name nafn User
	 * Finnur notanda sem er með tiltekið name
	 */
	public List<User> findByName(String name);
	
	/*
	 * Skilar false ef currUser er tómur
	 * annars false.
	 */
	public Boolean isUser();
	
	/*
	 * @name nafn notanda
	 * Skilar false ef ekkert object finnst með þessu name
	 * annars true
	 */
	public Boolean findUserName(String name);
	
	/*
	 * @u User object
	 * Vistar user object án þess að hasha-lykilorð
	 */
	public User update(User u);
	
	

}
