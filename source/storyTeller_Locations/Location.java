/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_Locations;

/*
* Importierte Bibliotheken und Klassen
*/

import javax.swing.JFrame;

public class Location extends JFrame {

	private static final long serialVersionUID = 1L;

/*
* Attribute der Klasse 'Location':
* 		
* 	Der String 'name' stellt den Namen der Klasse 'Location' dar
* 		
* 	Der String 'land' stellt das Land der Klasse 'Location' dar
* 		
* 	Der String 'stadt' stellt die Stadt der Klasse 'Location' dar
*
* 	Der int 'spielStand' beschreibt den Standpunkt der Klasse 'Location'
* 	im Bezug auf die Geschichte. Sie wird als Speicher-Variable benutzt
*/		

		protected String name;
		protected String land;
		protected String stadt;
		protected int spielStand;
		
/*
* Konstruktor der Klasse 'Location'
*/
		
public Location (String title, String name, String Land, String Stadt, int spielStand) {
			
		super(title);
		
	}
  
/*
* Gibt den Namen der Location zurück
*/

	public String getLocationName() {
		
	return name;
	
	}
	
/*
* Gibt das Land der Location zurück	
*/
	
	public String getLocationLand() {
		
	return land;
	
	}
	
/*
* Gibt die Stadt der Location zurück	
*/
	
	public String getLocationStadt() {
		
	return stadt;
	
	}
	
/*
* Gibt den Spielstand zurück	
*/
	
	public int getspielStand() {
		
	return spielStand;
	
	}

/*
* Setzt den Namen der Location anhand eines übergegebenen Strings 'name'
*/
	
	public void setLocationName (String name) {
	this.name = name;
	}
	
/*
* Setzt das Land der Location anhand eines übergegebenen Strings 'land'
*/
	
	public void setLocationLand (String land) {
	this.land = land;
	}
	
/*
* 		Setzt die Stadt der Location anhand eines übergegebenen Strings 'stadt'	
*/
	
	public void setLocationStadt (String stadt) {
	this.stadt = stadt;
	}
	
/*
* Setzt den Spielstand der Location anhand eines übergegebenen int 'spielStand'
*/
	
	public void setSpielstand (int spielStand) {
		
	this.spielStand = spielStand;
	
	}
	
/*
* Ende der Klasse 'Location'
*/	

}