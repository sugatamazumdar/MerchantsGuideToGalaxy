package com.merchants.guide.to.galaxy.output;

import static com.merchants.guide.to.galaxy.utils.TestUtils.loadFile;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.merchants.guide.to.galaxy.datastore.CacheType;
import com.merchants.guide.to.galaxy.datastore.DataStoreCacheFactory;

public class TestOutputInterpreterImpl {
	OutputInterpreter outputInterpreter = new OutputInterpreterImpl();

	@Test
	public void testParseOutput() {

		String[] expectedOutputs = loadFile("output.txt").split("\r\n");

		String[] inputs = new String[5];
		inputs[0] = "how much is pish tegj glob glob ?";
		inputs[1] = "how many Credits is glob prok Silver ?";
		inputs[2] = "how many Credits is glob prok Gold ?";
		inputs[3] = "how many Credits is glob prok Iron ?";
		inputs[4] = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).storeInCacheMap("glob", "I");
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).storeInCacheMap("prok", "V");
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).storeInCacheMap("pish", "X");
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).storeInCacheMap("tegj", "L");
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).storeInCacheMap("Silver", 17d);
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).storeInCacheMap("Gold", 14450d);
		DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).storeInCacheMap("Iron", 195.5d);
		String[] actualOutputs = outputInterpreter.parseOutput(inputs);

		for (int i = 0; i < actualOutputs.length; i++) {
			assertEquals(expectedOutputs[i], actualOutputs[i]);
		}
	}
}
