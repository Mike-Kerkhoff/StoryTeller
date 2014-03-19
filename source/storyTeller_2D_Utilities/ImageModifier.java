/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Utilities;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageModifier {

/*
* Die Methode 'resizeImage' nimmt ein BufferedImage 'originalImage', 
* ein int 'type', ein float 'x', ein float 'y', ein int 'initialWidth',
* ein int 'initialHeight' und ein double 'Size' entgegen, um ein 
* BufferedImage 'originalImage' in seiner Größe anzupassen	
*/
	
	public static BufferedImage resizeImage (BufferedImage originalImage, int type, float x, float y, int initialWidth, int initialHeight, double scale) {
		
		initialWidth *= scale;
		initialHeight *= scale;
		
		BufferedImage resizedImage = new BufferedImage(initialWidth, initialHeight, type);
		
		Graphics2D graphics2D  = resizedImage.createGraphics();
				
		graphics2D.drawImage(originalImage, (int)x, (int)y, initialWidth, initialHeight, null);
		graphics2D.dispose();
		
		return resizedImage;
	}
	
/*
* Ende der Klasse 'ImageModifier'
*/
	
}
