package com.merchants.guide.to.galaxy.roman;

public enum RomanEvaluatorFactory {
	INSTANCE;
	
	public RomanEvaluator getRomanEvaluator() {
		return new RomanEvaluatorImpl();
	}
}
