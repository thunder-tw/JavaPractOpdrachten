package model;

public class Movie extends Item {

	public Movie(String titel, int id, String beschrijving) {

		super(titel, id, 2, beschrijving);

	}
	
	public String getType()
	{
		return "Movie";
	}

}
