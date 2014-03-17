/*
*@Autor Mike Kerkhoff �2014 
*/

package storyTeller_2D_Input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import storyTeller_2D_Enums.GameState;
import storyTeller_2D_Graphics.Window;
import storyTeller_2D_Main.StoryTeller_2D;
import storyTeller_2D_Screens.Men�;
import storyTeller_Main.StoryTeller;

public class MouseInput extends MouseAdapter {
	
	public static int MOUSE_X;
	public static int MOUSE_Y;
	public static Rectangle MOUSE = new Rectangle (1, 1, 1, 1);
	private Men� men� = StoryTeller_2D.getInstance().getMen�();
	
	public void mouseClicked(MouseEvent e) {
		
		int mouse = e.getButton();
		
		if (mouse == MouseEvent.BUTTON1) {
			
			Rectangle rectangle = new Rectangle (e.getX(), e.getY(), 1, 1);
			
				switch (StoryTeller_2D.state) {
				
				case BEENDEN:
					
					break;
					
				case EINSTELLUNGEN:
					
					break;
					
				case BEGINNEN:
					
					break;
					
				case MEN�:
					
					if (rectangle.intersects(men�.introBeginnen)) {
						
						StoryTeller_2D.getInstance().chapterOne.loadChapter();
						StoryTeller_2D.state = GameState.BEGINNEN;
						
					}
					
					else if (rectangle.intersects(men�.spielSchlie�en)) {
						
						StoryTeller_2D.exit();
						
					}
					
					else if (rectangle.intersects(men�.zur�ckMen�)) {
						Window.getInstance().setVisible(false);
						StoryTeller.main(null);
					}
					
					break;
					
				case PAUSE:
					
					break;
					
				case ZUR�CKHAUPTMEN�:
					
					break;
					
				default:
					
					break;
				
			}
				
		}
	}
		
	public void mouseMoved(MouseEvent e) {
		
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();
		
		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
		
	}
}

