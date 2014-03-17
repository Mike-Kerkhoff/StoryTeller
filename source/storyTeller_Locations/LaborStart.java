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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.lwjgl.openal.AL;

import storyTeller_2D_Libraries.Images;
import storyTeller_Main.Speicherplatz;
import storyTeller_Main.StoryTeller;

public class LaborStart extends Location implements ActionListener {
	
/*
* Attribute der Klasse LaborStart
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
	
	private static final long serialVersionUID = 2L;

/*
* Konstruktor der Klasse LaborStart
*/
	
	public LaborStart (String title, String name, String land, String stadt, int spielStand) {
		
		super(title, name, land, stadt, spielStand);
	
/*
* Laden des Hintergrundbildes
*/
		
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
		
		textWillkommen = new JLabel ("Im Labor von New Eden in Amerika: ");
		textWillkommen.setBounds (80, 20, 320, 20);
		textWillkommen.setForeground(Color.BLACK);
		textWillkommen.setVisible(true);
		add(textWillkommen);
		
		textAusgabe = new JTextArea(20, 30);
		textAusgabe.setBounds(80, 60, 420, 300);
		textAusgabe.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		textAusgabe.setEditable(false);
		textAusgabe.setVisible(true);
		add(textAusgabe);
		
		zurückMenü = new JButton ("Zurück zum Hauptmenü");
		zurückMenü.setBounds(100, 500, 180, 50);
		zurückMenü.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		zurückMenü.addActionListener(this);
		zurückMenü.setEnabled(true);
		zurückMenü.setVisible(true);
		add(zurückMenü);
		
		spielSpeichern = new JButton ("Spiel Speichern");
		spielSpeichern.setBounds(100, 400, 180, 50);
		spielSpeichern.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		spielSpeichern.addActionListener(this);
		spielSpeichern.setEnabled(true);
		spielSpeichern.setVisible(true);
		add(spielSpeichern);
		
		
		beginnen = new JButton("Spiel beginnen");
		beginnen.setBounds(320, 400, 180, 50);
		beginnen.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		beginnen.addActionListener(this);
		beginnen.setEnabled(true);
		beginnen.setVisible(true);
		add(beginnen);
		
		weiter2 = new JButton("Weiter");
		weiter2.setBounds(320, 400, 180, 50);
		weiter2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		weiter2.addActionListener(this);
		weiter2.setEnabled(true);
		weiter2.setVisible(false);
		add(weiter2);
		
		weiter = new JButton("Weiter");
		weiter.setBounds(320, 400, 180, 50);
		weiter.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		weiter.addActionListener(this);
		weiter.setEnabled(true);
		weiter.setVisible(false);
		add(weiter);
				
		wahl1 = new JButton("Entscheidung1");
		wahl1.setBounds(100, 400, 180, 50);
		wahl1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		wahl1.addActionListener(this);
		wahl1.setEnabled(true);
		wahl1.setVisible(false);
		add(wahl1);
		
		wahl2 = new JButton("Entscheidung2");
		wahl2.setBounds(320, 400, 180, 50);
		wahl2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		wahl2.addActionListener(this);
		wahl2.setEnabled(true);
		wahl2.setVisible(false);
		add(wahl2);
		
		wahl3 = new JButton("Entscheidung3");
		wahl3.setBounds(320, 500, 180, 50);
		wahl3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		wahl3.addActionListener(this);
		wahl3.setEnabled(true);
		wahl3.setVisible(false);
		add(wahl3);
	}
		

	
/*
* Main-Methode der Klasse LaborStart
*/
	
