package edu.pitt.todolist.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EtchedBorder;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import edu.pitt.todolist.controller.Controller;
import edu.pitt.todolist.model.ListTreeNode;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Todo List";
	private Controller controller;
	private ListTreeNode treeRoot;
	private JTextField txtTaskName;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JButton btnAdd;
	private JButton btnDelete;
	private JTree tree;
	private DefaultTreeModel treeModel;

	public View() {
		super(WINDOW_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(450, 350);
		getContentPane().setLayout(null);

		JPanel panelDisplay = new JPanel();
		panelDisplay.setBounds(6, 6, 444, 155);
		getContentPane().add(panelDisplay);
		panelDisplay.setLayout(null);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(327, 70, 117, 29);
		panelDisplay.add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(4, 25, 325, 128);
		panelDisplay.add(scrollPane);

		tree = new JTree();

		tree.setModel(treeModel);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		scrollPane.setViewportView(tree);

		JLabel lblTasks = new JLabel("Tasks");
		lblTasks.setBounds(6, 6, 61, 16);
		panelDisplay.add(lblTasks);

		JPanel panelInput = new JPanel();
		panelInput.setBounds(10, 165, 430, 157);
		getContentPane().add(panelInput);
		panelInput.setLayout(null);

		JPanel panelFields = new JPanel();
		panelFields.setBounds(0, 23, 430, 134);
		panelInput.add(panelFields);
		panelFields.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFields.setLayout(null);

		txtTaskName = new JTextField();
		txtTaskName.setBounds(12, 18, 410, 28);
		panelFields.add(txtTaskName);
		txtTaskName.setColumns(10);

		JLabel lblTaskName = new JLabel("Task Name");
		lblTaskName.setBounds(11, 2, 76, 16);
		panelFields.add(lblTaskName);

		txtFirstName = new JTextField();
		txtFirstName.setBounds(12, 65, 190, 28);
		panelFields.add(txtFirstName);
		txtFirstName.setColumns(10);

		txtLastName = new JTextField();
		txtLastName.setBounds(220, 65, 200, 28);
		panelFields.add(txtLastName);
		txtLastName.setColumns(10);

		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(15, 50, 76, 16);
		panelFields.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(223, 50, 76, 16);
		panelFields.add(lblLastName);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(305, 99, 117, 29);
		panelFields.add(btnAdd);

		getRootPane().setDefaultButton(btnAdd);

		JLabel lblAddATask = new JLabel("Add a Task");
		lblAddATask.setBounds(2, 0, 75, 16);
		panelInput.add(lblAddATask);
	}

	public void createView(Controller ctrl) {
		controller = ctrl;
		btnAdd.addActionListener(ctrl.getAddButton());
		btnDelete.addActionListener(ctrl.getDeleteButton());
		treeRoot = ctrl.getModel().getList();
		treeModel = new DefaultTreeModel(treeRoot);
		tree.setModel(treeModel);

		setVisible(true);
	}

	/**
	 * Gives the value of the text box where the user enters the description of the new item they want to add.
	 * @return The value in the taskName textbox,
	 */
	public String getTaskName() {
		return txtTaskName.getText();
	}

	/**
	 * Gives the value of the text box where the user enters the first name of the user the item is assigned to.
	 * @return The value in the firstName textbox.
	 */
	public String getFirstName() {
		return txtFirstName.getText();
	}

	/**
	 * Gives the value of the text box where the user enters the last name of the user the item is assigned to.
	 * @return The value in the lastName textbox.
	 */
	public String getLastName() {
		return txtLastName.getText();
	}

	/**
	 * Returns the item that is selected in the todoList.
	 * @return The selected item.
	 */
	public ListTreeNode getSelectedItem() {
		return (ListTreeNode)tree.getLastSelectedPathComponent();
	}

	/**
	 * Updates the data being displayed.
	 */
	public void updateList() {
		treeRoot = controller.getModel().getList();
		treeModel.reload();
		clearTextBoxes();
	}

	/**
	 * Clears the values from the input textboxes.
	 */
	public void clearTextBoxes() {
		txtTaskName.setText("");
		txtFirstName.setText("");
		txtLastName.setText("");
	}
}
