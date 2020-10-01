package com.cg.omts.show.dao;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.omts.show.entity.ShowEntity;


public interface ShowDao extends JpaRepository<ShowEntity, Integer> {
	
	@Query(value = "Select * from show_table where show_movie_id = ?1", nativeQuery = true)
	List<ShowEntity> searchShowByMovieId(Integer MovieId);
	
	@Query(value = "Select * from show_table where startTime = ?1", nativeQuery = true)
	List<ShowEntity>searchShowByStartTime(LocalTime startTime);
	
	@Query(value = "Select * from show_table where endTime = ?1", nativeQuery = true)
	List<ShowEntity> searchShowByEndTime(LocalTime endTime);


}
