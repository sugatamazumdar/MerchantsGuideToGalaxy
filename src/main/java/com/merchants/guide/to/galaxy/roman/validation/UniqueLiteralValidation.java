package com.merchants.guide.to.galaxy.roman.validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueLiteralValidation implements ValidationRule {
	Map<String,Integer> applicableCharsMap = null;

	public UniqueLiteralValidation() {
		super();
		applicableCharsMap = new HashMap<String,Integer>();
		applicableCharsMap.put("L",0);
		applicableCharsMap.put("D",0);
		applicableCharsMap.put("V",0);
	}

	public UniqueLiteralValidation(Map<String,Integer> applicableCharsMap) {
		super();
		this.applicableCharsMap = applicableCharsMap;
	}

	@Override
	public boolean validate(String roman) {
		String[] allCharsAsStr = roman.split("");
		for(String charsAsStr : allCharsAsStr) {
			if(applicableCharsMap.containsKey(charsAsStr)) {
				if(applicableCharsMap.get(charsAsStr).equals(0)) {
					applicableCharsMap.put(charsAsStr, 1);
				} else {
					return false;
				}
			}
		}
		return true;
	}

}
