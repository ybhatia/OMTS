package com.cg.omts.show.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omts.show.exception.CustomException;
import com.cg.omts.show.dao.ShowDao;
import com.cg.omts.show.entity.ShowEntity;

@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	ShowDao showDao;
	
	final static Logger logger = LoggerFactory.getLogger(ShowServiceImpl.class);

	@Override
	public ShowEntity addShow(ShowEntity show) throws CustomException{
		return showDao.save(show);
	}

	@Override
	public boolean deleteShow(Integer showId) throws CustomException{
		Optional<ShowEntity> optional = showDao.findById(showId);
		if (optional.isPresent()) {
			showDao.deleteById(showId);
			return true;
		} else {
			logger.error("SHOW NOT FOUND");
			throw new CustomException("Sorry, Show Not Found");
		}
	}

	@Override
	public ShowEntity getShowById(Integer showId) throws CustomException{
		Optional<ShowEntity> optional = showDao.findById(showId);
		if (optional.isPresent()) {
			ShowEntity show = optional.get();
			return show;
		} else {
			logger.error("SHOW NOT FOUND");
			throw new CustomException("Sorry, Show Not Found");
		}
	}

	@Override
	public List<ShowEntity> getShowByStartTime(LocalTime startTime) {
		return showDao.searchShowByStartTime(startTime);
	}

	@Override
	public List<ShowEntity> getShowByEndTime(LocalTime endTime) {
		return showDao.searchShowByEndTime(endTime);
	}

	@Override
	public List<ShowEntity> getShowByMovieId(Integer movieId) throws CustomException {
		List<ShowEntity> showList = showDao.searchShowByMovieId(movieId);
		if (showList.isEmpty()) {
			logger.error("SHOW NOT FOUND");
			throw new CustomException("Sorry!!! No Show under this MovieId");
		}
		return showList;
	}

	@Override
	public ShowEntity updateShow(ShowEntity show) throws CustomException{
		if (show == null) {
			throw new CustomException("Show can't be null");
		}
		return showDao.save(show);
	}

	@Override
	public List<ShowEntity> getAllShow() {
		return showDao.findAll();
	}

}
