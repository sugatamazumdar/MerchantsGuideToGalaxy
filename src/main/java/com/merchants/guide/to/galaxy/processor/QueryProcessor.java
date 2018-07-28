package com.merchants.guide.to.galaxy.processor;

import com.merchants.guide.to.galaxy.datastore.QueryCache;

public class QueryProcessor implements InputProcessor {
	private final String endPattern = "?";
	private final QueryCache queryCache = new QueryCache();

	@Override
	public void processInput(String input) {
		if(input.endsWith(endPattern)) {
			queryCache.storeInQueryList(input);
		}
	}

}
