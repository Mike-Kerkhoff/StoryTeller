/*
*@Autor Mike Kerkhoff �2014 
*/

package storyTeller_2D_Graphics;

import java.awt.Color;
import java.awt.Graphics;

import storyTeller_2D_Main.StoryTeller_2D;
public class Renderer {
	

	public void renderForeground (Graphics graphics) {
		
		switch(StoryTeller_2D.state) {
		
		case BEENDEN:
			
			break;
		
		case EINSTELLUNGEN:
			
			break;
		
		case BEGINNEN:
			// graphics.drawImage(Images.hintergrundbild3, 0, 0, null);
			StoryTeller_2D.getInstance().getController().render(graphics);
			
			
			break;
		
		case MEN�:
	
			break;
		
		case PAUSE:
			
			break;
		
		case ZUR�CKHAUPTMEN�:
			
			break;
		
		default:
			
			graphics.setColor(Color.RED);
			graphics.drawString("Unknown! GameState", 150, 150);
		
		}
	
}
	
	public void renderBackground(Graphics graphics) {
	
		
		switch(StoryTeller_2D.state) {
		
			case BEENDEN:
				
				break;
			
			case EINSTELLUNGEN:
				
				break;
			
			case BEGINNEN:
				
				break;
			
			case MEN�:
			
				StoryTeller_2D.getInstance().getMen�().render(graphics);
				
				
				break;
			
			case PAUSE:
				
				break;
			
			case ZUR�CKHAUPTMEN�:
				
				break;
			
			default:
				
				graphics.setColor(Color.RED);
				graphics.drawString("Unknown! GameState", 150, 150);
			
	}
		
}
		
	public void renderPlayer(Graphics graphics) {
		
	}
		
}
