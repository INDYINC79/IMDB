package lm.com.IMDB;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")

public class Person implements Serializable{
	@Id
	@GeneratedValue
	private int personId;
	String name;
	String gender;
	String type;
	
	public void merge(Person p) {
		if (p.getName() != null) {
			this.setName(p.getName());
		}
		if (p.getGender() != null) {
			this.setGender(p.getGender());
		}
		if (p.getType() != null) {
			this.setType(p.getType());
		}
	}
	
	
	public Person() {
		
	}
	
	public Person(int personId, String name, String gender, String dob, String type) {
		this.personId = personId;
		this.name = name;
		this.gender = gender;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", gender=" + gender + ", type="
				+ type + "]";
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
