package model;

public class CD extends Item {

	public CD(String titel, int id, String beschrijving) {

		super(titel, id, 1.5, beschrijving);
	}
	
	public String getType()
	{
		return "CD";
	}

}
