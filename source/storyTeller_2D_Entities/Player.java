/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Entities;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.Graphics;
import java.util.ArrayList;

import storyTeller_2D_Core.CoreObject;
import storyTeller_2D_Enums.Direction;
import storyTeller_2D_Graphics.Animation;
import storyTeller_2D_Libraries.Object_IDs;
import storyTeller_2D_Libraries.Textures;
import storyTeller_2D_Main.StoryTeller_2D;
import storyTeller_2D_Objects.Block;
import storyTeller_2D_Textures.TextureManager;

public class Player extends CoreObject {
	
/*
* Attribute der Klasse 'Player'	
*/
	
	private static ArrayList<CoreObject> blocks = StoryTeller_2D.getInstance().getController().getObjects();
	
	private Boolean falling = true;
	private Boolean jumping = false;
	private Boolean moving = false;
	private Animation animationRight;
	private Animation animationLeft;
	
	private Direction direction = Direction.FORWARD;
	
	private float gravity = 0.5f;
	
/*
* Konstruktor der Klasse 'Player', welcher ein int 'x', ein int 'y', ein int 'id'
* und einen TextureManager 'texture' entgegen nimmt	
*/
	
	public Player (float x, float y, int id, TextureManager texture) {
		
		super(x, y, id, texture);
		this.setSize(100, 97);
		
		animationRight = new Animation(8, Textures.playerRight);
		animationLeft = new Animation(8, Textures.playerLeft);
		
	}
	
/*
* Gibt zurück, ob der Spieler gerade am Springen ist.
*/
	
	public Boolean isJumping() {
		
		return jumping;
		
	}

/*
* Nimmt einen Boolean 'jumping' entgegen und übernimmt diesen	
*/
	
	public void setJumping(Boolean jumping) {
		
		this.jumping = jumping;
		
	}

/*
* Gibt zurück, ob sich der Spieler gerade bewegt. 
*/
	
	public Boolean getMoving() {
		
		return moving;
	}

/*
*  Nimmt einen Boolean 'moving' entgegen und übernimmt diesen
*/
	
	public void setMoving(Boolean moving) {
		
		this.moving = moving;
	}
	
/*
* Nimmt eine Direction 'direction' entgegen und übernimmt diese	
*/
	
	public void setDirection(Direction direction) {
		
		this.direction = direction;
	}
	
/*
* Gibt zurück, in welche Richtung sich der Spieler gerade bewegt	
*/
	
	public Direction getDirection() {
		
		return direction;
	}

/*
* Tick-Methode (überschrieben von der Überklasse 'CoreObject')
*/
	
	public void tick() {
		x += velX;
		y += velY;
		
		falling();
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

/*
* Render-Methode (Überschrieben von der Oberklasse 'CoreObject')
*/
	
	public void render (Graphics graphics) {
		
		if (!moving) {
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
		
		}
	}

/*
* Lässt den Spieler fallen anhand der Gravitation, falls dieser
* nicht am Springen ist	
*/
	
	public void falling() {
		
		if(falling) {
			
			velY += gravity;
			
		}
	}
	
/*
* Überprüft, ob der Spieler in Berührung mit Blöcken ist und 
* setzt die Collision fest	
*/
	
	private void checkCollision() {
		
		for (CoreObject obj : blocks) {
			
			if (obj instanceof Block) {
				
				
				if(getBottomBounds().intersects(obj.getTopBounds())) {
					
						velY = 0;
						y = obj.getY() - height+5;
						jumping = false;
						falling = false;

				} else 
					
					falling = true;
				
				if(getTopBounds().intersects(obj.getBottomBounds())) {
					
					falling();
					
					y = obj.getY() + obj.getHeight();
				}
				
				if (getRightBounds().intersects(obj.getLeftBounds()) && obj.getId() != Object_IDs.BLOCK_FLOOR1) {
					
					x = obj.getX() - width;
				}	
				
				if(getLeftBounds().intersects(obj.getRightBounds()) && obj.getId() != Object_IDs.BLOCK_FLOOR1) {
					
					x = obj.getX() + obj.getWidth();	
					
				}
				
			}
			
		}
		
	}
	
/*
* Ende der Klasse 'Player'
*/
	
}
