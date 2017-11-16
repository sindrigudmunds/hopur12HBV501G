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
import is.hi.hopur12.model.User;
import is.hi.hopur12.model.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/*
 * @author Atli Haraldsson
 * Greetingcontroller helur um breytingar á UserDetails objecti sem er Embedded
 * object í User klasa. Þ.e. breytir persónu upplýsingum og vistar nýjar á virkan notanda
 */
@Controller
@SessionAttributes("user")
@RequestMapping("/greeting")
public class GreetingController {
	
	@Autowired
	UserService userServ;
	
	@Autowired
	FoodService foodServ;
	
	@ModelAttribute("user")
	 public User setUpUserForm() {
		return new User();
	 }
	
    /*
     * @ModelAttribute er sessionattribute.
     * Object af taginu User.
     * Prentar út upplýsingar um User og UserDetails.
     */
    @RequestMapping(value="/changeInfo", method=RequestMethod.GET)
    public String changeInfo(@ModelAttribute("user") User u, Model model) {
    	u = userServ.getCurrUser();
    	model.addAttribute("user", u);
    	return "/greeting/changeInfo";
    }
    
    /*
     * GET
     * Upphafssíða þess að breyta persónu upplýsingum um notanda.
     */
    @RequestMapping(value="/userPage", method=RequestMethod.GET)
    public String userPage() {
    	return "/greeting/userInfo";
    }
    
    /*
     * @ModelAtrribute("userD") tekur userDetail object og reiknar nýtt BMR út frá nýjum upplýsingum
     * Vistar breytingar á virkan notanda
     */
    @RequestMapping(value="/userUpdate", method=RequestMethod.POST)
    public String userPage(@ModelAttribute("userD") UserDetails u) {
    	userServ.calcBMR(u);
    	userServ.getCurrUser().setUserDetails(u);
    	userServ.update(userServ.getCurrUser());
    	return "/greeting/userInfo";
    }
}