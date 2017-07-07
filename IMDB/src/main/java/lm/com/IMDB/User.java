package lm.com.IMDB;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	private String name;
	
	public User() {
		
	}
	
	public User(int userId, String name) {
		this.userId = userId;
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
	public void merge(User u) {
		if (u.getName() != null) {
			this.setName(u.getName());
		}
	}
}
