package com.merchants.guide.to.galaxy.datastore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AliasCache implements Cache{
	private static Map<String, String> aliasMap = new HashMap<String, String>();

	@Override
	public Map getCacheMap() {
		return aliasMap;
	}

	@Override
	public void storeInCacheMap(String key, Object value) {
		aliasMap.put(key, (String) value);
	}
}
