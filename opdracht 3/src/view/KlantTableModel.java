package view;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import db.DataBase;
import model.Item;
import model.Klant;

public class KlantTableModel extends DefaultTableModel{

	private String [] columnnames = {"ID","Voornaam", "Achternaam", "Straat","Nummer","Postcode","Gemeente"};
	private DataBase db;
	
	public KlantTableModel(DataBase db)
	{
		this.db = db;
		setData(db.getAllKlanten());
	}
	
	private void setData(List<Klant> klantList) {
		setDataVector(getData(klantList), columnnames);
	}
	
	private Object[][] getData(List<Klant> klantList) {
		Object[][] data = new Object[klantList.size()][7];
		for (int i = 0; i < klantList.size();i++ )
		{
			int id = i;
			Klant klant = klantList.get(i);
			data[i][0] = id;
			data[i][1] = klant.getVoornaam();
			data[i][2] = klant.getAchternaam();
			data[i][3] = klant.getStraat();
			data[i][4] = klant.getNummer();
			data[i][5] = klant.getPostcode();
			data[i][6] = klant.getGemeente();
		}
		return data;
	}
}
