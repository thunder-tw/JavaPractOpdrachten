package model;
 
import java.util.Date;
 
public class UitleenItem {
 
    int klantID;
    int itemID;
    Date terugkeerDatum;
 
    public UitleenItem(int klantID, int itemID, Date terugkeerDatum) {
        this.klantID = klantID;
        this.itemID = itemID;
        this.terugkeerDatum = terugkeerDatum;
    }
 
    public int getKlantID() {
        return klantID;
    }
 
    public int getItemID() {
        return itemID;
    }
 
    public Date getTerugkeerDatum() {
        return terugkeerDatum;
    }
}