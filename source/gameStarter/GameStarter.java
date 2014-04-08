/**
*@Autor Mike Kerkhoff ©2014 
*/

package gameStarter;

/**
* Importierte Bibliotheken und Klassen.
*/

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import org.lwjgl.openal.AL;

import storyTeller_2D_Enums.GameState;
import storyTeller_2D_Utilities.ResourceLoader;
import storyTeller_2D_Utilities.Updater;
import storyTeller_Main.StoryTeller;

/**
* Die Klasse 'GameStarter' erbt von der Klasse 'Canvas' und 
* implementiert die Klasse 'Runnable'. Sie startet das Programm 
* 'StoryTeller' und kümmert sich darum Updates und Resourcen direkt
* am Anfang zu laden.
*/

public class GameStarter extends Canvas implements Runnable {

/**
* Eine zufällig generierte 'serialVersionUID'.		
*/
	
	private static final long serialVersionUID = 10L;
	
/**
* Das Objekt 'starter' ist ein Objekt der Klasse 'GameStarter'.
*/
	
	private static GameStarter starter = new GameStarter();
	
/**
* Die Integer-Konstante 'WIDTH' ist die Breite der Klasse 'GameStarter'.	
*/
	
	public static final int WIDTH = 600;
	
/**
* Die Integer-Konstante 'HEIGHT' ist die Höhe der Klasse 'GameStarter'.	
*/
	
	public static final int HEIGHT = 500;
	
/**
* Die String-Konstante 'TITLE' ist der Titel der Klasse 'GameStarter'.	
*/
	
	public static final String TITLE = "StoryTeller: Loading";
	
/**
* Der Boolean 'running' besagt, ob das Spiel am Laufen ist.
*/
	
	private static boolean running = false;
	
/**
* Der Thread 'gameStarter' ist der Haupt-Thread des Spiels.
*/
	
	private Thread gameStarter;
	
/**
* Der Integer 'time' ist eine Hilfsvariable für das Laden der Resourcen.
*/
	private int time = 100;
	
/**
* Der Integer 'counter' ist eine Hilfvariable für das Laden der Resourcen.
*/
	
	private int counter = 0;
	
/**
* Der GameState 'state' verwaltet den Status des Spiels.
*/
	
	public static GameState state = GameState.LOADING;

/**
* Die Main-Methode der Klasse 'GameStarter'.
*/
	
	public static void main(String[] args) {
		
		Window.createWindow(starter, TITLE);
		starter.start();
	
	}
	
/**
* Die Methode 'getInstance' gibt Zugang auf die nicht statischen 
* Elemente der Klasse 'GameStarter'. 
* 
* @return starter : ein Objekt der Klasse 'GameStarter'
*/
	
	public static GameStarter getInstance() {
		
		return starter;
		
	}
	
/**
* Die Methode 'run' startet die Spiel-Schleife, in der sowohl die Tick- und 
* Render-Methode, wie auch die Methode 'init' aufgerufen werden.
*/
	
	public void run() {
	
			
			init();
		
			long lastTime = System.nanoTime();
			final Double amountOfTicks = 60D;
			double ns = 1_000_000_000 / amountOfTicks;
			double delta = 0;
			
			while (running) {
				
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				
				if (delta >= 1) {
					tick();
					delta--;
					
				}
				
				 render();
			}
			
			stop();
		}

/**
* Die Methode 'init' wird zuallerst beim starten des Programms aufgerufen
* und kümmert sich darum die ersten Elemente des Spiels zu laden.
*/
	
	public void init () {
		
		ResourceLoader.preload();
		
	}
		
/**
* Die Methode 'load' ladet alle Bild-, Musik-, Sound- und Spieldateien. 
* Des Weiteren überprüft die Methode, ob es ein verfügbares Update gibt.	 	
*/
	
	private void load() {
		
		switch (counter) {
		
		case 0: 
				ResourceLoader.loadImages();
				counter++;
				LoadingScreen.loadMore();
				return;
		
		case 1:
				ResourceLoader.loadMusic();
				counter++;
				LoadingScreen.loadMore();
				return;
		
		case 2: 
				ResourceLoader.loadSounds();
				counter++;
				LoadingScreen.loadMore();
				return;
		
		case 3:
				ResourceLoader.loadSpritesheets();
				counter++;
				LoadingScreen.loadMore();
				return;
		case 4: 
			
				ResourceLoader.loadChapters();
				counter++;
				LoadingScreen.loadMore();
				return;
			
		case 5: 
				
				Updater.checkForUpdate(true);
				counter++;
				LoadingScreen.loadMore();
				return;
				
		case 6: 
		
				counter++;
				LoadingScreen.loadMore();
				Window.getInstance().setVisible(false);
				StoryTeller.main(null);
				return;
				
		}
			
	}
	
/**
* Die Methode 'tick' updatet die Objekte der Klasse 'GameStarter'.
*/
	
	private void tick() {
			
		if (state == GameState.LOADING) {
			
				time --;
				
				if (time <= 0) {
					
					load();
					time = 50;
			}
				
		}	
			
	}
	
/**
* Die Methode 'render' zeichnet die Objekte der Klasse 'GameStarter' 
* auf den Bildschirm.
*/
	
	private void render() {
		
		BufferStrategy bufferStrategy = this.getBufferStrategy();
		
		if (bufferStrategy == null) {
			createBufferStrategy(3);
			return;
			
		}
		
			Graphics graphics = bufferStrategy.getDrawGraphics();
			graphics.setColor(new Color(6, 0, 40));
			graphics.fillRect(0, 0, getWidth(), getHeight());
		
		if (state == GameState.LOADING) {
			
			LoadingScreen.render(graphics);
				
			}
		
			bufferStrategy.show();
			graphics.dispose();
	}
	
/**
* Die Methode 'start' startet das Spiel, falls es nicht
* bereits begonnen wurde, und beginnt in diesem Fall auch den Thread 'gameStarter'.	
*/
	
	public synchronized void start () {

		if (running)
			
			return;
		
		else 
			
			running = true;
		
		gameStarter = new Thread(this);
		gameStarter.start();
		
	}
	
/**
* Die Methode 'cleanUp' säubert das Programm, bevor es beendet wird.	
*/
	
	private void cleanUp () {
		
		AL.destroy();
		
	}
	
/**
* Die Methode 'exit' beendet das Spiel, in dem es die Methode 'stop' aufruft.
*/
	
	public static void exit() {
		
		starter.cleanUp();
		starter.stop();
		
	}
	
/**
* Die Methode 'stop' beendet das Spiel und ruft dabei die Methode
* 'cleanUp' auf, um das Programm vor dem Beenden zu säubern.	
*/
	
	public synchronized void stop () {
	
			
			if (!running) {
				
				
				return;
				
			}
			
			else { 
				
				running = false;
			
			}
			
			starter.cleanUp();
			System.exit(1);
			
	}
	
}