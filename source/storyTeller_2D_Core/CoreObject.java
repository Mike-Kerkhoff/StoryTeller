/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Core;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import storyTeller_2D_Textures.TextureManager;

public abstract class CoreObject {

/*
* Attribute der abstrakten Klasse 'CoreObject'	
*/
	
	protected float x;
	protected float y;
	protected float velX;
	protected float velY;
	protected int id;
	protected int width;
	protected int height;
	
	protected TextureManager texture;
	protected BufferedImage image;
	
/*
* 1. Konstruktor der Klasse CoreObject, welcher ein int 'x', ein int 'y' ein int 'id' 
* und einen TextureManager 'texture' entgegen nimmt. 
*/
	
	public CoreObject(float x, float y, int id, TextureManager texture) {
		
		this.x = x;
		this.y = y;
		this.id = id;
		this.texture = texture;
	}
	
/*
* 2. Konstruktor der Klasse CoreObject, welcher ein int 'x', ein int 'y' ein int 'id', 
* ein int 'width', ein int 'height' und einen TextureManager 'texture' entgegen nimmt. 	
*/
	
	public CoreObject (float x, float y, int id, int width, int height, TextureManager texture) {
		
		this.x = x;
		this.y = y;
		this.id = id;
		this.width = width;
		this.height = height;
		this.texture = texture;
	}

/*
* 3. Konstruktor der Klasse CoreObject, welcher ein int 'x', ein int 'y' ein int 'id'
* und ein BufferedImage 'image' entgegen nimmt. 
*/	
	
public CoreObject (float x, float y, int id, BufferedImage image) {
		
		this.x = x;
		this.y = y;
		this.id = id;
		this.image = image;
	}
	

/*
* Gibt 'x' zurück
*/

	public float getX() {
		return x;
	}

/*
* Gibt 'y' zurück	
*/
	
	public float getY() {
		
		return y;
	}

/*
* Gibt 'velX' zurück	
*/
	
	public float getVelX() {
		
		return velX;
	}

/*
* Gibt 'velY' zurück	
*/
	
	public float getVelY() {
		
		return velY;
	}
	
/*
* Gibt 'id' zurück	
*/
	
	public int getId() {
		
		return id;
	}
	
/*
* Gibt 'width' zurück	
*/
	
	public int getWidth() {
		
		return width;
	}

/*
* Gibt 'height' zurück	
*/
	
	public int getHeight() {
		
		return height;
	}
	
/*
* Nimmt einen Wert für 'x' entgegen und übernimmt diesen
*/
	
	public void setX(float x) {
		
		this.x = x;
	}

/*
* Nimmt einen Wert für 'y' entgegen und übernimmt diesen
*/	
	
	public void setY(float y) {
		
		this.y = y;
	}

/*
* Nimmt einen Wert für 'VelX' entgegen und übernimmt diesen
*/	
	
	public void setVelX(float velX) {
		
		this.velX = velX;
	}

/*
* Nimmt einen Wert für 'VelY' entgegen und übernimmt diesen
*/	
	
	public void setVelY(float velY) {
		
		this.velY = velY;
	}

/*
* Nimmt einen Wert für 'width' entgegen und übernimmt diesen
*/	
	
	public void setWidth(int width) {
		
		this.width = width;
	}

/*
* Nimmt einen Wert für 'height' entgegen und übernimmt diesen
*/	
	
	public void setHeight(int height) {
		
		this.height = height;
	}
	
/*
* Nimmt sowohl einen Wert für 'width' wie auch für 'height' entgegen,
* um die größte des Objektes festzulegen 	
*/
	
	public void setSize(int width, int height) {
		
		this.width = width;
		this.height = height;
	}

/*
* Abstrakte Tick-Methode	
*/
	
	public abstract void tick();
	
/*
* Abstrakte Render-Methode	
*/
	
	public abstract void render(Graphics graphics);
	
/*
* Gibt die oberen Grenzen des Objektes zurück	
*/
	
	public Rectangle getTopBounds(){
		
		return new Rectangle((int)x, (int)y, width, height);
		
	}
	
/*
* Gibt die unteren Grenzen des Objektes zurück	
*/	
	
	public Rectangle getBottomBounds() {
		
		return new Rectangle((int)x, (int)y + (height -8), width, 6);
		
	}
	
/*
* Gibt die rechten Grenzen des Objektes zurück	
*/	
	
	public Rectangle getRightBounds() {
		
		return new Rectangle((int)x + (width-8), (int)y, 6, height);
		
	}
	
/*
* Gibt die linken Grenzen des Objektes zurück	
*/	
	
	public Rectangle getLeftBounds() {
		
		return new Rectangle((int)x, (int)y, 6, height);
		
	}

/*
* Ende der Klasse 'CoreObject'
*/	
	
}
