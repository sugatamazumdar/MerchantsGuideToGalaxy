package com.merchants.guide.to.galaxy.roman.units.unit;

import org.junit.Test;

public class TestUnitsUnitInterpreter {
	UnitsUnitInterpreter unitsUnitInterpreter = new UnitsUnitInterpreter();

	@Test
	public void testUnits1() {
		String testRoman = "VIII";
		String extractedRoman = unitsUnitInterpreter.extractUnitValue(testRoman);
		int arabic = unitsUnitInterpreter.calculateUnitsValue(extractedRoman);
		System.out.println(extractedRoman);
		System.out.println(arabic);
	}
	
	@Test
	public void testUnits2() {
		String testRoman = "IX";
		String extractedRoman = unitsUnitInterpreter.extractUnitValue(testRoman);
		int arabic = unitsUnitInterpreter.calculateUnitsValue(extractedRoman);
		System.out.println(extractedRoman);
		System.out.println(arabic);
	}
	
	@Test
	public void testUnits3() {
		String testRoman = "III";
		String extractedRoman = unitsUnitInterpreter.extractUnitValue(testRoman);
		int arabic = unitsUnitInterpreter.calculateUnitsValue(extractedRoman);
		System.out.println(extractedRoman);
		System.out.println(arabic);
	}
	
	@Test
	public void testUnits4() {
		String testRoman = "IV";
		String extractedRoman = unitsUnitInterpreter.extractUnitValue(testRoman);
		int arabic = unitsUnitInterpreter.calculateUnitsValue(extractedRoman);
		System.out.println(extractedRoman);
		System.out.println(arabic);
	}
}
