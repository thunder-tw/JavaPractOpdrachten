package model.tellers;

public class CyclischeTeller extends Teller {

	/**
	 * 
	 */
	public CyclischeTeller()
	{
		super();
	}
	
	/**
	 * 
	 * @param c
	 */
	public CyclischeTeller(char... c)
	{
		super(c);
//		for( char karakter : c ){
//		}
	}
	
	
	/**
	 * 
	 */
	public void updateHuidigeWaarde()
	{
		int index = getHuidigeIndex() +1;
		if( index >= getMaxIndex() )
			setHuidigeIndex(0);
		else
			setHuidigeIndex(index);
	}
}
