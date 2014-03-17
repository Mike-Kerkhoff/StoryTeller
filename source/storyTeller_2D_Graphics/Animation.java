/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {

/*
* Attribute der Klasse 'Animation' 	
*/
	
	private int count = 0;
	private int index = 0;
	private int speed;
	private int frames;
	
	private BufferedImage currentImage; 
	private BufferedImage animation[];
	
/*
* Konstruktor der Klasse 'Animation', welcher ein int 'speed' und 
* ein BufferedImage-Array 'animation' entgegen nimmt	
*/
	
	public Animation(int speed, BufferedImage[] animation) {
		this.speed = speed;
		this.animation = animation;
		
		frames = animation.length;
		
	}
	
/*
* Die Methode 'runAnimation' bringt die Animation des Spielers 
* zum laufen	
*/
	
	public void runAnimation() {	
		index++;
		
		if (index > speed) {
			index = 0;
			nextFrame();
		}
	} 
	
/*
* Die Methode 'nextFrame' zählt die einzelnen 'frames' durch	
*/
	
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
	
/*
* Die Methode 'drawAnimation' zeichnet die einzelnen 'frames' und
* somit auch die Animation des Spielers	
*/
	
	public void drawAnimation(Graphics graphics, float x, float y) {
		
		graphics.drawImage(currentImage, (int)x, (int)y,null);
		
	}
	
/*
* Ende der Klasse 'Animation'
*/
	
}
