package edu.pitt.todolist.model;

/**
 * <h1>User</h1>
 * This class creates an object for each user.
 * @author Noah Scholfield
 */
public class User {
	private int id;
	private String firstName;
	private String lastName;

	/**
	 * Creates a new User object.
	 * @param id  The user id of the new User.
	 * @param fn  The first name of the new User.
	 * @param ln  The last name of the new User.
	 */
	public User(int id, String fn, String ln) {
		this.id = id;
		firstName = fn;
		lastName = ln;
	}

	/**
	 * Gives the user id of the User.
	 * @return The user id of the User.
	 */
	public int getID() {
		return id;
	}

	/**
	 * Gives the first name of the User.
	 * @return The first name of the user.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gives the last name of the User.
	 * @return The last name of the user.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Overrides the generic toString so that the User's full name is shown in the JTable.
	 * @return The full name of the User.
	 */
	public String toString() {
		return firstName + ' ' + lastName;
	}
}
