/*
*@Autor Mike Kerkhoff ©2014 
*/

package storyTeller_2D_Textures;


import storyTeller_2D_Graphics.Spritesheet;
import storyTeller_2D_Libraries.Spritesheets;
import storyTeller_2D_Libraries.Textures;

public class TextureManager {

	private Spritesheet spritesheet_blocks;
	private Spritesheet spritesheet_characters;
	
	
	public TextureManager () {
		
		spritesheet_blocks = new Spritesheet(Spritesheets.spritesheet_blocks, 50);
		spritesheet_characters = new Spritesheet(Spritesheets.spritesheet_player, 50, 100);
		
		
		
		initTextures();
		
	}
	
	private void initTextures() {
		
		Textures.playerStandingFront = spritesheet_characters.getSprite(1, 3);
		Textures.playerStandingRight = spritesheet_characters.getSprite(1, 1);
		Textures.playerStandingLeft = spritesheet_characters.getSprite(1, 2);
		Textures.floorBlock = spritesheet_blocks.getSprite(1, 1);
		
		Textures.playerRight[0] = spritesheet_characters.getSprite(1, 1);
		Textures.playerRight[1] = spritesheet_characters.getSprite(2, 1);
		Textures.playerRight[2] = spritesheet_characters.getSprite(3, 1);
		Textures.playerRight[3] = spritesheet_characters.getSprite(4, 1);
		Textures.playerRight[4] = spritesheet_characters.getSprite(5, 1);
		Textures.playerRight[5] = spritesheet_characters.getSprite(6, 1);
		Textures.playerRight[6] = spritesheet_characters.getSprite(7, 1);
		Textures.playerRight[7] = spritesheet_characters.getSprite(8, 1);
		Textures.playerRight[8] = spritesheet_characters.getSprite(9, 1);
		
		Textures.playerLeft[0] = spritesheet_characters.getSprite(1, 2);
		Textures.playerLeft[1] = spritesheet_characters.getSprite(2, 2);
		Textures.playerLeft[2] = spritesheet_characters.getSprite(3, 2);
		Textures.playerLeft[3] = spritesheet_characters.getSprite(4, 2);
		Textures.playerLeft[4] = spritesheet_characters.getSprite(5, 2);
		Textures.playerLeft[5] = spritesheet_characters.getSprite(6, 2);
		Textures.playerLeft[6] = spritesheet_characters.getSprite(7, 2);
		Textures.playerLeft[7] = spritesheet_characters.getSprite(8, 2);
		Textures.playerLeft[8] = spritesheet_characters.getSprite(9, 2);
		
		
	}
}
