package is.hi.hopur12.services;

import org.springframework.stereotype.Component;
import is.hi.hopur12.model.Nutrition;
import is.hi.hopur12.model.Food;
import is.hi.hopur12.repository.FoodRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * Service klasi fyrir Food og samband við nutrition klasa
 * Atli Haraldsson
 * HBV501G
 */
@Component
public class FoodServiceImp implements FoodService {

	Nutrition nutrition;
	public Nutrition currNutrition;
	int MILL = 100;
	int knt;
	int convToGrams;
	
	@Autowired
    FoodRepository foodRep;
    
	@Override
	public Nutrition getCurrNutrition() {
		return currNutrition;
	}
	
	@Override
	public void setCurrNutrition(Nutrition nutrition) {
		this.nutrition = nutrition;
	}

	@Override
	public Food save(Food food) {
		return foodRep.save(food);
	}
	
	@Override
    public List<Food> allFood() {
        return foodRep.findAll(); 
    }
	
	@Override
	public Food findOne(long id) {
		return foodRep.findOne(id);
	}
	
	@Override
	public void calcProtein(Food food, Nutrition nut,int grams) {
		knt = nut.getPpro();
		convToGrams = food.getProtein()*grams;
		nut.setPpro((convToGrams/MILL)+knt);
		nut.setProcentProtein((MILL*nut.getPpro())/nut.getProtein());
	}
	
	@Override
	public void calcFat(Food food, Nutrition nut, int grams) {
		knt = nut.getPfat();
		convToGrams = food.getFat()*grams;
		nut.setPfat((convToGrams/MILL)+nut.getPfat());
		nut.setProcentFat((MILL*nut.getPfat())/nut.getFat());
	}
	
	@Override
	public void calcCarb(Food food, Nutrition nut, int grams) {
		knt = nut.getPcar();
		convToGrams = food.getCarb()*grams;
		nut.setPcar((convToGrams/MILL)+knt);
		nut.setProcentCarbs((MILL*nut.getPcar())/nut.getCarbs());
		
	}
	
	@Override
	public Nutrition calcEaten(long id, Nutrition nut, int grams) {
		calcFat(findOne(id),nut, grams);
		calcCarb(findOne(id),nut, grams);
		calcProtein(findOne(id),nut, grams);
		return nut;
	}


}
