package edu.pitt.todolist.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.pitt.todolist.model.ListItem;

public class DeleteButton implements ActionListener {
	private Controller controller;
	
	public DeleteButton(Controller c) {
		controller = c;
	}
	
	public void actionPerformed(ActionEvent e) {
		ListItem toDelete = controller.getView().getSelectedItem();
		controller.getModel().deleteListItem(toDelete);
		controller.getView().updateList("Remove", toDelete);
	}

}
