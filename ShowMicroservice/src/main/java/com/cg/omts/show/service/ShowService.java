package com.cg.omts.show.service;

import java.time.LocalTime;
import java.util.List;

import com.cg.omts.show.entity.ShowEntity;
import com.cg.omts.show.exception.CustomException;

public interface ShowService {
	
	ShowEntity addShow	(ShowEntity show) throws CustomException;
	
	boolean deleteShow(Integer showId) throws CustomException ;
	
	ShowEntity getShowById(Integer showId) throws CustomException ;
	
	List<ShowEntity> getShowByStartTime(LocalTime startTime);
	
	List<ShowEntity> getShowByEndTime(LocalTime endTime);
	
	List<ShowEntity> getShowByMovieId(Integer movieId);

	ShowEntity updateShow(ShowEntity show) throws CustomException ;

	List<ShowEntity> getAllShow();


}
