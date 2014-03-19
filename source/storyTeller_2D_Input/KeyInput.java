/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Input;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import storyTeller_2D_Entities.Player;
import storyTeller_2D_Enums.Direction;
import storyTeller_2D_Libraries.Object_IDs;
import storyTeller_2D_Main.StoryTeller_2D;


public class KeyInput implements KeyListener {

/*
* Attribute der Klasse 'KeyInput'	
*/
	
	private Player player;
	private boolean [] keyDown = new boolean[2];
	
/*
* Konstruktor der Klasse 'KeyInput'	
*/
	
	public KeyInput() {
		
		for (int k = 0; k < StoryTeller_2D.getInstance().getController().getObjects().size(); k++) {
			
			if (StoryTeller_2D.getInstance().getController().getObjects().get(k).getID() == Object_IDs.PLAYER) {
				
				player = (Player) StoryTeller_2D.getInstance().getController().getObjects().get(k);
				
			}
		}
	}
	
/*
*  Die Methode 'keyPressed' (Überschrieben von der Klasse 'KeyListener')
*  reagiert, sobald eine Taste gedrückt wurde.
*/
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		switch(StoryTeller_2D.state) {
		
		case BEENDEN:
			
			break;
			
		case SPIELEN:
			
				if (key == KeyEvent.VK_UP && !player.isJumping()) {
					player.setJumping(true);
					player.setVelY(-14);
				}
				
				if (key == KeyEvent.VK_LEFT) {
					player.setMoving(true);
					player.setVelX(-2);
					player.setDirection(Direction.LEFT);
					keyDown[0] = true;
				}
				
				if (key == KeyEvent.VK_RIGHT) {
					player.setMoving(true);
					player.setVelX(+2);
					player.setDirection(Direction.RIGHT);
					keyDown[1] = true;
				}
				
				if (key == KeyEvent.VK_DOWN) {
					player.setDirection(Direction.FORWARD);
				}
				
			break;
			
		case EINSTELLUNGEN:
			
			break;
			
		case MENÜ:
			
			break;
			
		case PAUSE:
			
			break;
			
		case ZURÜCKHAUPTMENÜ:
			
			break;
			
		default:
			
			break;
		
		}
	}

/*
*  Die Methode 'keyReleased' (Überschrieben von der Klasse 'KeyListener')
*  reagiert, sobald eine Taste losgelassen wurde.
*/
	
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		switch(StoryTeller_2D.state) {
		
		case SPIELEN:
					
		if (key == KeyEvent.VK_UP) {
			
			player.setVelY(0);
			player.setJumping(false);
		}
			
					
		if (key == KeyEvent.VK_LEFT) {
			player.setVelX(0);
			keyDown[0] = false;
			player.setMoving(false);
		}
					
		if (key == KeyEvent.VK_RIGHT) {
			
			player.setVelX(0);
			keyDown[1] = false;
			player.setMoving(false);
		}
			
		
		
		if (keyDown[0] && !keyDown[1]) {
			player.setVelX(-5);
		}
		
		if (!keyDown[0] && keyDown [1]) {
			player.setVelX(5);
		}
		
		if (!keyDown[0] && !keyDown [1]) {
			player.setVelX(0);
		}
				
		
		break;
				
			case EINSTELLUNGEN:
				
				break;
				
			case MENÜ:
				
				break;
				
			case PAUSE:
				
				break;
				
			case ZURÜCKHAUPTMENÜ:
				
				break;
				
			default:
				
				break;
			
			}
					
	}

/*
*  Die Methode 'keyTyped' (Überschrieben von der Klasse 'KeyListener')
*  reagiert, sobald eine Taste eingegeben wurde.
*/
	
	
	public void keyTyped(KeyEvent arg0) {
		
	}
	
/*
* Ende der Klasse 'KeyInput'	
*/
	
}


