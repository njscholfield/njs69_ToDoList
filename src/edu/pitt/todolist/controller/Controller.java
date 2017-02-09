package edu.pitt.todolist.controller;

import edu.pitt.todolist.model.Model;
import edu.pitt.todolist.view.View;

/**
 * <h1>Controller</h1>
 * This class provides an interface between the Model and View packages.
 * @author Noah Scholfield
 *
 */
public class Controller {
	private View view;
	private Model model;
	private AddButton addButton;
	private DeleteButton deleteButton;

	/**
	 * Constructor for the Controller. This function calls for the view to be connected to the controller and displayed.
	 * @param  v The View object.
	 * @param  m The Model Object.
	 */
	public Controller(View v, Model m) {
		view = v;
		model = m;
		addButton = new AddButton(this);
		deleteButton = new DeleteButton(this);
		view.createView(this);
	}

	/**
	 * Returns the View object.
	 * @return The View object.
	 */
	public View getView() {
		return view;
	}

	/**
	 * Returns the Model object.
	 * @return The Model object.
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Returns the add button.
	 * @return The AddButton object.
	 */
	public AddButton getAddButton() {
		return addButton;
	}

	/**
	 * Returns the delete button.
	 * @return The DeleteButton object.
	 */
	public DeleteButton getDeleteButton() {
		return deleteButton;
	}

}
