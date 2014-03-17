/*
*@Autor Mike Kerkhoff �2014 
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
	
	private JButton zur�ckMen�;
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
* Initiierung der Men�-Elemente
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
		
		zur�ckMen� = new JButton ("Zur�ck zum Hauptmen�");
		zur�ckMen�.setBounds(100, 500, 180, 50);
		zur�ckMen�.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		zur�ckMen�.addActionListener(this);
		zur�ckMen�.setEnabled(true);
		zur�ckMen�.setVisible(true);
		add(zur�ckMen�);
		
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
* �berschriebene actionPerformed-Methode des ActionListeners
*/

	public void actionPerformed(ActionEvent i) {

	/*
	 * Verl�sst das Spiel und kehrt zum Hauptmen� zur�ck
	 */
		
		if(i.getSource() == zur�ckMen�) {
			this.setVisible(false);
			StoryTeller.main(null);
		}
/*
 * �berschreibt den Wert der Variable 'speicherplatz' aus der Klasse Speicherplatz
 * mit dem Wert der von Lokation klasseneigenen Variable 'spielStand' und �berschreibt
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
 * Das, was passiert, wenn der Knopf 'beginnen' gedr�ckt wird in Abh�ngigkeit der 
 * Spielvariablen 'verlauf', 'entscheidung1', 'entscheidung2', 'entscheidung3'		
 */
		
		if (i.getSource() == beginnen) {
			if(verlauf == 0) {
				
			   textAusgabe.setText(" Ruhelos flackern die Deckenlampen �ber dir und mit m�den Augen blickst"
			   + "\n" 
			   + " du zum Computermonitor. Geschlafen hast du vermutlich schon seit ein"
			   + "\n"
			   + " paar Tagen nicht mehr. Aber die Arbeit wartet ja nicht auf einen."
			   + "\n"
			   + "\n"
			   + " Du startest eine weitere Simulation, um deine Ergebnisse zu �berpr�fen,"
			   + "\n"
			   + " aber das Resultat ist wieder dasselbe: Testobjekt ist nicht �berlebensf�hig."
			   + "\n"
			   + "\n"
			   + " Du bei�t dir frustriert auf die Lippe und lehnst dich zur�ck, woraufhin der"
			   + "\n"
			   + " Plastikstuhl, auf dem du sitzt, leise quietscht. "
			   + "\n"
			   + "\n"
			   + " Mit einem kaum h�rbaren Seufzen gehst du deine Programmierung noch"
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
			   + " Grausam ist diese Welt, grausam und unerm�tlich.");
											
			   spielSpeichern.setEnabled(false);
			   spielSpeichern.setVisible(false);
			   beginnen.setVisible(false);
			   weiter.setVisible(true);
			   verlauf = 1;
			   }
			
		}
		
/*
* Das, was passiert, wenn der Knopf 'weiter' gedr�ckt wird in Abh�ngigkeit der 
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
							+ " Frustriert schaltest du den Computermonitor aus und verl�sst mit deiner"
							+ "\n" 
							+ " Kaffeetasse in der Hand das in Schweigen geh�llte Labor."
							+ "\n"
							+ "\n"
							+ " Auf dem Weg nach drau�en, stellt sich dir die Frage, was du jetzt tun"
							+ "\n"
							+ " k�nntest."
							+ "\n"
							+ "\n"
							+ " Eine M�glichkeit w�re dich hinzulegen. Immerhin hast du seit Tagen keinen "
							+ "\n"
							+ " vern�nftigen Schlaf mehr bekommen. Aber du k�nntest dir auch eine neue"
							+ "\n"
							+ " Kaffeekanne aufsetzen und weiter dar�ber nachdenken, warum dein"
							+ "\n"
							+ " Versuch so kl�glich gescheitert ist. Irgendwo in den Zeilen deines"
							+ "\n"
							+ " Codes muss ja die L�sung stehen. "
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
							
							textAusgabe.setText(" Dein Zimmer im Institut ist karg und lieblos eingerichtet, aber es reicht f�r"
							+ "\n"
							+ " den Moment lang v�llig aus."
							+ "\n"
							+ "\n"
							+ " Die Einrichtung beschr�nkt sich auf ein Bett, ein Kleiderschrank, ein kleines"
							+ "\n"
							+ " Badezimmer und eine Einbauk�che. Mehr befindet sich nicht darin."
							+ "\n"
							+ "\n"
							+ " Mit einem G�hnen ziehst du deinen zerknitterten Laborkittel aus und l�sst "
							+ "\n"
							+ " dich auf das Bett fallen, das leise unter dir aufknarrt."
							+ "\n"
							+ "\n"
							+ " Totenstille umh�llt dich langsam, w�hrend deine Gedanken um das"
							+ "\n"
							+ " momentane Projekt kreisen. Warum wollte die Programmierung dieses"
							+ "\n"
							+ " Gens nicht funktionieren? Weshalb verfielen all deine Simulationen nur"
							+ "\n"
							+ " ins Leere? Es m�sste doch m�glich sein dieses Gen so zu ver�ndern, "
							+ "\n"
							+ " dass die �berlebenschancen des Wesens h�her als 10% liegen k�nnten!"
							+ "\n"
							+ "\n"
							+ " Du schlie�t mit einem Seufzen deine Augen. Auch wenn du noch eine Zeit"
							+ "\n"
							+ " lang deinen Gedanken nach gehst, dauert es nicht lange, bis die"
							+ "\n"
							+ " M�digkeit dich �berw�ltigt und du in einen traumlosen Schlaf versinkst."
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
							
							textAusgabe.setText(" Dein Zimmer im Institut ist karg und lieblos eingerichtet, aber es reicht f�r"
							+ "\n"
							+ " den Moment lang v�llig aus."
							+ "\n"
							+ "\n"
							+ " Die Einrichtung beschr�nkt sich auf ein Bett, ein Kleiderschrank, ein kleines"
							+ "\n"
							+ " Badezimmer und eine Einbauk�che. Mehr befindet sich nicht darin."
							+ "\n"
							+ "\n"
							+ " Du legst deinen Kittel aufs Bett und �ffnest die ersten Kn�pfe  deines"
							+ "\n"
							+ " wei�en Hemds. Danach gehst du in die schmale Einbauk�che, um dir den"
							+ "\n"
							+ " versprochenen Kaffee aufzusetzen. Als du allerdings den Filterdeckel"
							+ "\n" 
							+ " deiner Maschine �ffnest, f�llt dir auf, dass du beim letzten Mal nicht den"
							+ "\n"
							+ " benutzten Kaffeefilter in den M�ll geschmissen hattest."
							+ "\n"
							+ "\n"
							+ " Mit rollenden Augen l�sst du das verschimmelte Filterpapier in den M�ll "
							+ "\n"
							+ " wandern und s�uberst hastig die Kaffeekanne, bevor du einen neuen Filter"
							+ "\n"
							+ " aus einer Plastikpackung holst und ihn bis zum Rand mit Kaffee f�llst."
							+ "\n"
							+ "\n"
							+ " �das sollte reichen, um mich wieder wach zu bekommen�, murmelst du"
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
							
							textAusgabe.setText(" Dein Zimmer im Institut ist karg und lieblos eingerichtet, aber es reicht f�r"
									+ "\n"
									+ " den Moment lang v�llig aus."
									+ "\n"
									+ "\n"
									+ " Die Einrichtung beschr�nkt sich auf ein Bett, ein Kleiderschrank, ein kleines"
									+ "\n"
									+ " Badezimmer und eine Einbauk�che. Mehr befindet sich nicht darin."
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
							
							textAusgabe.setText(" Du f�hrst dir mit der Hand durch deine Nacken-langen, braunen Haare"
							+ "\n"
							+ " und vergisst f�rs Erste das Thema. Es ist nicht dein Job den Sinn dieser"
							+ "\n"
							+ " Auftr�ge zu verstehen. Du bist Wissenschaftler, aber du arbeitest immerhin"
							+ "\n"
							+ " f�r New Eden SD. Fragen steht nicht in deinem Arbeitsvertrag. Mit gro�er"
							+ "\n"
							+ " Wahrscheinlichkeit w�rdest du dir damit sogar mehr �rger als Antworten"
							+ "\n"
							+ " einholen. Und solange du keine Anl�sse f�r Bedenken hast, brauchst du"
							+ "\n"
							+ " dir keine Sorgen darum zu machen."
							+ "\n"
							+ "\n"
							+ " Du nimmst dir deine Tasse mit der Aufschrift �Was Gott kann, k�nnen wir"
							+ "\n"
							+ " schon lange� und f�llst sie bis zum Rand. Dann lehnst du dich zur�ck, "
							+ "\n"
							+ " w�hrend du gen�sslich den Kaffee austrinkst."
							+ "\n"
							+ "\n"
							+ " Die Zeit vergeht allm�hlich und aus einer Tasse werden zwei, und aus"
							+ "\n"
							+ " zwei werden letztlich drei. Dann rei�t dich jedoch ein schrilles Klingen aus"
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
* Das, was passiert, wenn der Knopf 'weiter2' gedr�ckt wird in Abh�ngigkeit der 
* Spielvariablen 'verlauf', 'entscheidung1', 'entscheidung2', 'entscheidung3'		
*/	
				
			if(i.getSource() == weiter2) {
				if (verlauf == 2) {
					if (entscheidung1 == 0) {
						if (entscheidung2 == 0) {
							if (entscheidung3 == 0) {
								
								textAusgabe.setText(null);
									
								textAusgabe.setText(" Zuletzt k�nntest du dir zuerst allerdings auch eine hei�e Dusche g�nnen"
								+ "\n"
								+ " Deine Schultern sind von all dem Sitzen so verspannt, dass es dir"
								+ "\n"
								+ " sicherlich auch gut tun w�rde. Danach k�nntest du weiter �ber diese ganze"
								+ "\n"
								+ " Sache nachdenken."
								+ "\n"
								+ "\n"
								+ "\n"
								+ " Also, wonach w�re dir am ehesten?"
								+ "\n"
								+ "\n");
									
								weiter2.setVisible(false);
								wahl1.setText("Dich ins Bett legen");
								wahl1.setVisible(true);
								wahl2.setText("Neuen Kaffee aufsetzen");
								wahl2.setVisible(true);
								wahl3.setText("Eine hei�e Dusche nehmen");
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
								
								textAusgabe.setText(" W�hrend das Wasser durch den Filter flie�t und durch diesen hindurch" 
								+ "\n"
								+ " allm�hlich eine dunkle, gut-riechende Br�he in deine Kaffeekanne tropft, "
								+ "\n"
								+" setzt du dich auf den einzigen Stuhl im Zimmer, der neben der Einbauk�che"
								+ "\n"
								+ " steht. Es ist ein schwarzer, robuster Stuhl, gemacht aus einem dir nicht"
								+ "\n"
								+ " bekannten Material."
								+ "\n"
								+ "\n"
								+ " Du wartest, bis der Kaffee fertig ist und schlie�t inzwischen eine Weile lang"
								+ "\n"
								+ " deine Augen, um noch einmal die letzten Stunden deiner Arbei rev�e"
								+ "\n"
								+ " passieren zu lassen. Die Tatsache, dass du keine L�sung zu dem Auftrag"
								+ "\n"
								+ " finden konntest, m�chte dich nicht mehr loslassen. Noch nie ist dir so"
								+ "\n"
								+ " etwas passiert! Zwar gab es manche Auftr�ge, die du nur durch Theorien"
								+ "\n"
								+ " l�sen konntest. Aber, dass du nicht einen einzigen L�sungsansatz finden"
								+ "\n"
								+ " konntest, hatte es bisher noch nie gegeben. Zumindest bis heute. "
								+ "\n" 
								+ "\n"
								+ " Mit einem Seufzen denkst du �ber die Auftr�ge der letzten Wochen nach:"
								+ "\n"
								+ " Seit geraumer Zeit schickt dir Henrik Jones immer seltsamere Auftr�ge."
								+ "\n"
								+ " Genexperimente und Manipulationen, die keinen Sinn ergeben. Und dieser"
								+ "\n"
								+ " letzte Auftrag war noch merkw�rdiger gewesen, als alle davor.");
								
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
* Das, was passiert, wenn der Knopf 'wahl1' gedr�ckt wird in Abh�ngigkeit der 
* Spielvariablen 'verlauf', 'entscheidung1', 'entscheidung2', 'entscheidung3'		
*/			

		if (i.getSource() == wahl1) {
			if (verlauf == 3) {
				if (entscheidung1 == 0) {
					if (entscheidung2 == 0) {
						if (entscheidung3 == 0) {
				
							textAusgabe.setText(null);
							
							textWillkommen.setText("im Korridor des Instituts:");
							
							textAusgabe.setText(" Du verl�sst das Labor und ziehst die Holzt�re hinter dir zu. Leise f�llt die  " 
							+ "\n"
							+ " T�re in das elektronische Schloss und du machst dich auf den Weg."
							+ "\n"
							+ "\n"
							+ " Ohne dich noch einmal umzudrehen gehst du den menschenleeren"
							+ "\n" 
							+ " Korridor entlang."
							+ "\n"
							+ "\n"
							+ " Die Neonr�hren flimmern mit einem leisen Knistern �ber dir, w�hrend "
							+ "\n"
							+ " du weiter an unterschiedlichen Laboren vorbeil�ufst. Hin und wieder"
							+ "\n"
							+ " vernimmst du ein Ger�usch, das durch die geschlossenen T�ren dringt, "
							+ "\n"
							+ " und h�lst kurz inne, um den Ursprung des Ger�uschs festzumachen."
							+ "\n"
							+ "\n"
							+ " Die Luft im schmalen Korridor ist stickig und wird nur durch mehrere"
							+ "\n"
							+ " Luftabz�ge an der Decke ausgewechselt. Nat�rliches Licht gibt es hier"
							+ "\n"
							+ " unten nicht. Nur die Neonr�hren beleuchten dieses unterirdische Reich."
							+ "\n"
							+ "\n"
							+ " Es dauert mehrere Minuten, bis du das dir zugeteilte Zimmerabteil"
							+ "\n"
							+ " erreichst. Mit einer silbernen Identit�tskarte �ffnest du das elektronische "
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
* Das, was passiert, wenn der Knopf 'wahl2' gedr�ckt wird in Abh�ngigkeit der 
* Spielvariablen 'verlauf', 'entscheidung1', 'entscheidung2', 'entscheidung3'	
*/			
		
		if (i.getSource() == wahl2) {
			if (verlauf == 3) {
				if (entscheidung1 == 0) {
					if (entscheidung2 == 0) {
						if (entscheidung3 == 0) {
							
							textAusgabe.setText(null);
							
							textWillkommen.setText("im Korridor des Instituts:");
							
							textAusgabe.setText(" Du verl�sst das Labor und ziehst die schwere Holzt�re hinter dir zu. Leise" 
							+ "\n"
							+ " f�llt die T�re in das elektronische Schloss und du machst dich auf den Weg."
							+ "\n"
							+ " Ohne dich noch einmal umzudrehen gehst den menschenleeren Korridor"
							+ "\n" 
							+ " entlang."
							+ "\n"
							+ "\n"
							+ " Die Neonr�hren flimmern mit einem leisen Knistern �ber dir, w�hrend "
							+ "\n"
							+ " du weiter an unterschiedlichen Laboren vorbeil�ufst. Hin und wieder"
							+ "\n"
							+ " vernimmst du ein Ger�usch, das durch die geschlossenen T�ren dringt, "
							+ "\n"
							+ " und h�lst kurz inne, um den Ursprung des Ger�uschs festzumachen."
							+ "\n"
							+ "\n"
							+ " Die Luft im schmalen Korridor ist stickig und wird nur durch mehrere"
							+ "\n"
							+ " Luftabz�ge an der Decke ausgewechselt. Nat�rliches Licht gibt es hier"
							+ "\n"
							+ " unten nicht. Nur die Neonr�hren beleuchten dieses unterirdische Reich."
							+ "\n"
							+ "\n"
							+ " Es dauert mehrere Minuten, bis du das dir zugeteilte Zimmerabteil"
							+ "\n"
							+ " erreichst. Mit einer silbernen Identit�tskarte �ffnest du das elektronische "
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
* Das, was passiert, wenn der Knopf 'wahl3' gedr�ckt wird in Abh�ngigkeit der 
* Spielvariablen 'verlauf', 'entscheidung1', 'entscheidung2', 'entscheidung3'		
*/	
		
		if (i.getSource() == wahl3) {
			if (verlauf == 3) {
				if (entscheidung1 == 0) {
					if (entscheidung2 == 0) {
						if (entscheidung3 == 0) {
				
							textAusgabe.setText(null);
							
							textWillkommen.setText("im Korridor des Instituts:");
							
							textAusgabe.setText(" Du verl�sst das Labor und ziehst die schwere Holzt�re hinter dir zu. Leise" 
							+ "\n"
							+ " f�llt die T�re in das elektronische Schloss und du machst dich auf den Weg."
							+ "\n"
							+ " Ohne dich noch einmal umzudrehen gehst den menschenleeren Korridor"
							+ "\n" 
							+ " entlang."
							+ "\n"
							+ "\n"
							+ " Die Neonr�hren flimmern mit einem leisen Knistern �ber dir, w�hrend "
							+ "\n"
							+ " du weiter an unterschiedlichen Laboren vorbeil�ufst. Hin und wieder"
							+ "\n"
							+ " vernimmst du ein Ger�usch, das durch die geschlossenen T�ren dringt, "
							+ "\n"
							+ " und h�lst kurz inne, um den Ursprung des Ger�uschs festzumachen."
							+ "\n"
							+ "\n"
							+ " Die Luft im schmalen Korridor ist stickig und wird nur durch mehrere"
							+ "\n"
							+ " Luftabz�ge an der Decke ausgewechselt. Nat�rliches Licht gibt es hier"
							+ "\n"
							+ " unten nicht. Nur die Neonr�hren beleuchten dieses unterirdische Reich."
							+ "\n"
							+ "\n"
							+ " Es dauert mehrere Minuten, bis du das dir zugeteilte Zimmerabteil"
							+ "\n"
							+ " erreichst. Mit einer silbernen Identit�tskarte �ffnest du das elektronische "
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