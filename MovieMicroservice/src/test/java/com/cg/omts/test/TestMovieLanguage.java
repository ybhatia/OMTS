package com.cg.omts.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.cg.omts.validation.Validation;

public class TestMovieLanguage {
	Validation validation = new Validation();

	@Test
	public void testLanguageBlank() {
		boolean isLanguageValid = validation.isValidMovieLanguage("");
		assertFalse(isLanguageValid);
	}
	
	@Test
	public void testLanguageWithCharacters() {
		boolean isLanguageValid = validation.isValidMovieLanguage("Hindi");
		assertTrue(isLanguageValid);
	}

	@Test
	public void testLanguageWithCharAndNum() {
		boolean isLanguageValid = validation.isValidMovieLanguage("Hindi1");
		assertFalse(isLanguageValid);
	}

	@Test
	public void testLanguageWithNum() {
		boolean isLanguageValid = validation.isValidMovieLanguage("2020");
		assertFalse(isLanguageValid);
	}

	@Test
	public void testLanguageWithSpecialChar() {
		boolean isLanguageValid = validation.isValidMovieLanguage("T@mil");
		assertFalse(isLanguageValid);
	}

	@Test
	public void testLanguageUnderLimit() {
		boolean isLanguageValid = validation.isValidMovieLanguage("abcd");
		assertFalse(isLanguageValid);
	}

	@Test
	public void testLanguageOverLimit() {
		boolean isLanguageValid = validation.isValidMovieLanguage("HindiEnglish");
		assertFalse(isLanguageValid);
	}

	@Test
	public void testLanguageWithinLimit() {
		boolean isLanguageValid = validation.isValidMovieLanguage("English");
		assertTrue(isLanguageValid);
	}

}
