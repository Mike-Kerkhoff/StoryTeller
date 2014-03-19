/**
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

/**
* Importierte Bibliotheken und Klassen.
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import storyTeller_2D_Input.MouseInput;
import storyTeller_2D_Libraries.Reference;

/**
* Die Klasse 'Button' ist eine Unterklasse von Rectangle und bildet
* das Grundgerüst für jegliche Buttons für den StoryTeller2D.
*/

public class Button extends Rectangle {

/**
* Eine zufällig generierte 'serialVersionUID'.
*/
	
	private static final long serialVersionUID = 1L;

/**
* Der String 'title' stellt den Titel unseres Buttons dar.	
*/
	
	private String title;

/**
* Konstruktor der Klasse 'Button'.
*/
	
	public Button() {
		super();
		
	}

/**
* Konstruktor der Klasse 'Button', nimmt ein Rechteck 'r' entgegen. 
* 
* @param r : das Rechteck des Objektes	
*/

	public Button(Rectangle r) {
		super(r);

	}

/**
* Konstruktor der Klasse 'Button', nimmt einen Punkt 'p' entgegen.
* 
* @param p : ein Punkt des Objektes
*/
	
	public Button(Point p) {
		super(p);

	}

/**
* Konstruktor der Klasse 'Button', nimmt eine Dimension 'd' entgegen.
* 
* @param d : die Dimension des Objektes	
*/
	
	public Button(Dimension d) {
		super(d);

	}

/**
* Konstruktor der Klasse 'Button', nimmt einen integer 'width' und einen 
* integer 'height' entgegen. 
* 
* @param width : die Breite des Objektes
* @param height : die Höhe des Objektes	
*/
	
	public Button(int width, int height) {
		super(width, height);

	}

/**
* Konstruktor der Klasse 'Button', nimmt einen Punkt 'p' und eine Dimension 'd'
* entgegen. 	
* 
* @param p : ein Punkt des Objektes
* @param d : eine Dimension des Objektes
*/
	
	public Button(Point p, Dimension d) {
		super(p, d);

	}

/**
* Konstruktor der Klasse 'Button', nimmt einen integer 'x', einen integer 'y', 
* einen integer 'width' und einen integer 'height' entgegen.
* 
* @param x : der x-Wert des Objektes
* @param y : der y-Wert des Objektes
* @param width : die Breite des Objektes
* @param height : die Höhe des Objektes	
*/
	
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

/**
 * Die Methode 'getTitle' gibt den Titel des Buttons zurück.
 * 
 * @return title : der Titel unseres Buttons
 */
	
	public String getTitle() {
		return title;
	}

/**
* Die Methode 'setTitle' nimmt einen String 'title' entgegen, übernimmt diesen
* und gibt letztendlich noch den Button zurück.
* 
* @param title : der Titel unseres Buttons
* @return ein verändertes Objekt der Klasse 'Button'
*/
	
	public Button setTitle(String title) {
		this.title = title;
		return this;
	}
	
/**
* Die Methode 'drawButton' zeichnet einen Button. Dazu nimmt sie ein Objekt der Klasse 
* 'Graphics' und einen integer 'offset' entgegen.	
* 
*  @param graphics : ein Objekt der Klasse 'Graphics'
*  @param offset : eine Hilfsvariable für das Zeichnen von Buttons
*/
	
	public void drawButton(Graphics graphics, int offset) {
		
		int xTitle = Reference.CENTER_X - 90;
		int yTitle = this.y - offset;
		
		Font tempfont = new Font("Arial", Font.BOLD, 15);
		
		graphics.setFont(tempfont);
		
		if (MouseInput.MOUSE.intersects(this) && MouseInput.MOUSE != null) {
			
			graphics.setColor(new Color(0, 30, 70));
			
		} else graphics.setColor(Color.BLACK);	
			
		
		graphics.drawRect(x, y, width, height);
		graphics.drawRect(x, y, width, height);
		graphics.fillRect(this.x, this.y, this.width, this.height);
		graphics.setColor(Color.WHITE);
		graphics.drawString(title, xTitle, yTitle);
		
	}
	
}
