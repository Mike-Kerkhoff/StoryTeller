/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Libraries;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.image.BufferedImage;

import storyTeller_2D_Main.StoryTeller_2D;

public class Reference {

/*
* Attribute der Klasse 'Reference' 
* 	
* 		Die Klasse 'Reference' dient als Bibliothek für bestimmte 
* 		Konstanten und Datei-Pfade	
*/		
	
/*
* 		SpielKonstanten	
*/
	
	public static final int CENTER_X = StoryTeller_2D.WIDTH / 2;
	public static final int CENTER_Y = StoryTeller_2D.HEIGHT / 2;
	
/*
* 		Hilfskonstanten	
*/
	
	public static final int ALPHA_RGB = BufferedImage.TYPE_INT_ARGB;
	
/*
* 		Datei und Resourcen-Pfade	
*/
	
	public static final String RESOURCE_LOCATION = "./Resources/";
	public static final String SPRITESHEET_LOCATION = RESOURCE_LOCATION + "Spritesheets/";
	public static final String CHAPTER_LOCATION = RESOURCE_LOCATION + "Chapters/";
	public static final String IMAGE_LOCATION = RESOURCE_LOCATION + "Images/";
	public static final String FONT_LOCATION = RESOURCE_LOCATION + "Fonts/";
	public static final String SOUND_LOCATION = RESOURCE_LOCATION + "Sounds/";
	public static final String MUSIC_LOCATION = RESOURCE_LOCATION + "Music/";
	
/*
* Ende der Klasse 'Reference'	
*/
	
}
