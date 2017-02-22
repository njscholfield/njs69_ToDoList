package edu.pitt.todolist.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.pitt.todolist.model.ListTreeNode;


/**
 * <h1>DeleteButton</h1>
 * This class implements the {@code ActionListener} interface to remove an item from the todoList when the delete button is pressed.
 * @author Noah Scholfield
 *
 */
public class DeleteButton implements ActionListener {
	private Controller controller;

	/**
	 * Constructor for DeleteButton.
	 * @param ctrl The controller object.
	 */
	public DeleteButton(Controller ctrl) {
		controller = ctrl;
	}

	/**
	 * Implemented from the ActionListener class. Removes an item to the todoList when the delete button is selected.
	 * @param event The button click event from the JButton. 
	 */
	public void actionPerformed(ActionEvent event) {
		ListTreeNode toDelete = controller.getView().getSelectedItem();
		if(toDelete != null) {
			controller.getModel().deleteListItem(toDelete);
			controller.getView().updateList();
		}
	}

}
