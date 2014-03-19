/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Input;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import storyTeller_2D_Enums.GameState;
import storyTeller_2D_Graphics.Window;
import storyTeller_2D_Main.StoryTeller_2D;
import storyTeller_2D_Screens.Menü;
import storyTeller_Main.StoryTeller;

public class MouseInput extends MouseAdapter {
	
/*
* Attribute der Klasse 'MouseInput'	
*/
	
	public static int MOUSE_X;
	public static int MOUSE_Y;
	public static Rectangle MOUSE = new Rectangle (1, 1, 1, 1);
	private Menü menü = StoryTeller_2D.getInstance().getMenü();

/*
* Die Methode 'mouseClicked' (Überschrieben von der Klasse 'MouseAdapter') reagiert, 
* sobald die Maus betätigt wird	
*/
	
	public void mouseClicked(MouseEvent e) {
		
		int mouse = e.getButton();
		
		if (mouse == MouseEvent.BUTTON1) {
			
			Rectangle rectangle = new Rectangle (e.getX(), e.getY(), 1, 1);
			
				switch (StoryTeller_2D.state) {
				
				case BEENDEN:
					
					break;
					
				case EINSTELLUNGEN:
					
					break;
					
				case SPIELEN:
					
					break;
					
				case MENÜ:
					
					if (rectangle.intersects(menü.introBeginnen)) {
						
						StoryTeller_2D.getInstance().chapterOne.loadChapter();
						StoryTeller_2D.state = GameState.SPIELEN;
						
					}
					
					else if (rectangle.intersects(menü.spielSchließen)) {
						
						StoryTeller_2D.exit();
						
					}
					
					else if (rectangle.intersects(menü.zurückMenü)) {
						Window.getInstance().setVisible(false);
						StoryTeller.main(null);
					}
					
					break;
					
				case PAUSE:
					
					break;
					
				case ZURÜCKHAUPTMENÜ:
					
					break;
					
				default:
					
					break;
				
			}
				
		}
	}
		
/*
* Die Methode 'mouseMoved' (Überschrieben von der Klasse 'MouseAdapter') reagiert, 
* sobald die Maus bewegt wird	
*/	
	
	public void mouseMoved(MouseEvent e) {
		
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();
		
		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
		
	}
	
/*
* Ende der Klasse 'MouseInput'	
*/
	
}

