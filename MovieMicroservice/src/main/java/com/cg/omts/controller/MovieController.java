package com.cg.omts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.omts.dto.MovieDto;
import com.cg.omts.entity.MovieEntity;
import com.cg.omts.exception.CustomException;
import com.cg.omts.service.MovieService;

/* @RestController tells Spring that this is the Handler class and contains handler methods. Basically does combined job of @Controller and @ResponseBody
 * @RequestMapping annotation is used to map the web requests to specified
 * handler classes or methods
 * */

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
	final static Logger logger = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/addmovie")
	public ResponseEntity<MovieDto> addNewMovie(@RequestBody MovieDto movie) {
		MovieEntity movieEntity = convertToMovieEntity(movie);
		movieEntity.setMovieName(movie.getMovieName());
		movieEntity.setMovieGenre(movie.getMovieGenre());
		movieEntity.setMovieLanguage(movie.getMovieLanguage());
		movieEntity.setMovieReleaseDate(movie.getMovieReleaseDate());
		movieService.addMovie(movieEntity);
		MovieDto movieDto = convertToMovieDto(movieEntity);
		logger.info("A NEW MOVIE ADDED SUCCESSFULY");
		return new ResponseEntity<>(movieDto, HttpStatus.OK);

	}

	@GetMapping("/allmovies")
	public ResponseEntity<List<MovieEntity>> getAllMovies() {
		List<MovieEntity> movie = movieService.getAllMovie();
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@GetMapping("/moviebyid/{movieId}")
	public ResponseEntity<MovieEntity> getMovieById(@PathVariable Integer movieId) {
		MovieEntity bus = movieService.getMovieById(movieId);
		return new ResponseEntity<>(bus, HttpStatus.OK);
	}

	@GetMapping("/moviebyname/{movieName}")
	public ResponseEntity<MovieEntity> getMovieByName(@PathVariable String movieName) {
		MovieEntity movie = movieService.getMovieByName(movieName);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@GetMapping("/moviebygenre/{movieGenre}")
	public ResponseEntity<List<MovieEntity>> getMovieByGenre(@PathVariable String movieGenre) {
		List<MovieEntity> movie = movieService.getMovieByGenre(movieGenre);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@GetMapping("/moviebylanguage/{movieLanguage}")
	public ResponseEntity<List<MovieEntity>> getMovieByLanguage(@PathVariable String movieLanguage) {
		List<MovieEntity> movie = movieService.getMovieByLanguage(movieLanguage);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<MovieDto> updateMovie(@RequestBody MovieDto movie) {
		MovieEntity movieEntity = convertToMovieEntity(movie);
		movieEntity = movieService.updateMovie(movieEntity);
		MovieDto movieDto = convertToMovieDto(movieEntity);
		logger.info("MOVIE IS UPDATED SUCCESSFULLY");
		return new ResponseEntity<>(movieDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{movieId}")
	public boolean deleteMovie(@PathVariable Integer movieId) {
		boolean flag = movieService.deleteMovie(movieId);
		logger.info("MOVIE IS REMOVED SUCCESSFULLY");
		return flag;
	}

	/*
	 * Handle Movie not found Exception
	 * 
	 * @param ex
	 */
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> handleBookingNotFound(CustomException ex) {
		logger.error("MOVIE NOT FOUND!!!", ex);
		String msg = ex.getMessage();
		return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
	}

	/*
	 * Blanket Exception Handler
	 * 
	 * @param ex
	 */
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleAll(Throwable ex) {
		logger.error("Something went wrong", ex);
		String msg = ex.getMessage();
		return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public MovieEntity convertToMovieEntity(MovieDto movieDto) {
		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setMovieId(movieDto.getMovieId());
		movieEntity.setMovieName(movieDto.getMovieName());
		movieEntity.setMovieGenre(movieDto.getMovieGenre());
		movieEntity.setMovieLanguage(movieDto.getMovieLanguage());
		movieEntity.setMovieReleaseDate(movieDto.getMovieReleaseDate());
		return movieEntity;
	}

	public MovieDto convertToMovieDto(MovieEntity movieEntity) {
		MovieDto movieDto = new MovieDto();
		movieDto.setMovieId(movieEntity.getMovieId());
		movieDto.setMovieName(movieEntity.getMovieName());
		movieDto.setMovieGenre(movieEntity.getMovieGenre());
		movieDto.setMovieLanguage(movieEntity.getMovieLanguage());
		movieDto.setMovieReleaseDate(movieEntity.getMovieReleaseDate());
		return movieDto;
	}
}
