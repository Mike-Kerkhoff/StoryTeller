/*
*@Autor Mike Kerkhoff ©09.04.2014 
*/
package storyTeller_2D_Entities;

import java.awt.Graphics;

import storyTeller_2D_World.World;

public abstract class Entity {
	
	protected int x;
	protected int y;
	
	// protected Sprite sprite;
	
	protected World world;
	
	public Entity (int x, int y, World world) {
		this.x = x;
		this.y = y;
		this.world = world;
		
	}

	public abstract void tick();
	
	public void render(Graphics graphics) {}
	
	public int getX() {
		
		return x;
		
	}

	public int getY() {
		
		return y;
		
	}

	public void setX(int x) {
		
		this.x = x;
		
	}

	public void setY(int y) {
		
		this.y = y;
		
	}

}
