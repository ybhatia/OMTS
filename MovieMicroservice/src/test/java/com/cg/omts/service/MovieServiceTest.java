package com.cg.omts.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.omts.dao.MovieDao;
import com.cg.omts.entity.MovieEntity;

@SpringBootTest
public class MovieServiceTest {
	
//	 @InjectMocks
	@Autowired
	 private MovieService movieService;
//	
//	@Mock
//	private MovieDao movieDao;
//	
//	 @Before
//	 public void init() {
//	        MockitoAnnotations.initMocks(this);
//	    }

	@SuppressWarnings("deprecation")
	@Test
	public void testAddMovieByBlankMovieId(){
//		Optional<MovieEntity> optional = movieDao.findById(101);
//		if(optional.isPresent()) {
//		MovieEntity movie = optional.get();
//		movie.setMovieId(101);
//		movie.setMovieName("Dangal");
//		movie.setMovieGenre("Action");
//		movie.setMovieLanguage("Hindi");
//		movie.setMovieReleaseDate(new Date(2020,12,20));
//	    Mockito.when(movieDao.findById(101)).thenReturn(optional);
//	    assertThat(movieService.getMovieById(101)).isEqualTo(movie);
//		MovieEntity movie = new MovieEntity(0,"Dangal","Action","Hindi",SimpleDateFormat("dd-mm-yyyy").format(new Date(2020,12,20)));
//		assertEquals("Movie Id cannot be zero", movieService.addMovie(movie));
	}
}
