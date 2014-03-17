/*
*@Autor Mike Kerkhoff �2014 
*/

package storyTeller_Main;

/*
* Importierte Bibliotheken und Klassen
*/


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// import StoryTeller_Main_Locations.IntroJ;









import org.lwjgl.openal.AL;

import storyTeller_2D_Libraries.Audio;
import storyTeller_2D_Libraries.Images;
import storyTeller_2D_Utilities.AudioPlayer;
import storyTeller_2D_Utilities.ResourceLoader;
import storyTeller_Main_Locations.LaborStart;
import storyTeller_Main_Locations.SchlafzimmerStart;

public class StoryTeller extends JFrame implements ActionListener {
	
private static final long serialVersionUID = 1L;


/*
* Attribute der Klasse StoryTeller
*  
* 		Attribute des Hauptmen�s
*/

private JButton auswahl;
private JButton credits;
private JButton spielLaden;
private JButton einstellungen;
private JButton spielEnde;
protected Image background;
protected ImageIcon hintergrund;


/*
* 		Attribute der Geschichten-Auswahl
*/

private JButton newEden;
private JButton zwischenDenWeltenspiegeln;
private JButton zur�ckMen�;

/*
* 		Attribute der Spielstand-Auswahl
*/

private JButton spielStand;
private JButton spielStandReset;
private JButton zur�ckMen�2;

/*
* 		Attribute der Charakter-Auswahl
*/

protected JLabel textWillkommen;
protected JLabel charakterAuswahl;
protected JButton alaine;
protected JButton joseph;

/*
* 		Attribute der Kapitel-Auswahl f�r Alaine
*/

protected JLabel kapitelauswahlA;
protected JButton introA;
protected JButton kapitelA1;
protected JButton kapitelA2;
protected JButton nextPage1;
protected JButton zur�ckMen�3;

/*
* 		Attribute der Kapitel-Auswahl f�r Joseph
*/

protected JLabel kapitelauswahlJ;
protected JButton introJ;
protected JButton kapitelJ1;
protected JButton kapitelJ2;
protected JButton nextPage2;
protected JButton zur�ckMen�4;

/*
* Konstruktor der Klasse StoryTeller
*/
	
