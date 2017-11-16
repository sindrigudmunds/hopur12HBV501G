/**
* Innskráning og heilsa. 
* 
* Hópur 12
* Atli Haraldsson ath174@hi.is
* Sindri Þór Guðmundsson sthg11@hi.is
* Jónas Bergsteinsson job33@hi.is
* HBV501G - Hugbúnaðarverkefni 1
*/

package is.hi.hopur12.controller;

import is.hi.hopur12.services.FoodService;
import is.hi.hopur12.services.UserService;
import is.hi.hopur12.model.Food;
import is.hi.hopur12.model.Nutrition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/*
 * Control klasi fyrir greetings. Hefur í samskiptum við "/greeting/*.jps" skrár.
 */

@Controller
@SessionAttributes("nutritionInfo")
@RequestMapping("/greeting") // Request Mapping er gerð fyrir klasann til að slóðin byrji á /greeting fyrir allar skipanir 
public class NutritionController {
	
	@Autowired
	UserService userServ;
	
	@Autowired
	FoodService foodServ;
	
	@ModelAttribute("nutritionInfo")
	 public Nutrition setUpNutritionForm() {
		return new Nutrition();
	 }
    
    @RequestMapping(value="/foodList", method=RequestMethod.GET)
    public String foodList(Model model, HttpSession sessions) {
    	ArrayList<Food> listi;
    	listi = (ArrayList<Food>) foodServ.allFood();
    	Nutrition newNut = userServ.calcAll();
    	foodServ.setCurrNutrition(newNut);
    	model.addAttribute("nutritionInfo", newNut);
    	model.addAttribute("allFood", listi);
    	return "/greeting/justInfo";
    }  
    
    @RequestMapping(value="/moreInfo", method=RequestMethod.POST)
    public String moreInfo(@RequestParam("foodVar") long foodID,
    					   @RequestParam("gramVar") int grams,
    					   @ModelAttribute("nutritionInfo") Nutrition nut,
    					   Model model) {
    	ArrayList<Food> listi;
    	listi = (ArrayList<Food>) foodServ.allFood();
    	model.addAttribute("allFood", listi);
    	
    	nut = foodServ.calcEaten(foodID,nut, grams);
    	foodServ.setCurrNutrition(nut);
    	model.addAttribute("nutritinInfo", nut);
    	return "greeting/justInfo";
    }
    
    @RequestMapping(value="/submitDiet", method=RequestMethod.POST)
    public String submitDiet(@ModelAttribute("nutritionInfo") Nutrition nut) {
    	userServ.saveNutrition(nut);
    	return "/greeting/userInfo";
    	
    }
    
    @RequestMapping(value="/daysBefore", method=RequestMethod.GET)
    public String daysBefore(@ModelAttribute("nutritionInfo")  Nutrition nut, Model model) {
    	ArrayList<Nutrition> listi;
    	listi = (ArrayList<Nutrition>) userServ.findByUserId(userServ.getCurrUser().getId());
    	model.addAttribute("myDays", listi);
    	
    	return "/greeting/days";
    }
    

}

