package edu.pitt.todolist.model;

import java.util.Vector;

public class Model {
	private Vector<ListItem> todoList;

	/**
	 * Creates a new model object.
	 * @return A Model object.
	 */
	public Model() {
		todoList = new Vector<ListItem>();
	}

	/**
	 * Adds a new item to the todoList.
	 * @param itemDescription The description of the new item.
	 * @return The new ListItem object that was added.
	 */
	public ListItem addListItem(String itemDescription) {
		ListItem newItem = new ListItem(itemDescription);
		todoList.add(newItem);
		return newItem;
	}

	/**
	 * Deletes the passed item from the todoList.
	 * @param item The item to be removed from the todoList.
	 */
	public void deleteListItem(ListItem item) {
		todoList.remove(item);
	}

	/**
	 * Returns the todoList.
	 * @return The todoList Vector.
	 */
	public Vector<ListItem> getList() {
		return todoList;
	}
}
