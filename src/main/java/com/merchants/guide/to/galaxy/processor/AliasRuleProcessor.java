package com.merchants.guide.to.galaxy.processor;

import com.merchants.guide.to.galaxy.datastore.CacheType;
import com.merchants.guide.to.galaxy.datastore.DataStoreCacheFactory;

public class AliasRuleProcessor implements InputProcessor {
	private final String inputToken = " ";
	private final String aliasSeperator = "is";

	@Override
	public void processInput(String input) {
		String[] parts = input.split(inputToken);
		if (parts[1].equals(aliasSeperator) && parts.length == 3) {
			DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).storeInCacheMap(parts[0], parts[2].replaceAll("\r", ""));	
		}
	}

}
