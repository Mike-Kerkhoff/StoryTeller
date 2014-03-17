/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

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

	private String title;

	public Button() {
		super();
		
	}


	public Button(Rectangle r) {
		super(r);

	}


	public Button(Point p) {
		super(p);

	}


	public Button(Dimension d) {
		super(d);

	}


	public Button(int width, int height) {
		super(width, height);

	}


	public Button(Point p, Dimension d) {
		super(p, d);

	}


	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);

	}


	public String getTitle() {
		return title;
	}


	public Button setTitle(String title) {
		this.title = title;
		return this;
	}
	
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
