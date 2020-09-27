package com.cg.omts.show.validation;

import java.util.regex.Pattern;

public class Validation {
	public boolean isValidShowTime(String showTime) {
		String timePattern = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
		if (Pattern.matches(timePattern, showTime))
			return true;
		else
			return false;
	}

}
