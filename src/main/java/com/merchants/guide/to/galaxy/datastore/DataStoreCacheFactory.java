package com.merchants.guide.to.galaxy.datastore;

public enum DataStoreCacheFactory {
	INSTANCE;
	public Cache getDataStoreCache(CacheType cacheType) {
		Cache cache = null;
		switch (cacheType) {
		case ALIAS:
			cache = new AliasCache();
			break;
		case CREDIT_COIN:
			cache = new CreditCoinCache();
			break;
		case ROMAN:
			cache = new RomanNumberCache();
			break;
		default:
			cache = null;
		}
		return cache;
	}
}
