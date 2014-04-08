/**
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

/**
* Importierte Bibliotheken und Klassen.
*/

import storyTeller_2D_Entities.Player;
import storyTeller_2D_Main.StoryTeller_2D;

/**
* Die Klasse 'Camera' dient als Spielkamera für den StoryTeller2D,
* sodass der Spieler immer im Mittelpunkt des Bildschirms steht.
*/

public class Camera {

/**
 * Der Integer 'x' ist die x-Koordinate des Objektes.
 */
	
	private int x;
	
/**
* Der Integer 'y' ist die y-Koordinate des Objektes.
*/	
	
	private int y;
	
/**
* Der Player 'player' ist ein Objekt der Klasse 'Player'.
*/
	private Player player;

/**
* Konstruktor der Klasse 'Camera', nimmt einen Integer 'x' und einen Integer 'y' 
* entgegen.
* 
* @param x : die x-Koordinate des Objektes
* @param y : die y-Koordinate des Objektes
*/
	
	public Camera(Player player, int x, int y) {
		
		this.x = x;
		this.y = y;
		this.player = player;
				
			
	}
	
/**
* Die Methode 'getX' gibt die x-Koordinate des Objektes zurück.
* 
* @return x : die x-Koordinate des Objektes
*/

	public int getX() {
		
		return x;
		
	}

/**
* Die Methode 'getY' gibt die y-Koordinate des Objektes zurück.
* 
* @return y : die y-Koordinate des Objektes
*/
	
	public int getY() {
		
		return y;
		
	}

/**
* Die Methode 'setX' nimmt einen Wert für 'x' entgegen und übernimmt diesen.
* 
* @param x : die x-Koordinate des Objektes
*/
	
	public void setX(int x) {
		
		this.x = x;
		
	}

/**
* Die Methode 'setY' nimmt einen Wert für 'y' entgegen und übernimmt diesen.
* 
* @param y : die y-Koordinate des Objektes
*/	
	
	public void setY(int y) {
		
		this.y = y;
		
	}
	
/**
* Die Methode 'tick' updated die Position der Kamera und setzt diese mit der 
* Position des Spielers gleich. 
*/
	
	public void tick() {
		
		x += ((-player.getX() + StoryTeller_2D.WIDTH / 2) - x) * 0.0275f;
		y = (-player.getY() + StoryTeller_2D.HEIGHT / 2);
		
	}
	
}
