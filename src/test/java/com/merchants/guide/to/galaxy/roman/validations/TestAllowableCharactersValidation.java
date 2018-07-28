package com.merchants.guide.to.galaxy.roman.validations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.merchants.guide.to.galaxy.roman.validation.AllowableCharactersValidation;

public class TestAllowableCharactersValidation {
	AllowableCharactersValidation allowableCharactersValidation = new AllowableCharactersValidation();
	
	@Test
	public void testValidate() {
		String testRoman = "MMCXIV";
		assertEquals(true, allowableCharactersValidation.validate(testRoman));
	}
	
	@Test
	public void testValidateNegative() {
		String testRoman = "MMCUXIV";
		assertEquals(false, allowableCharactersValidation.validate(testRoman));
	}
}
