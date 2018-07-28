package com.merchants.guide.to.galaxy.processor;

import com.merchants.guide.to.galaxy.datastore.CacheType;
import com.merchants.guide.to.galaxy.datastore.DataStoreCacheFactory;
import com.merchants.guide.to.galaxy.roman.RomanEvaluatorFactory;

public class CreditCoinRuleProcessor implements InputProcessor {

	private final String endPattern = "Credits";
	private final String creditCoinSeperator = " is";
	private final String creditCoinToken = " ";

	@Override
	public void processInput(String input) {
		if (input.endsWith(endPattern)) {
			String initial = input.substring(0, input.indexOf(endPattern));
			String[] parts = initial.split(creditCoinSeperator);
			String lhs = parts[0].trim();
			String rhs = parts[1].trim();
			System.out.println(lhs);
			
			Double creditVal;
			try {
				creditVal = Double.parseDouble(rhs);
			} catch (NumberFormatException e) {
				return;
			}
			System.out.println(creditVal);
			
			String[] lhsItems = lhs.split(creditCoinToken);
			String creditCoin = lhsItems[lhsItems.length - 1];
			System.out.println(creditCoin);

			if (DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).getCacheMap()
					.containsKey(creditCoin)) {
				return;
			}

			StringBuffer romanNumber = new StringBuffer();
			for (int i = 0; i < lhsItems.length - 1; i++) {
				String key = lhsItems[i];
				System.out.println(key);
				String roman = key;
				if (DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).getCacheMap().containsKey(key)) {
					roman = (String) DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).getCacheMap()
							.get(key);
				}

				if (DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ROMAN).getCacheMap()
						.containsKey(roman)) {
					romanNumber.append(roman);
				}
			}
			
			System.out.println(romanNumber.toString());
			Double creditValue;
			try {
				creditValue = creditVal / evaluateRomanNumber(romanNumber.toString());
			} catch (Exception e) {
				return;
			}
			DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).storeInCacheMap(creditCoin, creditValue);
		}

	}
	
	private int evaluateRomanNumber(String romanNumber) throws Exception {
		return RomanEvaluatorFactory.INSTANCE.getRomanEvaluator().getArabicFromRoman(romanNumber);
	}

}
