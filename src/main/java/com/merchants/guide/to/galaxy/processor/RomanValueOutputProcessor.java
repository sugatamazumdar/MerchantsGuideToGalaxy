package com.merchants.guide.to.galaxy.processor;

public class RomanValueOutputProcessor implements OutputProcessor {
	private String beginString = "how much is ";
	private String token = " ";

	@Override
	public String processOutput(String input) {
		String output = null;
		if (input.startsWith(beginString)) {
			String expression = input.substring(beginString.length(), input.length() - 1).trim();
			System.out.println(expression);

			String[] parts = expression.split(token);
			String romanNumber = evaluateRomanNumber(parts);

			if (romanNumber == null) {
				return output;
			}

			System.out.println(romanNumber);
			Integer romanValue;
			try {
				romanValue = evaluateRomanNumberToArabic(romanNumber);
			} catch (Exception e) {
				return output;
			}

			System.out.println(romanValue);

			output = String.format("%s is %d", expression, romanValue);
		}
		return output;
	}

}
