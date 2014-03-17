/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Utilities.Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Textfile {

	private static String line; 
	
	
	public static String readFile(String filepath) {
		
		try {
			
			BufferedReader file;
			file = new BufferedReader(new FileReader(filepath));
			line = file.readLine();
			file.close();
			
		} catch (IOException e) {
			
			System.err.println("Error: IO Exception");
			
		}
		
		return line;
	}
	
	public static void writeFile(String filepath, String text) {
		
		try {
			
			FileWriter file;
			file = new FileWriter(filepath);
			file.write(text);
			file.close();
			
		} catch (IOException e) {
			
			System.err.println("Error: IO Exception");
			
		}
	}
	
	
}
