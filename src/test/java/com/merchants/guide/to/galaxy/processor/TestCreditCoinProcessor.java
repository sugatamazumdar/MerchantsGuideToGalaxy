package com.merchants.guide.to.galaxy.processor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.merchants.guide.to.galaxy.datastore.CacheType;
import com.merchants.guide.to.galaxy.datastore.DataStoreCacheFactory;
import com.merchants.guide.to.galaxy.processor.AliasRuleProcessor;
import com.merchants.guide.to.galaxy.processor.CreditCoinRuleProcessor;

public class TestCreditCoinProcessor {
	CreditCoinRuleProcessor creditCoinRuleProcessor = new CreditCoinRuleProcessor();
	
	@Test
	public void testProcessInput() {
		AliasRuleProcessor aliasRuleProcessor = new AliasRuleProcessor();
		aliasRuleProcessor.processInput("glob is I");
		creditCoinRuleProcessor.processInput("glob glob Platinum is 10000 Credits");
		assertEquals(5000d, DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).getCacheMap().get("Platinum"));
	}
	
	@Test
	public void testProcessInput1() {
		AliasRuleProcessor aliasRuleProcessor = new AliasRuleProcessor();
		creditCoinRuleProcessor.processInput("I I I Paladium is 6000 Credits");
		assertEquals(2000d, DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).getCacheMap().get("Paladium"));
	}
	
	@Test
	public void testProcessInput2() {
		AliasRuleProcessor aliasRuleProcessor = new AliasRuleProcessor();
		aliasRuleProcessor.processInput("pish is X");
		aliasRuleProcessor.processInput("tegj is L");
		creditCoinRuleProcessor.processInput("pish tegj Uranium is 8000 Credits");
		assertEquals(200d, DataStoreCacheFactory.INSTANCE.getDataStoreCache(CacheType.CREDIT_COIN).getCacheMap().get("Uranium"));
	}
}
