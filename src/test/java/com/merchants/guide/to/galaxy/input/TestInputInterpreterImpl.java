package com.merchants.guide.to.galaxy.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.merchants.guide.to.galaxy.datastore.CacheType;
import com.merchants.guide.to.galaxy.datastore.DataStoreCacheFactory;

import static com.merchants.guide.to.galaxy.utils.TestUtils.loadFile;

public class TestInputInterpreterImpl {
	InputInterpreter inputInterpreter = new InputInterpreterImpl();

	@Test
	public void testParseInput() {
		inputInterpreter.parseInputs(loadFile("input.txt").split("\r\n"));
		assertTrue(DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).getCacheMap().containsKey("glob"));
		assertEquals("I", (String) DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).getCacheMap().get("glob"));
		assertEquals("V", (String) DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).getCacheMap().get("prok"));
		assertEquals("X", (String) DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).getCacheMap().get("pish"));
		assertEquals("L", (String) DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).getCacheMap().get("tegj"));
		assertEquals(17d, DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).getCacheMap().get("Silver"));
		assertEquals(14450d, DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).getCacheMap().get("Gold"));
		assertEquals(195.5d, DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).getCacheMap().get("Iron"));
	}
}
