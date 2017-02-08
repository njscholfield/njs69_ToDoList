package edu.pitt.todolist.view;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

import edu.pitt.todolist.model.ListItem;
import edu.pitt.todolist.model.User;

public class TableDataModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"Item", "Name"};
	private HashMap<ListItem, User> data;
	private ListItem items[];

	
	public TableDataModel() {
		this.data = new HashMap<ListItem, User>();
		items = new ListItem[0];
	}
	
	public void updateData(HashMap<ListItem, User> data) {
		this.data = data;
		items = new ListItem[data.size()];
		data.keySet().toArray(items);
		fireTableDataChanged();
	}
	
	public String getColumnName(int index) {
		return columnNames[index];
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		ListItem object = items[rowIndex];
		
		if(columnIndex == 0) {
			return object;
		} else if(columnIndex == 1) {
			return data.get(object);
		} else {
			return null;
		}
	}
}
