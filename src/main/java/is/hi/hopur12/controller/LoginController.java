package is.hi.hopur12.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import is.hi.hopur12.model.User;
import is.hi.hopur12.model.UserDetails;
import is.hi.hopur12.services.FoodService;
import is.hi.hopur12.services.UserService;


/*
 * @author Atli Haraldsson
 * Service klasi fyrir login, logout og register virknir
 */
@SessionAttributes("user")
@Controller
@RequestMapping("/greeting")
public class LoginController {
	

	@Autowired
	UserService userServ;
	
	@Autowired
	FoodService foodServ;
	
	@ModelAttribute("user")
	 public User setUpUserForm() {
		return new User();
	 }
	
	@ModelAttribute("userD")
	 public UserDetails setUpUserDetailsForm() {
		return new UserDetails();
	 }
	
	/*
	 * @Sessions eyðir út virkum SessionAttributes
	 * @model model fyrir controller klasa
	 * Eyðir vikrum sessionum ef einhver eru virk,
	 * þ.e. logout og endurstillir userServ.currUser ef þörf er
	 * annars sýnir login.jsp
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpSession sessions, ModelMap model, SessionStatus status) {
		if(userServ.isUser()) {
			model.remove("userD");
			model.remove("user");
			status.setComplete();
			sessions.removeAttribute("user");
	    	userServ.setCurrUser(null);
	    	return "/greeting/login";
	    } else {
	    	return "/greeting/login";
	    }
	}
	
	/*
	 * @param name er nafn notanda
	 * @param password er lykilorð notanda
	 * Fer í gegnum hvort til sé notandi með þessar upplýsingar,
	 * annars login.jsp
	 */
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public String loginProcess(@RequestParam("name") String name,
						@RequestParam("password") String password, Model model) {
		if (userServ.authUser(name, password)) {
			User u = userServ.getCurrUser();
			model.addAttribute("user", u);
			return "/greeting/userInfo";
		} else
			return "/greeting/login";
	}
	
	
	/*
	 * Upphafssíða register virkni
	 */
	@RequestMapping(value="/reg", method=RequestMethod.GET)
	public String reg() {
		return "/greeting/reg";
	}
	
	
	/*
	 * @Model currUser, geymir upplýsingar sem eru geymdar í User object
	 * að undanskildu UserDetails objecti sem er embeddað innan þess
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User currUser,
							@RequestParam("name") String name, HttpSession session) {
		if (userServ.findUserName(name))
			return "/greeting/register";
		else {
			return "/greeting/reg";
		}
	}
	
	/*
	 * @Model u UserDetail Object
	 * @Model currUser User object
	 * Smellir userdetail í user object og vistar ef nægjanlegar uplýsingar eru tið staðar
	 */
    @RequestMapping(value="/registerProcess", method=RequestMethod.POST)
    public String registerProcess(@ModelAttribute("userD") UserDetails u, 
    							  @ModelAttribute("user") User currUser,
    							  ModelMap model) {
    	userServ.calcBMR(u);
    	User newUser = currUser;
    	newUser.setUserDetails(u);
       	model.addAttribute("user", newUser);
    	userServ.setCurrUser(newUser);
    	userServ.save(userServ.getCurrUser());
    	return "/greeting/userInfo";
    }
}