	public static void main(String[] args) {
		
/*
 * Erstellt ein neues Objekt von der Klasse LaborStart
 */
		
		LaborStart laborStart = new LaborStart("Story Teller", "New Eden Labor", "Amerika", "Nicht bekannt", 2);
		laborStart.addWindowListener(
				
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						LaborStart.exit();
					}
				}
				);
		
		laborStart.setSize (600, 600);
		laborStart.setLocationRelativeTo(null);
		laborStart.setResizable(false);
		laborStart.setLayout (null);
		laborStart.setVisible (true);
		
	}
	
	
		private static void cleanUp () {
			
			AL.destroy();
			
		}
		
		public static void exit() {
			
			cleanUp();
			System.exit(1);
			
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
 *
 */
		if (i.getSource() == spielSpeichern) {
			
			Speicherplatz.speicherplatz = spielStand;
			Speicherplatz.kapitelJoseph = kapitel;
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
				
			   textAusgabe.setText(" Ruhelos flackern die Deckenlampen über dir und mit müden Augen blickst"
			   + "\n" 
			   + " du zum Computermonitor. Geschlafen hast du vermutlich schon seit ein"
			   + "\n"
			   + " paar Tagen nicht mehr. Aber die Arbeit wartet ja nicht auf einen."
			   + "\n"
			   + "\n"
			   + " Du startest eine weitere Simulation, um deine Ergebnisse zu überprüfen,"
			   + "\n"
			   + " aber das Resultat ist wieder dasselbe: Testobjekt ist nicht überlebensfähig."
			   + "\n"
			   + "\n"
			   + " Du beißt dir frustriert auf die Lippe und lehnst dich zurück, woraufhin der"
			   + "\n"
			   + " Plastikstuhl, auf dem du sitzt, leise quietscht. "
			   + "\n"
			   + "\n"
			   + " Mit einem kaum hörbaren Seufzen gehst du deine Programmierung noch"
			   + "\n"
			   + " einmal durch. Irgendwo muss doch dieser Fehler zu finden sein. Mit der"
			   + "\n"
			   + " Zeit steigt Frust in dir auf und dir vergeht die Geduld.  Das kann doch"
			   + "\n"
			   + " nicht wahr sein!"
			   + "\n"
			   + "\n"
			   + " Und zu allem Guten ist jetzt auch noch dein Kaffee leer!"
			   + "\n"
			   + "\n"
			   + " Grausam ist diese Welt, grausam und unermütlich.");
											
			   spielSpeichern.setEnabled(false);
			   spielSpeichern.setVisible(false);
			   beginnen.setVisible(false);
			   weiter.setVisible(true);
			   verlauf = 1;
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
							
							textAusgabe.setText(" Mehr oder weniger widerwillig arbeitest du noch ein paar Stunden lang"
							+ "\n" 
							+ " weiter. Aber irgendwann wird es dir letztlich doch zu viel: Genug ist genug."
							+ "\n"
							+ "\n"
							+ " Du schreibst noch kurz eine Email an deinen Vorgesetzten und verschickst"
							+ "\n"
							+ " das Ergebnis deiner Arbeit im Anhang mit ab. Zwar wird Henrik Jones nicht "
							+ "\n"
							+ " mit dir zufrieden sein, aber du kannst ja auch nicht zaubern!"
							+ "\n"
							+ "\n"
							+ " Frustriert schaltest du den Computermonitor aus und verlässt mit deiner"
							+ "\n" 
							+ " Kaffeetasse in der Hand das in Schweigen gehüllte Labor."
							+ "\n"
							+ "\n"
							+ " Auf dem Weg nach draußen, stellt sich dir die Frage, was du jetzt tun"
							+ "\n"
							+ " könntest."
							+ "\n"
							+ "\n"
							+ " Eine Möglichkeit wäre dich hinzulegen. Immerhin hast du seit Tagen keinen "
							+ "\n"
							+ " vernünftigen Schlaf mehr bekommen. Aber du könntest dir auch eine neue"
							+ "\n"
							+ " Kaffeekanne aufsetzen und weiter darüber nachdenken, warum dein"
							+ "\n"
							+ " Versuch so kläglich gescheitert ist. Irgendwo in den Zeilen deines"
							+ "\n"
							+ " Codes muss ja die Lösung stehen. "
							+ "\n");
											
							weiter.setVisible(false);
							weiter2.setVisible (true);
							verlauf = 2;
							}
						
						}
					
					}
				
				}
			
			if (verlauf == 4) {
				if (entscheidung1 == 1) {
					if (entscheidung2 == 0) {
						if (entscheidung3 == 0) {
							
							textWillkommen.setText("In deinem Appartment: ");
							
							textAusgabe.setText(null);
							
							textAusgabe.setText(" Dein Zimmer im Institut ist karg und lieblos eingerichtet, aber es reicht für"
							+ "\n"
							+ " den Moment lang völlig aus."
							+ "\n"
							+ "\n"
							+ " Die Einrichtung beschränkt sich auf ein Bett, ein Kleiderschrank, ein kleines"
							+ "\n"
							+ " Badezimmer und eine Einbauküche. Mehr befindet sich nicht darin."
							+ "\n"
							+ "\n"
							+ " Mit einem Gähnen ziehst du deinen zerknitterten Laborkittel aus und lässt "
							+ "\n"
							+ " dich auf das Bett fallen, das leise unter dir aufknarrt."
							+ "\n"
							+ "\n"
							+ " Totenstille umhüllt dich langsam, während deine Gedanken um das"
							+ "\n"
							+ " momentane Projekt kreisen. Warum wollte die Programmierung dieses"
							+ "\n"
							+ " Gens nicht funktionieren? Weshalb verfielen all deine Simulationen nur"
							+ "\n"
							+ " ins Leere? Es müsste doch möglich sein dieses Gen so zu verändern, "
							+ "\n"
							+ " dass die Überlebenschancen des Wesens höher als 10% liegen könnten!"
							+ "\n"
							+ "\n"
							+ " Du schließt mit einem Seufzen deine Augen. Auch wenn du noch eine Zeit"
							+ "\n"
							+ " lang deinen Gedanken nach gehst, dauert es nicht lange, bis die"
							+ "\n"
							+ " Müdigkeit dich überwältigt und du in einen traumlosen Schlaf versinkst."
							+ "\n");
							
							weiter2.setVisible(false);
							weiter.setVisible(true);
							verlauf = 5;
							}
						
						}
					
					}
				
				}
			
			if (verlauf == 4) {
				if (entscheidung1 == 0) {
					if (entscheidung2 == 1) {
						if (entscheidung3 == 0) {
	
							textWillkommen.setText("In deinem Appartment: ");
							
							textAusgabe.setText(null);
							
							textAusgabe.setText(" Dein Zimmer im Institut ist karg und lieblos eingerichtet, aber es reicht für"
							+ "\n"
							+ " den Moment lang völlig aus."
							+ "\n"
							+ "\n"
							+ " Die Einrichtung beschränkt sich auf ein Bett, ein Kleiderschrank, ein kleines"
							+ "\n"
							+ " Badezimmer und eine Einbauküche. Mehr befindet sich nicht darin."
							+ "\n"
							+ "\n"
							+ " Du legst deinen Kittel aufs Bett und öffnest die ersten Knöpfe  deines"
							+ "\n"
							+ " weißen Hemds. Danach gehst du in die schmale Einbauküche, um dir den"
							+ "\n"
							+ " versprochenen Kaffee aufzusetzen. Als du allerdings den Filterdeckel"
							+ "\n" 
							+ " deiner Maschine öffnest, fällt dir auf, dass du beim letzten Mal nicht den"
							+ "\n"
							+ " benutzten Kaffeefilter in den Müll geschmissen hattest."
							+ "\n"
							+ "\n"
							+ " Mit rollenden Augen lässt du das verschimmelte Filterpapier in den Müll "
							+ "\n"
							+ " wandern und säuberst hastig die Kaffeekanne, bevor du einen neuen Filter"
							+ "\n"
							+ " aus einer Plastikpackung holst und ihn bis zum Rand mit Kaffee füllst."
							+ "\n"
							+ "\n"
							+ " »das sollte reichen, um mich wieder wach zu bekommen«, murmelst du"
							+ "\n"
							+ " leise, als du den Berg aus dunklem Pulver betrachtest."
							+ "\n"
							+ "\n");
							
							weiter.setVisible(false);
							weiter2.setVisible(true);
							verlauf = 5;
							}
							
						}
							
					}
						
				}	
			
			if (verlauf == 4) {
				if (entscheidung1 == 0) {
					if (entscheidung2 == 0) {
						if (entscheidung3 == 1) {
							
							textAusgabe.setText(null);
							
							textAusgabe.setText(" Dein Zimmer im Institut ist karg und lieblos eingerichtet, aber es reicht für"
									+ "\n"
									+ " den Moment lang völlig aus."
									+ "\n"
									+ "\n"
									+ " Die Einrichtung beschränkt sich auf ein Bett, ein Kleiderschrank, ein kleines"
									+ "\n"
									+ " Badezimmer und eine Einbauküche. Mehr befindet sich nicht darin."
									+ "\n"
									+ "\n");
									
									weiter.setVisible(false);
									weiter2.setVisible(true);
									verlauf = 5;
									}
						
							}
							
					}
						
			}	

			if (verlauf == 6) {
				if (entscheidung1 == 0) {
					if (entscheidung2 == 1) {
						if (entscheidung3 == 0) {
							
							textAusgabe.setText(null);
							
							textAusgabe.setText(" Du fährst dir mit der Hand durch deine Nacken-langen, braunen Haare"
							+ "\n"
							+ " und vergisst fürs Erste das Thema. Es ist nicht dein Job den Sinn dieser"
							+ "\n"
							+ " Aufträge zu verstehen. Du bist Wissenschaftler, aber du arbeitest immerhin"
							+ "\n"
							+ " für New Eden SD. Fragen steht nicht in deinem Arbeitsvertrag. Mit großer"
							+ "\n"
							+ " Wahrscheinlichkeit würdest du dir damit sogar mehr Ärger als Antworten"
							+ "\n"
							+ " einholen. Und solange du keine Anlässe für Bedenken hast, brauchst du"
							+ "\n"
							+ " dir keine Sorgen darum zu machen."
							+ "\n"
							+ "\n"
							+ " Du nimmst dir deine Tasse mit der Aufschrift »Was Gott kann, können wir"
							+ "\n"
							+ " schon lange« und füllst sie bis zum Rand. Dann lehnst du dich zurück, "
							+ "\n"
							+ " während du genüsslich den Kaffee austrinkst."
							+ "\n"
							+ "\n"
							+ " Die Zeit vergeht allmählich und aus einer Tasse werden zwei, und aus"
							+ "\n"
							+ " zwei werden letztlich drei. Dann reißt dich jedoch ein schrilles Klingen aus"
							+ "\n"
							+ " deinen Gedanken."
							+ "\n");
							
							weiter.setVisible(false);
							weiter2.setVisible(true);
							verlauf = 7;
							
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
									
								textAusgabe.setText(" Zuletzt könntest du dir zuerst allerdings auch eine heiße Dusche gönnen"
								+ "\n"
								+ " Deine Schultern sind von all dem Sitzen so verspannt, dass es dir"
								+ "\n"
								+ " sicherlich auch gut tun würde. Danach könntest du weiter über diese ganze"
								+ "\n"
								+ " Sache nachdenken."
								+ "\n"
								+ "\n"
								+ "\n"
								+ " Also, wonach wäre dir am ehesten?"
								+ "\n"
								+ "\n");
									
								weiter2.setVisible(false);
								wahl1.setText("Dich ins Bett legen");
								wahl1.setVisible(true);
								wahl2.setText("Neuen Kaffee aufsetzen");
								wahl2.setVisible(true);
								wahl3.setText("Eine heiße Dusche nehmen");
								wahl3.setVisible(true);
								verlauf = 3;
									
								}
								
							}
							
						}
						
					}
				
				if (verlauf == 5) {
					if (entscheidung1 == 0) {
						if (entscheidung2 == 1) {
							if (entscheidung3 == 0) {
								
								textAusgabe.setText(null);
								
								textAusgabe.setText(" Während das Wasser durch den Filter fließt und durch diesen hindurch" 
								+ "\n"
								+ " allmählich eine dunkle, gut-riechende Brühe in deine Kaffeekanne tropft, "
								+ "\n"
								+" setzt du dich auf den einzigen Stuhl im Zimmer, der neben der Einbauküche"
								+ "\n"
								+ " steht. Es ist ein schwarzer, robuster Stuhl, gemacht aus einem dir nicht"
								+ "\n"
								+ " bekannten Material."
								+ "\n"
								+ "\n"
								+ " Du wartest, bis der Kaffee fertig ist und schließt inzwischen eine Weile lang"
								+ "\n"
								+ " deine Augen, um noch einmal die letzten Stunden deiner Arbei revûe"
								+ "\n"
								+ " passieren zu lassen. Die Tatsache, dass du keine Lösung zu dem Auftrag"
								+ "\n"
								+ " finden konntest, möchte dich nicht mehr loslassen. Noch nie ist dir so"
								+ "\n"
								+ " etwas passiert! Zwar gab es manche Aufträge, die du nur durch Theorien"
								+ "\n"
								+ " lösen konntest. Aber, dass du nicht einen einzigen Lösungsansatz finden"
								+ "\n"
								+ " konntest, hatte es bisher noch nie gegeben. Zumindest bis heute. "
								+ "\n" 
								+ "\n"
								+ " Mit einem Seufzen denkst du über die Aufträge der letzten Wochen nach:"
								+ "\n"
								+ " Seit geraumer Zeit schickt dir Henrik Jones immer seltsamere Aufträge."
								+ "\n"
								+ " Genexperimente und Manipulationen, die keinen Sinn ergeben. Und dieser"
								+ "\n"
								+ " letzte Auftrag war noch merkwürdiger gewesen, als alle davor.");
								
								weiter2.setVisible(false);
								weiter.setVisible(true);
								verlauf = 6;
								
							}
						}
					}
				}
				
				if (verlauf == 7) {
					if (entscheidung1 == 0) {
						if (entscheidung2 == 1) {
							if (entscheidung3 == 0) {
								
								textAusgabe.setText(null);
								
								weiter2.setVisible(false);
								weiter.setVisible(true);
								verlauf = 8;
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
			if (verlauf == 3) {
				if (entscheidung1 == 0) {
					if (entscheidung2 == 0) {
						if (entscheidung3 == 0) {
				
							textAusgabe.setText(null);
							
							textWillkommen.setText("im Korridor des Instituts:");
							
							textAusgabe.setText(" Du verlässt das Labor und ziehst die Holztüre hinter dir zu. Leise fällt die  " 
							+ "\n"
							+ " Türe in das elektronische Schloss und du machst dich auf den Weg."
							+ "\n"
							+ "\n"
							+ " Ohne dich noch einmal umzudrehen gehst du den menschenleeren"
							+ "\n" 
							+ " Korridor entlang."
							+ "\n"
							+ "\n"
							+ " Die Neonröhren flimmern mit einem leisen Knistern über dir, während "
							+ "\n"
							+ " du weiter an unterschiedlichen Laboren vorbeiläufst. Hin und wieder"
							+ "\n"
							+ " vernimmst du ein Geräusch, das durch die geschlossenen Türen dringt, "
							+ "\n"
							+ " und hälst kurz inne, um den Ursprung des Geräuschs festzumachen."
							+ "\n"
							+ "\n"
							+ " Die Luft im schmalen Korridor ist stickig und wird nur durch mehrere"
							+ "\n"
							+ " Luftabzüge an der Decke ausgewechselt. Natürliches Licht gibt es hier"
							+ "\n"
							+ " unten nicht. Nur die Neonröhren beleuchten dieses unterirdische Reich."
							+ "\n"
							+ "\n"
							+ " Es dauert mehrere Minuten, bis du das dir zugeteilte Zimmerabteil"
							+ "\n"
							+ " erreichst. Mit einer silbernen Identitätskarte öffnest du das elektronische "
							+ "\n"
							+ " Schloss und tretest hinein."
							+ "\n"
							+ "\n");
				
							
							wahl1.setVisible(false);
							wahl2.setVisible(false);
							wahl3.setVisible(false);
							weiter.setVisible(true);
							entscheidung1 = 1;
							verlauf = 4;
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
			if (verlauf == 3) {
				if (entscheidung1 == 0) {
					if (entscheidung2 == 0) {
						if (entscheidung3 == 0) {
							
							textAusgabe.setText(null);
							
							textWillkommen.setText("im Korridor des Instituts:");
							
							textAusgabe.setText(" Du verlässt das Labor und ziehst die schwere Holztüre hinter dir zu. Leise" 
							+ "\n"
							+ " fällt die Türe in das elektronische Schloss und du machst dich auf den Weg."
							+ "\n"
							+ " Ohne dich noch einmal umzudrehen gehst den menschenleeren Korridor"
							+ "\n" 
							+ " entlang."
							+ "\n"
							+ "\n"
							+ " Die Neonröhren flimmern mit einem leisen Knistern über dir, während "
							+ "\n"
							+ " du weiter an unterschiedlichen Laboren vorbeiläufst. Hin und wieder"
							+ "\n"
							+ " vernimmst du ein Geräusch, das durch die geschlossenen Türen dringt, "
							+ "\n"
							+ " und hälst kurz inne, um den Ursprung des Geräuschs festzumachen."
							+ "\n"
							+ "\n"
							+ " Die Luft im schmalen Korridor ist stickig und wird nur durch mehrere"
							+ "\n"
							+ " Luftabzüge an der Decke ausgewechselt. Natürliches Licht gibt es hier"
							+ "\n"
							+ " unten nicht. Nur die Neonröhren beleuchten dieses unterirdische Reich."
							+ "\n"
							+ "\n"
							+ " Es dauert mehrere Minuten, bis du das dir zugeteilte Zimmerabteil"
							+ "\n"
							+ " erreichst. Mit einer silbernen Identitätskarte öffnest du das elektronische "
							+ "\n"
							+ " Schloss und tretest hinein."
							+ "\n"
							+ "\n");
				
							
							wahl1.setVisible(false);
							wahl2.setVisible(false);
							wahl3.setVisible(false);
							weiter.setVisible(true);
							entscheidung2 = 1;
							verlauf = 4;
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
			if (verlauf == 3) {
				if (entscheidung1 == 0) {
					if (entscheidung2 == 0) {
						if (entscheidung3 == 0) {
				
							textAusgabe.setText(null);
							
							textWillkommen.setText("im Korridor des Instituts:");
							
							textAusgabe.setText(" Du verlässt das Labor und ziehst die schwere Holztüre hinter dir zu. Leise" 
							+ "\n"
							+ " fällt die Türe in das elektronische Schloss und du machst dich auf den Weg."
							+ "\n"
							+ " Ohne dich noch einmal umzudrehen gehst den menschenleeren Korridor"
							+ "\n" 
							+ " entlang."
							+ "\n"
							+ "\n"
							+ " Die Neonröhren flimmern mit einem leisen Knistern über dir, während "
							+ "\n"
							+ " du weiter an unterschiedlichen Laboren vorbeiläufst. Hin und wieder"
							+ "\n"
							+ " vernimmst du ein Geräusch, das durch die geschlossenen Türen dringt, "
							+ "\n"
							+ " und hälst kurz inne, um den Ursprung des Geräuschs festzumachen."
							+ "\n"
							+ "\n"
							+ " Die Luft im schmalen Korridor ist stickig und wird nur durch mehrere"
							+ "\n"
							+ " Luftabzüge an der Decke ausgewechselt. Natürliches Licht gibt es hier"
							+ "\n"
							+ " unten nicht. Nur die Neonröhren beleuchten dieses unterirdische Reich."
							+ "\n"
							+ "\n"
							+ " Es dauert mehrere Minuten, bis du das dir zugeteilte Zimmerabteil"
							+ "\n"
							+ " erreichst. Mit einer silbernen Identitätskarte öffnest du das elektronische "
							+ "\n"
							+ " Schloss und tretest hinein."
							+ "\n"
							+ "\n");
				
							
							wahl1.setVisible(false);
							wahl2.setVisible(false);
							wahl3.setVisible(false);
							weiter.setVisible(true);
							entscheidung3 = 1;
							verlauf = 4;
							}
						
						}
						
					}
					
				}
				
			}	
			
/*
 * Ende der Methode des ActionListeners		
 */
		
}
	
/*
* Ende der Klasse LaborStart
*/	

}