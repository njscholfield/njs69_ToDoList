package edu.pitt.todolist.model;

public class ListItem {
	private String description;
	
	public ListItem(String d) {
		description = d;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String input) {
		description = input;
	}
	
	public String toString() {
		return description;
	}
}
