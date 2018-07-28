package com.merchants.guide.to.galaxy.processor;

import com.merchants.guide.to.galaxy.datastore.CacheType;
import com.merchants.guide.to.galaxy.datastore.DataStoreCacheFactory;

public class CreditCoinConverterOutputProcessor implements OutputProcessor {
	private String beginString = "how many ";
	private String token = " ";

	@Override
	public String processOutput(String input) {
		String output = null;
		if (input.startsWith(beginString)) {
			String expression = input.substring(beginString.length(), input.length() - 1).trim();
			System.out.println(expression);

			String[] parts = expression.split(token);

			String creditCoinValue = parts[parts.length - 1];
			System.out.println(creditCoinValue);
			double coinvalue = 0;

			if (DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).getCacheMap()
					.containsKey(creditCoinValue)) {
				coinvalue = (Double) DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN)
						.getCacheMap().get(creditCoinValue);
			} else {
				return output;
			}

			System.out.println(coinvalue);

			if (coinvalue == 0) {
				return output;
			}

			String lhs = expression.substring(0, expression.indexOf(" is"));
			System.out.println(lhs);

			String rhs = expression.substring(expression.indexOf(" is") + 4, expression.length());
			System.out.println(rhs);

			String[] rhsArr = rhs.split(token);
			String[] romanNumArr = new String[rhsArr.length - 1];
			for (int count = 0; count < rhsArr.length - 1; count++) {
				System.out.println(rhsArr[count]);
				romanNumArr[count] = rhsArr[count];
			}

			String romanNumber = evaluateRomanNumber(romanNumArr);

			System.out.println(romanNumber);

			int arabicValue;
			try {
				arabicValue = evaluateRomanNumberToArabic(romanNumber);
			} catch (Exception e) {
				return output;
			}

			Double rhsVal = arabicValue * coinvalue;

			System.out.println(rhsVal);

			Double lhsValue = (Double) DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN)
					.getCacheMap().get(lhs);

			int value = (int) (rhsVal / lhsValue);

			System.out.println(value);

			output = rhs + " is " + value + " " + lhs;
		}
		return output;
	}

}
