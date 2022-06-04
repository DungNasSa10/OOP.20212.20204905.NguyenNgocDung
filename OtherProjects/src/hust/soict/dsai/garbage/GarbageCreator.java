package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
	
	public static void main(String[] args) throws IOException {
		String filename = "AimsProject/bin/hust/soict/dsai/aims/Aims.class";
		byte[] inputBytes = {0};
		long startTime, endTime;
		
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		String outputString = "";
		
		for (byte b: inputBytes) {
			outputString += (char) b;
		}
		
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
		startTime = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		
		for (byte b: inputBytes) {
			sb.append(b);
		}
	
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
		startTime = System.currentTimeMillis();
		StringBuilder sb1 = new StringBuilder();
		
		for (byte b: inputBytes) {
			sb1.append(b);
		}
	
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
	
}
