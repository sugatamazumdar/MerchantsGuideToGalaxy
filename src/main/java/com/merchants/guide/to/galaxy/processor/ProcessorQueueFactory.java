package com.merchants.guide.to.galaxy.processor;

import java.util.Arrays;
import java.util.List;

public enum ProcessorQueueFactory {
	INSTANCE;
	
	List<InputProcessor> inputProcessorQueue = Arrays.asList(new AliasRuleProcessor(), new CreditCoinRuleProcessor(), new QueryProcessor());
	List<OutputProcessor> outputProcessorQueue = Arrays.asList(new RomanValueOutputProcessor(), new CreditValueOutputProcessor(), new CreditCoinConverterOutputProcessor());
	
	public List<InputProcessor> getInputProcessorQueue() {
		return inputProcessorQueue;
	}
	
	public List<OutputProcessor> getOutputProcessorQueue() {
		return outputProcessorQueue;
	}
}
