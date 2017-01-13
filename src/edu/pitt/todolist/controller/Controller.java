package edu.pitt.todolist.controller;

import edu.pitt.todolist.model.Model;
import edu.pitt.todolist.view.View;

public class Controller {
	private View view;
	private Model model;
	private AddButton addButton;
	private DeleteButton deleteButton;
	
	public Controller(View v, Model m) {
		view = v;
		model = m;
	}
	
	private View getView() {
		return view;
	}
	
	private Model getModel() {
		return model;
	}
	
	private AddButton getAddButton() {
		return addButton;
	}

	private DeleteButton getDeleteButton() {
		return deleteButton;
	}
	
}
