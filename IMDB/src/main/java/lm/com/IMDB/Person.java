package lm.com.IMDB;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Person")

public class Person implements Serializable{
	@Id
	@GeneratedValue
	private int personId;
	private String name;
	private String gender;
	private String type;
	
	@ManyToMany(mappedBy = "person", cascade=CascadeType.ALL)
	private Set<Movie> movies = new HashSet<>();

	
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
	
	public Person(int personId, String name, String gender, String type) {
		this.personId = personId;
		this.name = name;
		this.gender = gender;
		this.type = type;
	}

	public Set<Movie> getMovies() {
		return movies;
	}


	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
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