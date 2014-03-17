/*
*@Autor Mike Kerkhoff �2014 
*/

package gameStarter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import storyTeller_2D_Libraries.Images;
import storyTeller_Main.StoryTeller;

public class LoadingScreen {

	private static int width = 398; 
	private static int numResources = 6;
	private static int loadAdd = width / numResources;
	private static int loadStatus = 0;
	
	private static String message = "Loading Resources";
	
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
	
	public static void loadMore() {
		
		loadStatus += loadAdd;
		
	}
	
	public static void setMessage(String message) {
		
		LoadingScreen.message = message;
	}
	
}
