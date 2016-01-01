package model.tellers;

public class TerugLoopTeller extends Teller {

	private boolean oplopend;

	/**
	 * 
	 */
	public TerugLoopTeller() {
		super();
		oplopend = true;
	}

	/**
	 * 
	 * @param c
	 */
	public TerugLoopTeller(char... c) {
		super(c);
		oplopend = true;
	}

	/**
	 * 
	 */
	public void updateHuidigeWaarde() {
		int index = getHuidigeIndex();
		if (oplopend) {
			index++;
			setHuidigeIndex(index);
			if (index >= getMaxIndex()-1)
				oplopend = !oplopend;
		} else {
			index--;
			setHuidigeIndex(index);
			if (index <= 0)
				oplopend = !oplopend;
		}
	}
}
