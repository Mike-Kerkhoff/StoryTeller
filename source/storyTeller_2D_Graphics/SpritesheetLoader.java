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

public class SpritesheetLoader {
	
/*
* Attribute der Klasse 'SpritesheetLoader'	
*/
	
	private static BufferedImage spritesheet;

/*
* Die Methode 'loadImage' nimmt einen String 'imagePath' entgegen
* und übernimmt diesen, um das BufferedImage zu laden	
*/	
	
	public static BufferedImage loadImage (String imagePath) {
			
	LoadingScreen.setMessage("Loading textures from " + Reference.SPRITESHEET_LOCATION);
		
	try {
			
		spritesheet = ImageIO.read(new File(Reference.SPRITESHEET_LOCATION + imagePath));
	
	return spritesheet;
			
	} catch (IOException e) {
		
		System.err.println("Error: IO Exception");
		
	}
	
	return null;
	
	}
	
	
/*
* Ende der Klasse 'SpritesheetLoader'
*/
	
}
