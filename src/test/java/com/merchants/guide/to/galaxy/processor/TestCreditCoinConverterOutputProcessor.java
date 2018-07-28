package com.merchants.guide.to.galaxy.processor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.merchants.guide.to.galaxy.datastore.CacheType;
import com.merchants.guide.to.galaxy.datastore.DataStoreCacheFactory;

public class TestCreditCoinConverterOutputProcessor {
	CreditCoinConverterOutputProcessor processor = new CreditCoinConverterOutputProcessor();
	
	@Test
	public void testProcessInput() {
		String testInput = "how many Silver is glob Gold ?";
		String expectedOutput = "glob Gold is 850 Silver";
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).storeInCacheMap("Silver", 17d);
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).storeInCacheMap("Gold", 14450d);
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).storeInCacheMap("glob", "I");
		String actualOutput = processor.processOutput(testInput);
		assertEquals(expectedOutput, actualOutput);

	}
}
