package is.hi.hopur12.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

/*
 * @author Atli Haraldsson
 * Model klasi fyrir User object
 */
@Entity
@Table (name="aboutUser")
public class User {
	

	private String name;
	private String password;
    private Long user_id;
	
	@Embedded
	private UserDetails userDetails;
	
	public User(String name, int age) {
		setName(name);
		setPassword(password);
	}
	
	@Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return user_id;
    }

    public void setId(Long user_id) {
        this.user_id = user_id;
    }
    
	public User() {
		
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public UserDetails getUserDetails() {
		return this.userDetails;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


}
