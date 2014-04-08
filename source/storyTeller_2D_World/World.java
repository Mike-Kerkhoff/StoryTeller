/*
*@Autor Mike Kerkhoff ©09.04.2014 
*/
package storyTeller_2D_World;

import java.awt.Graphics;
import java.util.ArrayList;

import storyTeller_2D_Entities.Entity;

public class World {

	private ArrayList <Entity> entities = new ArrayList<Entity>();
	
	public void addEntity(Entity entity) {
		
		entities.add(entity);
		
	}
	
	public void removeEntity(Entity entity) {
		
		entities.remove(entity);
	}
	
	public ArrayList<Entity> getEntity() {
		
		return entities;
		
	}
	
	public void render(Graphics graphics) {
		
		for (Entity entity : entities) {
			
			entity.render(graphics);
			
		}
		
	}
	
	public void tick() {
		
		for (Entity entity : entities) {
			
			entity.tick();
			
		}
	}
}
