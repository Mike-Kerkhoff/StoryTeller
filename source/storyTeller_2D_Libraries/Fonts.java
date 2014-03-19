/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Libraries;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import gameStarter.LoadingScreen;

public class Fonts {
	
/*
* Attribute der Klasse 'Fonts'	
*/
	
	private static ArrayList<Fonts> fontList = new ArrayList <Fonts>();
	
	private static String fontPath;
	
/*
* Konstruktor der Klasse 'Fonts'	
*/
	
	public Fonts (String filePath) {
		Fonts.fontPath = Reference.FONT_LOCATION + filePath;
		registerFont();
		
	}
	
/*
* Die Methode 'registerFont' registriert eine neue Schriftart	
*/
	
	private void registerFont () {
		
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
			
			try {
				
				graphicsEnvironment.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));
			
			} catch (FontFormatException e) {
				
				System.err.println("Error: FontFormatException");
			
			} catch (IOException e) {
				
				System.err.println("Error: IOException");
			}
		
	}
	
/*
* Die Methode 'addFont' fügt eine neue Schriftart zum Spiel hinzu	
*/
	
	public static void addFont(Fonts font) {
		
		LoadingScreen.setMessage("Loading fonts from " + Reference.FONT_LOCATION);
		
		fontList.add(font);
		
	}
	
/*
* Ende der Klasse 'Fonts'	
*/
	
}
