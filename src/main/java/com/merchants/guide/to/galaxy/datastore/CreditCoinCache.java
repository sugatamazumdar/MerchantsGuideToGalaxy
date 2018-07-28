package com.merchants.guide.to.galaxy.datastore;

import java.util.HashMap;
import java.util.Map;

public class CreditCoinCache implements Cache {
	private static Map<String, Double> creditCoinMap = new HashMap<String, Double>();
	
	@Override
	public Map getCacheMap() {
		return creditCoinMap;
	}

	@Override
	public void storeInCacheMap(String key, Object value) {
		creditCoinMap.put(key, (Double) value);
	}
}
