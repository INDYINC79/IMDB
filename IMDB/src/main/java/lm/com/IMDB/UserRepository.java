package lm.com.IMDB;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lm.com.IMDB.Movie;

public interface UserRepository extends JpaRepository<User, Integer> {  
	@Query ("SELECT u FROM User u where (:name is null OR UPPER(name) LIKE UPPER(CONCAT('%',:name,'%')))")
	public List<User> findAllByNameLike(@Param("name") String name);
}
