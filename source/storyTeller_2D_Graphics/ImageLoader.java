/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import storyTeller_2D_Libraries.Reference;
import storyTeller_2D_Screens.LoadingScreen;

public class ImageLoader {
	
	private BufferedImage image;

	public BufferedImage loadImage (String imagePath) {
	
	LoadingScreen.setMessage("Loading images from " + Reference.IMAGE_LOCATION);	
		
	try {
			
	image = ImageIO.read(new File(Reference.IMAGE_LOCATION + imagePath));
	
	return image;
			
	} catch (IOException e) {
		
		System.err.println("Error: IO Exception");
		
	}
	return null;
	}
	
}
