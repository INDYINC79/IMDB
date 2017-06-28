package lm.com.IMDB;

import java.io.Serializable;

public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
	private String genre;
	private int year;
	private String desc;
	
	public Movie(String title, String genre, int year, String desc) {
		super();
		this.title = title;
		this.genre = genre;
		this.year = year;
		this.desc = desc;
	}
	
	public Movie() {
		
	}
	
	@Override
	public String toString() {
		return "Movie [title=" + title + ", genre=" + genre + ", year=" + year + ", description=" + desc + "]";
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
