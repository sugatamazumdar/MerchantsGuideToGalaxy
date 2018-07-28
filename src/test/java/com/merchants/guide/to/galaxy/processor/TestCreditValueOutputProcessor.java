package com.merchants.guide.to.galaxy.processor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.merchants.guide.to.galaxy.datastore.CacheType;
import com.merchants.guide.to.galaxy.datastore.DataStoreCacheFactory;

public class TestCreditValueOutputProcessor {
	CreditValueOutputProcessor creditValueOutputProcessor = new CreditValueOutputProcessor();

	@Test
	public void testProcessInput() {
		String testInput = "how many Credits is glob prok Platinum ?";
		String expectedOutput = "glob prok Platinum is 20000 Credits";
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).storeInCacheMap("Platinum", 5000d);
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).storeInCacheMap("glob", "I");
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).storeInCacheMap("prok", "V");
		String actualOutput = creditValueOutputProcessor.processOutput(testInput);
		assertEquals(expectedOutput, actualOutput);

	}

}
