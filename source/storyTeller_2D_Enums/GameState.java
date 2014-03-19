/*
*@Autor Mike Kerkhoff �2014 
*/

package storyTeller_2D_Enums;

/**
* Die Klasse 'GameState' verwaltet alle Zust�nde des StoryTellers.
*/

public enum GameState {
	
/**
* Der StoryTeller befindet sich im Ladezustand.
*/
	
	LOADING, 
	
/**
* In diesem Zustand ist der StoryTeller 1.0 aktiv.
*/
	
	STORYTELLER,
	
/**
* In diesem Zustand ist der StoryTeller2D aktiv.	
*/
	STORYTELLER_2D,
	
/**
* In diesem Zustand wird das Men� des StoryTellers2D aufgerufen.
*/
	
	MEN�,
	
/**
* In diesem Zustand wird das Spiel des StoryTeller2D begonnen.	
*/
	
	SPIELEN,
	
/**
* In diesem Zustand wird wieder zum StoryTeller 1.0 gewechselt.	
*/
	
	ZUR�CKHAUPTMEN�,
	
/**
* In diesem Zustand wird der StoryTeller2D pausiert.	
*/
	
	PAUSE,
	
/**
* In diesem Zustand werden die Einstellungen des StoryTeller2D abgerufen.	
*/
	
	EINSTELLUNGEN,
	
/**
* In diesem Zustand wird der StoryTeller augenblicklich beendet.
*/
		
	BEENDEN;	
	
}
