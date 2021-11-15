package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class RegNo {

	

	public static int writeFile(String path, int i) {
		
		int n = i + 1;
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {

			bufferedWriter.write(String.valueOf(n));
			bufferedWriter.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	public static int readFile(String path) {
		
		int count = 0;
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

			
			String row = "";

			while ((row = bufferedReader.readLine()) != null) {
			
			}
			count = Integer.parseInt(row);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return count;

	}


}
