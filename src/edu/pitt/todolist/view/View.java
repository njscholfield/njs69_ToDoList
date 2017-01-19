package edu.pitt.todolist.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import edu.pitt.todolist.controller.Controller;
import edu.pitt.todolist.model.ListItem;

/**
 * <h1>View</h1>
 * THis class creates and controls the GUI of the todoList application.
 * @author Noah Scholfield
 *
 */
public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField input = new JTextField();
	private JList<ListItem> list;
	private DefaultListModel<ListItem> listModel;
	private static final String WINDOW_TITLE = "Todo List";

	/**
	 * Constructor for View. Creates an empty JFrame called Todo List.
	 */
	public View() {
		super(WINDOW_TITLE);
	}

	/**
	 * Returns the value of the text box where the user enters the description of the new item they want to add.
	 * @return The value in the text box,
	 */
	public String getInputValue() {
		return input.getText();
	}

	/**
	 * Returns the item that is selected in the todoList.
	 * @return The selected item.
	 */
	public ListItem getSelectedItem() {
		return list.getSelectedValue();
	}

	/**
	 * Updates the list in the View.
	 * @param item  The item to be removed or added to the todoList.
	 */
	public void updateList(ListItem item) {
		if(listModel.contains(item)) {
			listModel.removeElement(item);
		} else {
			listModel.addElement(item);
			input.setText("");
		}
	}

	/**
	 * Adds all of the components to the JFrame created by the Constructor.
	 * @param ctrl The controller object.
	 */
	public void createView(Controller ctrl) {
		setSize(600, 200);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		listModel = new DefaultListModel<ListItem>();
		list = new JList<ListItem>(listModel);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 12;
		c.weightx = 0.9;
		list.setFixedCellHeight(-1);
		list.setBorder(new EmptyBorder(10,10,10,10));
		JScrollPane scrollpane = new JScrollPane(list);
		add(scrollpane, c);

		JButton deleteBtn = new JButton("Delete");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 12;
		c.gridx = 12;
		c.gridy = 0;
		c.weightx = 0.1;
		deleteBtn.addActionListener(ctrl.getDeleteButton());
		add(deleteBtn, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 11;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.9;
		add(input, c);

		JButton addBtn = new JButton("Add");
		c.gridwidth = 1;
		c.weightx = 0.1;
		c.gridx = 12;
		c.gridy = 1;
		addBtn.addActionListener(ctrl.getAddButton());
		add(addBtn, c);

		getRootPane().setDefaultButton(addBtn);

		setVisible(true);
	}
}
