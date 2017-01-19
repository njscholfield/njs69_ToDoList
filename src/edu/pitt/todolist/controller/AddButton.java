package edu.pitt.todolist.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.pitt.todolist.model.ListItem;

public class AddButton implements ActionListener {
	private Controller controller;

	/**
	 * Constructor for AddButton
	 * @param ctrl The controller object.
	 * @return An AddButton object.
	 */
	public AddButton(Controller ctrl) {
		controller = ctrl;
	}

	/**
	 * Implemented from the ActionListener class. Adds an item to the todoList when the add button is selected.
	 * @param event The button click event from the JButton. 
	 */
	public void actionPerformed(ActionEvent event) {
		String newItemDescription = controller.getView().getInputValue();
		ListItem newItem = controller.getModel().addListItem(newItemDescription);
		controller.getView().updateList("Add", newItem);
	}

}
