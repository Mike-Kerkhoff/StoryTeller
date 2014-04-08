/*
*@Autor Mike Kerkhoff �2014 
*/

package storyTeller_2D_Input;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




public class KeyInput implements KeyListener {

/*
* Attribute der Klasse 'KeyInput'	
*/
	
	private boolean [] keys = new boolean[256];
	

/*
*  Die Methode 'keyPressed' (�berschrieben von der Klasse 'KeyListener')
*  reagiert, sobald eine Taste gedr�ckt wurde.
*/
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		keys [key] = true;
		
	}

/**
*  Die Methode 'keyReleased' (�berschrieben von der Klasse 'KeyListener')
*  reagiert, sobald eine Taste losgelassen wurde.
*/
	
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		keys [key] = false;
					
	}

/**
*  Die Methode 'keyTyped' (�berschrieben von der Klasse 'KeyListener')
*  reagiert, sobald eine Taste eingegeben wurde.
*/
	
	
	public void keyTyped(KeyEvent arg0) {
		
	}
	
/*
* Ende der Klasse 'KeyInput'	
*/
	
}