	public StoryTeller (String title) {
		
		super (title);

		
/*
* Laden des Hintergrundbildes
*/
		ResourceLoader.loadImages();
		this.setContentPane(new JLabel(new ImageIcon(Images.hintergrundbild4)));
	
		
/* 
* Initiierung der Hauptmen� Elemente		
*/
		
		auswahl = new JButton ("Auswahl der Geschichte");
		auswahl.setBounds(155, 60, 180, 30);
		auswahl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		auswahl.addActionListener(this);
		auswahl.setVisible(true);
		add(auswahl);
		
		credits = new JButton ("Credits");
		credits.setBounds(155, 130, 180, 30);
		credits.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		credits.addActionListener(this);
		credits.setVisible(true);
		add(credits);
		
		spielLaden = new JButton ("Spiel Laden");
		spielLaden.setBounds(155, 200, 180, 30);
		spielLaden.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		spielLaden.addActionListener(this);
		spielLaden.setVisible(true);
		add(spielLaden);
		
		einstellungen = new JButton ("Einstellungen");
		einstellungen.setBounds(155, 270, 180, 30);
		einstellungen.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		einstellungen.addActionListener(this);
		einstellungen.setVisible(true);
		add(einstellungen);

		spielEnde = new JButton ("Spiel beenden");
		spielEnde.setBounds(155, 340, 180, 30);
		spielEnde.addActionListener(this);
		spielEnde.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		add(spielEnde);
			
/* 
* Initiierung der Geschichten-Auswahl Elemente
*/
		
		newEden = new JButton ("New Eden");
		newEden.setBounds(155, 50, 180, 30);
		newEden.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		newEden.addActionListener(this);
		newEden.setVisible(false);
		add(newEden);
		
		zwischenDenWeltenspiegeln = new JButton ("Zwischen den Weltenspiegeln");
		zwischenDenWeltenspiegeln.setBounds(155, 120, 180, 30);
		zwischenDenWeltenspiegeln.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		zwischenDenWeltenspiegeln.addActionListener(this);
		zwischenDenWeltenspiegeln.setEnabled(false);
		zwischenDenWeltenspiegeln.setVisible(false);
		add(zwischenDenWeltenspiegeln);
		
		
		
		zur�ckMen� = new JButton ("Zur�ck zum Hauptmen�");
		zur�ckMen�.setBounds(155, 190, 180, 30);
		zur�ckMen�.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		zur�ckMen�.addActionListener(this);
		zur�ckMen�.setVisible(false);
		add(zur�ckMen�);
		
		
/*
* Initiierung der SpielStand-Auswahl Elemente		
*/
		
		spielStand = new JButton ("Spiel laden");
		spielStand.setBounds(155, 60, 180, 30);
		spielStand.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		spielStand.addActionListener(this);
		spielStand.setVisible(false);
		add(spielStand);
		
		spielStandReset = new JButton ("Spielstand l�schen");
		spielStandReset.setBounds(155, 130, 180, 30);
		spielStandReset.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		spielStandReset.addActionListener(this);
		spielStandReset.setVisible(false);
		add(spielStandReset);
		
		zur�ckMen�2 = new JButton ("Zur�ck zum Hauptmen�");
		zur�ckMen�2.setBounds(155, 200, 180, 30);
		zur�ckMen�2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		zur�ckMen�2.addActionListener(this);
		zur�ckMen�2.setVisible(false);
		add(zur�ckMen�2);
		
/*
* Initiierung der Charakter-Auswahl Elemente		
*/
		
		alaine = new JButton ("Alaine");
		alaine.setBounds(155, 100, 180, 30);
		alaine.setVisible(false);
		alaine.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		alaine.addActionListener(this);
		alaine.setVisible(false);
		add(alaine);
		
		joseph = new JButton ("Joseph");
		joseph.setBounds(155, 200, 180, 30);
		joseph.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		joseph.addActionListener(this);
		joseph.setVisible(false);
		add(joseph);
		
		
/*
* Initiierung der Kapitel-Auswahl Elemente f�r Alaine
*/
		
		kapitelauswahlA = new JLabel ("W�hlen Sie ein gew�nschtes Kapitel:");
		kapitelauswahlA.setBounds (120, 5, 280, 30);
		kapitelauswahlA.setForeground(Color.WHITE);
		kapitelauswahlA.setVisible(false);
		add(kapitelauswahlA);
		
		
		
		introA = new JButton ("Intro");
		introA.setBounds(155, 60, 180, 30);
		introA.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		introA.addActionListener(this);
		introA.setEnabled(false);
		introA.setVisible(false);
		add(introA);
		
		
		kapitelA1 = new JButton ("Erstes Kapitel");
		kapitelA1.setBounds(155, 130, 180, 30);
		kapitelA1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		kapitelA1.addActionListener(this);
		kapitelA1.setEnabled(true);
		kapitelA1.setVisible(false);
		add(kapitelA1);
		
		kapitelA2 = new JButton ("Zweites Kapitel");
		kapitelA2.setBounds(155, 200, 180, 30);
		kapitelA2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		kapitelA2.addActionListener(this);
		kapitelA2.setEnabled(false);
		kapitelA2.setVisible(false);
		add(kapitelA2);
		
		nextPage1 = new JButton ("N�chste Seite");
		nextPage1.setBounds(155, 350, 180, 30);
		nextPage1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		nextPage1.addActionListener(this);
		nextPage1.setEnabled(false);
		nextPage1.setVisible(false);
		add(nextPage1);
		
		
		zur�ckMen�3 = new JButton ("Zur�ck zum Hauptmen�");
		zur�ckMen�3.setBounds(155, 400, 180, 30);
		zur�ckMen�3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		zur�ckMen�3.addActionListener(this);
		zur�ckMen�3.setEnabled(true);
		zur�ckMen�3.setVisible(false);
		add(zur�ckMen�3);
			
/*
* Initiierung der Kapitel-Auswahl Elemente f�r Joseph
*/
		kapitelauswahlJ = new JLabel ("W�hlen Sie ein gew�nschtes Kapitel:");
		kapitelauswahlJ.setBounds (120, 5, 280, 30);
		kapitelauswahlJ.setForeground(Color.BLACK);
		kapitelauswahlJ.setVisible(false);
		add(kapitelauswahlJ);
		
		introJ = new JButton ("Intro");
		introJ.setBounds(155, 60, 180, 30);
		introJ.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		introJ.addActionListener(this);
		introJ.setEnabled(false);
		introJ.setVisible(false);
		add(introJ);
		
		kapitelJ1 = new JButton ("Erstes Kapitel");
		kapitelJ1.setBounds(155, 130, 180, 30);
		kapitelJ1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		kapitelJ1.addActionListener(this);
		kapitelJ1.setEnabled(true);
		kapitelJ1.setVisible(false);
		add(kapitelJ1);
		
		kapitelJ2 = new JButton ("Zweites Kapitel");
		kapitelJ2.setBounds(155, 200, 180, 30);
		kapitelJ2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		kapitelJ2.addActionListener(this);
		kapitelJ2.setEnabled(false);
		kapitelJ2.setVisible(false);
		add(kapitelJ2);
		
		nextPage2 = new JButton ("N�chste Seite");
		nextPage2.setBounds(155, 350, 180, 30);
		nextPage2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		nextPage2.addActionListener(this);
		nextPage2.setEnabled(false);
		nextPage2.setVisible(false);
		add(nextPage1);
		
		zur�ckMen�4 = new JButton ("Zur�ck zum Hauptmen�");
		zur�ckMen�4.setBounds(155, 400, 180, 30);
		zur�ckMen�4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		zur�ckMen�4.addActionListener(this);
		zur�ckMen�4.setEnabled(true);
		zur�ckMen�4.setVisible(false);
		add(zur�ckMen�4);
		
	}

	
/*
* Main-Methode der Klasse StoryTeller
*/
		
