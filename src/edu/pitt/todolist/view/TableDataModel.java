package edu.pitt.todolist.view;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

import edu.pitt.todolist.model.ListItem;
import edu.pitt.todolist.model.User;

/**
 * <h1>TableDataModel</h1>
 * This class controls the data of the JTable.
 * @author Noah Scholfield
 */
public class TableDataModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"Item", "Name"};
	private HashMap<ListItem, User> data;
	private ListItem items[];

	/**
	 * Creates the model by creating a new HashMap to hold data.
	 */
	public TableDataModel() {
		this.data = new HashMap<ListItem, User>();
		items = new ListItem[0];
	}

	/**
	 * Updates the data in the table.
	 * @param data The new data to be put into the table.
	 */
	public void updateData(HashMap<ListItem, User> data) {
		this.data = data;
		items = new ListItem[data.size()];
		data.keySet().toArray(items);
		fireTableDataChanged();
	}

	/**
	 * Gives the name of the column at the requested index.
	 * @param  index  The index of the column.
	 * @return  The name of the column.
	 */
	@Override
	public String getColumnName(int index) {
		return columnNames[index];
	}

	/**
	 * Gives the number of rows of data.
	 * @return Number of rows of data.
	 */
	@Override
	public int getRowCount() {
		return data.size();
	}

	/**
	 * Gives the number of columns of data.
	 * @return Number of columns of data.
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * Gives the value of the requested cell.
	 * @param  rowIndex  The row of the requested data.
	 * @param  columnIndex  The column of the requested data.
	 * @return  The value at the requested cell.
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
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
