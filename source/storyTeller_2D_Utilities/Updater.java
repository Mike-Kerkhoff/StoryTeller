/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Utilities;

import storyTeller_2D_Utilities.Files.Textfile;

public class Updater {

	private static String currentVersion;
	private static String newVersion;
	public static int update = 0;
	
	public static void checkForUpdate(boolean isAuto) {
		currentVersion = Textfile.readFile("./Version.text");
		
	}
	
}
