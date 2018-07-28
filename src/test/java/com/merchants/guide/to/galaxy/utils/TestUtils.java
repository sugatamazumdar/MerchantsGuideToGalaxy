package com.merchants.guide.to.galaxy.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtils {
	public static String loadFile(String fileName) {
		URL url = Thread.currentThread().getContextClassLoader().getResource(fileName);
		String testInput = null;
		try {
			testInput = new String(Files.readAllBytes(Paths.get(url.toURI())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testInput;
	}
}
