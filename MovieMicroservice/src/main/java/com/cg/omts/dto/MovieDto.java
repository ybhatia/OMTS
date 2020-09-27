package com.cg.omts.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MovieDto {

	private Integer movieId;
	private String movieName;
	private String movieGenre;
	private String movieLanguage;
	private LocalDate movieReleaseDate;
	
	public MovieDto() {
		super();
	}

	public MovieDto(Integer movieId, String movieName, String movieGenre, String movieLanguage,
			LocalDate movieReleaseDate) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieLanguage = movieLanguage;
		this.movieReleaseDate = movieReleaseDate;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public LocalDate getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(LocalDate movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	@Override
	public String toString() {
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "MovieEntity [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre
				+ ", movieLanguage=" + movieLanguage + ", movieReleaseDate=" + movieReleaseDate.format(format1) + "]";
		}
	
	
	
	
}
