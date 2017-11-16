package is.hi.hopur12.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * @author Atli Haraldsson
 * Model klasi fyrir Food
 */
@Entity
@Table (name="food")
public class Food {

    private Long id;
    private int fat;
    private int protein;
    private int carb;
    private String name;
	
    public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getCarb() {
		return carb;
	}

	public void setCarb(int carb) {
		this.carb = carb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	
}
