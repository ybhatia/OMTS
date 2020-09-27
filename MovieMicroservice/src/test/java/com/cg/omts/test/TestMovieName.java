package com.cg.omts.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.cg.omts.validation.Validation;

public class TestMovieName {

	Validation validation = new Validation();

	@Test
	public void testNameBlank() {
		boolean isNameValid = validation.isValidMovieName("");
		assertFalse(isNameValid);
	}

	@Test
	public void testNameWithCharacters() {
		boolean isNameValid = validation.isValidMovieName("Dangal");
		assertTrue(isNameValid);
	}

	@Test
	public void testNameWithCharAndNum() {
		boolean isNameValid = validation.isValidMovieName("3Idiots");
		assertTrue(isNameValid);
	}

	@Test
	public void testNameWithNum() {
		boolean isNameValid = validation.isValidMovieName("2020");
		assertTrue(isNameValid);
	}

	@Test
	public void testNameWithSpecialChar() {
		boolean isNameValid = validation.isValidMovieName("Dhoom-2");
		assertTrue(isNameValid);
	}

	@Test
	public void testNameUnderLimit() {
		boolean isNameValid = validation.isValidMovieName("Q");
		assertFalse(isNameValid);
	}

	@Test
	public void testNameOverLimit() {
		boolean isNameValid = validation.isValidMovieName("Weird Al Yankovic The Ultimate video collection	");
		assertFalse(isNameValid);
	}

	@Test
	public void testNameWithinLimit() {
		boolean isNameValid = validation.isValidMovieName("Dhoom");
		assertTrue(isNameValid);
	}

}
