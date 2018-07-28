package com.merchants.guide.to.galaxy.processor;

import com.merchants.guide.to.galaxy.datastore.CacheType;
import com.merchants.guide.to.galaxy.datastore.DataStoreCacheFactory;
import com.merchants.guide.to.galaxy.roman.RomanEvaluatorFactory;

public interface OutputProcessor {
	public String processOutput(String input);
	
	public default String evaluateRomanNumber(String[] inputs) {
		StringBuffer romanNum = new StringBuffer();
		for(String input:inputs) {
			System.out.println(input);
			String roman = input;
			
			if (DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).getCacheMap().containsKey(input)) {
				roman = (String) DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).getCacheMap()
						.get(input);
			}
			
			if (DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ROMAN).getCacheMap()
					.containsKey(roman)) {
				romanNum.append(roman);
			} else {
				return null;
			}
		}
		return romanNum.toString();
	}
	
	public default int evaluateRomanNumberToArabic(String romanNumber) throws Exception {
		return RomanEvaluatorFactory.INSTANCE.getRomanEvaluator().getArabicFromRoman(romanNumber);
	}
}
