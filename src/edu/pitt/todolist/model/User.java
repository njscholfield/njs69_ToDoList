package edu.pitt.todolist.model;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	
	public User(int id, String fn, String ln) {
		this.id = id;
		firstName = fn;
		lastName = ln;
	}
	
	public int getID() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		return firstName + ' ' + lastName;
	}
	
	public String toString() {
		return firstName + ' ' + lastName;
	}
}
