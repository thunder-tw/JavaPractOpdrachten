package model;

public class CD extends Item {

	public CD(String titel, String beschrijving) {

		super(titel, 1.5, beschrijving);
	}
	
	public String getType()
	{
		return "CD";
	}

}
