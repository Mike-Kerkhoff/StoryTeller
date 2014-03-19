/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_Main;

/*
* Importierte Bibliotheken und Klassen
*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import storyTeller_Locations.LaborStart;
import storyTeller_Locations.SchlafzimmerStart;

public class Speicherplatz {
	
/*
* Attribute der Klasse 'Speicherplatz':
* 
* 	Der int 'speicherplatz' dient als Speichervariable
* 
* 	Der int 'kapitelJoseph' dient als Speichervariable
* 
* 	Der int 'kapitelAlaine' dient als Speichervariable
* 
* 	Der String 'userName' dient als Erkennung des Benutzers
*/
 
public static int speicherplatz = 0;
public static int kapitelJoseph = 1;
public static int kapitelAlaine = 1;
public static String userName;

/*
* Gibt den int 'speicherplatz' zurück
*/

public static int getSpeicherplatz() {
	
	return speicherplatz;
	
	}

/*
* Gibt den int 'kapitelJoseph' zurück
*/

public static int getKapitelJoseph() {
	
	return kapitelJoseph;
	
}

/*
* Gibt den int 'KapitelAlaine' zurück
*/

public static int getKapitelAlaine() {
	
	return kapitelAlaine;
	
}

/*
* Gibt den String 'userName' zurück
*/

public static String getUserName() {
	
	return userName;
	
}

/*
* Setzt den int 'speicherplatz' wieder auf den Wert
* 0 zurück
*/

public static void resetSpeicherplatz() {
	
	speicherplatz = 0;
	
}

/*
* Setzt den int 'kapitelJoseph' wieder auf den Grundwert
* 1 zurück
*/

public static void resetKapitelJoseph() {
	
	kapitelJoseph = 1;
	
}

/*
* Setzt den int 'kapitelAlaine' wieder auf den Grundwert
* 1 zurück
*/

public static void resetKapitelAlaine() {
	
	kapitelAlaine = 1;
	
}

/*
* Liest aus der Datei 'Spielstand.txt' den zuletzt gespeicherten Wert
* von 'speicherplatz' heraus und speichert diesen, um anschließend anhand 
* mehreren If-Anweisungen den Wert 'speicherplatz' auszuwerten und das spiel 
* an entsprechender Stelle zu laden.
* 
* Liest aus der Datei 'KapitelJ.txt' den zuletzt gespeicherten Wert 
* von 'kapitelJoseph' heraus und speichert diesen.
* 
* Liest aus der Datei 'KapitelA.txt' den zuletzt gespeicherten Wert 
* von 'kapitelJoseph' heraus und speichert diesen.
* 
*/

public static void spielLaden() {
	
	FileInputStream in1;
	FileInputStream in2;
	FileInputStream in3;
	DataInputStream intIn1;
	DataInputStream intIn2;
	DataInputStream intIn3;
	
	try {
		in1 = new FileInputStream("Spielstand.txt");
		in2 = new FileInputStream("KapitelA.txt");
		in3 = new FileInputStream("KapitelJ.txt");
		
		intIn1 = new DataInputStream(in1);
		intIn2 = new DataInputStream(in2);
		intIn3 = new DataInputStream(in3);
		
		speicherplatz = intIn1.readInt();
		kapitelJoseph = intIn2.readInt();
		kapitelAlaine = intIn3.readInt();
		
		intIn1.close();
		intIn2.close();
		intIn3.close();
		
		
	} catch (FileNotFoundException e) {
		System.out.println("Error: File not found");
	} catch (IOException e) {
		System.out.println("Error: IO-Exception");
	}
	
	
	 if (speicherplatz == 1) {
		 SchlafzimmerStart.main(null);
	 }
	 if (speicherplatz == 2) {
		 LaborStart.main(null);
	 }

	
	
}

/*
* Schreibt in die Datei 'Spielstand.txt' den aktuellen Wert für 'speicherplatz'
* herein, um so das Spiel zu speichern. Zusätzlich nimmt die Methode die Werte
* der Variablen 'kapitelAlaine' und 'kapitelJoseph', um sie in die Speicherdateien
* 'KapitelA.txt' und 'KaputelJ.txt' zu speichern
*/

public static void spielSpeichern() {
	FileOutputStream out1;
	FileOutputStream out2;
	FileOutputStream out3;
	DataOutputStream intOut1;
	DataOutputStream intOut2;
	DataOutputStream intOut3;
	
	try {
	
		out1 = new FileOutputStream ("Spielstand.txt");
		out2 = new FileOutputStream ("KapitelJ.txt");
		out3 = new FileOutputStream ("KapitelA.txt");
		
		intOut1 = new DataOutputStream(out1);
		intOut2 = new DataOutputStream(out2);
		intOut3 = new DataOutputStream(out3);
		
		intOut1.writeInt(speicherplatz);
		intOut2.writeInt(kapitelJoseph);
		intOut3.writeInt(kapitelAlaine);
		intOut1.close();
		intOut2.close();
		intOut3.close();
		
	} catch (FileNotFoundException e) {
		System.err.println("Error: File not found");
	} catch (IOException e) {
		System.err.println("Error: IO-Exception");
	}
}

/*
* Ende der Klasse Speicherplatz
*/

}

	
