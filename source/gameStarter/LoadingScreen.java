/*
*@Autor Mike Kerkhoff ©2014 
*/

package gameStarter;

/**
* Importierte Bibliotheken und Klassen.
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import storyTeller_2D_Libraries.Images;
import storyTeller_Main.StoryTeller;

/**
* Die Klasse 'LoadingScreen' kümmert sich um das Laden der Resourcen
* und um das Zeichnen des Ladebildschirms.
*/

public class LoadingScreen {

/**
* Breite des Ladebalkens.
*/
	
	private static int width = 398; 
	
/**
* Anzahl der zu ladenden Resourcen.	
*/
	
	private static int numResources = 6;
	
/**
* Anzahl der bereits geladenen Resourcen.	
*/
	
	private static int loadStatus = 0;
	
/**
* Teilt den Ladebalken durch die Anzahl der zu ladenden Resourcen.	
*/
	private static int loadAdd = width / numResources;
	
/**
* Anzuzeigender Text, während die Resourcen geladen werden.	
*/
	
	private static String message = "Loading Resources";
	
/**
* Die Methode 'render' zeichnet die Objekte der Klasse 'LoadingScreen' 
* auf den Bildschirm.
* 
* @param graphics : ein Objekt der Klasse 'Graphics'
*/
	
	public static void render (Graphics graphics) {
		
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, StoryTeller.WIDTH, StoryTeller.HEIGHT);
		graphics.drawImage(Images.hintergrundbild2, 0, 0, null);
		graphics.setColor(Color.BLACK);
		graphics.fillRect(51, 298, width, 52);
		graphics.setColor(Color.black);
		graphics.fillRect(51, 238, 400, 18);
		graphics.setColor(Color.WHITE);
		graphics.setFont(new Font("Arial", Font.BOLD, 12));
		graphics.drawString(message, 140, 250);
		graphics.setColor(new Color(107, 33, 35));
		graphics.fillRect(52, 299, loadStatus, 50);
		
	}
	
/**
* Die Methode 'loadMore' zählt für den Ladebalken durch, 
* was noch für Elemente geladen werden müssen.	
*/
	
	public static void loadMore() {
		
		loadStatus += loadAdd;
		
	}

/**
* Die Methode 'setMessage' nimmt einen String 'message'
* entgegen und übernimmt diesen, um den Text des Ladebildschirms
* zu updaten.
* 
* @param message : der anzuzeigende Text
*/
	
	public static void setMessage(String message) {
		
		LoadingScreen.message = message;
		
	}
	
}
