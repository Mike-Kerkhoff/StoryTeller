/*
*@Autor Mike Kerkhoff 2014 
*/

package storyTeller_2D_World;

import java.awt.image.BufferedImage;

import storyTeller_2D_Controller.Controller;
import storyTeller_2D_Main.StoryTeller_2D;
import storyTeller_2D_Objects.Block;
import storyTeller_2D_Libraries.Images;
import storyTeller_2D_Libraries.Object_IDs;
import storyTeller_2D_Libraries.Textures;

public class Chapter {

	private BufferedImage image;
	private Controller controller = StoryTeller_2D.getInstance().getController();
	
	
	public Chapter(int number) {
		switch (number) {
		case 1: 
			image = Images.level1;
			break;
			
		default: 
			image = Images.level1;
		}
	}
	
	public void loadChapter() {
		
		int width = image.getWidth();
		int height = image.getHeight();
		
		for (int x = 0; x < width; x++) {
			
			for (int y = 0; y < height; y++) {
				
				int pixel = image.getRGB(x, y);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if (red == 255 && green == 255 && blue == 255) {
					
					controller.addObject(new Block(x * 50, y * 50, Object_IDs.BLOCK_FLOOR1, Textures.floorBlock));
				
				}
			}
		}
	}
}
