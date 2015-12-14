package db;
 
import java.util.List;
import java.util.Vector;
 
import model.CD;
import model.Item;
import model.Klant;
import model.UitleenItem;
 
public class DataBase {
 
    List<Item> ListItems;
    List<Klant> ListKlanten;
    List<UitleenItem> ListUitleenItem;
 
    public DataBase() {
        ListItems = new Vector<Item>();
        ListKlanten = new Vector<Klant>();
        ListUitleenItem = new Vector<UitleenItem>();
        VoegItemToe(new CD("lala", 100, "lolo"));
    }
 
    public void VoegItemToe(Item item) {
        ListItems.add(item);
    }
 
    public List<Item> getAllItems() {
        return ListItems;
    }
 
	public void VoegKlantToe(Klant klant) {
		ListKlanten.add(klant);
	}

	public List<Klant> getAllKlanten() {
		return ListKlanten;
	}
	
	public void RemoveKlant(int index)
	{
		ListKlanten.remove(index);
	}
 
    public List<UitleenItem> getAllUitleenItems() {
        return ListUitleenItem;
    }
 
    public void VoegUitleenItemToe(UitleenItem uitleenItem) {
        ListUitleenItem.add(uitleenItem);
    }
 
    public void removeItem(int index) {
        ListItems.remove(index);
    }
 
}
