/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.Color;
import java.awt.Graphics;

import storyTeller_2D_Main.StoryTeller_2D;

public class Renderer {
	
/*
* Die Methode 'renderForeground' zeichnet den Vordergrund auf den Bildschirm
*/

	public void renderForeground (Graphics graphics) {
		
		switch(StoryTeller_2D.state) {
		
		case BEENDEN:
			
			break;
		
		case EINSTELLUNGEN:
			
			break;
		
		case SPIELEN:
			
			StoryTeller_2D.getInstance().getController().render(graphics);
			
			
			break;
		
		case MENÜ:
	
			break;
		
		case PAUSE:
			
			break;
		
		case ZURÜCKHAUPTMENÜ:
			
			break;
		
		default:
			
			graphics.setColor(Color.RED);
			graphics.drawString("Unknown! GameState", 150, 150);
		
		}
	
	}
	
/*
* Die Methode 'renderBackground' zeichnet den Hintergrund auf den Bildschirm
*/
	
	public void renderBackground(Graphics graphics) {
	
		
		switch(StoryTeller_2D.state) {
		
			case BEENDEN:
				
				break;
			
			case EINSTELLUNGEN:
				
				break;
			
			case SPIELEN:
				
				break;
			
			case MENÜ:
			
				StoryTeller_2D.getInstance().getMenü().render(graphics);
				
				
				break;
			
			case PAUSE:
				
				break;
			
			case ZURÜCKHAUPTMENÜ:
				
				break;
			
			default:
				
				graphics.setColor(Color.RED);
				graphics.drawString("Unknown! GameState", 150, 150);
			
		}
		
	}
	
/*
* Die Methode 'renderPlayer' zeichnet den Spieler auf den Bildschirm
*/
		
	public void renderPlayer(Graphics graphics) {
		
	}
	
/*
* Ende der Klasse 'Renderer'	
*/
	
}
