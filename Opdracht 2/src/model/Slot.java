package model;

import java.util.ArrayList;

import model.tellers.Teller;

public class Slot {
	
	private String geheimeCode;
	private ArrayList<Teller> tellers;

	/**
	 * 
	 */
	public Slot(ArrayList<Teller> tellers, String geheimeCode)
	{
		this.tellers = tellers;
		this.geheimeCode = geheimeCode;
	}
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	public char getWaardeTeller(int i)
	{
		return tellers.get(i).getHuidigeWaarde();
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Teller> getTellers()
	{
		return tellers;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSlotKombinatie()
	{
		String str = "";
		
		for (Teller teller : tellers)
		{
			str += teller.getHuidigeWaarde();
		}
		
		return str;
	}
	
	/**
	 * 
	 * @param i
	 */
	public void updateHuidigeWaardeTeller(int i)
	{
		tellers.get(i).updateHuidigeWaarde();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getAantalTellers()
	{
		return tellers.size();
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isGeheimGevonden()
	{
		if (getSlotKombinatie() == geheimeCode)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 */
	public void resetTellers()
	{
		tellers = new ArrayList<Teller>();
	}
}
