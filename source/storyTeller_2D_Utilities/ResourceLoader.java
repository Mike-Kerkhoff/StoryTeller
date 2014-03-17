/*
*@Autor Mike Kerkhoff 2014 
*/

package storyTeller_2D_Utilities;

import storyTeller_2D_Graphics.ChapterLoader;
import storyTeller_2D_Graphics.ImageLoader;
import storyTeller_2D_Graphics.SpritesheetLoader;
import storyTeller_2D_Libraries.Audio;
import storyTeller_2D_Libraries.Chapters;
import storyTeller_2D_Libraries.Fonts;
import storyTeller_2D_Libraries.Images;
import storyTeller_2D_Libraries.Spritesheets;

public class ResourceLoader {
	
	private static ImageLoader imageLoader = new ImageLoader();
	private static SpritesheetLoader spritesheetLoader = new SpritesheetLoader();
	private static ChapterLoader chapterLoader = new ChapterLoader();
	
	public static void preload() {
		
		Images.hintergrundbild3 =  imageLoader.loadImage("background3.jpg");
	}
	
	public static void loadImages() {
		
			
			Images.hintergrundbild1 =  imageLoader.loadImage("background1.jpg");
			Images.hintergrundbild2 =  imageLoader.loadImage("background2.jpg");
			Images.hintergrundbild3 =  imageLoader.loadImage("background3.jpg");
			Images.hintergrundbild4 =  imageLoader.loadImage("background4.jpg");
		
				
	}
	
	public static void loadSpritesheets() {
		
		Spritesheets.spritesheet_blocks = spritesheetLoader.loadImage("Tiles-Spritesheet 500x500.png");
		Spritesheets.spritesheet_player = spritesheetLoader.loadImage("Charakter-Spritesheet 450x900.png");
	}
	
	
	public static void loadChapters() {
		
		Chapters.introA = chapterLoader.loadImage("Level1.png");
		
	}
	public static void loadFonts() {
		
		Fonts.addFont(new Fonts(""));
	}
	
	public static void loadSounds() {
		
		AudioPlayer.addSound(Audio.RAVEN1, "raven1.ogg");
		AudioPlayer.addSound(Audio.COMPUTER_SOUNDS2, "Computer_Sounds2.ogg");
	}
	
	public static void loadMusic() {
		
		AudioPlayer.addMusic(Audio.BACKGROUND_THEME, "Background_Theme1.ogg");
		
	}
	
}
