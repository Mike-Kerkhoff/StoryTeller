/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import storyTeller_2D_Main.StoryTeller_2D;

public class Window {
	
/*
* Attribute der Klasse 'Window'
*/	
	
	private static JFrame frame;

/*
* Die Methode 'initWindow' iniitiert das JFrame 
* und das Ladefenster
*/

	public static void initWindow(String title) {
		
		frame = new JFrame(title);
		
	}

/*
* Die Methode 'addStoryTeller' fügt den StoryTeller_2D
* zum JFrame hinzu 
*/

	public static void addStoryTeller(StoryTeller_2D storyTeller) {
		
		frame.add(storyTeller);
	}

/*
* Die Methode 'createWindow' baut das Fenster auf
* und definiert die verschiedenen Parameter
*/

	public static void createWindow() {
		
		frame.setResizable(false);
		frame.setSize(StoryTeller_2D.WIDTH, StoryTeller_2D.HEIGHT);
		frame.addWindowListener(
				
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						StoryTeller_2D.exit();
					}
				}
				);
		
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		
	}

/*
* Die Methode 'setTitle' nimmt einen String 'title'
* entgegen und übernimmt diesen
*/

	public void setTitle(String title) {
		
		frame.setTitle(title);
	}

/*
* Die Methode 'getInstance' gibt das JFrame-Objekt
* zurück
*/

	public static JFrame getInstance() {
		return frame;
	}

/*
* Ende der Klasse 'Window'
*/

}
