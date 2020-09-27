//package com.cg.omts.dao;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Date;
//import java.util.Optional;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import com.cg.omts.entity.MovieEntity;
//
//public class MovieDaoTest {
//	
//	@Autowired
//	private TestEntityManager entityManager;
//	
//	@Autowired
//	private MovieDao movieDao;
//	
//	@Test
//	public void testMovieTicket(){
//		MovieEntity movie = getMovie();
//		MovieEntity savedInDb = entityManager.persist(movie);
//		Optional<MovieEntity> getFromDb = movieDao.findById(savedInDb.getMovieId());
//		
//		assertThat(getFromDb).isEqualTo(savedInDb);
//	}
//	
//	@Test
//	public void testGetTicketById(){
//		MovieEntity movie = new MovieEntity();
//		movie.setMovieName("Dhoom");
//		movie.setMovieGenre("Action");;
//		movie.setMovieLanguage("Hindi");
//		movie.setMovieReleaseDate(new Date());
//		//Save ticket in DB
//		MovieEntity movieSavedInDb = entityManager.persist(movie);
//		
//		//Get Ticket from DB
//		Optional<MovieEntity> movieFromInDb = movieDao.findById(movieSavedInDb.getMovieId());
//		assertThat(movieSavedInDb).isEqualTo(movieFromInDb);
//	}
//	
//	
//	private MovieEntity getMovie() {
//		MovieEntity movie = new MovieEntity();
//		movie.setMovieName("Dangal");
//		movie.setMovieGenre("Action");;
//		movie.setMovieLanguage("Hindi");
//		movie.setMovieReleaseDate(new Date());
//		return movie;
//	}
//	
//
//}
