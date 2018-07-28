package com.merchants.guide.to.galaxy.datastore;

import java.util.Map;

public interface Cache {
	public Map getCacheMap();
	public void storeInCacheMap(String key, Object value);
}
