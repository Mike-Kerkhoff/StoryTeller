/*
*@Autor Mike Kerkhoff ©17.03.2014 
*/
package storyTeller_2D_Graphics;

import gameStarter.LoadingScreen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import storyTeller_2D_Libraries.Reference;

public class ChapterLoader {
	
	private BufferedImage chapter;

	public BufferedImage loadImage (String imagePath) {
			
	LoadingScreen.setMessage("Loading textures from " + Reference.CHAPTER_LOCATION);
		
	try {
			
		chapter = ImageIO.read(new File(Reference.CHAPTER_LOCATION + imagePath));
	
	return chapter;
			
	} catch (IOException e) {
		
		System.err.println("Error: IO Exception");
		
	}
	
	return null;
	
	}
	
	
}
