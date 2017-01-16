package edu.pitt.todolist.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.pitt.todolist.model.ListItem;

public class AddButton implements ActionListener {
	private Controller controller;
	
	public AddButton(Controller c) {
		controller = c;
	}
	
	public void actionPerformed(ActionEvent e) {
		String newItemDescription = controller.getView().getInputValue();
		ListItem newItem = controller.getModel().addListItem(newItemDescription);
		controller.getView().updateList("Add", newItem);
	}
	
}
