/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

import javax.swing.JOptionPane;

import storyTeller_2D_Libraries.Reference;
import storyTeller_2D_Main.StoryTeller_2D;
import storyTeller_2D_Utilities.Files.Textfile;

public class Updater {

	private static String currentVersion;
	private static String newVersion;
	public static int update = 0;
	
	public static void checkForUpdate(boolean isAuto) {
		currentVersion = Textfile.readFile("./Version.txt");
		
		try {
			URL updateSite = new URL("https://raw.github.com/Mike-Kerkhoff/StoryTeller/master/Version.txt");
			Scanner scan = new Scanner(updateSite.openStream());
            newVersion = scan.nextLine();
            scan.close();
            
		} catch (IOException e) {}
		
		if (currentVersion.equals(newVersion)) {
			
			if (!isAuto) {
				
				DoNotUpdate();
			}
			
			return;
			
		} else  {
			
			Object[] options = {"Update", "Do not update"};
			int temp = JOptionPane.showOptionDialog(null, 
			"An update has been found for the StoryTeller (Current version: " + currentVersion + " New version: " + newVersion + ")" 
			+ "\n"
			+ "\n"
			+ "The update may take several minutes."
			+ "\n"
			+ "\n"
			+ "\n"
			+ "Do not close the game while updating."
			+ "\n"
			+ "\n", 
			"Updater", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			
			if (temp == 1) {
				
				return;
				
			} else {
				
				Textfile.writeFile("./Version.txt", newVersion);
				
				try {
					URL updateSite = new URL("https://raw.github.com/Mike-Kerkhoff/StoryTeller/master/Resources/Spritesheets/Charakter-Spritesheet%20450x900.png");
					ReadableByteChannel rbc = Channels.newChannel(updateSite.openStream());
					FileOutputStream fos = new FileOutputStream(Reference.SPRITESHEET_LOCATION + "Charakter-Spritesheet 450x900.png");
					fos.getChannel().transferFrom(rbc, 0, 1 << 24);
					fos.close();
				} catch (IOException e) {}
				
				try {
					URL updateSite = new URL("https://github.com/Mike-Kerkhoff/StoryTeller/raw/master/Resources/Music/Background_Theme1.ogg");
					ReadableByteChannel rbc = Channels.newChannel(updateSite.openStream());
					FileOutputStream fos = new FileOutputStream(Reference.MUSIC_LOCATION + "Background_Theme1.ogg");
					fos.getChannel().transferFrom(rbc, 0, 1 << 24);
					fos.close();
				} catch (IOException e) {}
			
				finishUpdate();
				return;
			}
		}
	}
	
	private static void DoNotUpdate() {
		
		JOptionPane.showMessageDialog(null, "No Update found", "Updater", JOptionPane.INFORMATION_MESSAGE);
		return;
		
	}
	
	private static void finishUpdate() {
		
		JOptionPane.showMessageDialog(null, "StoryTeller has been updated to " + newVersion, "Update completed", JOptionPane.INFORMATION_MESSAGE);
		StoryTeller_2D.exit();
		return;
		
	}
}
