package com.cg.omts.show.entity;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ShowTable")
public class ShowEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial", name = "show_id")
	private Integer showId;
	@Column(name = "show_start_time")
	private LocalTime showStartTime;
	@Column(name = "show_end_time")
	private LocalTime showEndTime;
//	@ManyToOne
//	@JoinTable(name = "show_movie_id",  referencedColumnName="movie_id")
//	@JsonManagedReference
	@Column(name = "show_movie_id")
	private Integer movieId;
	@Column(name = "no_of_seats")
	private Integer noOfSeats;
	
	public ShowEntity() {
		super();
	}

	public ShowEntity(Integer showId, LocalTime showStartTime, LocalTime showEndTime, Integer movieId,
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
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("hh:mm");
		return "ShowEntity [showId=" + showId + ", showStartTime=" + showStartTime.format(format1)+ ", showEndTime=" + showEndTime.format(format1)
				+ ", movieId=" + movieId + ", noOfSeats=" + noOfSeats + "]";
	}
	
	
	
	
}


