package edu.pitt.todolist.model;

import java.util.Vector;

public class Model {
	private Vector<ListItem> todoList;
	
	public Model() {
		todoList = new Vector<ListItem>();
	}
	
	public ListItem addListItem(String itemDescription) {
		ListItem newItem = new ListItem(itemDescription);
		todoList.add(newItem);
		return newItem;
	}
	
	public void deleteListItem(ListItem item) {
		todoList.remove(item);
	}
	
	public Vector<ListItem> getList() {
		return todoList;
	}
}
