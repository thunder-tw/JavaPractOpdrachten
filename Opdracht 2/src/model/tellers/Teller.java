package model.tellers;

import java.io.Serializable;
public abstract class Teller implements Cloneable, Serializable{
	
private static final long serialVersionUID = 1L;
	private char[] mogelijkeWaarden;
	private int huidigeIndex;

	public Teller(){
		this('0','1','2','3','4','5','6','7','8','9');
	}
	
	public Teller(char...waarden){
		this.mogelijkeWaarden = waarden;
	}
	
	public char getHuidigeWaarde() {
			return mogelijkeWaarden[huidigeIndex];
	}	
	
	protected char[] getMogelijkeWaarden(){
		return mogelijkeWaarden;
	}
	
	protected int getHuidigeIndex(){
		return huidigeIndex;
	}
	
	protected int getMaxIndex(){
		return mogelijkeWaarden.length;
	}
	
	protected void setHuidigeIndex(int index){
		huidigeIndex=index;
	}

	public void resetHuidigeWaarde() {
		this.huidigeIndex=0;
	}

	public abstract void updateHuidigeWaarde();
	
	public Teller clone() throws CloneNotSupportedException{
		return (Teller) super.clone();
	}

	@Override
	public String toString(){
			return "waarde = " + this.getHuidigeWaarde();
	}
}

