/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Screens;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.Color;
import java.awt.Graphics;

import storyTeller_2D_Libraries.Images;
import storyTeller_2D_Libraries.Reference;
import storyTeller_2D_Main.StoryTeller_2D;
import storyTeller_2D_Graphics.Button;

public class Menü {

/*
* Attribute der Klasse 'Menü'	
*/
	
	public Button introBeginnen;
	public Button spielSchließen;
	public Button einstellungen;
	public Button zurückMenü;
	
/*
* Konstruktor der Klasse 'Menü'	
*/
	public Menü () {
		
	int fillerY = 80;
	
	introBeginnen = new Button (Reference.CENTER_X - 100, fillerY, 200, 50).setTitle("Beginnen");
	einstellungen = new Button (Reference.CENTER_X - 100, fillerY + 80, 200, 50).setTitle("Einstellungen");
	zurückMenü = new Button (Reference.CENTER_X - 100, fillerY + 160, 200, 50).setTitle("Zurück zum Story Teller");
	spielSchließen = new Button (Reference.CENTER_X - 100, fillerY + 240, 200, 50).setTitle("Beenden");
	
	}

/*
* Render-Methode	
*/

	public void render(Graphics graphics) {
		
		graphics.setColor(Color.BLUE);
		graphics.fillRect(0, 0, StoryTeller_2D.WIDTH, StoryTeller_2D.HEIGHT);
		graphics.drawImage(Images.hintergrundbild1, 0, 0, null);
		
		introBeginnen.drawButton(graphics, -30);
		spielSchließen.drawButton(graphics, -30);
		einstellungen.drawButton(graphics, -30);
		zurückMenü.drawButton(graphics, -30);

		
	}
	
/*
* Ende der Klasse 'Menü'	
*/
	
}

