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
	 * @param id  The item id of the new ListItem.
	 * @param d  The description of the new ListItem.
	 * @param time  The timestamp of the new ListItem.
	 */
	public ListItem(int id, String d, Timestamp time) {
		this.id = id;
		description = d;
		timestamp = time;
	}

	/**
	 * Gives the id of the ListItem
	 * @return The id of the ListItem
	 */
	public int getID() {
		return id;
	}

	/**
	 * Gives the timestamp of when the ListItem was created
	 * @return The timestamp of the ListItem
	 */
	public Timestamp getTimestamp() {
		return timestamp;
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
	 * Overrides the generic toString so that the description is shown in the JTable.
	 * @return The description of the ListItem.
	 */
	public String toString() {
		return description;
	}
}
