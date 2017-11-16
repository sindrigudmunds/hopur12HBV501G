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


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/*
 * @author Atli Haraldsson
 * Control klasi fyrir Food. Hefur í samskiptum við Repository og "/greeting/*.jps" skrár.
 * ásamt server klösum
 */
@SessionAttributes("foodInfo")
@Controller
@RequestMapping("/greeting") 
public class FoodController {
	
	@Autowired
	UserService userServ;
	
	@Autowired
	FoodService foodServ;
	
	@ModelAttribute("foodInfo")
	 public Food setUpFood() {
		return new Food();
	 }
    
	/*
	 * Upphafssíða
	 * Bæta foodItem við DB
	 */
	@RequestMapping(value="/addFood", method=RequestMethod.GET)
	public String addFood(ModelMap model) {
		Food newFood = new Food();
		model.addAttribute("foodInfo", newFood);
		return "greeting/addFood";
	}
	
	/*
	 * @ModelAttribute er food-object sem á að vista í DB
	 * Sendir þig aftur á byrjendasíðu notendaviðmóts
	 */
	@RequestMapping(value="/declareFood", method=RequestMethod.POST)
		public String justInfo(@ModelAttribute("foodInfo") Food food, ModelMap model) {
		Food newFood = food;
		model.remove("foodInfo");
		foodServ.save(newFood);
	    return "greeting/userInfo";
	}
}

