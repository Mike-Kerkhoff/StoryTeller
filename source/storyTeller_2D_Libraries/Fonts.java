/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Libraries;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import storyTeller_2D_Screens.LoadingScreen;

public class Fonts {
	
	private static ArrayList<Fonts> fontList = new ArrayList <Fonts>();
	
	private static String fontPath;
	
	public Fonts (String filePath) {
		Fonts.fontPath = Reference.FONT_LOCATION + filePath;
		registerFont();
		
	}
	
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
	
	public static void addFont(Fonts font) {
		
		LoadingScreen.setMessage("Loading fonts from " + Reference.FONT_LOCATION);
		
		fontList.add(font);
		
	}
	
}
