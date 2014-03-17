/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_Locations;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import storyTeller_2D_Libraries.Images;
import storyTeller_2D_Utilities.ResourceLoader;
import storyTeller_Main.Speicherplatz;
import storyTeller_Main.StoryTeller;


public class SchlafzimmerStart extends Location implements ActionListener {
	
/*
* Attribute der Klasse SchlafzimmerStart
*/

	private JLabel textWillkommen;
	
	private JTextArea textAusgabe;
	
	private JButton zurückMenü;
	private JButton weiter;
	private JButton weiter2;
	private JButton beginnen;
	private JButton wahl1;
	private JButton wahl2;
	private JButton wahl3;
	private JButton spielSpeichern;
	
	
	private int verlauf = 0;
	private int entscheidung1 = 0;
	private int entscheidung2 = 0;
	private int entscheidung3 = 0;
	private int kapitel = 1;
	
	private static final long serialVersionUID = 3L;
	
/*
* Konstruktor der Klasse SchlafzimmerStart
*/
	
public SchlafzimmerStart (String title, String name, String land, String stadt, int spielStand) {
	
		super(title, name, land, stadt, spielStand);
		
/*
* Laden des Hintergrundbilds
*/
					
			ResourceLoader.loadImages();
			this.setContentPane(new JLabel(new ImageIcon(Images.hintergrundbild1)));

/*
*  Initiierung der von Location geerbten Attribute		
*/
				
		this.name = name;
		this.land = land;
		this.stadt = stadt;
		this.spielStand = spielStand;
				
/*
* Initiierung der Menü-Elemente
*/
				
		textWillkommen = new JLabel ("In einem Schlafzimmer in Cardiff: ");
		textWillkommen.setBounds (80, 20, 320, 20);
		textWillkommen.setForeground(Color.black);
		textWillkommen.setBackground(Color.LIGHT_GRAY);
		textWillkommen.setVisible(true);
		add(textWillkommen);
										
		textAusgabe = new JTextArea(20, 30);
		textAusgabe.setBounds(80, 60, 420, 290);
		textAusgabe.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		textAusgabe.setEditable(false);
		textAusgabe.setVisible(true);
		add(textAusgabe);
		
		zurückMenü = new JButton ("Zurück zum Hauptmenü");
		zurückMenü.setBounds(100, 500, 180, 50);
		zurückMenü.addActionListener(this);
		zurückMenü.setEnabled(true);
		zurückMenü.setVisible(true);
		add(zurückMenü);
		
		spielSpeichern = new JButton ("Spiel Speichern");
		spielSpeichern.setBounds(100, 400, 180, 50);
		spielSpeichern.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		spielSpeichern.setBackground(Color.white);
		spielSpeichern.addActionListener(this);
		spielSpeichern.setEnabled(true);
		spielSpeichern.setVisible(true);
		add(spielSpeichern);
		
		
		beginnen = new JButton("Spiel beginnen");
		beginnen.setBounds(320, 400, 180, 50);
		beginnen.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		beginnen.setBackground(Color.white);
		beginnen.addActionListener(this);
		beginnen.setEnabled(true);
		beginnen.setVisible(true);
		add(beginnen);
		
		weiter2 = new JButton("Weiter");
		weiter2.setBounds(320, 400, 180, 50);
		weiter2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		weiter2.setBackground(Color.white);
		weiter2.addActionListener(this);
		weiter2.setEnabled(true);
		weiter2.setVisible(false);
		add(weiter2);
		
		weiter = new JButton("Weiter");
		weiter.setBounds(320, 400, 180, 50);
		weiter.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		weiter.setBackground(Color.white);
		weiter.addActionListener(this);
		weiter.setEnabled(true);
		weiter.setVisible(false);
		add(weiter);
				
		wahl1 = new JButton("Entscheidung1");
		wahl1.setBounds(100, 400, 180, 50);
		wahl1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		wahl1.setBackground(Color.white);
		wahl1.addActionListener(this);
		wahl1.setEnabled(true);
		wahl1.setVisible(false);
		add(wahl1);
		
		wahl2 = new JButton("Entscheidung2");
		wahl2.setBounds(320, 400, 180, 50);
		wahl2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		wahl2.setBackground(Color.white);
		wahl2.addActionListener(this);
		wahl2.setEnabled(true);
		wahl2.setVisible(false);
		add(wahl2);
		
		wahl3 = new JButton("Entscheidung3");
		wahl3.setBounds(320, 500, 180, 50);
		wahl3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		wahl3.setBackground(Color.white);
		wahl3.addActionListener(this);
		wahl3.setEnabled(true);
		wahl3.setVisible(false);
		add(wahl3);					
	}
			

/*
* Main-Methode der Klasse SchlafzimmerStart
*/
	
