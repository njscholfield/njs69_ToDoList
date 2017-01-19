package edu.pitt.todolist.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.pitt.todolist.model.ListItem;

public class DeleteButton implements ActionListener {
	private Controller controller;

	/**
	 * Constructor for DeleteButton.
	 * @param ctrl The controller object.
	 * @return A DeleteButton object.x
	 */
	public DeleteButton(Controller ctrl) {
		controller = ctrl;
	}

	/**
	 * Implemented from the ActionListener class. Removes an item to the todoList when the delete button is selected.
	 * @param event The button click event from the JButton. 
	 */
	public void actionPerformed(ActionEvent e) {
		ListItem toDelete = controller.getView().getSelectedItem();
		controller.getModel().deleteListItem(toDelete);
		controller.getView().updateList("Remove", toDelete);
	}

}
