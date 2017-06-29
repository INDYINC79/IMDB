package lm.com.IMDB;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IMDBRestController {
	@Autowired
	private MovieRepository movieRepository;
	
	@RequestMapping(path = "/movieLookup", method = RequestMethod.GET)
	public List<Movie> movieInfo(Integer movieId, String title, String genre, String year, String desc) {
		if(movieId == null){
			movieId = 0;
		}
		
		List<Movie> movies = movieRepository.findAllByTitleLike(title, genre, year);
		
		return movies;
	}
	
	@RequestMapping(path = "/addMovie", method = RequestMethod.POST)
	public Movie newMovie(@RequestBody Movie movie) {
		movieRepository.save(movie);
		return movie;
	}
	
	@RequestMapping(path = "/updateMovie", method = RequestMethod.POST)
	public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {
		
		if (movie == null) {
			System.out.println("here1");
			return new ResponseEntity<>(movie, HttpStatus.BAD_REQUEST);
		}
		
		if (movie.getMovieId() == 0) {
			System.out.println("here");
			return new ResponseEntity<>(movie, HttpStatus.BAD_REQUEST);
		}
				
		Movie existingUpdate = movieRepository.findOne(movie.getMovieId());
		existingUpdate.merge(movie);
		
		movieRepository.save(existingUpdate);

		return new ResponseEntity<Movie>(existingUpdate, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/deleteMovie", method = RequestMethod.POST)
	public ResponseEntity<?> deleteMovie(@RequestBody Movie movie) {
		
		if (movie == null) {
			System.out.println("here1");
			return new ResponseEntity<>(movie, HttpStatus.BAD_REQUEST);
		}
		
		if (movie.getMovieId() == 0) {
			System.out.println("here");
			return new ResponseEntity<>(movie, HttpStatus.BAD_REQUEST);
		}

		movieRepository.delete(movie.getMovieId());
		
		return new ResponseEntity<Movie>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/personLookup", method = RequestMethod.GET)
	public ArrayList<Person> personInfo(String name, String gender, String dob, String type) {
		
		Person inputData = new Person(name, gender, dob, type);
		
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(inputData);
		
		return people;
	}
	
	
	
	@RequestMapping(path = "/addPerson", method = RequestMethod.POST)
	public Person newPerson(@RequestBody Person person) {
	    
		return person;
	}
	
	@RequestMapping(path = "/updatePerson", method = RequestMethod.POST)
	public Person updatePerson(@RequestBody Person person) {
	    
		return person;
	}
}