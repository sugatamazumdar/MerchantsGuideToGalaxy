package com.merchants.guide.to.galaxy.datastore;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberCache implements Cache {
	private static Map<String, Integer> romanNumberMap = new HashMap<String, Integer>();
	

	public RomanNumberCache() {
		super();
		romanNumberMap.put("M", 1000);
		romanNumberMap.put("D", 500);
		romanNumberMap.put("C", 100);
		romanNumberMap.put("L", 50);
		romanNumberMap.put("X", 10);
		romanNumberMap.put("V", 5);
		romanNumberMap.put("I", 1);
	}

	@Override
	public Map getCacheMap() {
		return romanNumberMap;
	}

	@Override
	public void storeInCacheMap(String key, Object value) {
		romanNumberMap.put(key, (Integer) value);
	}

}
