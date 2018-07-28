package com.merchants.guide.to.galaxy.roman.validations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.merchants.guide.to.galaxy.roman.validation.ContiguousLiteralValidationRule;

public class TestContiguousLiteralValidationRule {
	ContiguousLiteralValidationRule contiguousLiteralValidationRule = new ContiguousLiteralValidationRule();
	
	@Test
	public void testValidate() {
		String testRoman = "MMDXXXVIII";
		assertEquals(true, contiguousLiteralValidationRule.validate(testRoman));
	}
	
	@Test
	public void testValidate1() {
		String testRoman = "MMMDXXXVIII";
		assertEquals(true, contiguousLiteralValidationRule.validate(testRoman));
	}
	
	@Test
	public void testValidateNegative() {
		String testRoman = "MMMMDXXXVIII";
		assertEquals(false, contiguousLiteralValidationRule.validate(testRoman));
	}
}
