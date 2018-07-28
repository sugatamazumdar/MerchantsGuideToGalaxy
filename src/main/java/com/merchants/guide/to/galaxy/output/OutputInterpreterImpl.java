package com.merchants.guide.to.galaxy.output;

import java.util.List;

import com.merchants.guide.to.galaxy.processor.OutputProcessor;
import com.merchants.guide.to.galaxy.processor.ProcessorQueueFactory;

public class OutputInterpreterImpl implements OutputInterpreter {
	public OutputInterpreterImpl(List<OutputProcessor> processorQueue) {
		super();
		this.processorQueue = processorQueue;
	}

	public OutputInterpreterImpl() {
		super();
		processorQueue = ProcessorQueueFactory.INSTANCE.getOutputProcessorQueue();
	}

	List<OutputProcessor> processorQueue = null;

	@Override
	public String[] parseOutput(String[] inputs) {
		String[] outputs = new String[inputs.length];
		int count = 0;

		for (String input : inputs) {

			String defaultOutput = "I have no idea what you are talking about";
			String result = null;

			for (OutputProcessor processor : processorQueue) {
				result = processor.processOutput(input);
				if (result != null) {
					break;
				}
			}

			if (result == null) {
				result = defaultOutput;
			}
			outputs[count] = result;
			count++;
		}

		return outputs;
	}
}
