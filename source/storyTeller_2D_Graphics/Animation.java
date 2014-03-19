/**
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

/**
* Importierte Bibliotheken und Klassen.
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
* Die Klasse 'Animation' kümmert sich um die Verwaltung der
* Spieler und Charakter-Animation.
*/

public class Animation {

/**
* Der Integer 'count' dient als Zählvariable.	
*/
	
	private int count = 0;
	
/**
* Der Integer 'index' dient als Zählvariable.	
*/
	
	private int index = 0;
	
/**
* Der Integer 'frames' gibt die insgesamte Anzahl von Frames der 
* Animation an.	
*/
		
	private int frames;
			
	
/**
* Der Integer 'speed' gibt die Geschwindigkeit der Animation an.	
*/
	
	private int speed;
	
/**
* Das BufferedImage 'currentImage' beinhaltet das momentane Bild der Animation.	
*/
	
	private BufferedImage currentImage; 
	
/**
* Das Array aus BufferedImages 'animation' beinhaltet alle Bilder der Animation.	
*/
	
	private BufferedImage animation[];
	
/**
* Konstruktor der Klasse 'Animation', nimmt einen integer 'speed' und 
* einen Array aus BufferedImages 'animation' entgegen. 	
* 
* @param speed : die Geschwindigkeit der Animation
* @param animation : das Array aus BufferedImages der Animation
*/
	
	public Animation(int speed, BufferedImage[] animation) {
		this.speed = speed;
		this.animation = animation;
		
		frames = animation.length;
		
	}
	
/**
* Die Methode 'runAnimation' bringt die Animation des Spielers 
* zum laufen.	
*/
	
	public void runAnimation() {	
		index++;
		
		if (index > speed) {
			index = 0;
			nextFrame();
		}
	} 
	
/**
* Die Methode 'nextFrame' zählt die einzelnen Frames durch und
* verändert entsprechend das BufferedImage 'currentImage'.	
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
	
/**
* Die Methode 'drawAnimation' zeichnet das BufferedImage 'currentImage' der Animation.
* 
* @param graphics : ein Objekt der Klasse 'Graphics'
* @param x : der x-Wert des animierten Objektes
* @param y : der y-Wert des animierten Objektes
*/
	
	public void drawAnimation(Graphics graphics, int x, int y) {
		
		graphics.drawImage(currentImage, x, y,null);
		
	}
	
}
