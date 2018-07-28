package com.merchants.guide.to.galaxy;

import com.merchants.guide.to.galaxy.input.InputInterpreter;
import com.merchants.guide.to.galaxy.input.InputInterpreterImpl;
import com.merchants.guide.to.galaxy.output.OutputInterpreter;
import com.merchants.guide.to.galaxy.output.OutputInterpreterImpl;

public enum InterpreterFactory {
	INSTANCE;
	
	public InputInterpreter getInputInterpreter() {
		return new InputInterpreterImpl();
	}
	
	public OutputInterpreter getOutputInterpreter() {
		return new OutputInterpreterImpl();
	}
}
