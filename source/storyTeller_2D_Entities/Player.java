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
	
	public Player (float x, float y, int id, TextureManager texture) {
		
		super(x, y, id, texture);
		this.setSize(100, 97);
		
		animationRight = new Animation(8, Textures.playerRight);
		animationLeft = new Animation(8, Textures.playerLeft);
		
	}
	
	public Boolean isJumping() {
		
		return jumping;
		
	}

	public void setJumping(Boolean jumping) {
		
		this.jumping = jumping;
		
	}
	
	public Boolean getMoving() {
		
		return moving;
	}

	public void setMoving(Boolean moving) {
		
		this.moving = moving;
	}
	
	public void setDirection(Direction direction) {
		
		this.direction = direction;
	}
	
	public Direction getDirection() {
		
		return direction;
	}

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

	public void falling() {
		
		if(falling) {
			
			velY += gravity;
			
		}
	}
	
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
}
