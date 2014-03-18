/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import storyTeller_2D_Libraries.Reference;
import gameStarter.LoadingScreen;

public class ImageLoader {
	
/*
* Attribute der Klasse 'ImageLoader'	
*/
	
	private BufferedImage image;

/*
* Die Methode 'loadImage' nimmt einen String 'imagePath' entgegen
* und übernimmt diesen, um das BufferedImage zu laden	
*/
	
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
	
/*
* Ende der Klasse 'ImageLoader'	
*/
	
}
