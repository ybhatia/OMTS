package com.cg.omts.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.omts.entity.MovieEntity;
import com.cg.omts.exception.CustomException;

public interface MovieService {

	MovieEntity addMovie(MovieEntity movie) throws CustomException;

	boolean deleteMovie(Integer movieId) throws CustomException;

	MovieEntity getMovieById(Integer i) throws CustomException;

	MovieEntity getMovieByName(String name);

	List<MovieEntity> getMovieByLanguage(String language);

	List<MovieEntity> getMovieByGenre(String genre);

	List<MovieEntity> getMovieByReleaseDate(LocalDate movieReleaseDate);

	MovieEntity updateMovie(MovieEntity movie) ;

	List<MovieEntity> getAllMovie();

}
