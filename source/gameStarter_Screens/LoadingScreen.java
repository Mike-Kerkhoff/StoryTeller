/*
*@Autor Mike Kerkhoff ©2014 
*/

package gameStarter_Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import storyTeller_2D_Main.StoryTeller_2D;
import storyTeller_2D_Libraries.Images;

public class LoadingScreen {

	private static int width = 500; 
	private static int numResources = 5;
	private static int loadAdd = width / numResources;
	private static int loadStatus = 0;
	
	private static String message = "Loading Resources";
	
	public static void render (Graphics graphics) {
		
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, StoryTeller_2D.WIDTH, StoryTeller_2D.HEIGHT);
		graphics.drawImage(Images.hintergrundbild3, 0, 0, null);
		graphics.setColor(Color.BLACK);
		graphics.fillRect(51, 398, width, 51);
		graphics.setColor(Color.WHITE);
		graphics.setFont(new Font("Arial", Font.BOLD, 12));
		graphics.drawString(message, 140, 350);
		graphics.setColor(new Color(78, 99, 201));
		graphics.fillRect(52, 399, loadStatus, 50);
	}
	
	public static void loadMore() {
		
		loadStatus += loadAdd;
		
	}
	
	public static void setMessage(String message) {
		
		LoadingScreen.message = message;
	}
	
}
