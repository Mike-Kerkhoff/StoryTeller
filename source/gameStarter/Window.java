/*
*@Autor Mike Kerkhoff ©2014 
*/

package gameStarter;

/**
* Importierte Bibliotheken und Klassen.
*/

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import storyTeller_Main.StoryTeller;

/**
* Die Klasse 'Window' kümmert sich darum ein Fenster für
* die Klasse 'GameStarter' zu erschaffen.
*/

public class Window {
	
/**
* Fenster für die Klasse 'GameStarter'.		
*/
	
	private static JFrame frame;

/**
* Die Methode 'initWindow' nimmt einen Titel entgegen und iniitiert das JFrame 
* und somit auch das Fenster für die Klasse 'GameStarter'.
* 
* @param title : der Titel für das Fenster
*/

	public static void initWindow(String title) {
		
		frame = new JFrame(title);
		
	}

/**
* Die Methode 'addGameStarter' nimmt ein Objekt der Klasse 'GameStarter' entgegen und 
* fügt den GameStarter zum JFrame hinzu.
* 
*  @param starter : ein Objekt der Klasse 'GameStarter' 
*/

	public static void addGameStarter(GameStarter starter) {
		
		frame.add(starter);
	}

/**
* Die Methode 'createWindow' baut das Fenster auf und definiert die verschiedenen 
* Parameter.
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

/**
* Die Methode 'setTitle' nimmt einen String 'title'
* entgegen und übernimmt diesen.
* 
* @param title : der Titel des JFrames
*/

	public void setTitle(String title) {
		
		frame.setTitle(title);
	}

/**
* Die Methode 'getInstance' gibt das JFrame-Objekt der Klasse 'Window'
* zurück.
* 
* @return das JFrame-Objekt der Klasse 'Window'
*/

	public static JFrame getInstance() {
		return frame;
	}

}
