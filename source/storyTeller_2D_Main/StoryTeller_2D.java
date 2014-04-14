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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import org.lwjgl.openal.AL;

import storyTeller_2D_Graphics.Screen;
import storyTeller_2D_Graphics.Spritesheet;
import storyTeller_2D_Libraries.Spritesheets;

public class StoryTeller_2D extends Canvas implements Runnable {

/*
* Attribute der Klasse 'StoryTeller_2D' 	
*/
	
	private static final long serialVersionUID = 10L;
	
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 500;
	public static final String TITLE = "Story Teller 2D";
	
	private JFrame frame;
	private Thread gameRunner;
	private Screen screen;
	
	
	private BufferedImage screenImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	private int [] pixels = ((DataBufferInt)screenImage.getRaster().getDataBuffer()).getData();
	
	private static boolean running = false;
	
public StoryTeller_2D () {
	
	screen = new Screen (WIDTH, HEIGHT);
	
	frame = new JFrame(TITLE);
	frame.setSize(WIDTH, HEIGHT);
	frame.setResizable(false);
	frame.addWindowListener(
			
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					exit();
				}
			}
			);
	
	frame.setFocusable(true);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.add(this);
	frame.setVisible(true);
	frame.pack();	
	
}
	
/*
* Main-Methode der Klasse 'StoryTeller_2D'	
*/
	
	public static void main(String[] args) {
			
		StoryTeller_2D storyTeller_2D = new StoryTeller_2D();
		
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
		Boolean shouldRender = false;
		
		while (running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if (delta >= 1) {
				
				tick();
				delta--;
				shouldRender = true;
				
			}
			
			if (shouldRender) {
				
			 render();
			 
			}
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
			screen.clear();
			screen.render();
			for (int i = 0; i < pixels.length; i++) {
				pixels[i] = screen.pixels[i];
			}
		
			Graphics graphics = bufferStrategy.getDrawGraphics();
			graphics.setColor(new Color(6, 0, 40));
			graphics.fillRect(0, 0, getWidth(), getHeight());
			graphics.drawImage(screenImage, 0, 0, getWidth(), getHeight(), null);
		
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
		
		
		cleanUp();
		
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
		
		cleanUp();
		System.exit(1);
		
		}

/*
 * Ende der Klasse 'Storyteller_2D'	
 */
	
}
