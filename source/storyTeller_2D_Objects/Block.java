/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Objects;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import storyTeller_2D_Core.CoreObject;

public class Block extends CoreObject {

/*
* Konstruktor der Klasse 'Block', nimmt ein float 'x', ein float ' y',
* ein int 'id' und ein BufferedImage 'image' entgegen
*/
	public Block(float x, float y, int id, BufferedImage image) {
		super(x, y, id, image);
	
		this.setSize(50, 50);
		
	}

/*
* Tick-Methode
*/
	
	public void tick() {
	}

/*
* Render-Methode
*/
	
	public void render(Graphics graphics) {
		
		graphics.drawImage(image, (int)x, (int)y, null);
	}
	
/*
* Ende der Klasse 'Block'	
*/
	
}
