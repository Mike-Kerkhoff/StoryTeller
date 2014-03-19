/*
 *@Autor Mike Kerkhoff ©2014 
 */

package storyTeller_2D_Main;

/*
* Importierte Bibliotheken und Klassen
*/

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
import storyTeller_2D_Screens.Menü;
import storyTeller_2D_Textures.TextureManager;
import storyTeller_2D_World.Chapter;

public class StoryTeller_2D extends Canvas implements Runnable {

/*
* Attribute der Klasse 'StoryTeller_2D' 	
*/
	
	private static final long serialVersionUID = 10L;
	
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 500;
	private static boolean running = false;
	public static final String TITLE = "Story Teller 2D";
	

	private static StoryTeller_2D storyTeller_2D = new StoryTeller_2D();
	public static GameState state = GameState.MENÜ;
	
	private Thread gameRunner;
	private Controller controller;
	private Renderer renderer;
	private Menü menü;
	private MouseInput mouse;
	private TextureManager tex;
	public Chapter chapterOne;
	private Camera camera; 
	
/*
* Main-Methode der Klasse 'StoryTeller_2D'	
*/
	
	public static void main(String[] args) {
			
			Window.initWindow(TITLE);
			Window.addStoryTeller(storyTeller_2D);
			Window.createWindow();
			storyTeller_2D.start();
	}
	
/*
* Die Methode 'getMenü' gibt das zugehörtige Objekt 'menü' der
* Klasse 'StoryTeller_2D' zurück
*/
	
	public Menü getMenü() {
		
		return menü;
	}
	
/*
* Die Methode 'getInstance' gibt das zugehörtige Objekt 'storyTeller_2D' der
* Klasse 'StoryTeller_2D' zurück
*/
	
	public static StoryTeller_2D getInstance() {
		
		return storyTeller_2D;
	}
	
/*
* Die Methode 'getController' gibt das zugehörtige Objekt 'controller' der
* Klasse 'StoryTeller_2D' zurück
*/	
	
	public Controller getController() {
		
		return controller;
	}
	
/*
* Die Methode 'getTextureManager' gibt das zugehörtige Objekt 'tex' der
* Klasse 'StoryTeller_2D' zurück
*/	
		
	public TextureManager getTextureManager() {
			
		return tex;
			
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
		
		controller = new Controller();
		renderer = new Renderer();
		menü = new Menü();
		mouse = new MouseInput();
		tex = new TextureManager();
		chapterOne = new Chapter(1);
		camera = new Camera (0, 0);
		
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		this.addKeyListener(new KeyInput());
		
		
		controller.addObject(new Player(50, 0, Object_IDs.PLAYER, tex));
		
	}

/*
* Tick-Methode	
*/
	
	private void tick() {
		
		if (state == GameState.SPIELEN) {
			
			controller.tick();
			camera.tick();
			
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
			Graphics2D graphics2D = (Graphics2D) graphics;
			graphics.setColor(new Color(6, 0, 40));
			graphics.fillRect(0, 0, getWidth(), getHeight());
		
			renderer.renderBackground(graphics);
			
			if (camera != null) {
	
			graphics2D.translate(camera.getX(), camera.getY());
		
			}
			renderer.renderForeground(graphics);
			
			if (camera != null) {
			graphics2D.translate(-camera.getX(), -camera.getY());
		
			}
			
			bufferStrategy.show();
			graphics.dispose();
	}
	
/*
* Die Methode 'start' startet das Spiel, falls es nicht
* bereits begonnen wurde, und beginnt den Thread 'gameRunner'	
*/
	
	public synchronized void start () {

		if (running)
			
			return;
		
		else 
			
			running = true;
		
		gameRunner = new Thread(this);
		gameRunner.start();
		
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
		
		storyTeller_2D.stop();
		
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
 * Ende der Klasse 'Storyteller_2D'	
 */
	
}
