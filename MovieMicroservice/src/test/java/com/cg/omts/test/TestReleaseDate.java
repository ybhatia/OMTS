package com.cg.omts.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.cg.omts.validation.Validation;

public class TestReleaseDate {
	Validation validation = new Validation();

	@Test
	public void testDateBlank() {
		boolean isDateValid = validation.isValidReleaseDate("");
		assertFalse(isDateValid);
	}

	@Test
	public void testValidFormat() {
		boolean isDateValid = validation.isValidReleaseDate("20-11-2020");
		assertTrue(isDateValid);
	}

	@Test
	public void testInvalidFormatWithDayAndMonth() {
		boolean isDateValid = validation.isValidReleaseDate("20-11");
		assertFalse(isDateValid);
	}

	@Test
	public void testInvalidFormatWithMonthAndYear() {
		boolean isDateValid = validation.isValidReleaseDate("11-2020");
		assertFalse(isDateValid);
	}

	@Test
	public void testInvalidFormatWithDayAndYear() {
		boolean isDateValid = validation.isValidReleaseDate("20-2020");
		assertFalse(isDateValid);
	}

}
