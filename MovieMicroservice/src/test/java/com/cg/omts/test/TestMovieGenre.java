package com.cg.omts.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.cg.omts.validation.Validation;

public class TestMovieGenre {
	Validation validation = new Validation();

	@Test
	public void testGenreBlank() {
		boolean isGenreValid = validation.isValidMovieGenre("");
		assertFalse(isGenreValid);
	}
	
	@Test
	public void testGenreWithCharacters() {
		boolean isGenreValid = validation.isValidMovieGenre("Action");
		assertTrue(isGenreValid);
	}

	@Test
	public void testGenreWithCharAndNum() {
		boolean isGenreValid = validation.isValidMovieGenre("Action1");
		assertFalse(isGenreValid);
	}

	@Test
	public void testGenreWithNum() {
		boolean isGenreValid = validation.isValidMovieGenre("2020");
		assertFalse(isGenreValid);
	}

	@Test
	public void testGenreWithSpecialChar() {
		boolean isGenreValid = validation.isValidMovieGenre("Dr@ma");
		assertFalse(isGenreValid);
	}

	@Test
	public void testGenreUnderLimit() {
		boolean isGenreValid = validation.isValidMovieGenre("abcd");
		assertFalse(isGenreValid);
	}

	@Test
	public void testGenreOverLimit() {
		boolean isGenreValid = validation.isValidMovieGenre("Actiondrama");
		assertFalse(isGenreValid);
	}

	@Test
	public void testGenreWithinLimit() {
		boolean isGenreValid = validation.isValidMovieGenre("Horror");
		assertTrue(isGenreValid);
	}

}
