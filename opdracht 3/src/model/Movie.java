package model;

public class Movie extends Item {

	public Movie(String titel, String beschrijving) {

		super(titel, 2, beschrijving);

	}
	
	public String getType()
	{
		return "Movie";
	}

}
