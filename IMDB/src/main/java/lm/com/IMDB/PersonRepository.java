package lm.com.IMDB;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lm.com.IMDB.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	@Query ("SELECT p FROM Person p where (:name is null OR UPPER(name) LIKE UPPER(CONCAT('%',:name,'%')))"
			+ "AND (:gender is null OR UPPER(gender) LIKE UPPER(CONCAT('%',:gender,'%')))"
			+ "AND (:type is null OR UPPER(type) LIKE UPPER(CONCAT('%',:type,'%')))")
	public List<Person> findAllByNameLike(@Param("name") String name, @Param("gender") String gender, @Param("type") String type);
}
