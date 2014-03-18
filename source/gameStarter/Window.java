/*
*@Autor Mike Kerkhoff �2014 
*/

package gameStarter;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import storyTeller_Main.StoryTeller;

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
* Die Methode 'addGameStarter' f�gt den GameStarter
* zum JFrame hinzu 
*/

	public static void addGameStarter(GameStarter starter) {
		
		frame.add(starter);
	}

/*
* Die Methode 'createWindow' baut das Fenster auf
* und definiert die verschiedenen Parameter
*/

	public static void createWindow() {
		
		frame.setResizable(false);
		frame.setSize(StoryTeller.WIDTH, StoryTeller.HEIGHT);
		frame.addWindowListener(
				
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						GameStarter.exit();
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
* entgegen und �bernimmt diesen
*/

	public void setTitle(String title) {
		
		frame.setTitle(title);
	}

/*
* Die Methode 'getInstance' gibt das JFrame-Objekt
* zur�ck
*/

	public static JFrame getInstance() {
		return frame;
	}

/*
* Ende der Klasse 'Window'
*/

}
