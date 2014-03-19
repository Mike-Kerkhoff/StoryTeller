/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Utilities.Files;

/*
* Importierte Bibliotheken und Klassen
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Textfile {

/*
* Attribute der Klasse 'Textfile'	
*/
	
	private static String line; 
		
/*
* Die Methode 'readFile' nimmt einen String 'filepath' entgegen
* und liest einen Satz aus einer Datei heraus	
*/
	
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
	
/*
* Die Methode 'writeFile' nimmt einen String 'filepath' und einen 
* String 'Text' entgegen und schreibt einen Satz in eine Datei hinein	
*/	
	
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
	
/*
* Ende der Klasse 'TextFile'	
*/
	
}
