package com.center.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.center.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
	
	
	@Query(nativeQuery = true, value = "select * from movie where movie_name = :name OR hero =:name OR heroine =:name")
	public List<Movie> findByMovieName(@Param("name") String name);
	
	@Query(nativeQuery = true, value = "select * from movie where genre = :name OR language =:name")
	public List<Movie> findByMovieGenreOrLanguage(@Param("name") String name);
}
