package com.merchants.guide.to.galaxy.roman.units.ten;

import org.junit.Test;

public class TestTenUnitInterpreter {
	TenUnitInterpreter tenUnitInterpreter = new TenUnitInterpreter();

	@Test
	public void testTens1() {
		String testRoman = "XCIII";
		String extractedRoman = tenUnitInterpreter.extractUnitValue(testRoman);
		int arabic = tenUnitInterpreter.calculateUnitsValue(extractedRoman);
		System.out.println(extractedRoman);
		System.out.println(arabic);
	}
	
	@Test
	public void testTens2() {
		String testRoman = "XLVI";
		String extractedRoman = tenUnitInterpreter.extractUnitValue(testRoman);
		int arabic = tenUnitInterpreter.calculateUnitsValue(extractedRoman);
		System.out.println(extractedRoman);
		System.out.println(arabic);
	}
	
	@Test
	public void testTens3() {
		String testRoman = "LXXIX";
		String extractedRoman = tenUnitInterpreter.extractUnitValue(testRoman);
		int arabic = tenUnitInterpreter.calculateUnitsValue(extractedRoman);
		System.out.println(extractedRoman);
		System.out.println(arabic);
	}
	
	@Test
	public void testTens4() {
		String testRoman = "XXXVI";
		String extractedRoman = tenUnitInterpreter.extractUnitValue(testRoman);
		int arabic = tenUnitInterpreter.calculateUnitsValue(extractedRoman);
		System.out.println(extractedRoman);
		System.out.println(arabic);
	}
	
	@Test
	public void testTens5() {
		String testRoman = "XIII";
		String extractedRoman = tenUnitInterpreter.extractUnitValue(testRoman);
		int arabic = tenUnitInterpreter.calculateUnitsValue(extractedRoman);
		;
	}
}
