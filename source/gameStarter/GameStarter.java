/*
*@Autor Mike Kerkhoff ©17.03.2014 
*/
package gameStarter;

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
	
	public static void main(String[] args) {
		
		Window.initWindow(TITLE);
		Window.addGameStarter(starter);
		Window.createWindow();
		starter.start();
	
	}
	
	public static GameStarter getInstance() {
		
		return starter;
		
	}
	
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

	public void init () {
		
		ResourceLoader.preload();
	}
	
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
	
	private void tick() {
			
			if (state == GameState.LOADING) {
				time --;
				if (time <= 0) {
					load();
					time = 50;
				}
				
			}	
			
	}
	
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
	
	public synchronized void start () {

		if (running)
			
			return;
		
		else 
			
			running = true;
		
		gameStarter = new Thread(this);
		gameStarter.start();
		
	}
	
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
		private void cleanUp () {
			
			AL.destroy();
			
		}
		
		public static void exit() {
			
			starter.stop();
			
		}
	
}