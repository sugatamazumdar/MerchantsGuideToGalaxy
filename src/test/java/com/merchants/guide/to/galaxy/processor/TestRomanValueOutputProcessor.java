package com.merchants.guide.to.galaxy.processor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.merchants.guide.to.galaxy.datastore.CacheType;
import com.merchants.guide.to.galaxy.datastore.DataStoreCacheFactory;

public class TestRomanValueOutputProcessor {
	RomanValueOutputProcessor romanValueOutputProcessor = new RomanValueOutputProcessor();

	@Test
	public void testProcessInput() {
		String testInput = "how much is pish tegj glob glob ?";
		String expectedOutput = "pish tegj glob glob is 42";
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).storeInCacheMap("glob", "I");
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).storeInCacheMap("prok", "V");
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).storeInCacheMap("pish", "X");
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).storeInCacheMap("tegj", "L");
		String actualOutput = romanValueOutputProcessor.processOutput(testInput);
		assertEquals(expectedOutput, actualOutput);
		
	}

}
