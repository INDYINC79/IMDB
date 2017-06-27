package lm.com.IMDB;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IMDBJsonController {
	@RequestMapping(path = "/movieJson", method = RequestMethod.GET)
	public Movie jsonHome(String title, String genre, Integer year, String desc) {

		return new Movie(title, genre, year, desc);
	}
}
