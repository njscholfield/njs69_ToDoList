package edu.pitt.todolist.model;

public class ListItem {
	private String description;

	/**
	 * Creates a new ListItem
	 * @param d  The description of the new ListItem
	 * @return A new ListItem object
	 */
	public ListItem(String d) {
		description = d;
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
