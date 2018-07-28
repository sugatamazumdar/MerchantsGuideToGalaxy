package com.merchants.guide.to.galaxy.roman;

import java.util.List;

import com.merchants.guide.to.galaxy.roman.units.BuildUnitInterpreterQueue;
import com.merchants.guide.to.galaxy.roman.units.UnitInterpreter;
import com.merchants.guide.to.galaxy.roman.validation.BuildValidatorsQueue;
import com.merchants.guide.to.galaxy.roman.validation.ValidationRule;

public class RomanEvaluatorImpl implements RomanEvaluator {
	

	@Override
	public int getArabicFromRoman(String roman) throws Exception {
		String romanNumClone = roman;
		boolean valid = true;
		//Validation
		for(ValidationRule validation:BuildValidatorsQueue.INSTANCE.buildValidationQueue()) {
			valid = valid && validation.validate(romanNumClone);
		}
		
		if(!valid) {
			throw new Exception("Invalid Roman Number");
		}
		
		//Evaluations
		int sum = 0;
		List<UnitInterpreter> interpreterQueue = BuildUnitInterpreterQueue.INSTANCE.buildUnitInterpreterQueue();
		for(UnitInterpreter interpreter:interpreterQueue) {
			String unitRoman = interpreter.extractUnitValue(romanNumClone);
			sum += interpreter.calculateUnitsValue(unitRoman);
			romanNumClone = romanNumClone.substring(unitRoman.length());
		}
		return sum;
	}

}
