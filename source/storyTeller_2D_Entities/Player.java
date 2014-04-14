/**
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Entities;

/**
* Importierte Bibliotheken und Klassen.
*/

import java.awt.Graphics;

import java.util.ArrayList;

import storyTeller_2D_Enums.Direction;
import storyTeller_2D_Graphics.Animation;
import storyTeller_2D_Libraries.Textures;
import storyTeller_2D_Main.StoryTeller_2D;
import storyTeller_2D_Objects.Block;
import storyTeller_2D_Textures.TextureManager;

/**
 * Die Klasse 'Spieler' ist eine Unterklasse von CoreObjekt und verwaltet 
 * die Bewegungen und das Verhalten des Spielers.
 */

public class Player {
	
/**
* Der Boolean 'falling' gibt an, ob der Spieler am Fallen ist. 
*/
	
	private Boolean falling = false;
	
/**
* Der Boolean 'jumping' gibt an, ob der Spieler am Springen ist.
*/
	
	private Boolean jumping = false;
	
/**
* Der Boolean 'moving' gibt an, ob der Spieler sich am bewegen ist.
*/
	
	private Boolean moving = false;
	
/**
* Die Animation 'animationRight' kümmert sich um die Bewegung und Animation des 
* Spielers nach rechts.	
*/
	
	private Animation animationRight;
	
/**
* Die Animation 'animationLeft' kümmert sich um die Bewegung und Animation des 
* Spielers nach links.	
*/	
	private Animation animationLeft;
	
/**
* Die Direction 'direction' gibt an, in welche Richtung sich der Spieler bewegt.
*/
	
	private Direction direction = Direction.FORWARD;
	
/**
* Konstruktor der Klasse 'Player', nimmt einen Integer 'x', 
* einen Integer 'y', einen Integer 'id' und einen TextureManager 
* 'texture' entgegen.
* 
* @param x : der x-Wert des Spielers
* @param y : der y-Wert des Spielers
* @param id : die ID des Spielers
* @param texture : der TextureManager des Spielers	
*/
	
	public Player (int x, int y) {
		super(x, y);
		
		animationRight = new Animation(8, Textures.playerRight);
		animationLeft = new Animation(8, Textures.playerLeft);
		
	}
	
/**
* Die Methode 'isJumping' gibt zurück, ob der Spieler gerade am Springen ist.
* 
* @return jumping : der Boolean gibt an, ob der Spieler am Springen ist
*/
	
	public Boolean isJumping() {
		
		return jumping;
		
	}

/**
* Die Methode 'setJumping' nimmt einen Boolean 'jumping' entgegen und übernimmt 
* diesen.
* 
* @param jumping : der Boolean gibt an, ob der Spieler gerade am Springen ist	
*/
	
	public void setJumping(Boolean jumping) {
		
		this.jumping = jumping;
		
	}

/**
* Die Methode 'getMoving' gibt zurück, ob sich der Spieler gerade bewegt. 
* 
* @return moving : der Boolean gibt an, ob sich der Spieler gerade bewegt
*/
	
	public Boolean getMoving() {
		
		return moving;
	}

/**
* Die Methode 'setMoving' nimmt einen Boolean 'moving' entgegen und übernimmt 
* diesen.
* 
* @param moving : der Boolean gibt an, ob sich der Spieler gerade bewegt
*/
	
	public void setMoving(Boolean moving) {
		
		this.moving = moving;
	}
	
/**
* Die Methode 'setDirection' nimmt eine Direction 'direction' entgegen und übernimmt 
* diese.
* 
* @param direction : die Direction gibt an, in welche Richtung sich der Spieler 
* gerade bewegt	
*/
	
	public void setDirection(Direction direction) {
		
		this.direction = direction;
	}
	
/**
* Die Methode 'getDirection' gibt zurück, in welche Richtung sich der Spieler
* gerade bewegt.
* 
* @return direction : die Direction gibt an, in welche Richtung sich der Spieler 
* gerade bewegt	
*/
	
	public Direction getDirection() {
		
		return direction;
	}

/**
* Die Methode 'tick' updatet alle Bewegungen und Handlungen des Spielers.
*/
	
	public void tick() {
		x += velX;
		y += velY;
		
		checkCollision();
		
		if (moving) {
			
			if (direction == Direction.RIGHT) {
				
				animationRight.runAnimation();
			}
			
			else if (direction == Direction.LEFT) {
				
				animationLeft.runAnimation();
			}
		}
			
	}

/**
* Die Methode 'render' zeichnet den Spieler auf den Bildschirm.
*/
	
	public void render (Graphics graphics) {
		
/*		if (!moving) {
			if (direction == Direction.FORWARD) {
				
			graphics.drawImage(Textures.playerStandingFront, (int)x, (int)y, null);
			
			}
			
			else if (direction == Direction.RIGHT) {
				
				graphics.drawImage(Textures.playerStandingRight, (int)x, (int)y, null);
				
			}
			
			else if (direction == Direction.LEFT) {
				
				graphics.drawImage(Textures.playerStandingLeft, (int)x, (int)y, null);
				
			}
		}
		
		else {
			
			
				if (direction == Direction.RIGHT) {
				
				animationRight.drawAnimation(graphics, x, y);
				
				}
			
				else if (direction == Direction.LEFT) {
				
				animationLeft.drawAnimation(graphics, x, y);
				
				}
*/		
		}

	
/**
* Die Methode 'checkCollision' überprüft, ob der Spieler in Berührung mit 
* irgendwelchen Spielobjekten ist und setzt die Collision fest.	
*/
	
	private void checkCollision() {
		
		
	
}
	}
