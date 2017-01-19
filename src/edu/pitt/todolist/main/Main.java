package edu.pitt.todolist.main;

import edu.pitt.todolist.controller.Controller;
import edu.pitt.todolist.model.Model;
import edu.pitt.todolist.view.View;

/**
 * <h1>Main</h1>
 * This is the main class. It calls the model, view, and controller classes to start the application.
 * @author Noah Scholfield
 *
 */
public class Main {
	
	/**
	 * The main method that starts the application.
	 * @param args not used
	 */
	public static void main(String[] args) {
		View frame = new View();
		Model model = new Model();
		new Controller(frame, model);
	}

}