	public static void main(String[] args) {
		
/*
* Erstellt ein neues Objekt von der Klasse SchlafzimmerStart
*/
		
		SchlafzimmerStart schlafzimmerStart = new SchlafzimmerStart("Story Teller", "Alices Schlafzimmer", "Wales", "Cardiff", 1);
		schlafzimmerStart.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		schlafzimmerStart.setSize (600, 600);
		schlafzimmerStart.setLocationRelativeTo(null);
		schlafzimmerStart.setResizable(false);
		schlafzimmerStart.setLayout (null);
		schlafzimmerStart.setVisible (true);	
	
	}
	
/*
* Überschriebene actionPerformed-Methode des ActionListeners
*/
	
public void actionPerformed(ActionEvent i) {

/*
* Verlässt das Spiel und kehrt zum Hauptmenü zurück
*/
		
		if(i.getSource() == zurückMenü) {
			this.setVisible(false);
			StoryTeller.main(null);
		}
	
/*
* Überschreibt den Wert der Variable 'speicherplatz' aus der Klasse Speicherplatz
* mit dem Wert der von Lokation klasseneigenen Variable 'spielStand' und überschreibt
* genauso die Variable 'kapitelJoseph' aus der Klasse 'Speicherplatz' und ersetzt diese. 
* Danach wird die Methode 'spielSpeichern' aus der Klasse Speicherplatz aufgerufen, um das Spiel 
* zu speichern 
*/
	
	if (i.getSource() == spielSpeichern) {
			
		Speicherplatz.speicherplatz = spielStand;
		Speicherplatz.kapitelAlaine = kapitel;
		Speicherplatz.spielSpeichern();
		spielSpeichern.setEnabled(false);
		spielSpeichern.setVisible(false);
		textAusgabe.setText("System Control: Das Spiel wurde gespeichert ");
		
	}
		
/*
* Das, was passiert, wenn der Knopf 'beginnen' gedrückt wird in Abhängigkeit der 
* Spielvariablen 'verlauf', 'entscheidung1', 'entscheidung2', 'entscheidung3'		
*/	
	
		if (i.getSource() == beginnen) {
			if(verlauf == 0) {
					if (entscheidung1 == 0) {
						if (entscheidung2 == 0) {
							if (entscheidung3 == 0) {
								
								textAusgabe.setText(null);
								textAusgabe.setText("Draußen fällt der Regen mit einem leisen Prasseln gegen die"
								+ "\n" 
								+ "Fensterscheiben."
								+ "\n"
								+ "\n"
								+ "Mit einem Gähnen lässt du deinen Blick zur Uhr wandern: Es ist gerade "
								+ "\n"
								+ "mal fünf Uhr morgens. Aber schlafen kannst du nicht mehr. Deshalb"
								+ "\n"
								+ "gibst du die Sehnsucht nach einer vernünftigen Nachtruhe endgültig"
								+ "\n"
								+ "auf."
								+ "\n"
								+ "\n"
								+ "Neben dir schlummert Alice leise vor sich hin und merkt nichts von dem,"
								+ "\n"
								+ "was um sie herum passiert. Das Mädchen liegt in sich zusammengerollt und"
								+ "\n"
								+ "murmelt leise mehrere unverständige Worte vor sich hin."
								+ "\n"
								+ "\n"
								+ "Dich streckend stehst du vorsichtig auf, um sie nicht nicht zu wecken."
								+ "\n"
								+ "\n"
								+ "Mit einem erschöpften Lächeln auf den Lippen schaust du aus dem"
								+ "\n"
								+ "Fenster und beobachtest, wie die dunklen Sturmwolken der letzten Tage "
								+ "\n"
								+ "langsam verschwinden und allmählich das Licht wieder hindurch lassen.");
				
								spielSpeichern.setEnabled(false);
								spielSpeichern.setVisible(false);
								beginnen.setVisible(false);
								weiter.setVisible(true);
								verlauf = 1;
								}
							
						}
						
					}
					
				}
			
			}
		
/*
* Das, was passiert, wenn der Knopf 'weiter' gedrückt wird in Abhängigkeit der 
* Spielvariablen 'verlauf', 'entscheidung1', 'entscheidung2', 'entscheidung3'	
*/				
			
		
			if (i.getSource() == weiter) {
				if (verlauf == 1) {	
						if (entscheidung1 == 0) {
							if (entscheidung2 == 0) {
								if (entscheidung3 == 0) {
									
									textAusgabe.setText(null);
									weiter.setVisible(false);
									weiter2.setVisible(true);
									verlauf = 2;
									}
								
							}
							
						}
						
					}
				
				}
			
/*
* Das, was passiert, wenn der Knopf 'weiter2' gedrückt wird in Abhängigkeit der 
* Spielvariablen 'verlauf', 'entscheidung1', 'entscheidung2', 'entscheidung3'		
*/				
			
			if(i.getSource() == weiter2) {
				if (verlauf == 2) {
					if (entscheidung1 == 0) {
						if (entscheidung2 == 0) {
							if (entscheidung3 == 0) {
								
								textAusgabe.setText(null);
								weiter2.setVisible(false);
								wahl1.setText("Entscheidung 1");
								wahl1.setVisible(true);
								wahl2.setText("Entscheidung 2");
								wahl2.setVisible(true);
								wahl3.setText("Entscheidung 3");
								wahl3.setVisible(true);
								verlauf = 3;
								}
							
						}
						
					}
					
				}
				
				if (verlauf == 3) {
					if (entscheidung1 == 1) {
						if (entscheidung2 == 0) {
							if (entscheidung3 == 0) {
					
								textAusgabe.setText(null);	
								}
								
						}
								
					}
							
				}
				
				if (verlauf == 3) {
					if (entscheidung1 == 0) {
						if (entscheidung2 == 1) {
							if (entscheidung3 == 0) {
					
								textAusgabe.setText(null);
								}
								
						}
								
					}
							
				}	
				
				if (verlauf == 3) {
					if (entscheidung1 == 0) {
						if (entscheidung2 == 0) {
							if (entscheidung3 == 1) {
								
								textAusgabe.setText(null);
								}
							
						}
								
					}
							
				}	
				
			}	
		
			
/*
* Das, was passiert, wenn der Knopf 'wahl1' gedrückt wird in Abhängigkeit der 
* Spielvariablen 'verlauf', 'entscheidung1', 'entscheidung2', 'entscheidung3'		
*/					
			
			if (i.getSource() == wahl1) {
				if (verlauf == 2) {
					if (entscheidung1 == 0) {
						if (entscheidung2 == 0) {
							if (entscheidung3 == 0) {
					
								textAusgabe.setText(null);
								wahl1.setVisible(false);
								wahl2.setVisible(false);
								wahl3.setVisible(false);
								weiter.setVisible(true);
								entscheidung3 = 1;
								verlauf = 3;
							
							}
							
						}
							
					}
						
				}
					
			}	
			
/*
* Das, was passiert, wenn der Knopf 'wahl2' gedrückt wird in Abhängigkeit der 
* Spielvariablen 'verlauf', 'entscheidung1', 'entscheidung2', 'entscheidung3'		
*/				
			
			if (i.getSource() == wahl2) {
				if (verlauf == 2) {
					if (entscheidung1 == 0) {
						if (entscheidung2 == 0) {
							if (entscheidung3 == 0) {
					
								textAusgabe.setText(null);
								wahl1.setVisible(false);
								wahl2.setVisible(false);
								wahl3.setVisible(false);
								weiter.setVisible(true);
								entscheidung3 = 1;
								verlauf = 3;
							
							}
							
						}
							
					}
						
				}
					
			}	
		
/*
* Das, was passiert, wenn der Knopf 'wahl3' gedrückt wird in Abhängigkeit der 
* Spielvariablen 'verlauf', 'entscheidung1', 'entscheidung2', 'entscheidung3'		
*/				
			
			if (i.getSource() == wahl3) {
				if (verlauf == 2) {
					if (entscheidung1 == 0) {
						if (entscheidung2 == 0) {
							if (entscheidung3 == 0) {
					
								textAusgabe.setText(null);
								wahl1.setVisible(false);
								wahl2.setVisible(false);
								wahl3.setVisible(false);
								weiter.setVisible(true);
								entscheidung3 = 1;
								verlauf = 3;
							
							}
							
						}
							
					}
						
				}
					
			}	
			
			
			
}

/*
* Ende der Klasse SchlafzimmerStart
*/

}


