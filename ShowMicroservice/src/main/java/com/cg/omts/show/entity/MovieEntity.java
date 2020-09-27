package com.cg.omts.show.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	
@Table(name = "movie")
public class MovieEntity {		
		@Id
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
//		@Column(columnDefinition = "serial", name = "movie_id")
		private Integer movieId;
		//@Column(name = "movie_name")
		private String movieName;
		//@Column(name = "movie_genre")
		private String movieGenre;
		//@Column(name = "movie_language")
		private String movieLanguage;
		//@Column(name = "movie_releaseDate")
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



