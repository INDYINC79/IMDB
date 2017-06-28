package lm.com.IMDB;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IMDBRestController {

	@RequestMapping(path = "/movieLookup", method = RequestMethod.GET)
	public ArrayList<Movie> movieInfo(String title, String genre, Integer year, String desc) {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		return movies;
	}
	
	@RequestMapping(path = "/personLookup", method = RequestMethod.GET)
	public ArrayList<Person> personInfo(String name, String gender, String dob, String type) {
		
		Person lookupObject = new Person(name, gender, dob, type);
		
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(lookupObject);
		
		return people;
	}
	
	@RequestMapping(path = "/addMovie", method = RequestMethod.POST)
	public Movie newMovie(@RequestBody Movie movie) {
	
		return movie;
	}
	
	@RequestMapping(path = "/addPerson", method = RequestMethod.POST)
	public Person newPerson(@RequestBody Person person) {
	    
		return person;
	}
	
	@RequestMapping(path = "/updatePerson", method = RequestMethod.POST)
	public Person updatePerson(@RequestBody Person person) {
	    
		return person;
	}
	
	@RequestMapping(path = "/updateMovie", method = RequestMethod.POST)
	public Movie updateMovie(@RequestBody Movie movie) {
	    
		return movie;
	}
}