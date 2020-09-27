package com.cg.omts.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omts.dao.MovieDao;
import com.cg.omts.entity.MovieEntity;
import com.cg.omts.exception.CustomException;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDao movieDao;
	// final static Logger logger = Logger.getLogger(MovieServiceImpl.class);

	@Override
	public MovieEntity addMovie(MovieEntity movie) throws CustomException {
		String movieName = movie.getMovieName();
		if (movieName.equals(null)) {
			throw new CustomException("Movie Name cannot be null");
		}
		List<MovieEntity> movieDetails = (List<MovieEntity>) movieDao.findAll();
		for (int i = 0; i < movieDetails.size(); i++) {
			if (movieDetails.get(i).getMovieName().equals(movieName)) {
				throw new CustomException("Movie with this Movie Id already exist");
			}
		}
		return movieDao.save(movie);
	}

	@Override
	public boolean deleteMovie(Integer movieId) throws CustomException {
		Optional<MovieEntity> optional = movieDao.findById(movieId);
		if (optional.isPresent()) {
			movieDao.deleteById(movieId);
			return true;
		} else {
			throw new CustomException("Sorry, Movie Not Found");
		}
	}

	@Override
	public MovieEntity getMovieById(Integer movieId) throws CustomException {
		Optional<MovieEntity> optional = movieDao.findById(movieId);
		if (optional.isPresent()) {
			MovieEntity movie = optional.get();
			return movie;
		} else {
			throw new CustomException("Sorry, Movie Not Found");
		}
	}

	@Override
	public MovieEntity getMovieByName(String name){
		return movieDao.searchMovieByName(name);
	}

	@Override
	public List<MovieEntity> getMovieByLanguage(String language){
		return movieDao.searchMovieByLanguage(language);
	}

	@Override
	public List<MovieEntity> getMovieByGenre(String genre){
		return movieDao.searchMovieByGenre(genre);
	}

	@Override
	public List<MovieEntity> getMovieByReleaseDate(LocalDate releaseDate){
		return movieDao.searchMovieByReleaseDate(releaseDate);
	}

	@Override
	public MovieEntity updateMovie(MovieEntity movie) throws CustomException {
		if (movie == null) {
			throw new CustomException("Movie can't be null");
		}
		return movieDao.save(movie);
	}

	@Override
	public List<MovieEntity> getAllMovie(){
		return movieDao.findAll();
	}

}