package model;

public class Klant {
	String voornaam;
	String achternaam;
	String straat;
	String nummer;
	String postcode;
	String gemeente;
	
	public Klant(String voornaam, String achternaam, String straat, String nummer, String postcode, String gemeente)
	{
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.straat = straat;
		this.nummer = nummer;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}
	
	public Klant()
	{
		this.voornaam = "";
		this.achternaam = "";
		this.straat = "";
		this.nummer = "";
		this.postcode = "";
		this.gemeente = "";
	}
	
	
	public String getVoornaam()
	{
		return voornaam;
	}
	
	public String getAchternaam()
	{
		return achternaam;
	}
	
	public String getStraat()
	{
		return straat;
	}
	
	public String getNummer()
	{
		return nummer;
	}
	
	public String getPostcode()
	{
		return postcode;
	}
	
	public String getGemeente()
	{
		return gemeente;
	}

}
