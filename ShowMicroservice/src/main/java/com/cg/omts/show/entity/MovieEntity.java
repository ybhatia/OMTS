package com.cg.omts.show.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	
@Table(name = "movie")
public class MovieEntity {		
		@Id
		private Integer movieId;
		private String movieName;
		private String movieGenre;
		private String movieLanguage;
		private LocalDate movieReleaseDate;
		
		public MovieEntity() {
			super();
		}
		
		public MovieEntity(Integer movieId, String movieName, String movieGenre, String movieLanguage,
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

		public void setMovieId(Integer id) {
			this.movieId = id;
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



