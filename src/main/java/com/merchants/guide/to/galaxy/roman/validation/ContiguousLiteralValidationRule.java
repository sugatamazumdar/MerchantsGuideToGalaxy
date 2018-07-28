package com.merchants.guide.to.galaxy.roman.validation;

import java.util.ArrayList;
import java.util.List;

public class ContiguousLiteralValidationRule implements ValidationRule {
	List<String> applicableChars = null;
	int allowedContinuousRepeats = 0;

	public ContiguousLiteralValidationRule() {
		super();
		applicableChars = new ArrayList<String>();
		applicableChars.add("C");
		applicableChars.add("M");
		applicableChars.add("X");
		applicableChars.add("I");
		this.allowedContinuousRepeats = 3;
	}

	public ContiguousLiteralValidationRule(List<String> applicableChars, int allowedContinuousRepeats) {
		super();
		this.applicableChars = applicableChars;
		this.allowedContinuousRepeats = allowedContinuousRepeats;
	}

	@Override
	public boolean validate(String roman) {
		for (String applicableChar : applicableChars) {
			int index = roman.lastIndexOf(applicableChar);
			if (index == -1) {
				continue;
			}
			String[] charArr = roman.split("");
			int count = 0;
			for (int i = index; i >= 0; i--) {
				if (charArr[i].equals(applicableChar)) {
					count++;
				} else {
					break;
				}
			}

			if (count > allowedContinuousRepeats) {
				return false;
			}
		}
		return true;
	}

}
