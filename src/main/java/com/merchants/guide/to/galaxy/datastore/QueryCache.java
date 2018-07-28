package com.merchants.guide.to.galaxy.datastore;

import java.util.ArrayList;
import java.util.List;

public class QueryCache {
	private static List<String> queryList = new ArrayList<String>();

	public void refreshQueryList() {
		queryList = new ArrayList<String>();
	}
	
	public List<String> getQueries() {
		return queryList;
	}

	public void storeInQueryList(String query) {
		queryList.add(query);
	}
}
