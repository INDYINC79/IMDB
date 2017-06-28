package lm.com.IMDB;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = 2L;
	String name;
	String gender;
	String dob;
	String type;
	
	public Person(String name, String gender, String dob, String type) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.type = type;
	}
	
	public Person(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
