package view;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Klant;
import model.UitleenItem;

public class UitleenTableModel extends DefaultTableModel {
	
	private String [] columnnames = {"klant-ID","item-ID", "Datum terugkeer"};

	public UitleenTableModel()
	{
		
	}
	
	public UitleenTableModel(List<UitleenItem> UitleenItemList)
	{
		setData(UitleenItemList);
	}

	private void setData(List<UitleenItem> UitleenItemList) {
		setDataVector(getData(UitleenItemList), columnnames);
	}

	private Object[][] getData(List<UitleenItem> UitleenItemList) {
		Object[][] data = new Object[UitleenItemList.size()][4];
		for (int i = 0; i < UitleenItemList.size();i++ )
		{
			UitleenItem UitItem = UitleenItemList.get(i);
			data[i][0] = UitItem.getKlantID();
			data[i][1] = UitItem.getItemID();
			data[i][2] = UitItem.getTerugkeerDatum();
		}
		return data;
	}
	
}
