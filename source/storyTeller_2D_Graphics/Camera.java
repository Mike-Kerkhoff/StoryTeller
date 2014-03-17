/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

import storyTeller_2D_Core.CoreObject;
import storyTeller_2D_Entities.Player;
import storyTeller_2D_Libraries.Object_IDs;
import storyTeller_2D_Main.StoryTeller_2D;

public class Camera {

	
	private float x;
	private float y;
	private Player player;
	public Camera(float x, float y) {
		
		this.x = x;
		this.y = y;
		
		for (CoreObject obj : StoryTeller_2D.getInstance().getController().getObjects()) {
			if (obj.getId() == Object_IDs.PLAYER) {
				player = (Player) obj;
			}
		}
		
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public void tick() {
		
		x += ((-player.getX() + StoryTeller_2D.WIDTH / 2) - x) * 0.0275f;
		y = (-player.getY() + StoryTeller_2D.HEIGHT / 2);
	}
}
