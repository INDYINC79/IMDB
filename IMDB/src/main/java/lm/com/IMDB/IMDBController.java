package lm.com.IMDB;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IMDBController {

	@RequestMapping(path = "/movie", method = RequestMethod.GET)
	public String movie(Model model, int movieId, String title, String genre, String year, String desc) {
		Movie m = new Movie(movieId, title, genre, year, desc);
		model.addAttribute("movie", m);
		return "movie";
	}
	
	@RequestMapping(path = "/person", method = RequestMethod.GET)
	public String person(Model model, int personId, String name, String gender, String dob, String type) {
		Person p = new Person(personId, name, gender, dob, type);
		model.addAttribute("person", p);
		return "person";
	}
}
