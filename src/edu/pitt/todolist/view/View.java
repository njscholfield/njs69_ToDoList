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

public class View extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField input = new JTextField();
	JList<ListItem> list;
	private DefaultListModel<ListItem> listModel;
	
	public View() {
		super("Todo List");
	}
	
	public String getInputValue() {
		return input.getText();
	}
	
	public ListItem getSelectedItem() {
		return list.getSelectedValue();
	}
	
	public void updateList(String action, ListItem item) {
		if(action == "Add") {
			listModel.addElement(item);
			input.setText("");
		} else {
			listModel.removeElement(item);
		}
	}
	
	public void createView(Controller ctrl) {
		int y = 0;
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
		c.gridy = y;
		c.gridwidth = 12;
		c.weightx = 0.9;
		list.setFixedCellHeight(-1);
		list.setBorder(new EmptyBorder(10,10,10,10));
		JScrollPane scrollpane = new JScrollPane(list);
		//scrollpane.setBorder(new EmptyBorder(10,10,10,10));
		add(scrollpane, c);
		
		JButton deleteBtn = new JButton("Delete");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 12;
		c.gridx = 12;
		c.gridy = y;
		c.weightx = 0.1;
		deleteBtn.addActionListener(ctrl.getDeleteButton());
		add(deleteBtn, c);
		
		y++;
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 11;
		c.gridx = 0;
		c.gridy = y;
		c.weightx = 0.9;
		add(input, c);
		
		JButton addBtn = new JButton("Add");
		c.gridwidth = 1;
		c.weightx = 0.1;
		c.gridx = 12;
		c.gridy = y;
		addBtn.addActionListener(ctrl.getAddButton());
		add(addBtn, c); 
		
		getRootPane().setDefaultButton(addBtn);
		
		setVisible(true);
	}
}
