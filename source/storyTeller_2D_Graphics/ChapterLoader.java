/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

/*
* Importierte Bibliotheken und Klassen
*/

import gameStarter.LoadingScreen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import storyTeller_2D_Libraries.Reference;

public class ChapterLoader {
	
/*
* Attribute der Klasse 'ChapterLoader'
*/
	
	private BufferedImage chapter;

/*
* Die Methode 'loadImage' nimmt einen String 'imagePath' entgegen
* und übernimmt diesen, um das BufferedImage zu laden	
*/
	
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
	

/*
* Ende der Klasse 'ChapterLoader'	
*/
	
}
