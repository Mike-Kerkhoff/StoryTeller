/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

/*
* Importierte Bibliotheken und Klassen
*/

import storyTeller_2D_Core.CoreObject;
import storyTeller_2D_Entities.Player;
import storyTeller_2D_Libraries.Object_IDs;
import storyTeller_2D_Main.StoryTeller_2D;

public class Camera {

/*
* Attribute der Klasse 'Camera'	
*/
	
	private float x;
	private float y;
	private Player player;

/*
* Konstruktor der Klasse 'Camera', nimmt eine float 'x' und eine float 'y' 
* entgegen
*/
	
	public Camera(float x, float y) {
		
		this.x = x;
		this.y = y;
		
		for (CoreObject obj : StoryTeller_2D.getInstance().getController().getObjects()) {
			if (obj.getID() == Object_IDs.PLAYER) {
				player = (Player) obj;
			}
		}
		
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
* Nimmt eine float 'x' entgegen und übernimmt diese	
*/
	
	public void setX(float x) {
		this.x = x;
	}

/*
* Nimmt eine float 'y' entgegen und übernimmt diese	
*/	
	
	public void setY(float y) {
		this.y = y;
	}
	
/*
* Tick-Methode	
*/
	
	public void tick() {
		
		x += ((-player.getX() + StoryTeller_2D.WIDTH / 2) - x) * 0.0275f;
		y = (-player.getY() + StoryTeller_2D.HEIGHT / 2);
	}
	
/*
* Ende der Klasse 'Camera'
*/
	
}
