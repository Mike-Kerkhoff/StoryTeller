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


import storyTeller_2D_Enums.GameState;
import storyTeller_2D_Graphics.Camera;
import storyTeller_2D_Graphics.Window;
import storyTeller_2D_Input.KeyInput;
import storyTeller_2D_Input.MouseInput;
import storyTeller_2D_Screens.Menü;

public class StoryTeller_2D extends Canvas implements Runnable {

/*
* Attribute der Klasse 'StoryTeller_2D' 	
*/
	
	private static final long serialVersionUID = 10L;
	
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 500;
	private static boolean running = false;
	public static final String TITLE = "Story Teller 2D";
	
	public static GameState state = GameState.MENÜ;
	
	private Thread gameRunner;
	private Menü menü;
	private MouseInput mouse;
	private Camera camera; 
	
public StoryTeller_2D () {
	
	menü = new Menü();
	mouse = new MouseInput();
	camera = new Camera (0, 0);
	
	this.addMouseListener(mouse);
	this.addMouseMotionListener(mouse);
	this.addKeyListener(new KeyInput());
	
}
	
/*
* Main-Methode der Klasse 'StoryTeller_2D'	
*/
	
	public static void main(String[] args) {
			
		StoryTeller_2D storyTeller_2D = new StoryTeller_2D();
		Window.createWindow(storyTeller_2D, TITLE);
		storyTeller_2D.start();
			
	}
	

/*
* Überschriebene Run-Methode der Klasse 'Runnable'
*/
	
	public void run() {
	
		requestFocus();
	
		long lastTime = System.nanoTime();
		double amountOfTicks = 60D;
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
	

/*
* Tick-Methode	
*/
	
	private void tick() {
		
		if (state == GameState.SPIELEN) {
			
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
		
/*			
			renderBackground(graphics);
			
			if (camera != null) {
	
			graphics2D.translate(camera.getX(), camera.getY());
		
			}
			
			renderForeground(graphics);
			
			if (camera != null) {
			graphics2D.translate(-camera.getX(), -camera.getY());
		
			}
*/			
			bufferStrategy.show();
			graphics.dispose();
	}
	

	/*private void renderForeground(Graphics graphics) {
	
		
	}


	private void renderBackground(Graphics graphics) {
	
	}
*/
	
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
	
	private void cleanUp () {
		
		AL.destroy();
		
	}
	
/*
* Die Methode 'exit' beendet das Spiel, in dem es die Methode 'stop' aufruft
*/	
	
	public static void exit() {
		
		
		storyTeller_2D.cleanUp();
		
		System.exit(0);
		
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
		
		try {
			
			gameRunner.join();
			
		} catch (InterruptedException e) {
			
		}
		
		storyTeller_2D.cleanUp();
		System.exit(1);
		
		}

/*
 * Ende der Klasse 'Storyteller_2D'	
 */
	
}
