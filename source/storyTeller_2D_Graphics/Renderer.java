/**
*@Autor Mike Kerkhoff �2014 
*/

package storyTeller_2D_Graphics;

/**
* Die Klasse 'Renderer' k�mmert sich um das Zeichnen auf dem Bildschirm
*/

public class Renderer {

/**
* Die Konstante 'MAP_SIZE' speichert die Kartengr��e
*/
	
	public final int MAP_SIZE = 64;
	
/**
* Die Konstante 'MAP_MASK'
*/
	
	public final int MAP_MASK = MAP_SIZE - 1;
	
/**
* Der Integer 'width' stellt die H�he dar
*/
	
	public int width;
	
/**
* Der Integer 'height' stellt die Breite dar.	
*/
	
	public int height;
	
/**
* Ein Array mit den Pixeln des Bildschirms
*/
	
	public int [] pixels;
	
/**
* Ein Array mit den Tiles des Spieles	
*/
	
	public int [] tiles = new int [MAP_SIZE * MAP_SIZE];

	
/**
* Konstruktor der Klasse 'Renderer', nimmt einen Integer 'width' und einen Integer 'height'
* entgegen.	
* @param width : die Breite des Fensters
* @param height : die H�he des Fensters
*/
	
	public Renderer (int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int [width * height];
			
	}
		
/**
* Die Methode 'clear' �berzeichnet den Bildschirm mit schwarzen Pixeln und s�ubert so 
* den Bildschirm	
*/
	
	public void clear() {
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		
		}
	
	}
	
/**
* Die Methode 'render' zeichnet die einzelnen Pixel auf den Bildschirm
*/
	
	public void render () {
		
		for (int y = 0; y < height; y++) {
			
					int yy = y;
				
					// if (y < 0 || y > height) break;
				
			for (int x = 0; x < width; x++) {
				
					int xx = x;	
				
					// if (x < 0 || x > width) break;
				
				int tileIndex = (((xx >> 4) & MAP_MASK) + ((yy >> 4)) & MAP_MASK) * MAP_SIZE;
				
				pixels [x+y * width] = tiles[tileIndex];
				
				}
			
			}
		
	}

}
