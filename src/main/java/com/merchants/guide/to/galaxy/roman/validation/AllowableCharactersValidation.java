package com.merchants.guide.to.galaxy.roman.validation;

import java.util.ArrayList;
import java.util.List;

public class AllowableCharactersValidation implements ValidationRule {
	List<String> applicableChars = null;

	public AllowableCharactersValidation() {
		super();
		applicableChars = new ArrayList<String>();
		applicableChars.add("C");
		applicableChars.add("M");
		applicableChars.add("X");
		applicableChars.add("I");
		applicableChars.add("L");
		applicableChars.add("D");
		applicableChars.add("V");
	}

	public AllowableCharactersValidation(List<String> applicableChars) {
		super();
		this.applicableChars = applicableChars;
	}

	@Override
	public boolean validate(String roman) {
		String[] allCharsAsStr = roman.split("");
		for(String charsAsStr : allCharsAsStr) {
			if(!applicableChars.contains(charsAsStr)) {
				return false;
			}
		}
		return true;
	}

}
