package com.merchants.guide.to.galaxy.roman.units.thousand;

import org.junit.Test;

public class TestThousandUnitInterpreter {
	ThousandUnitInterpreter thousandUnitInterpreter = new ThousandUnitInterpreter();

	@Test
	public void testThousands1() {
		String testRoman = "MCMXCIX";
		String extractedRoman = thousandUnitInterpreter.extractUnitValue(testRoman);
		int arabic = thousandUnitInterpreter.calculateUnitsValue(extractedRoman);
		System.out.println(extractedRoman);
		System.out.println(arabic);
	}
}
