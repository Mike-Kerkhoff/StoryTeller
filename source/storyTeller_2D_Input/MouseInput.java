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

public class MouseInput extends MouseAdapter {
	
/*
* Attribute der Klasse 'MouseInput'	
*/
	
	public static int MOUSE_X;
	public static int MOUSE_Y;
	public static Rectangle MOUSE = new Rectangle (1, 1, 1, 1);

/*
* Die Methode 'mouseClicked' (Überschrieben von der Klasse 'MouseAdapter') reagiert, 
* sobald die Maus betätigt wird	
*/
	
	public void mouseClicked(MouseEvent e) {
		
		int mouse = e.getButton();	
	
	}
		
/*
* Die Methode 'mouseMoved' (Überschrieben von der Klasse 'MouseAdapter') reagiert, 
* sobald die Maus bewegt wird	
*/	
	
	public void mouseMoved(MouseEvent e) {
		
	}
	
/*
* Ende der Klasse 'MouseInput'	
*/
	
}

