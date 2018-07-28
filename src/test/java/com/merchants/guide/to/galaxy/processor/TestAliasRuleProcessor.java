package com.merchants.guide.to.galaxy.processor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.merchants.guide.to.galaxy.datastore.CacheType;
import com.merchants.guide.to.galaxy.datastore.DataStoreCacheFactory;
import com.merchants.guide.to.galaxy.processor.AliasRuleProcessor;

public class TestAliasRuleProcessor {
	AliasRuleProcessor aliasRuleProcessor = new AliasRuleProcessor();

	@Test
	public void testProcessInput() {
		aliasRuleProcessor.processInput("blob is C");
		assertEquals("C", DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.ALIAS).getCacheMap().get("blob"));
	}
}
