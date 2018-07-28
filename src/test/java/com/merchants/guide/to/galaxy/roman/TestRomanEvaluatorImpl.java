package com.merchants.guide.to.galaxy.roman;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRomanEvaluatorImpl {
	RomanEvaluator evaluator = new RomanEvaluatorImpl();
	
	@Test
	public void testRomanNumbers() throws Exception {
		assertEquals(1999, evaluator.getArabicFromRoman("MCMXCIX"));
	}
	
	@Test
	public void testRomanNumbers1() throws Exception {
		assertEquals(3578, evaluator.getArabicFromRoman("MMMDLXXVIII"));
	}
	
	@Test
	public void testRomanNumbers2() throws Exception {
		assertEquals(796, evaluator.getArabicFromRoman("DCCXCVI"));
	}
	
	@Test
	public void testRomanNumbers3() throws Exception {
		assertEquals(99, evaluator.getArabicFromRoman("XCIX"));
	}
	
	@Test
	public void testRomanNumbers4() throws Exception {
		assertEquals(3976, evaluator.getArabicFromRoman("MMMCMLXXVI"));
	}
	
	@Test
	public void testRomanNumbers5() throws Exception {
		assertEquals(13, evaluator.getArabicFromRoman("XIII"));
	}
}
