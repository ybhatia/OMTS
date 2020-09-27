package com.cg.omts.show.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.cg.omts.show.service.ShowService;

@RestController
@RequestMapping("/show")
public class ShowController {

	@Autowired
	private ShowService showService;
	// final static Logger logger = Logger.getLogger(MovieController.class);

	@Autowired
	RestTemplate restTemplate;

//	@GetMapping("/moviebyid/{movieId}")
//	public ResponseEntity<MovieEntity> getMovieById(@PathVariable Integer movieId) {
//		String url = "http://MOVIE-INFO-SERVICE/movie/moviebyid/" + movieId;
//		MovieEntity movie = restTemplate.getForObject(url, MovieEntity.class);
//		ResponseEntity<MovieEntity> response = new ResponseEntity<>(movie, HttpStatus.OK);
//		return response;
//	}

	@PostMapping("/addshow")
	public ResponseEntity<ShowEntity> addNewShow(@RequestBody ShowEntity showDto) {
		ShowEntity show = new ShowEntity();
		show.setShowStartTime(showDto.getShowStartTime());
		show.setShowEndTime(showDto.getShowEndTime());
		show.setMovieId(showDto.getMovieId());
		show.setNoOfSeats(showDto.getNoOfSeats());
		showService.addShow(show);
		ResponseEntity<ShowEntity> response = new ResponseEntity<>(showDto, HttpStatus.OK);
		// logger.info("A NEW BUS ADDED WITH THE BUS ID = " + movieDto.getBusId());
		return response;
	}

	@GetMapping("/allshows")
	public ResponseEntity<List<ShowEntity>> getAllShow() {
		List<ShowEntity> show = showService.getAllShow();
		ResponseEntity<List<ShowEntity>> response = new ResponseEntity<>(show, HttpStatus.OK);
		return response;
	}

	@GetMapping("/showbyid/{showId}")
	public ResponseEntity<ShowEntity> getShowById(@PathVariable Integer showId) {
		ShowEntity show = showService.getShowById(showId);
		ResponseEntity<ShowEntity> response = new ResponseEntity<>(show, HttpStatus.OK);
		return response;
	}

	@GetMapping("/showbymovieid/{movieId}")
	public ResponseEntity<List<ShowEntity>> getShowByMovieId(@PathVariable Integer movieId) {
		List<ShowEntity> show = showService.getShowByMovieId(movieId);
		ResponseEntity<List<ShowEntity>> response = new ResponseEntity<>(show, HttpStatus.OK);
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<ShowEntity> updateShow(@RequestBody ShowEntity showDto) {
		ShowEntity show = showService.updateShow(showDto);
		ResponseEntity<ShowEntity> response = new ResponseEntity<>(show, HttpStatus.OK);
		// logger.info("BUS WITH THE BUS ID = " + entity.getBusId() + " UPDATED.");
		return response;

	}

	@DeleteMapping("/delete/{showId}")
	public boolean deleteShow(@PathVariable Integer showId) {
		boolean flag = showService.deleteShow(showId);
		// logger.info("BUS REMOVED WITH THE BUS ID = " + busId);
		return flag;
	}
//	

}
