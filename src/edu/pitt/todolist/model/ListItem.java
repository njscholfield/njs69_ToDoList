package edu.pitt.todolist.model;

import java.sql.Timestamp;

/**
 * <h1>ListItem</h1>
 * This class creates an object for each of the items in the todoList.
 * @author Noah Scholfield
 *
 */
public class ListItem {
	private int id;
	private String description;
	private Timestamp timestamp;
	
	/**
	 * Creates a new ListItem
	 * @param d  The description of the new ListItem
	 */
	public ListItem(int id, String d, Timestamp time) {
		this.id = id;
		description = d;
		timestamp = time;
	}

	/** Gives the description of the ListItem.
	 * @return The description of the ListItem
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Allows the description of a ListItem to be changed.
	 * @param newDescription The new description of the ListItem
	 */
	public void setDescription(String newDescription) {
		description = newDescription;
	}

	/**
	 * Overrides the generic toString so that the description is shown in the JList.
	 * @return The description of the ListItem.
	 */
	public String toString() {
		return description;
	}
}
