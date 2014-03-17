/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Utilities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageModifier {

	public static BufferedImage resizeImage (BufferedImage originalImage, int type, float x, float y, int initialWidth, int initialHeight, double scale) {
		
		initialWidth *= scale;
		initialHeight *= scale;
		
		BufferedImage resizedImage = new BufferedImage(initialWidth, initialHeight, type);
		
		Graphics2D graphics2D  = resizedImage.createGraphics();
				
		graphics2D.drawImage(originalImage, (int)x, (int)y, initialWidth, initialHeight, null);
		graphics2D.dispose();
		
		return resizedImage;
	}
}
