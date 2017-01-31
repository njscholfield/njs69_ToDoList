package edu.pitt.todolist.model;

import java.sql.*;
import java.util.Vector;

/**
 * <h1>Model</h1>
 * This class handles the storage and editing of the todoList data.
 * @author Noah Scholfield
 *
 */
public class Model {
	private Vector<ListItem> todoList;
	private Connection connection;

	/**
	 * Creates a new model object.
	 */
	public Model() {
		todoList = new Vector<ListItem>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://sis-teach-01.sis.pitt.edu/njs69is1017", "njs69is1017", "njs69@pitt.edu");
			
			String query = "SELECT * FROM todolist ORDER BY id;";
			Statement statement = connection.createStatement();
			ResultSet rs =  statement.executeQuery(query);
			
			while(rs.next()) {
				todoList.add(new ListItem(rs.getString("description")));
			}
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds a new item to the todoList.
	 * @param itemDescription The description of the new item.
	 * @return The new ListItem object that was added.
	 */
	public ListItem addListItem(String itemDescription) {
		if(itemDescription.equals("")) {
			return null;
		}
		ListItem newItem = new ListItem(itemDescription);
		String addItem = "INSERT INTO todolist (description) VALUES ('" + newItem.getDescription() + "');";
		try {
			connection.createStatement().executeUpdate(addItem);
			todoList.add(newItem);
			return newItem;
		} catch(Throwable e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes the passed item from the todoList.
	 * @param item The item to be removed from the todoList.
	 */
	public void deleteListItem(ListItem item) {
		String deleteItem = "DELETE FROM todolist WHERE description = '" + item.getDescription() + "';";
		try {
			connection.createStatement().executeUpdate(deleteItem);
			todoList.remove(item);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Returns the todoList.
	 * @return The todoList Vector.
	 */
	public Vector<ListItem> getList() {
		return todoList;
	}
}
