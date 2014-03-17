/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {

	private int count = 0;
	private int index = 0;
	private int speed;
	private int frames;
	
	private BufferedImage currentImage; 
	private BufferedImage animation[];
	
	public Animation(int speed, BufferedImage[] animation) {
		this.speed = speed;
		this.animation = animation;
		
		frames = animation.length;
		
	}
	
	public void runAnimation() {	
		index++;
		
		if (index > speed) {
			index = 0;
			nextFrame();
		}
	} 
	
	public void nextFrame() {
		for (int k = 0; k < frames; k++) {
			if (count == k) {
				currentImage = animation[k];
			}
		}
		
		count++;
		if (count > frames) {
			count = 0;
		}
	}
	
	public void drawAnimation(Graphics graphics, float x, float y) {
		
		graphics.drawImage(currentImage, (int)x, (int)y,null);
		
	}
}
