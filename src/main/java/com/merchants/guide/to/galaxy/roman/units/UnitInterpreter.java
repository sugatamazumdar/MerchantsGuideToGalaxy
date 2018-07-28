package com.merchants.guide.to.galaxy.roman.units;

public abstract class UnitInterpreter {
	protected String unitId;
	protected String midUnitId;
	protected String nextUnitId;
	protected int unit;

	public int calculateUnitsValue(String roman) {
		String[] charArrayAsStrings = roman.split("");
		int arabicSumForUnit = 0;
		for (int i = 0; i < roman.length(); i++) {

			if (charArrayAsStrings[i].equals(unitId)) {
				arabicSumForUnit += unit;
			} else if (midUnitId!=null && charArrayAsStrings[i].equals(midUnitId)) {
				arabicSumForUnit = (5 * unit - arabicSumForUnit);
			} else if (nextUnitId!=null && charArrayAsStrings[i].equals(nextUnitId)) {
				return (10 * unit - arabicSumForUnit);
			}
		}
		return arabicSumForUnit;
	}

	public String extractUnitValue(String roman) {
		String[] charArrayAsStrings = roman.split("");
		StringBuffer extractedRoman = new StringBuffer();

		for (int i = 0; i < roman.length(); i++) {
			if (charArrayAsStrings[i].equals(unitId)) {
				extractedRoman.append(charArrayAsStrings[i]);
			} else if (midUnitId != null && charArrayAsStrings[i].equals(midUnitId)) {
				extractedRoman.append(charArrayAsStrings[i]);
			} else if (nextUnitId != null && charArrayAsStrings[i].equals(nextUnitId)) {
				extractedRoman.append(charArrayAsStrings[i]);
				break;
			} else {
				break;
			}
		}
		return extractedRoman.toString();
	}
	
	private int processRoman(String roman, StringBuffer extractedRoman) {
		String[] charArrayAsStrings = roman.split("");
		int arabicSumForUnit = 0;
		
		for (int i = 0; i < roman.length(); i++) {
			if (charArrayAsStrings[i].equals(unitId)) {
				extractedRoman.append(charArrayAsStrings[i]);
				arabicSumForUnit += unit;
			} else if (midUnitId != null && charArrayAsStrings[i].equals(midUnitId)) {
				extractedRoman.append(charArrayAsStrings[i]);
				arabicSumForUnit = (5 * unit - arabicSumForUnit);
			} else if (nextUnitId != null && charArrayAsStrings[i].equals(nextUnitId)) {
				extractedRoman.append(charArrayAsStrings[i]);
				break;
			} else {
				break;
			}
		}
		
		return arabicSumForUnit;
	}
}
