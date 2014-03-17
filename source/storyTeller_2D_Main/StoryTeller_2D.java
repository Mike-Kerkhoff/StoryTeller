/*
 *@Autor Mike Kerkhoff �2014 
 */
package storyTeller_2D_Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import org.lwjgl.openal.AL;

import storyTeller_2D_Controller.Controller;
import storyTeller_2D_Entities.Player;
import storyTeller_2D_Enums.GameState;
import storyTeller_2D_Graphics.Camera;
import storyTeller_2D_Graphics.Renderer;
import storyTeller_2D_Graphics.Window;
import storyTeller_2D_Input.KeyInput;
import storyTeller_2D_Input.MouseInput;
import storyTeller_2D_Libraries.Object_IDs;
import storyTeller_2D_Screens.LoadingScreen;
import storyTeller_2D_Screens.Men�;
import storyTeller_2D_Textures.TextureManager;
import storyTeller_2D_Utilities.ResourceLoader;
import storyTeller_2D_World.Chapter;

public class StoryTeller_2D extends Canvas implements Runnable {

	private static final long serialVersionUID = 10L;
	
	private static StoryTeller_2D intro = new StoryTeller_2D();
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 500;
	public static final String TITLE = "Story Teller 2D";
	
	public static GameState state = GameState.LOADING;
	
	private static boolean running = false;
	private Thread gameRunner;
	private Renderer renderer;
	private Men� men�;
	private MouseInput mouse;
	
	private static Controller controller = new Controller();
	
	private static TextureManager tex;
	
	public Chapter chapterOne;
	
	private Camera camera; 
	
	private int time = 100;
	private int counter = 0;
	
	public static void main(String[] args) {
			
			Window.initWindow(TITLE);
			Window.addStoryTeller(intro);
			Window.createWindow();
			intro.start();
	}
	
	public Men� getMen�() {
		
		return men�;
	}
	
	public static StoryTeller_2D getInstance() {
		return intro;
	}
	
	public Controller getController() {
		return controller;
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
			
			tex = new TextureManager();
			counter++;
			LoadingScreen.loadMore();
			return;
	
	case 5:
			
			men� = new Men�();
			counter++;
			LoadingScreen.loadMore();
			return;

	case 6: 
		
			renderer = new Renderer();
			counter++;
			LoadingScreen.loadMore();
			return;
	
	case 7:
		
			mouse = new MouseInput();
			this.addMouseListener(mouse);
			this.addMouseMotionListener(mouse);
			counter++;
			LoadingScreen.loadMore();
			return;
	
	case 8: 
		
			chapterOne = new Chapter(1);
			counter++;
			LoadingScreen.loadMore();
			return;
	
	case 9: 
		
			controller.addObject(new Player(50, 0, Object_IDs.PLAYER, tex));
			camera = new Camera (0, 0);
			this.addKeyListener(new KeyInput());
			
			counter++;
			LoadingScreen.loadMore();
			return;
			
	case 10: 
			
			counter++;
			LoadingScreen.loadMore();
			state = GameState.MEN�;
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
		
		if (state == GameState.BEGINNEN) {
			controller.tick();
			camera.tick();
		}
		
	}

	private void render() {
		
BufferStrategy bufferStrategy = this.getBufferStrategy();
		
		if (bufferStrategy == null) {
			createBufferStrategy(3);
			return;
			
		}
		
			Graphics graphics = bufferStrategy.getDrawGraphics();
			Graphics2D graphics2D = (Graphics2D) graphics;
			graphics.setColor(new Color(6, 0, 40));
			graphics.fillRect(0, 0, getWidth(), getHeight());
		
			if (state == GameState.LOADING) {
				LoadingScreen.render(graphics);
				
			}
			
			else { renderer.renderBackground(graphics);
			
			if (camera != null) {
	
			graphics2D.translate(camera.getX(), camera.getY());
		
			}
			renderer.renderForeground(graphics);
			
			if (camera != null) {
			graphics2D.translate(-camera.getX(), -camera.getY());
		
			}
		}
			
			bufferStrategy.show();
			graphics.dispose();
	}
	
	
	public static Player getPlayer() {
		return null;
	}
	
	public static TextureManager getTextureManager() {
		return tex;
	}

	public synchronized void start () {

		if (running)
			
			return;
		
		else 
			
			running = true;
		
		gameRunner = new Thread(this);
		gameRunner.start();
		
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
		intro.stop();
	}
}
