/*
*@Autor Mike Kerkhoff ©2014 
*/

package gameStarter;

/*
* Importierte Bibliotheken und Klassen
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


public class GameStarter extends Canvas implements Runnable {

/*
* Attribute der Klasse 'GameStarter'	
*/
	
	private static final long serialVersionUID = 10L;
	
	private static GameStarter starter = new GameStarter();
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 500;
	public static final String TITLE = "StoryTeller: Loading";
	
	private static boolean running = false;
	private Thread gameStarter;
	private int time = 100;
	private int counter = 0;
	
	public static GameState state = GameState.LOADING;

/*
* Main-Methode der Klasse 'GameStarter'	
*/
	
	public static void main(String[] args) {
		
		Window.initWindow(TITLE);
		Window.addGameStarter(starter);
		Window.createWindow();
		starter.start();
	
	}
	
/*
* Die Methode 'getInstance' gibt das zugehörtige Objekt 'starter' 
* der Klasse 'GameStarter'zurück
*/
	
	public static GameStarter getInstance() {
		
		return starter;
		
	}
	
/*
* Überschriebene Run-Methode der Klasse 'Runnable'
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

/*
* Init-Methode	
*/
	
	public void init () {
		
		ResourceLoader.preload();
	}
	
/*
* Die Methode 'load' ladet alle Bild-, Musik-, Sound- und Spieldateien. 
* Des Weiteren überprüft die Methode, ob es ein verfügbares Update gibt	
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
	
/*
* Tick-Methode
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
	
/*
* Render-Methode	
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
	
/*
* Die Methode 'start' startet das Spiel, falls es nicht
* bereits begonnen wurde, und beginnt den Thread 'gameStarter'	
*/
	
	public synchronized void start () {

		if (running)
			
			return;
		
		else 
			
			running = true;
		
		gameStarter = new Thread(this);
		gameStarter.start();
		
	}
	
/*
* Die Methode 'cleanUp' säubert das Programm, bevor es beendet wird	
*/
	
	private static void cleanUp () {
		
		AL.destroy();
		
	}
	
/*
* Die Methode 'exit' beendet das Spiel, in dem es die Methode 'stop' aufruft
*/
	
	public static void exit() {
		
		starter.stop();
		
	}
	
/*
* Die Methode 'stop' beendet das Spiel und ruft dabei die Methode
* 'cleanUp' auf, um das Programm vor dem Beenden zu säubern	
*/
	
	public synchronized void stop () {
	
			
			if (!running) {
				
				
				return;
				
			}
			
			else { 
				
				running = false;
			
			}
			
			cleanUp();
			System.exit(1);
			
	}
	
/*
* Ende der Klasse 'GameStarter'	
*/
	
}