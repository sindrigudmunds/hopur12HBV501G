package is.hi.hopur12.services;

import org.springframework.stereotype.Component;
import is.hi.hopur12.model.User;
import is.hi.hopur12.model.UserDetails;

import is.hi.hopur12.model.Nutrition;
import is.hi.hopur12.repository.NutritionRepository;
import is.hi.hopur12.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


/*
 * @author Atli Haraldsson
 * HBV501G - Háskóli Íslands
 * Service klasi sem implementar UserService interface.
 */
@Component
public class UserServiceImp implements UserService {
	
	public User currUser = null;
	Nutrition nutrition;
	
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
    @Autowired
    NutritionRepository nutRep;
    
	@Autowired
    UserRepository userRep;
	
	/*
	 * Fyrir password hash
	 */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
	
	@Override
	public User getCurrUser() {
		return currUser;
	}
	
	@Override
	public void setCurrUser(User u) {
		currUser = u;
	}
     
	@Override
    public User save(User u) {
		String tempPassword = passwordEncoder.encode(u.getPassword());
		u.setPassword(tempPassword);
        return userRep.save(u);
    }
	
	@Override
	public User update(User u) {
		return userRep.save(u);
	}

	public List<User> findByName(String name) {
		return userRep.findByName(name);
	}
	
	public Boolean findUserName(String name) {
		List<User> listi = findByName(name);
		if (listi.isEmpty())
			return true;
		else
			return false;
	}

	public Boolean authUser(String name, String password) {
		List<User> listi = findByName(name);
		for(User u : listi) {
			if(passwordEncoder.matches(password, u.getPassword())) {	
				setCurrUser(u);
				return true;
			}
		}
		return false;
	}
	
	public Boolean isUser() {
		if(currUser != null) {
			return true; }
		else
			return false;
	}
	
	@Override
	public Nutrition calcAll() {
		int bmr = currUser.getUserDetails().getBmr();
		Nutrition nut = new Nutrition(currUser, calcProtein(bmr),calcCarbs(bmr), calcFat(bmr),0,0,0,0,0,0);
		return nut;
		
	}
	
	public Nutrition saveNutrition(Nutrition nutrition) {
		return nutRep.save(nutrition);
	}
	
	@Override
    public List<Nutrition> findByUserId(long user_id) {
        return nutRep.findByUserId(user_id);
    }

	@Override
	public void calcBMR(UserDetails u) {
		int bmrx = 0;
		if(u.getGender().contentEquals("M")) {
			bmrx = (int)(66.5 + (13.75*u.getWeight()) + (5.003*u.getHeight()) - (6.755*u.getAge()));
		}
		if (u.getGender().contentEquals("F")) {
			bmrx = (int)(655.1 + (9.563*u.getWeight()) + (1.85*u.getHeight()) - (4.676*u.getAge()));
		}
		if(u.getGoal().contentEquals("1")) {
			bmrx = bmrx-500;
		} else if (u.getGoal().contentEquals("3")) {
			bmrx = bmrx+500;
		}
		checkWorkout(u,bmrx);
	}

	public void checkWorkout(UserDetails u, int bmr) {
		if(u.getWorkout().contentEquals("1"))
			u.setBmr((int)(bmr*1.2));
		else if(u.getWorkout().contentEquals("2"))
			u.setBmr((int)(bmr*1.375));
		else if(u.getWorkout().contentEquals("3"))
			u.setBmr((int)(bmr*1.55));
		else if(u.getWorkout().contentEquals("4"))
			u.setBmr((int)(bmr*1.725));
		else if(u.getWorkout().contentEquals("5"))
			u.setBmr((int)(bmr*1.9));
	}
	
	@Override
	public int calcProtein(int bmr) {
		return (int)((0.3*bmr)/4);
	}
	
	@Override
	public int calcFat(int bmr) {
		return (int)((0.2*bmr)/9);

	}

	@Override
	public int calcCarbs(int bmr) {
		return (int)((0.5*bmr)/4);
	}
	
	
	

}
