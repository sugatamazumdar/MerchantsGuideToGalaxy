package com.merchants.guide.to.galaxy.input;

import java.util.Arrays;
import java.util.List;

import com.merchants.guide.to.galaxy.processor.InputProcessor;
import com.merchants.guide.to.galaxy.processor.ProcessorQueueFactory;

public class InputInterpreterImpl implements InputInterpreter {

	public InputInterpreterImpl(List<InputProcessor> processorQueue) {
		super();
		this.processorQueue = processorQueue;
	}

	public InputInterpreterImpl() {
		super();
		processorQueue = ProcessorQueueFactory.INSTANCE.getInputProcessorQueue();
	}

	List<InputProcessor> processorQueue = null;

	public void parseInputs(String[] inputs) {

		Arrays.stream(inputs).forEach(input -> {
			processorQueue.forEach(processor -> {
				processor.processInput(input.trim());
			});
		});
	}

}