		public static void main (String [] args) {
			
			ResourceLoader.loadMusic();
			AudioPlayer.getMusic(Audio.BACKGROUND_THEME).loop(1f, 0.1f);
			
			StoryTeller storyTeller = new StoryTeller("Story Teller");
			storyTeller.setVisible(true);
			storyTeller.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			storyTeller.setSize (500, 500);
			storyTeller.setLocationRelativeTo(null);
			storyTeller.setResizable(false);
			storyTeller.setLayout (null);
			storyTeller.setVisible(true);
		
		}	
	
/*
* �berschriebene actionPerformed-Methode des ActionListeners
*/
	
	public void actionPerformed(ActionEvent e) {
	
/*
* Blendet das Auswahlmen� der Geschichten ein
*/
		
		if(e.getSource() == auswahl)  {
			
			auswahl.setVisible(false);
			credits.setVisible(false);
			einstellungen.setVisible(false);
			spielLaden.setVisible(false);
			spielEnde.setVisible(false);
			newEden.setVisible(true);
			zwischenDenWeltenspiegeln.setVisible(true);
			zur�ckMen�.setVisible(true);
			
		}
		
/*
* �ffnet ein OptionDialog mit den Credits
*/
		
		if (e.getSource() == credits) {
			
			Object[] option = { "Ok" };
			JOptionPane.showOptionDialog (null, "Programmiert von Mike Kerkhoff", "Credits", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,

		        null, option, option[0]);
			
		}
		
/*
* Blendet das Spielstandmen� ein		
*/
		
		if (e.getSource() == spielLaden) {
			
			auswahl.setVisible(false);
			credits.setVisible(false);
			einstellungen.setVisible(false);
			spielLaden.setVisible(false);
			spielEnde.setVisible(false);
			zur�ckMen�2.setVisible(true);
			spielStandReset.setVisible(true);
			spielStand.setVisible(true);
			
		}
			
/*
* Blendet die Einstellungen ein	
*/
		
		if (e.getSource() == einstellungen) {
		
				// einstellungen();
			
		}
	
/*
* Beendet das Spiel		
*/
		
		if (e.getSource() == spielEnde) {
			
			AudioPlayer.getMusic(Audio.BACKGROUND_THEME).stop();
			AL.destroy();
			System.exit(0);
			
		}
				
/*
* Blendet die Charakter-Auswahl der Geschichte 'New Eden' ein		
*/
		
		if(e.getSource() == newEden)  {
			
			auswahl.setVisible(false);
			credits.setVisible(false);
			einstellungen.setVisible(false);
			spielLaden.setVisible(false);
			spielEnde.setVisible(false);
			newEden.setVisible(false);
			zwischenDenWeltenspiegeln.setVisible(false);
			zur�ckMen�.setVisible(false);
			alaine.setVisible(true);
			joseph.setVisible(true);

		}
		

/*
* Blendet die Charakter-Auswahl der Geschichte 'Zwischen den Weltenspiegeln' ein
*/
		
		if (e.getSource() == zwischenDenWeltenspiegeln) {
			
		}
/*
* Kehrt zum Hauptmen� zur�ck
*/
		
		if(e.getSource() == zur�ckMen�) {
			
			auswahl.setVisible(true);
			credits.setVisible(true);
			einstellungen.setVisible(true);
			spielLaden.setVisible(true);
			spielEnde.setVisible(true);
			newEden.setVisible(false);
			zwischenDenWeltenspiegeln.setVisible(false);
			zur�ckMen�.setVisible(false);
			
		}	
		

/*
* Ruft die Methode 'resetSpeicherplatz' der Klasse Speicherplatz auf, 
* die den momentanen Speicherplatz und Kapitelfortschritt auf 0 zur�ckstellt 
* und zuletzt auch noch die Methode 'spielSpeichern' derselbigen Klasse aufruft,
* um den zur�ckgesetzten Wert der drei Variablen in die 
* 'Spielstand.txt', 'KapitelA', 'KapitelJ' Datein zu schreiben, um auf diese Weise den Spielstand 
* v�llig zur�ckzusetzen
*/
	
		if (e.getSource() == spielStandReset) {
			
			Speicherplatz.resetSpeicherplatz();
			Speicherplatz.resetKapitelAlaine();
			Speicherplatz.resetKapitelJoseph();
			Speicherplatz.spielSpeichern();
		}
		
/*
* Ruft die Methode 'spielLaden' der Klasse Speicherplatz auf,
* und l�d somit den zuletzt gespeicherten Spielstand und schaltet
* den Werten der Variablen 'kapitelAlaine' und 'kapitelJoseph' entsprechend
* die Kapitel der Geschichte frei
*/
		
		if (e.getSource() == spielStand) {
				Speicherplatz.spielLaden();
				AudioPlayer.getMusic(Audio.BACKGROUND_THEME).stop();

			
			if (Speicherplatz.kapitelAlaine == 2) {
				kapitelA2.setEnabled(true);
			}
			
			if (Speicherplatz.kapitelJoseph == 2) {
				kapitelJ2.setEnabled(true);
			}
			
			this.setVisible(false);
		}
		
/*
* Kehrt zum Hauptmen� zur�ck
*/
			
		if (e.getSource() == zur�ckMen�2) {
			
			auswahl.setVisible(true);
			credits.setVisible(true);
			einstellungen.setVisible(true);
			spielLaden.setVisible(true);
			spielEnde.setVisible(true);
			zur�ckMen�2.setVisible(false);
			spielStandReset.setVisible(false);
			spielStand.setVisible(false);
			
		}
		
/*
* Blendet das Kapitel-Auswahlmen� f�r Alaine ein
*/
				
			if (e.getSource() == alaine) {
					
				alaine.setVisible(false);
				joseph.setVisible(false);
				kapitelauswahlA.setVisible(true);
				introA.setVisible(true);
				kapitelA1.setVisible(true);
				kapitelA2.setVisible(true);
				nextPage2.setVisible(true);
				zur�ckMen�3.setVisible(true);
				
			}
					
/*
* Ruft die Main-Methode der Klasse AlaineIntro auf und beginnt
* somit das Intro von Alaine		
*/
				
			if (e.getSource() == introA) {
				
				AudioPlayer.getMusic(Audio.BACKGROUND_THEME).stop();
			}
						
/*
* Ruft die Main-Methode der Klasse SchlafzimmerStart auf und beginnt
* somit das Spiel bei dem ersten Kapitel der Geschichte	
*/
						
			if(e.getSource() == kapitelA1) {
				
				AudioPlayer.getMusic(Audio.BACKGROUND_THEME).stop();
				this.setVisible(false);
				SchlafzimmerStart.main(null);
			}
					
/*
* Blendet die n�chste Seite des Kapitelmen�s ein
*/
							
			if (e.getSource() == nextPage1) {
									
			}
						
						
			
/*
* Kehrt zum Hauptmen� zur�ck
*/
			if (e.getSource() == zur�ckMen�3) {
					
				kapitelauswahlA.setVisible(false);
				kapitelA1.setVisible(false);
				kapitelA2.setVisible(false);
				introA.setVisible(false);
				zur�ckMen�3.setVisible(false);
				nextPage1.setVisible(false);
				auswahl.setVisible(true);
				credits.setVisible(true);
				einstellungen.setVisible(true);
				spielLaden.setVisible(true);
				spielEnde.setVisible(true);
						
			}		
			
/*
* Blendet das Kapitel-Auswahlmen� f�r Joseph ein
*/
	
		if (e.getSource() == joseph) {
			
			alaine.setVisible(false);
			joseph.setVisible(false);
			kapitelauswahlJ.setVisible(true);
			introJ.setVisible(true);
			kapitelJ1.setVisible(true);
			kapitelJ2.setVisible(true);
			nextPage2.setVisible(true);
			zur�ckMen�4.setVisible(true);
		
		}
		
/*
* Ruft die Main-Methode der Klasse JosephIntro auf und beginnt
* somit das Intro von Joseph		
*/
		
		if (e.getSource() == introJ) {
			
			AudioPlayer.getMusic(Audio.BACKGROUND_THEME).stop();
		}	
		
/*
* Ruft die Main-Methode der Klasse LaborStart auf und beginnt
* somit das Spiel bei dem ersten Kapitel der Geschichte	
*/
		
		if(e.getSource() == kapitelJ1) {
			
			AudioPlayer.getMusic(Audio.BACKGROUND_THEME).stop();
			this.setVisible(false);
			LaborStart.main(null);
		}
		
/*
* Blendet die n�chste Seite des Kapitelmen�s ein
*/
	
		if (e.getSource() == nextPage2) {
			
		}
		
/*
* Kehrt zum Hauptmen� zur�ck
*/
		if (e.getSource() == zur�ckMen�4) {
		
			kapitelauswahlJ.setVisible(false);
			kapitelJ1.setVisible(false);
			kapitelJ2.setVisible(false);
			introJ.setVisible(false);
			zur�ckMen�4.setVisible(false);
			nextPage2.setVisible(false);
			auswahl.setVisible(true);
			credits.setVisible(true);
			einstellungen.setVisible(true);
			spielLaden.setVisible(true);
			spielEnde.setVisible(true);
			
		}

	}
	
/*
* Ende der Klasse StoryTeller
*/	
	
}


