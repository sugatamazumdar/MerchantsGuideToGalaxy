package com.merchants.guide.to.galaxy.roman.validations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.merchants.guide.to.galaxy.roman.validation.UniqueLiteralValidation;

public class TestUniqueLiteralValidation {
	UniqueLiteralValidation uniqueLiteralValidation = new UniqueLiteralValidation();
	
	@Test
	public void testValidate() {
		String testRoman = "MMDXIV";
		assertEquals(true, uniqueLiteralValidation.validate(testRoman));
	}
	
	@Test
	public void testValidateNegative() {
		String testRoman = "MMCVXIV";
		assertEquals(false, uniqueLiteralValidation.validate(testRoman));
	}
}
