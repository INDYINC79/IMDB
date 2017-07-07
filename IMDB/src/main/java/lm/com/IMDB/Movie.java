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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Movie")

public class Movie implements Serializable {
	@Id
	@GeneratedValue
	private int movieId;
	private String title;
	private String genre;
	private String year;
	private String desc;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="movies")
	//@JsonBackReference
	private Set<Person> people;

	public Movie(String title, String genre, String year, String desc) {
		super();
		this.title = title;
		this.genre = genre;
		this.year = year;
		this.desc = desc;
	}
	
	public Movie(int movieId, String title, String genre, String year, String desc) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.year = year;
		this.desc = desc;
	}
	
	public Movie() {
		
	}
	
	public Set<Person> getPeople() {
		return people;
	}

	public void setPeople(Set<Person> people) {
		this.people = people;
	}
	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void merge(Movie m) {
		if (m.getTitle() != null) {
			this.setTitle(m.getTitle());
		}
		if (m.getGenre() != null) {
			this.setGenre(m.getGenre());
		}
		if (m.getYear() != null) {
			this.setYear(m.getYear());
		}
		if (m.getDesc() != null) {
			this.setDesc(m.getDesc());
		}
	}
}