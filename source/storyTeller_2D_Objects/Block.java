/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import storyTeller_2D_Core.CoreObject;

public class Block extends CoreObject {

	
	public Block(float x, float y, int id, BufferedImage image) {
		super(x, y, id, image);
	
		this.setSize(50, 50);
		
	}


	public void tick() {
	}


	public void render(Graphics graphics) {
		
		graphics.drawImage(image, (int)x, (int)y, null);
	}
	
}
