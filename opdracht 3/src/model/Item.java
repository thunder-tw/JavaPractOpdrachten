package model;
 
public abstract class Item {
 
    String titel;
    private static Integer id;
    double dagPrijs; //(BigDecimal)
 
    String beschrijving;
 
    public Item(String Titel, Integer Id, double Prijs, String Beschrijving) {
        this.titel = Titel;
        this.id = Id;
        this.dagPrijs = Prijs;
        this.beschrijving = Beschrijving;
    }
 
    public abstract String getType();
 
    public int getID() {
        return id;
    }
 
    public String getTitle() {
        return titel;
    }
 
    public double getDagPrijs() {
        return dagPrijs;
    }
 
    public String getBeschrijving() {
        return beschrijving;
    }
 
    public Object getTerugKeerDatum() {
        // TODO Auto-generated method stub
        return null;
    }
 
}