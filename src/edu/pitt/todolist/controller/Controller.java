package edu.pitt.todolist.controller;

import edu.pitt.todolist.model.Model;
import edu.pitt.todolist.view.View;

public class Controller {
	private View view;
	private Model model;
	private AddButton addButton = new AddButton(this);
	private DeleteButton deleteButton = new DeleteButton(this);
	
	public Controller(View v, Model m) {
		view = v;
		model = m;
		view.createView(this);
	}
	
	public View getView() {
		return view;
	}
	
	
	public Model getModel() {
		return model;
	}
	
	public AddButton getAddButton() {
		return addButton;
	}

	public DeleteButton getDeleteButton() {
		return deleteButton;
	}
	
}
