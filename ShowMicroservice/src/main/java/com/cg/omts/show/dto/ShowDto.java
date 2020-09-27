package com.cg.omts.show.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class ShowDto {
	
	private Integer showId;
	private LocalTime showStartTime;
	private LocalTime showEndTime;
	private Integer movieId;
	private Integer noOfSeats;
	
	public ShowDto() {
		super();
	}
	public ShowDto(Integer showId, LocalTime showStartTime, LocalTime showEndTime, Integer movieId,
			Integer noOfSeats) {
		super();
		this.showId = showId;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.movieId = movieId;
		this.noOfSeats = noOfSeats;
	}
	public Integer getShowId() {
		return showId;
	}
	public void setShowId(Integer showId) {
		this.showId = showId;
	}
	public LocalTime getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(LocalTime showStartTime) {
		this.showStartTime = showStartTime;
	}
	public LocalTime getShowEndTime() {
		return showEndTime;
	}
	public void setShowEndTime(LocalTime showEndTime) {
		this.showEndTime = showEndTime;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	@Override
	public String toString() {
		return "ShowDto [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
				+ ", showMovieId=" + movieId + ", noOfSeats=" + noOfSeats + "]";
	}
	
	

}
