package com.merchants.guide.to.galaxy.processor;

import com.merchants.guide.to.galaxy.datastore.CacheType;
import com.merchants.guide.to.galaxy.datastore.DataStoreCacheFactory;

public class CreditValueOutputProcessor implements OutputProcessor {
	private String beginString = "how many Credits is ";
	private String token = " ";

	@Override
	public String processOutput(String input) {
		String output = null;
		if (input.startsWith(beginString)) {
			String expression = input.substring(beginString.length(), input.length() - 1).trim();
			System.out.println(expression);

			String[] parts = expression.split(token);
			

			String creditCoinValue = parts[parts.length-1];
			System.out.println(creditCoinValue);
			double coinvalue = 0;
			
			if (DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).getCacheMap().containsKey(creditCoinValue)) {
				coinvalue = (Double) DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).getCacheMap()
						.get(creditCoinValue);
			} else {
				return output;
			}
			
			System.out.println(coinvalue);
			
			if(coinvalue==0) {
				return output;
			}
			
			String expressionPart = expression.substring(0, expression.indexOf(creditCoinValue)).trim();
			System.out.println(expressionPart);
			parts = expressionPart.split(token);
			
			String romanNumber = evaluateRomanNumber(parts);
			
			if(romanNumber == null) {
				return output;
			}
			
			System.out.println(romanNumber);
			
			int value;
			try {
				value = (int) (coinvalue * evaluateRomanNumberToArabic(romanNumber));
			} catch (Exception e) {
				return output;
			}
			
			System.out.println(value);
			
			output = String.format( "%s is %d Credits"  , expression, value);
		}
		return output;

	}

}
