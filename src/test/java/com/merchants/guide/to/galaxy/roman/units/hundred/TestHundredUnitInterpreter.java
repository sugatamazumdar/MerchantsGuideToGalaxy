package com.merchants.guide.to.galaxy.roman.units.hundred;

import org.junit.Test;

public class TestHundredUnitInterpreter {

	HundredUnitInterpreter hundredUnitInterpreter = new HundredUnitInterpreter();

	@Test
	public void testHundreds1() {
		String testRoman = "DCCLVI";
		String extractedRoman = hundredUnitInterpreter.extractUnitValue(testRoman);
		int arabic = hundredUnitInterpreter.calculateUnitsValue(extractedRoman);
		System.out.println(extractedRoman);
		System.out.println(arabic);
	}
	
	@Test
	public void testHundreds2() {
		String testRoman = "CMXXXII";
		String extractedRoman = hundredUnitInterpreter.extractUnitValue(testRoman);
		int arabic = hundredUnitInterpreter.calculateUnitsValue(extractedRoman);
		System.out.println(extractedRoman);
		System.out.println(arabic);
	}
	
	@Test
	public void testHundreds3() {
		String testRoman = "CDLXXIX";
		String extractedRoman = hundredUnitInterpreter.extractUnitValue(testRoman);
		int arabic = hundredUnitInterpreter.calculateUnitsValue(extractedRoman);
		System.out.println(extractedRoman);
		System.out.println(arabic);
	}
	
	@Test
	public void testHundreds4() {
		String testRoman = "CCCXXXI";
		String extractedRoman = hundredUnitInterpreter.extractUnitValue(testRoman);
		int arabic = hundredUnitInterpreter.calculateUnitsValue(extractedRoman);
		System.out.println(extractedRoman);
		System.out.println(arabic);
	}
}
