package model;

public class Game extends Item {

	public Game(String titel, String beschrijving) {

		super(titel, 3, beschrijving);

	}
	
	public String getType()
	{
		return "Game";
	}
}
