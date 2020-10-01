package com.cg.omts.show.controller;

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

import com.cg.omts.show.dto.ShowDto;
import com.cg.omts.show.entity.MovieEntity;
import com.cg.omts.show.entity.ShowEntity;
import com.cg.omts.show.exception.CustomException;
import com.cg.omts.show.service.ShowService;

/* @RestController tells Spring that this is the Handler class and contains handler methods. Basically does combined job of @Controller and @ResponseBody
 * @RequestMapping annotation is used to map the web requests to specified
 * handler classes or methods
 * */

@RestController
@RequestMapping("/show")
public class ShowController {

	@Autowired
	private ShowService showService;
	final static Logger logger = LoggerFactory.getLogger(ShowController.class);

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/moviebyid/{movieId}")
	public ResponseEntity<MovieEntity> getMovieById(@PathVariable Integer movieId) {
		String url = "http://localhost:1111/movie/moviebyid/" + movieId;
		MovieEntity movie = restTemplate.getForObject(url, MovieEntity.class);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@PostMapping("/addshow")
	public ResponseEntity<ShowDto> addNewShow(@RequestBody ShowDto showDto) {
		ShowEntity show = new ShowEntity();
		show.setShowStartTime(showDto.getShowStartTime());
		show.setShowEndTime(showDto.getShowEndTime());
		show.setMovieId(showDto.getMovieId());
		show.setNoOfSeats(showDto.getNoOfSeats());
		showService.addShow(show);
		logger.info("A NEW SHOW ADDED SUCCESSFULLY");
		return new ResponseEntity<>(showDto, HttpStatus.OK);
	}

	@GetMapping("/bookseats/{showId}/{numberOfSeats}")
	public ResponseEntity<ShowEntity> bookSeats(@PathVariable Integer showId, @PathVariable Integer numberOfSeats) {
		ShowEntity show = showService.getShowById(showId);
		Integer availableNumberOfSeats = show.getNoOfSeats() - numberOfSeats;
		show.setNoOfSeats(availableNumberOfSeats);
		ShowEntity updatedShow = showService.updateShow(show);
		ResponseEntity<ShowEntity> response = new ResponseEntity<>(updatedShow, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/cancelseats/{showId}/{numberOfSeats}")
	public ResponseEntity<ShowEntity> cancelSeats(@PathVariable Integer showId, @PathVariable Integer numberOfSeats) {
		ShowEntity show = showService.getShowById(showId);
		Integer availableNumberOfSeats = show.getNoOfSeats() + numberOfSeats;
		show.setNoOfSeats(availableNumberOfSeats);
		ShowEntity updatedShow = showService.updateShow(show);
		ResponseEntity<ShowEntity> response = new ResponseEntity<>(updatedShow, HttpStatus.OK);
		return response;
	}

	@GetMapping("/allshows")
	public ResponseEntity<List<ShowEntity>> getAllShow() {
		List<ShowEntity> show = showService.getAllShow();
		return new ResponseEntity<>(show, HttpStatus.OK);

	}

	@GetMapping("/showbyid/{showId}")
	public ResponseEntity<ShowEntity> getShowById(@PathVariable Integer showId) {
		ShowEntity show = showService.getShowById(showId);
		return new ResponseEntity<>(show, HttpStatus.OK);
	}

	@GetMapping("/showbymovieid/{movieId}")
	public ResponseEntity<List<ShowEntity>> getShowByMovieId(@PathVariable Integer movieId) {
		List<ShowEntity> show = showService.getShowByMovieId(movieId);
		return new ResponseEntity<>(show, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ShowEntity> updateShow(@RequestBody ShowEntity showDto) {
		ShowEntity show = showService.updateShow(showDto);
		logger.info("SHOW UPDATED SUCCESSFULLY");
		return new ResponseEntity<>(show, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{showId}")
	public boolean deleteShow(@PathVariable Integer showId) {
		boolean flag = showService.deleteShow(showId);
		logger.info("SHOW REMOVED SUCCESSFULLY");
		return flag;
	}

	/*
	 * Handle Movie not found Exception
	 * 
	 * @param ex
	 */
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> handleBookingNotFound(CustomException ex) {
		logger.error("SHOW NOT FOUND!!!", ex);
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

	public ShowEntity convertToMovieEntity(ShowDto showDto) {
		ShowEntity showEntity = new ShowEntity();
		showEntity.setShowId(showDto.getShowId());
		showEntity.setShowStartTime(showDto.getShowStartTime());
		showEntity.setShowEndTime(showDto.getShowEndTime());
		showEntity.setMovieId(showDto.getMovieId());
		showEntity.setNoOfSeats(showDto.getNoOfSeats());
		return showEntity;
	}

	public ShowDto convertToMovieDto(ShowEntity showEntity) {
		ShowDto showDto = new ShowDto();
		showDto.setShowId(showDto.getShowId());
		showDto.setShowStartTime(showDto.getShowStartTime());
		showDto.setShowEndTime(showDto.getShowEndTime());
		showDto.setMovieId(showDto.getMovieId());
		showDto.setNoOfSeats(showDto.getNoOfSeats());
		return showDto;
	}

}
