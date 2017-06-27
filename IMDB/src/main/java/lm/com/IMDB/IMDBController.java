package lm.com.IMDB;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IMDBController {

	@RequestMapping(path = "/movie", method = RequestMethod.GET)
	public String movie(Model model, String title, String genre, int year, String desc) {
		System.out.println("here");
		Movie m = new Movie(title, genre, year, desc);
		model.addAttribute("movie", m);
		return "movie";
	}
}
