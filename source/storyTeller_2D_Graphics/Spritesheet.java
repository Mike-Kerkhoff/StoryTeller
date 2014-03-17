/*
*@Autor ©24.02.2014 
*/

package storyTeller_2D_Graphics;

import java.awt.image.BufferedImage;


public class Spritesheet {
	
	private BufferedImage sheet;
	private int width;
	private int height;
	
	public Spritesheet (BufferedImage sheet, int width) {
		
		this.sheet = sheet;
		this.width = width;
		this.height = width;
	}
	
	public Spritesheet (BufferedImage sheet, int width, int height) {
		
		this.sheet = sheet;
		this.width = width;
		this.height = height;
	}

	public BufferedImage getSprite(int column, int row) {
		
		return sheet.getSubimage((column * width) - width, (row * height) - height, width, height);
		
	}
}
