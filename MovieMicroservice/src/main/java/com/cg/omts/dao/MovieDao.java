package com.cg.omts.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.omts.entity.MovieEntity;

/*
 * DAO design pattern is a way to reduce coupling between Business logic and
 * Persistence logic. 
 */

public interface MovieDao extends JpaRepository<MovieEntity, Integer> {

	@Query(value = "Select * from movie where movie_genre = ?", nativeQuery = true)
	List<MovieEntity> searchMovieByGenre(String genre);

	@Query(value = "Select * from movie where movie_name = ?", nativeQuery = true)
	MovieEntity searchMovieByName(String name);

	@Query(value = "Select * from movie where movie_language = ?", nativeQuery = true)
	List<MovieEntity> searchMovieByLanguage(String language);

	@Query(value = "Select * from movie where releaseDate = ?", nativeQuery = true)
	List<MovieEntity> searchMovieByReleaseDate(LocalDate releaseDate);

}
