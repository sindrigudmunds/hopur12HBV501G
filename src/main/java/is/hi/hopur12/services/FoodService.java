package is.hi.hopur12.services;

import java.util.List;

import is.hi.hopur12.model.*;

/*
 * @author Atli Haraldsson
 * HBV501G - Háskóli Íslands
 * Interface fyrir FoodserviceImp klasan
 * samskipti við Food og nutrition
 */
public interface FoodService {
	
	/*
	 * Vistar gögn í gagnagrunni
	 * @user er model af taginu User.
	 */
	public Food save(Food food);
	
	/*
	 * prentar lista af öllum matvörum með
	 * næringargildum sem til staðar eru í DB
	 */
	public List<Food> allFood();
	
	/*
	 * @id á Food objecti
	 * finnur food object í DB eftir gefnu id
	 */
	public Food findOne(long id);
	
	/*
	 * @id á Food objecti
	 * @nut Nutrition object
	 * @grams integer tala
	 * notar calcProtein, calcFat og calcCarb til að reikna næringargildið
	 * í tilteknum mat og vistar í nutrition objectinu nut
	 */
	public Nutrition calcEaten(long id,Nutrition nut, int grams);
	
	/*
	 * @id á Food objecti
	 * @nut Nutrition object
	 * @grams integer tala
	 * Reiknar prótein magn í Food objecti og vistar í nutrition
	 */
	public void calcProtein(Food food,Nutrition nut, int grams);
	
	/*
	 * @id á Food objecti
	 * @nut Nutrition object
	 * @grams integer tala
	 * Reiknar fitu magn í Food objecti og vistar í nutrition
	 */
	public void calcFat(Food food,Nutrition nut, int grams);
	
	/*
	 * @id á Food objecti
	 * @nut Nutrition object
	 * @grams integer tala
	 * Reiknar kolvetn magn í Food objecti og vistar í nutrition
	 */
	public void calcCarb(Food food,Nutrition nut, int grams);
	
	/*
	 * @nutrition er nutrition object
	 * breytir local currNutrition í nutrition
	 */
	public void setCurrNutrition(Nutrition nutrition);
	
	/*
	 * @returns currNutrition í FoodService klasa
	 */
	public Nutrition getCurrNutrition();
	
	
}
