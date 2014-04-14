package storyTeller_2D_Graphics;

public class Screen {

	
	public int [] pixels;
	public int [] tiles = new int [64*64];
	public int width;
	public int height;
	public final int MAP_SIZE = 64;
	public final int MAP_MASK = MAP_SIZE - 1;
	
	
	
/**
 * Konstruktor der Klasse 'Screen', nimmt einen Integer 'width' und einen Integer 'height'
 * entgegen.	
 * @param width : die Breite des Fensters
 * @param height : die Höhe des Fensters
 */
	
	public Screen (int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int [width * height];
			
	}
		
	public void clear() {
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render () {
		
		for (int y = 0; y < height; y++) {
			
			int yy = y;
			
			for (int x = 0; x < width; x++) {
				
			int xx = x;	
			
				int tileIndex = ((xx / 32) & 63) + ((yy / 32) & 63) * 64;
				pixels [x+y * width] = tiles[tileIndex];
				
			}
		}
		
	}
}
