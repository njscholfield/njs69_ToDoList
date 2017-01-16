package edu.pitt.todolist.main;

import edu.pitt.todolist.controller.Controller;
import edu.pitt.todolist.model.Model;
import edu.pitt.todolist.view.View;

public class Main {

	public static void main(String[] args) {
		View frame = new View();
		Model model = new Model();
		Controller controller = new Controller(frame, model);
	}

}
