/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Controller;

/*
* Importierte Bibliotheken und Klassen
*/


import java.awt.Graphics;
import java.util.ArrayList;

import storyTeller_2D_Core.CoreObject;

public class Controller {
	
/*
* Attribute der Klasse 'Controller'	
*/
	
	private ArrayList<CoreObject> objects = new ArrayList<CoreObject>();
	k
/*
* Tick-Methode, die immer wieder aufgerufen wird, um das Spiel zu updaten. 
* Ruft die Tick-Methode jedes Objektes auf, das ein 'CoreObject' ist und sich
* in der ArrayList 'objects' befindet. 
*/
	
	public void tick() {
		
		for(CoreObject obj: objects) {
			
			obj.tick();
			
			}
		}

	
/*
* Render-Methode, welche immer wieder aufgerufen wird, um das Spiel zu updaten.
* Ruft die Render-Methode jedes Objektes auf, das ein 'CoreObject' ist und sich
* in der ArrayList 'objects' befindet. 	
*/
	
	public void render(Graphics graphics) {
		for(CoreObject obj: objects) {
			
			obj.render(graphics);
		}
	}
	
/*
* Fügt ein Objekt in die ArrayList 'objects' hinzu
*/
	
	public void addObject(CoreObject instance) {
		
		objects.add(instance);
	}
	
/*
* Löscht ein Element aus der ArrayList 'objects'	
*/
	
	public void removeObject(CoreObject instance) {
		
		objects.remove(instance);
		
	}
	

/*
* Gibt alles Objekte der ArrayList 'objects' zurück
*/
	
	public ArrayList<CoreObject> getObjects() {
		return objects;
	}
	
/*
* Ende der Klasse 'Controller'
*/
	
}
