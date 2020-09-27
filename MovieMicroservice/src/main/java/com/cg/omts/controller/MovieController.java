package com.cg.omts.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.omts.entity.MovieEntity;
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
	// final static Logger logger = Logger.getLogger(MovieController.class);

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/addmovie")
	public ResponseEntity<MovieEntity> addNewMovie(@RequestBody MovieEntity movieDto) {
		MovieEntity movie = new MovieEntity();
		movie.setMovieName(movieDto.getMovieName());
		movie.setMovieGenre(movieDto.getMovieGenre());
		movie.setMovieLanguage(movieDto.getMovieLanguage());
		movie.setMovieReleaseDate(movieDto.getMovieReleaseDate());
		movieService.addMovie(movie);
		ResponseEntity<MovieEntity> response = new ResponseEntity<>(movieDto, HttpStatus.OK);
		// logger.info("A NEW BUS ADDED WITH THE BUS ID = " + movieDto.getBusId());
		return response;
	}

	@GetMapping("/allmovies")
	public ResponseEntity<List<MovieEntity>> getAllMovies() {
		List<MovieEntity> movie = movieService.getAllMovie();
		ResponseEntity<List<MovieEntity>> response = new ResponseEntity<>(movie, HttpStatus.OK);
		return response;
	}

	@GetMapping("/moviebyid/{movieId}")
	public ResponseEntity<MovieEntity> getMovieById(@PathVariable Integer movieId) {
		MovieEntity bus = movieService.getMovieById(movieId);
		ResponseEntity<MovieEntity> response = new ResponseEntity<>(bus, HttpStatus.OK);
		return response;
	}

	@GetMapping("/moviebyname/{movieName}")
	public ResponseEntity<MovieEntity> getMovieByName(@PathVariable String movieName) {
		MovieEntity movie = movieService.getMovieByName(movieName);
		ResponseEntity<MovieEntity> response = new ResponseEntity<>(movie, HttpStatus.OK);
		return response;
	}

	@GetMapping("/moviebygenre/{movieGenre}")
	public ResponseEntity<List<MovieEntity>> getMovieByGenre(@PathVariable String movieGenre) {
		List<MovieEntity> movie = movieService.getMovieByGenre(movieGenre);
		ResponseEntity<List<MovieEntity>> response = new ResponseEntity<>(movie, HttpStatus.OK);
		return response;
	}

	@GetMapping("/moviebylanguage/{movieLanguage}")
	public ResponseEntity<List<MovieEntity>> getMovieByLanguage(@PathVariable String movieLanguage) {
		List<MovieEntity> movie = movieService.getMovieByLanguage(movieLanguage);
		ResponseEntity<List<MovieEntity>> response = new ResponseEntity<>(movie, HttpStatus.OK);
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<MovieEntity> updateMovie(@RequestBody MovieEntity movie) {
		MovieEntity bus = movieService.updateMovie(movie);
		ResponseEntity<MovieEntity> response = new ResponseEntity<>(bus, HttpStatus.OK);
		// logger.info("BUS WITH THE BUS ID = " + entity.getBusId() + " UPDATED.");
		return response;

	}

	@DeleteMapping("/delete/{movieId}")
	public boolean deleteMovie(@PathVariable Integer movieId) {
		boolean flag = movieService.deleteMovie(movieId);
		// logger.info("BUS REMOVED WITH THE BUS ID = " + busId);
		return flag;
	}

}
