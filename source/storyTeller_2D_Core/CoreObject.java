/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Core;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import storyTeller_2D_Textures.TextureManager;

public abstract class CoreObject {

	protected float x;
	protected float y;
	protected float velX;
	protected float velY;
	protected int id;
	protected int width;
	protected int height;
	
	protected TextureManager texture;
	protected BufferedImage image;
	
	public CoreObject(float x, float y, int id, TextureManager texture) {
		
		this.x = x;
		this.y = y;
		this.id = id;
		this.texture = texture;
	}
	
	public CoreObject (float x, float y, int id, int width, int height, TextureManager texture) {
		
		this.x = x;
		this.y = y;
		this.id = id;
		this.width = width;
		this.height = height;
		this.texture = texture;
	}

public CoreObject (float x, float y, int id, BufferedImage image) {
		
		this.x = x;
		this.y = y;
		this.id = id;
		this.image = image;
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		
		return y;
	}

	public float getVelX() {
		
		return velX;
	}

	public float getVelY() {
		
		return velY;
	}
	public int getId() {
		
		return id;
	}
	
	public int getWidth() {
		
		return width;
	}

	public int getHeight() {
		
		return height;
	}
	

	public void setX(float x) {
		
		this.x = x;
	}

	public void setY(float y) {
		
		this.y = y;
	}

	public void setVelX(float velX) {
		
		this.velX = velX;
	}

	public void setVelY(float velY) {
		
		this.velY = velY;
	}
	
	public void setWidth(int width) {
		
		this.width = width;
	}

	public void setHeight(int height) {
		
		this.height = height;
	}
	
	public void setSize(int width, int height) {
		
		this.width = width;
		this.height = height;
	}

	public abstract void tick();
	public abstract void render(Graphics graphics);
	
	public Rectangle getTopBounds(){
		
		return new Rectangle((int)x, (int)y, width, height);
		
	}
	
	public Rectangle getBottomBounds() {
		
		return new Rectangle((int)x, (int)y + (height -8), width, 6);
		
	}
	
	public Rectangle getRightBounds() {
		
		return new Rectangle((int)x + (width-8), (int)y, 6, height);
		
	}
	
	public Rectangle getLeftBounds() {
		
		return new Rectangle((int)x, (int)y, 6, height);
		
	}

	
}
