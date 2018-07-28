package com.merchants.guide.to.galaxy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static com.merchants.guide.to.galaxy.utils.TestUtils.loadFile;



import org.junit.Test;

import com.merchants.guide.to.galaxy.datastore.QueryCache;

public class TestMerchantsGuideApplication {
	
	private String input_file_Name = "input.txt";
	private String output_file_Name = "output.txt";
	private MerchantsGuideApplication merchantsGuideApplication = new MerchantsGuideApplication();
	
	@Test
	public void testprocessInputs() {
		String[] inputStream = getInput().split("\r\n");
		String[] expectedOutputStream = getOutput().split("\r\n");
		(new QueryCache()).refreshQueryList();
		String[] outputStream = merchantsGuideApplication.processInputs(inputStream);
		assertEquals(expectedOutputStream, outputStream);
	}
	
	@Test
	public void testprocessInputsAugmented() {
		String[] inputStream = loadFile("input_another.txt").split("\r\n");
		String[] expectedOutputStream = loadFile("output_another.txt").split("\r\n");
		(new QueryCache()).refreshQueryList();
		String[] outputStream = merchantsGuideApplication.processInputs(inputStream);
		assertEquals(expectedOutputStream, outputStream);
	}
	
	@Test
	public void testFileLoads() {
		assertNotNull(getInput());
		assertNotNull(getOutput());
		System.out.println(getInput());
		System.out.println("\r\n");
		System.out.println(getOutput());
	}

	String getInput() {
		return loadFile(input_file_Name);
	}
	
	String getOutput() {
		return loadFile(output_file_Name);
	}
	
	
}
