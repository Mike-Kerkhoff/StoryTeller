/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import storyTeller_2D_Input.MouseInput;
import storyTeller_2D_Libraries.Reference;

@SuppressWarnings("serial")
public class Button extends Rectangle {

/*
* Attribute der Klassen 'Button'	
*/
	
	private String title;

/*
 * 1. Konstruktor der Klasse 'Button' 	
 */
	
	public Button() {
		super();
		
	}

/*
* 2. Konstruktor der Klasse 'Button', nimmt ein Rechteck 'r' entgegen 	
*/

	public Button(Rectangle r) {
		super(r);

	}

/*
* 3. Konstruktor der Klasse 'Button', nimmt einen Punkt 'p' entgegen
*/
	
	public Button(Point p) {
		super(p);

	}

/*
* 4. Konstruktor der Klasse 'Button', nimmt eine Dimension 'd' entgegen 	
*/
	
	public Button(Dimension d) {
		super(d);

	}

/*
* 5. Konstruktor der Klasse 'Button', nimmt ein int 'width' und ein int 'height'
* entgegen 	
*/
	
	public Button(int width, int height) {
		super(width, height);

	}

/*
* 6. Konstruktor der Klasse 'Button', nimmt einen Punkt 'p' und eine Dimension 'd'
* entgegen 	
*/
	
	public Button(Point p, Dimension d) {
		super(p, d);

	}

/*
* 7. Konstruktor der Klasse 'Button', nimmt ein int 'x', ein int 'y', ein int 'width'
* und ein int 'height' entgegen	
*/
	
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

/*
* Gibt 'title' zurück 	
*/
	
	public String getTitle() {
		return title;
	}

/*
* Nimmt einen String 'title' entgegen und übernimmt diesen
*/
	
	public Button setTitle(String title) {
		this.title = title;
		return this;
	}
	
/*
* Die Methode 'drawButton' zeichnet einen Button. Sie nimmt ein Graphics 'graphics'
* und ein int 'offset' entgegen.	
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

/*
* Ende der Klasse 'Button'
*/	
	
}
