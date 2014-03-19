/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Utilities;

/*
* Importierte Bibliotheken und Klassen
*/

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import storyTeller_2D_Libraries.Reference;
import gameStarter.LoadingScreen;

public class AudioPlayer {

/*
* Attribute der Klasse 'AudioPlayer'	
*/
	
	private static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	
	private static Map<String, Music> musicMap = new HashMap<String, Music>();
	
/*
* Die Methode 'addSound' nimmt einen String 'key' und einen String 'path'
* entgegen, um eine Sound-Datei in die Map 'soundMap' zu laden.	
*/
	
	public static void addSound(String key, String path) {
		
		LoadingScreen.setMessage("Loading sounds from " + Reference.SOUND_LOCATION);
		
		
		try {
			
			soundMap.put(key, new Sound(Reference.SOUND_LOCATION + path));
			
		} catch (SlickException e) {
			
			System.err.println("Error: Exception");
			
		}
		
	}
	
/*
* Die Methode 'addMusic' nimmt einen String 'key' und einen String 'path'
* entgegen, um eine Musik-Datei in die Map 'musicMap' zu laden.	
*/	
	
	public static void addMusic(String key, String path) {
		
		LoadingScreen.setMessage("Loading music from " + Reference.MUSIC_LOCATION);
		
		try {
			
			musicMap.put(key, new Music(Reference.MUSIC_LOCATION + path));
			
		} catch (SlickException e) {
			
			System.err.println("Error: Exception");
			
		}
	}
	
/*
* Die Methode 'getSound' nimmt einen String 'key' entgegen, um eine
* Sound-Datei zurückzugeben
*/

	public static Sound getSound(String key) {
		
		return soundMap.get(key);
		
	}
	
/*
* Die Methode 'getMusic' nimmt einen String 'key' entgegen, um eine
* Musik-Datei zurückzugeben
*/	
	
	public static Music getMusic(String key) {
		
		return musicMap.get(key);
		
	}
	
/*
* Die Methode 'playSound' nimmt einen String 'key' entgegen, um eine
* Sound-Datei abzuspielen	
*/
	
	public static void playSound(String key) {
		
		soundMap.get(key).play();
	}
	
/*
* Die Methode 'playMusic' nimmt einen String 'key' entgegen, um eine
* Musik-Datei abzuspielen	
*/	
	
public static void playMusic(String key) {
		
		musicMap.get(key).loop();
		
	}

/*
* Ende der Klasse 'AudioPlayer'
*/

}


