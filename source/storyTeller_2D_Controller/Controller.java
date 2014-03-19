/**
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Controller;

/**
* Importierte Bibliotheken und Klassen.
*/

import java.awt.Graphics;
import java.util.ArrayList;

import storyTeller_2D_Core.CoreObject;

/**
* Die Klasse 'Controller' verwaltet alle Objekte im Spiel.
*/

public class Controller {
	
/**
* Die ArrayList 'objects' beeinhaltet alle Objekte des Spiels. 
*/
	
	private ArrayList<CoreObject> objects = new ArrayList<CoreObject>();
	
/**
* Die Methode 'tick' updatet alle Objekte im Spiel, indem es die Tick-Methode
* jedes Objekts, welches eine Unterklasse von 'CoreObject' ist und sich in der
* ArrayList 'objects' befindet, aufruft. 
*/
	
	public void tick() {
		
		for(CoreObject obj: objects) {
			
			obj.tick();
			
		}
	}

	
/**
* Die Methode 'render' zeichnet alle Objekte auf den Bildschirm, in dem es die Render-Methode
* jedes Objekts, welches eine Unterklasse von 'CoreObject' ist und sich in der ArrayList
* 'objects' befindet, aufruft.
* 
* @param graphics : ein Objekt der Klasse 'Graphics'
*/
	
	public void render(Graphics graphics) {
		
		for(CoreObject obj: objects) {
			
			obj.render(graphics);
			
		}
	}
	
/**
* Die Methode 'addObject' fügt ein Objekt in die ArrayList 'objects' hinzu.
* 
* @param object : ein Objekt der Klasse 'CoreObject'
*/
	
	public void addObject(CoreObject object) {
		
		objects.add(object);
		
	}
	
/**
* Die Methode 'removeObject' löscht ein Element aus der ArrayList 'objects'.
* 
* @param object : ein Objekt der Klasse 'CoreObject'	
*/
	
	public void removeObject(CoreObject object) {
		
		objects.remove(object);
		
	}
	

/**
* Die Methode 'getObjects' gibt alle Objekte der ArrayList 'objects' zurück.
*
* @return objects : die Objekte der ArrayList 'objects'
*/
	
	public ArrayList<CoreObject> getObjects() {
		
		return objects;
		
	}
	
}
