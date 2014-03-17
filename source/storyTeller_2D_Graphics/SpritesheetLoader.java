/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import storyTeller_2D_Libraries.Reference;
import gameStarter_Screens.LoadingScreen;

public class SpritesheetLoader {
	
	private BufferedImage spritesheet;

	public BufferedImage loadImage (String imagePath) {
			
	LoadingScreen.setMessage("Loading textures from " + Reference.SPRITESHEET_LOCATION);
		
	try {
			
		spritesheet = ImageIO.read(new File(Reference.SPRITESHEET_LOCATION + imagePath));
	
	return spritesheet;
			
	} catch (IOException e) {
		
		System.err.println("Error: IO Exception");
		
	}
	return null;
	}
	
}
