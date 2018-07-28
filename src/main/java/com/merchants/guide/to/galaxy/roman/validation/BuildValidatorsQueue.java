package com.merchants.guide.to.galaxy.roman.validation;

import java.util.ArrayList;
import java.util.List;

public enum BuildValidatorsQueue {
	INSTANCE;
	
	public List<ValidationRule> buildValidationQueue() {
		List<ValidationRule> validationQueue = new ArrayList<ValidationRule>();
		validationQueue.add(new AllowableCharactersValidation());
		validationQueue.add(new UniqueLiteralValidation());
		validationQueue.add(new ContiguousLiteralValidationRule());
		return validationQueue;
	}
}
