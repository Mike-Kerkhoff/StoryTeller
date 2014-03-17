/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Controller;

import java.awt.Graphics;
import java.util.ArrayList;

import storyTeller_2D_Core.CoreObject;

public class Controller {

	private ArrayList<CoreObject> objects = new ArrayList<CoreObject>();
	
	
	public void tick() {
		
		
/*
 * for-each-loop (for each CoreObject, do (...)
 */
		for(CoreObject obj: objects) {
			
			obj.tick();
			
			}
		}

	
	public void render(Graphics graphics) {
		for(CoreObject obj: objects) {
			
			obj.render(graphics);
		}
	}
	
	public void addObject(CoreObject instance) {
		
		objects.add(instance);
	}
	
	public void removeObject(CoreObject instance) {
		
		objects.remove(instance);
		
	}
	
	public ArrayList<CoreObject> getObjects() {
		return objects;
	}
	
	
}
