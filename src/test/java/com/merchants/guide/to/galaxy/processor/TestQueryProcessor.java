package com.merchants.guide.to.galaxy.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.merchants.guide.to.galaxy.datastore.QueryCache;
import com.merchants.guide.to.galaxy.processor.QueryProcessor;

public class TestQueryProcessor {
	QueryProcessor queryProcessor = new QueryProcessor();
	
	@Test
	public void testProcessInput() {
		String query1 = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
		String query2 = "how much did the quick brown fox ?";
		queryProcessor.processInput(query1);
		queryProcessor.processInput(query2);
		QueryCache queryCache = new QueryCache();
		assertTrue(queryCache.getQueries().contains(query1));
		assertTrue(queryCache.getQueries().contains(query2));
	}
}
