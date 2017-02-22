package edu.pitt.todolist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

/**
 * <h1>Model</h1>
 * This class handles the storage and editing of the todoList data.
 * @author Noah Scholfield
 *
 */
public class Model {
	private Vector<User> users;
	private ListTreeNode root;
	private Connection connection;

	/**
	 * Creates a new model object, creates database connection, fetches user and items from the database.
	 */
	public Model() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://sis-teach-01.sis.pitt.edu/njs69is1017", "njs69is1017", "njs69@pitt.edu");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		} catch(InstantiationException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		fetchUsersFromDatabase(); // fetches users from the database
		fetchItemsFromDatabase(); // fetches tasks and their owners
	}

	/**
	 * Gets users from the database and puts them into a Vector or users.
	 */
	public void fetchUsersFromDatabase() {
		users = new Vector<User>();
		try {
			String query = "SELECT * FROM user;";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				users.addElement(new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the todoList Items from the database and stores puts them into a HashMap with the user each is assigned to.
	 */
	private void fetchItemsFromDatabase() {
		try {
			String query = "SELECT todolist.id AS list_id, description, timestamp, user.id AS user_id, firstname, lastname " +
					"FROM todolist JOIN user_todo JOIN user " +
					"ON todolist.id = user_todo.todo_id AND user.id = user_todo.user_id " +
					"ORDER BY todolist.id;";
			String query2 = "SELECT * FROM todo_tree";
			Statement statement = connection.createStatement();
			ResultSet rs2 = statement.executeQuery(query2);
			HashMap<Integer, Integer> treeRelationship = new HashMap<Integer, Integer>();
			root = new ListTreeNode("ToDo List");
			
			while(rs2.next()) {
				treeRelationship.put(new Integer(rs2.getInt("child_id")), new Integer(rs2.getInt("parent_id")));
			}
			
			ResultSet rs =  statement.executeQuery(query);

			while(rs.next()) {
				ListItem item = new ListItem(rs.getInt("list_id"), rs.getString("description"), rs.getTimestamp("timestamp"));
				User user = getUser(rs.getInt("user_id"));
				ListTreeNode newNode = new ListTreeNode(item, user);
				if(treeRelationship.containsKey(new Integer(item.getID()))) {
					Enumeration<ListTreeNode> children = root.children();
					while(children.hasMoreElements()) {
						ListTreeNode currentParent = children.nextElement();
						int parentID = treeRelationship.get(new Integer(item.getID())).intValue();
						if(currentParent.getItem().getID() == parentID) {
							currentParent.add(newNode);
						}
					}
				} else {
					root.add(newNode);
				}
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Adds a new item to the todoList.
	 * @param itemDescription The description of the new item.
	 * @param firstName       The first name of the person the item is assigned to.
	 * @param lastName        The last name of the person the item is assigned to.
	 */
	public void addListItem(String itemDescription, String firstName, String lastName, ListTreeNode selectedItem) {
		if(itemDescription.equals("") || firstName.equals("") || lastName.equals("")) {
			return;
		}
		String addItem = "INSERT INTO todolist (description) VALUES ('" + itemDescription + "');";
		String getNewItem = "SELECT * FROM todolist WHERE description = '" + itemDescription + "';";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(addItem);
			ResultSet rs = statement.executeQuery(getNewItem);
			rs.next();
			ListItem newItem = new ListItem(rs.getInt("id"), rs.getString("description"), rs.getTimestamp("timestamp"));
			User user = getOrCreateUser(firstName, lastName);
			String createConnection = "INSERT INTO user_todo (user_id, todo_id) VALUES (" + user.getID() + ", " + newItem.getID() + ");";
			statement.executeUpdate(createConnection);
			
			if(selectedItem != null && selectedItem != root) {
				String treeRelationship = "INSERT INTO todo_tree (parent_id, child_id) " + 
						"VALUES (" + selectedItem.getItem().getID() + ", " + newItem.getID() + ");";
				statement.executeUpdate(treeRelationship);
				selectedItem.add(new ListTreeNode(newItem, user));
			} else {
				root.add(new ListTreeNode(newItem, user));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			// will throw an exception if there is a duplicate
		}
	}

	/**
	 * Find a user by user id.
	 * @param  id  The id for the user to find.
	 * @return A User object of the found user or null if user is not found.
	 */
	public User getUser(int id) {
		for(User user : users) {
			if(user.getID() == id) {
				return user;
			}
		}
		return null; // return null if not found
	}

	/**
	 * Find a user by name or create a new user if that user does not exist.
	 * @param fn The first name of the user to find or create.
	 * @param ln The last name of the user to find or create.
	 * @return  A User object that was found or created.
	 */
	public User getOrCreateUser(String fn, String ln) {
		for(User user : users) {
			if(user.getFirstName().equals(fn) && user.getLastName().equals(ln)) {
				return user;
			}
		}

		createUser(fn, ln);

		for(User user : users) {
			if(user.getFirstName().equals(fn) && user.getLastName().equals(ln)) {
				return user;
			}
		}
		return null;
	}

	/**
	 * Creates a new User
	 * @param fn The first name of the user to create.
	 * @param ln The last name of the user to create.
	 */
	public void createUser(String fn, String ln) {
		try {
			String addNewUser = "INSERT INTO user (firstname, lastname) VALUES ('" + fn + "', '" + ln + "');";
			Statement statement = connection.createStatement();
			statement.executeUpdate(addNewUser);
			fetchUsersFromDatabase();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes the passed item from the todoList.
	 * @param item The item to be removed from the todoList.
	 */
	public void deleteListItem(ListTreeNode item) {
		int itemID = item.getItem().getID();
		String deleteItem = "DELETE FROM todolist WHERE description = '" + item.getItem().getDescription() + "';";
		String removePairing = "DELETE FROM user_todo WHERE todo_id = " + itemID + ";";
		String removeTreeRelationship = "DELETE FROM todo_tree WHERE child_id = " + 
				itemID + " OR parent_id = " + itemID + ";";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(deleteItem);
			statement.executeUpdate(removePairing);
			ListTreeNode parent = item.getParent();
			
			if(parent == null) {
				parent = root;
			}
			
			if(!item.isLeaf()) {
				Enumeration<ListTreeNode> children = item.children();
				
				while(children.hasMoreElements()) {
					deleteListItem(children.nextElement());
					children = item.children();
				}
			}
			
			parent.remove(item);
			statement.executeUpdate(removeTreeRelationship);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the todoList.
	 * @return The todoList HashMap.
	 */
	public ListTreeNode getList() {
		return root;
	}
}
