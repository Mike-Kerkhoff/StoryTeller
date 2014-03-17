/*
*@Autor Mike Kerkhoff ©2014 
*/

package gameStarter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import storyTeller_Main.StoryTeller;

public class Window {
	
private static JFrame frame;


public static void initWindow(String title) {
	
	frame = new JFrame(title);
	
}

public static void addGameStarter(GameStarter starter) {
	
	frame.add(starter);
}

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

public void setTitle(String title) {
	
	frame.setTitle(title);
}

public static JFrame getInstance() {
	return frame;
}

}
