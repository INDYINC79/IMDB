package lm.com.IMDB;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IMDBRestController {
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private UserRepository userRepository;

	
	@RequestMapping(path = "/addActor/{movieId}/{actorId}", method = RequestMethod.PUT)
	public void addActor(@PathVariable(name = "movieId", required = true) Integer movieId,
			@PathVariable(name = "actorId", required = true) Integer actorId) {
		Movie m = movieRepository.findOne(movieId);
		Person actor = personRepository.findOne(actorId);
		m.getPeople().add(actor);
		movieRepository.save(m);
	}

	// ===================******************** Movie methods// ****************==============================
	@RequestMapping(path = "/addMovie", method = RequestMethod.POST)
	public List<Movie> newMovie(@RequestBody List<Movie> movie) {
		List<Movie> addedMovies = new ArrayList<Movie>();

		for (int i = 0; i < movie.size(); i++) {
			movieRepository.save(movie.get(i));
			addedMovies.add(movie.get(i));
		}
		return addedMovies;
	}
	
	@RequestMapping(path = "/findMovieInfo/{movieId}", method = RequestMethod.GET)
	public Movie findMovieInfo(@PathVariable(name = "movieId", required = true) Integer movieId){
		if (movieId == null) {
			movieId = 0;
		}
		Movie m = movieRepository.findOne(movieId);
		System.out.println(m.toString());
		return m;
	}
		
	@RequestMapping(path = "/movieLookup", method = RequestMethod.GET)
	public List<Movie> movieLookup(Integer movieId, String title, String genre, String year, String desc) {
		if (movieId == null) {
			movieId = 0;
		}
		
		List<Movie> movies = movieRepository.findAllByTitleLike(movieId, title, genre, year);
		System.out.println(movies.toString());
		return movies;
	}

	@RequestMapping(path = "/updateMovie", method = RequestMethod.PUT)
	public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {

		if (movie.getMovieId() == 0) {
			String errorMessage = "movieId required.";
			return new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}

		Movie existingUpdate = movieRepository.findOne(movie.getMovieId());
		existingUpdate.merge(movie);

		movieRepository.save(existingUpdate);

		return new ResponseEntity<Movie>(existingUpdate, HttpStatus.OK);
	}

	@RequestMapping(path = "/deleteMovie", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMovie(@RequestBody Movie movie) {
		if (movie.getMovieId() == 0) {
			String errorMessage = "movieId required.";
			return new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}

		movieRepository.delete(movie.getMovieId());

		return new ResponseEntity<Movie>(HttpStatus.OK);
	}

	// =================******************** Person methods// ****************=======================
	@RequestMapping(path = "/addPerson", method = RequestMethod.POST)
	public List<Person> newPerson(@RequestBody List<Person> person) {

		List<Person> people = new ArrayList<Person>();

		for (Person p : person) {
			personRepository.save(person);
			people.add(p);
		}

		return people;
	}
	
	@RequestMapping(path = "/findPersonInfo/{personId}", method = RequestMethod.GET)
	public Person findPersonInfo(@PathVariable(name = "personId", required = true) Integer personId){
		
		Person p = personRepository.findOne(personId);
		

		return p;
	}
	
	
	@RequestMapping(path = "/personLookup", method = RequestMethod.GET)
	public List<Person> personInfo(Integer personId, String name, String gender, String type) {
		if (personId == null) {
			personId = 0;
		}

		List<Person> people = personRepository.findAllByNameLike(name, gender, type);
		for (Person p : people) {
			System.out.println("num movies " + p.getMovies());
		}
		for(int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i).getName());
			System.out.println(people.get(i).getMovies());
		}
		return people;
	}

	@RequestMapping(path = "/updatePerson", method = RequestMethod.POST)
	public ResponseEntity<?> updatePerson(@RequestBody Person person) {

		if (person == null) {
			return new ResponseEntity<>(person, HttpStatus.BAD_REQUEST);
		}
		if (person.getPersonId() == 0) {
			return new ResponseEntity<>(person, HttpStatus.BAD_REQUEST);
		}

		Person existingUpdate = personRepository.findOne(person.getPersonId());
		existingUpdate.merge(person);
		personRepository.save(existingUpdate);

		return new ResponseEntity<Person>(existingUpdate, HttpStatus.OK);
	}

	@RequestMapping(path = "/deletePerson", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePerson(@RequestBody Person person) {
		if (person == null) {
			return new ResponseEntity<>(person, HttpStatus.BAD_REQUEST);
		}

		if (person.getPersonId() == 0) {
			return new ResponseEntity<>(person, HttpStatus.BAD_REQUEST);
		}

		personRepository.delete(person.getPersonId());

		return new ResponseEntity<Person>(HttpStatus.OK);
	}
	
	// =================******************** User methods// ****************=======================
	@RequestMapping(path = "/addUser", method = RequestMethod.POST)
	public List<User> newUser(@RequestBody List<User> user) {

		List<User> users = new ArrayList<User>();
		
		for (User u : user) {
			System.out.println(u.getName());
			userRepository.save(user);
			users.add(u);
		}

		return user;
	}
	
	@RequestMapping(path = "/findUserInfo/{userId}", method = RequestMethod.GET)
	public User findUserInfo(@PathVariable(name = "userId", required = true) Integer userId){
		
		User u = userRepository.findOne(userId);

		return u;
	}
	
	
	@RequestMapping(path = "/userLookup", method = RequestMethod.GET)
	public List<User> userInfo(Integer userId, String name, String gender, String type) {
		if (userId == null) {
			userId = 0;
		}

		List<User> user = userRepository.findAllByNameLike(name);
		return user;
	}

	@RequestMapping(path = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody User user) {

		if (user == null) {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
		if (user.getUserId() == 0) {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}

		User existingUpdate = userRepository.findOne(user.getUserId());
		existingUpdate.merge(user);
		userRepository.save(existingUpdate);

		return new ResponseEntity<User>(existingUpdate, HttpStatus.OK);
	}

	@RequestMapping(path = "/deleteUser", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@RequestBody User user) {
		if (user == null) {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}

		if (user.getUserId() == 0) {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}

		userRepository.delete(user.getUserId());

		return new ResponseEntity<User>(HttpStatus.OK);
	}
}