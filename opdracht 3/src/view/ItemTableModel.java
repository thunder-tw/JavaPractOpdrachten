package view;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import db.DataBase;
import model.Item;

public class ItemTableModel extends DefaultTableModel {
	
	private String [] columnnames = {"ID","Type", "Title", "TerugkeerDatum"};
	private DataBase db;
	
	public ItemTableModel(DataBase db)
	{
		this.db = db;
		setData(db.getAllItems());
	}
	
	private void setData(List<Item> itemList) {
		setDataVector(getData(itemList), columnnames);
	}

	private Object[][] getData(List<Item> itemList) {
		Object[][] data = new Object[itemList.size()][4];
		for (int i = 0; i < itemList.size();i++ )
		{
			int id = i;
			Item item = itemList.get(i);
			data[i][1] = id;
			data[i][0] = item.getType();
			data[i][2] = item.getTitle();
			data[i][3] = item.getTerugKeerDatum();	
		}
		return data;
	}
	
	@Override
	public void removeRow(int row)
	{
		super.removeRow(row);
		db.removeItem(row);
	}
	
}
