package lm.com.IMDB;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Integer> {  
	
	@Query ("SELECT m FROM Movie m where (:title is null OR UPPER(title) LIKE UPPER(CONCAT('%',:title,'%')))"
			+ "AND (:genre is null OR UPPER(genre) LIKE UPPER(CONCAT('%',:genre,'%')))"
			+ "AND (:year is null OR year = :year)")
	public List<Movie> findAllByTitleLike(@Param("title") String title, @Param("genre") String genre, @Param("year") String year);
}
