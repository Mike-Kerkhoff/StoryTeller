/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Graphics;

/*
* Importierte Bibliotheken und Klassen
*/

import java.awt.image.BufferedImage;


public class Spritesheet {
	
/*
* Attribute der Klasse 'Spritesheet'	
*/
	
	private BufferedImage sheet;
	private int width;
	private int height;
	
/*
* 1. Konstruktor der Klasse 'Spritesheet', nimmt ein BufferedImage 'sheet' 
* und ein int 'width' entgegen	
*/
	
	public Spritesheet (BufferedImage sheet, int width) {
		
		this.sheet = sheet;
		this.width = width;
		this.height = width;
	}
	
/*
* 1. Konstruktor der Klasse 'Spritesheet', nimmt ein BufferedImage 'sheet',  
* ein int 'width' und ein int 'height' entgegen	
*/	
	
	public Spritesheet (BufferedImage sheet, int width, int height) {
		
		this.sheet = sheet;
		this.width = width;
		this.height = height;
	}

/*
* Die Methode 'getSprite' nimmt ein int 'column' und ein int 'row' entgegen,
* um die einzelnen Texturen aus einem Spritesheet 'sprite' auszuschneiden	
*/
	
	public BufferedImage getSprite(int column, int row) {
		
		return sheet.getSubimage((column * width) - width, (row * height) - height, width, height);
		
	}
	
/*
* Ende der Klasse 'Spritesheet'	
*/
	
}
