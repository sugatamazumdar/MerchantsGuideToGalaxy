package com.merchants.guide.to.galaxy;

import com.merchants.guide.to.galaxy.datastore.QueryCache;
import com.merchants.guide.to.galaxy.input.InputInterpreter;
import com.merchants.guide.to.galaxy.output.OutputInterpreter;

public class MerchantsGuideApplication {
	QueryCache queryCache = null;
	InputInterpreter inputInterpreter = null;
	OutputInterpreter outputInterpreter = null;
	
	
	public MerchantsGuideApplication() {
		super();
		this.inputInterpreter = InterpreterFactory.INSTANCE.getInputInterpreter();
		this.outputInterpreter = InterpreterFactory.INSTANCE.getOutputInterpreter();
		this.queryCache = new QueryCache();
	}


	public MerchantsGuideApplication(QueryCache queryCache, InputInterpreter inputInterpreter,
			OutputInterpreter outputInterpreter) {
		super();
		this.queryCache = queryCache;
		this.inputInterpreter = inputInterpreter;
		this.outputInterpreter = outputInterpreter;
	}


	public String[] processInputs(String[] inputStream) {
		inputInterpreter.parseInputs(inputStream);
		String[] queries = new String[queryCache.getQueries().size()];
		int count = 0;
		for(String query:queryCache.getQueries()) {
			queries[count] = query;
			count++;
		}
		return outputInterpreter.parseOutput(queries);
	}
}
