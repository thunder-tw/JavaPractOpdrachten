package model;

public class Game extends Item {

	public Game(String titel, int id, String beschrijving) {

		super(titel, id, 3, beschrijving);

	}
	
	public String getType()
	{
		return "Game";
	}
}
