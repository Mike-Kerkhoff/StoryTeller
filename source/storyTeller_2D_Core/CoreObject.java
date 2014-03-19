/**
*@Autor Mike Kerkhoff �2014 
*/

package storyTeller_2D_Core;

/**
* Importierte Bibliotheken und Klassen.
*/

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import storyTeller_2D_Textures.TextureManager;

/**
* Die abstrakte Klasse 'CoreObject' bildet das Grundger�st
* f�r alle Objekte im Spiel.
*/

public abstract class CoreObject {

/**
* Der Integer 'x' ist die x-Koortinate des Objektes.
*/
	
	protected int x;
	
/**
* Der Integer 'y' ist die y-Koordinate des Objektes.
*/
	
	protected int y;
	
/**
* Der Integer 'velX' ist die Geschwindigkeit des Objektes in x-Richtung.
*/
	
	protected int velX;
	
/**
* Der Integer 'velY' ist die Geschwindigkeit des Objektes in y-Richtung.
*/
	
	protected int velY;
	
/**
* Der Integer 'id' ist die ID des Objektes.	
*/
	
	protected int id;
	
/**
* Der Integer 'width' ist die Breite des Objektes.	
*/
	
	protected int width;
	
/**
* Der Integer 'height' ist die H�he des Objektes.
*/
	
	protected int height;
		
/**
* Der TextureManager 'texture' ist der TextureManager des Objektes.
*/
	
	protected TextureManager texture;
	
/**
* Das BufferedImage 'image' ist das Bild des Objektes.	
*/
	
	protected BufferedImage image;
	
/**
* Konstruktor der Klasse 'CoreObject', nimmt einen Integer 'x', 
* einen Integer 'y' einen Integer 'id' und einen TextureManager 'texture' 
* entgegen.
* 
* @param x : die x-Koordinate des Objektes
* @param y : die y-Koordinate des Objektes
* @param id : die ID des Objektes
* @param texture : der TextureManager des Objektes
*/
	
	public CoreObject(int x, int y, int id, TextureManager texture) {
		
		this.x = x;
		this.y = y;
		this.id = id;
		this.texture = texture;
		
	}
	
/**
* Konstruktor der Klasse 'CoreObject', welcher einen integer 'x', 
* einen integer 'y' einen integer 'id', einen integer 'width', 
* einen integer 'height' und einen TextureManager 'texture' entgegen nimmt.
* 
* @param x : die x-Koordinate des Objektes
* @param y : die y-Koordinate des Objektes
* @param id : die ID des Objektes
* @param width : die Breite des Objektes
* @param height : die H�he des Objektes
* @param texture : der TextureManager des Objektes 	
*/
	
	public CoreObject (int x, int y, int id, int width, int height, TextureManager texture) {
		
		this.x = x;
		this.y = y;
		this.id = id;
		this.width = width;
		this.height = height;
		this.texture = texture;
		
	}

/**
* Konstruktor der Klasse 'CoreObject', welcher einen integer 'x', 
* einen integer 'y', einen integer 'id' und ein BufferedImage 'image' 
* entgegen nimmt. 
* 
* @param x : die x-Koordinate des Objektes
* @param y : die y-Koordinate des Objektes
* @param id : die ID des Objektes
* @param image : das Bild des Objektes
*/	
	
public CoreObject (int x, int y, int id, BufferedImage image) {
		
		this.x = x;
		this.y = y;
		this.id = id;
		this.image = image;
		
	}
	

/**
* Die Methode 'getX' gibt die x-Koordinate des Objektes zur�ck.
* 
* @return x : die x-Koordinate des Objektes
*/

	public int getX() {
		
		return x;
		
	}

/**
* Die Methode 'getY' gibt die y-Koordinate des Objektes zur�ck.
* 
* @return y : die y-Koordinate des Objektes
*/
	
	public int getY() {
		
		return y;
		
	}

/**
* Die Methode 'getVelX' gibt die Geschwindigkeit in x-Richtung des Objektes zur�ck.
* 
* @return velX : die Geschwindigkeit in x-Richtung des Objektes
*/
	
	public int getVelX() {
		
		return velX;
		
	}

/**
* Die Methode 'getVelY' gibt die Geschwindigkeit in y-Richtung des Objektes zur�ck.
* 
* @return velY : die Geschwindigkeit in y-Richtung des Objektes
*/
	
