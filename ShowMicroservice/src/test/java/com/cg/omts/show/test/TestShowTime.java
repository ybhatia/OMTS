package com.cg.omts.show.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.cg.omts.show.validation.Validation;

public class TestShowTime {
	Validation validation = new Validation();

	@Test
	public void testTimeBlank() {
		boolean isTimeValid = validation.isValidShowTime("");
		assertFalse(isTimeValid);
	}

	@Test
	public void testTimeValid() {
		boolean isTimeValid = validation.isValidShowTime("10:30");
		assertTrue(isTimeValid);
	}

	@Test
	public void testTimeInvalidWithHour() {
		boolean isTimeValid = validation.isValidShowTime("10");
		assertFalse(isTimeValid);
	}

	@Test
	public void testTimeInvalidWithMinute() {
		boolean isTimeValid = validation.isValidShowTime("30");
		assertFalse(isTimeValid);
	}

}
