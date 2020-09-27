package com.cg.omts.validation;

import java.util.regex.Pattern;

public class Validation {
	public boolean isValidMovieName(String movieName) {
		String namePattern = "^[A-Za-z0-9_-]{2,40}$";
		if (Pattern.matches(namePattern, movieName))
			return true;
		else
			return false;
	}

	public boolean isValidMovieGenre(String movieGenre) {
		String genrepattern = "^[A-Za-z]{5,10}$";
		if (Pattern.matches(genrepattern, movieGenre))
			return true;
		else
			return false;
	}

	public boolean isValidReleaseDate(String date) {
		String datePattern = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$";
		if (Pattern.matches(datePattern, date))
			return true;
		else
			return false;
	}

	public boolean isValidMovieLanguage(String movieLanguage) {
		String languagePattern = "^[A-Za-z]{5,10}$";
		if (Pattern.matches(languagePattern, movieLanguage))
			return true;
		else
			return false;
	}

}
