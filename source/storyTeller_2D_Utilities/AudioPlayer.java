/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Utilities;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import storyTeller_2D_Libraries.Reference;
import gameStarter_Screens.LoadingScreen;

public class AudioPlayer {

	private static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	
	private static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	public static void addSound(String key, String path) {
		
		LoadingScreen.setMessage("Loading sounds from " + Reference.SOUND_LOCATION);
		
		
		try {
			
			soundMap.put(key, new Sound(Reference.SOUND_LOCATION + path));
			
		} catch (SlickException e) {
			
			System.err.println("Error: Exception");
			
		}
	}
	
	public static void addMusic(String key, String path) {
		
		LoadingScreen.setMessage("Loading music from " + Reference.MUSIC_LOCATION);
		
		try {
			
			musicMap.put(key, new Music(Reference.MUSIC_LOCATION + path));
			
		} catch (SlickException e) {
			
			System.err.println("Error: Exception");
			
		}
	}

	public static Sound getSound(String key) {
		
		return soundMap.get(key);
		
	}
	
	public static Music getMusic(String key) {
		
		return musicMap.get(key);
		
	}
	
	public static void playSound(String key) {
		
		soundMap.get(key).play();
	}
	
public static void playMusic(String key) {
		
		musicMap.get(key).loop();
		
	}
}