	public int getVelY() {
		
		return velY;
		
	}
	
/**
* Die Methode 'getID' gibt die ID des Objektes zur�ck.
* 
* @return id : die ID des Objektes
*/
	
	public int getID() {
		
		return id;
		
	}
	
/**
* Die Methode 'getWidth' gibt die Breite des Objektes zur�ck.
* 
* @return width : die Breite des Objektes
*/
	
	public int getWidth() {
		
		return width;
		
	}

/**
* Die Methode 'getHeight' gibt die H�he des Objektes zur�ck.
* 
* @return height : die H�he des Objektes
*/
	
	public int getHeight() {
		
		return height;
		
	}
	
/**
* Die Methode 'setX' nimmt einen Wert f�r 'x' entgegen und �bernimmt diesen.
* 
* @param x : die x-Koordinate des Objektes
*/
	
	public void setX(int x) {
		
		this.x = x;
		
	}

/**
* Die Methode 'setY' nimmt einen Wert f�r 'y' entgegen und �bernimmt diesen.
* 
* @param y : die y-Koordinate des Objektes
*/	
	
	public void setY(int y) {
		
		this.y = y;
		
	}

/**
* Die Methode 'setVelX' nimmt einen Wert f�r 'VelX' entgegen und �bernimmt diesen.
* 
* @param velX : die Geschwindigkeit in x-Richtung des Objektes
*/	
	
	public void setVelX(int velX) {
		
		this.velX = velX;
		
	}

/**
* Die Methode 'setVelY' nimmt einen Wert f�r 'VelY' entgegen und �bernimmt diesen.
* 
* @param velY : die Geschwindigkeit in y-Richtung des Objektes
*/	
	
	public void setVelY(int velY) {
		
		this.velY = velY;
		
	}

/**
* Die Methode 'setWidth' nimmt einen Wert f�r 'width' entgegen und �bernimmt diesen.
* 
* @param width : die Breite des Objektes
*/	
	
	public void setWidth(int width) {
		
		this.width = width;
		
	}

/**
* Die Methode 'setHeight' nimmt einen Wert f�r 'height' entgegen und �bernimmt diesen.
* 
* @param height : die H�he des Objektes
*/	
	
	public void setHeight(int height) {
		
		this.height = height;
	}
	
/**
* Die Methode 'setSize' nimmt sowohl einen Wert f�r 'width' wie auch f�r 'height' entgegen,
* um die Gr��e des Objektes festzulegen.
* 
* @param width : die Breite des Objektes
* @param height : die H�he des Objektes 	
*/
	
	public void setSize(int width, int height) {
		
		this.width = width;
		this.height = height;
		
	}

/**
* Die Methode 'tick' updatet die Objekte des Spieles.	
*/
	
	public abstract void tick();
	
/**
* Die Methode 'render' zeichnet die Objekte auf den Bildschirm.
* 
* @param graphics : ein Objekt der Klasse 'Graphics'	
*/
	
	public abstract void render(Graphics graphics);
	
/**
* Die Methode 'getTopBounds' gibt die oberen Grenzen des Objektes zur�ck.
* 
* @return Rectangle : die oberen Grenzen des Objektes	
*/
	
	public Rectangle getTopBounds(){
		
		return new Rectangle(x, y, width, height);
		
	}
	
/**
* Die Methode 'getBottomBounds' gibt die unteren Grenzen des Objektes zur�ck.
* 
* @return Rectangle : die unteren Grenzen des Objektes	
*/	
	
	public Rectangle getBottomBounds() {
		
		return new Rectangle(x, y + (height -8), width, 6);
		
	}
	
/**
* Die Methode 'getRightBounds' gibt die rechten Grenzen des Objektes zur�ck.
* 
* @return Rectangle : die rechten Grenzen des Objektes	
*/	
	
	public Rectangle getRightBounds() {
		
		return new Rectangle(x + (width-8), y, 6, height);
		
	}
	
/**
* Die Methode 'getLeftBounds' gibt die linken Grenzen des Objektes zur�ck.
* 
* @return Rectangle : die linken Grenzen des Objektes	
*/
	
	public Rectangle getLeftBounds() {
		
		return new Rectangle(x, y, 6, height);
		
	}
	
}
