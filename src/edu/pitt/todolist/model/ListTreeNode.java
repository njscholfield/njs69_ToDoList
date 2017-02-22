package edu.pitt.todolist.model;

import java.util.Enumeration;
import java.util.Vector;

import javax.swing.tree.TreeNode;

public class ListTreeNode implements TreeNode {
	private ListItem item;
	private User owner;
	private ListTreeNode parent;
	private Vector<ListTreeNode> children;
	private boolean allowsChildren;
	
	public ListTreeNode(String description) {
		item = new ListItem(-1, description, null);
		owner = null;
		parent = null;
		children = new Vector<ListTreeNode>();
		allowsChildren = true;
	}
	
	public ListTreeNode(ListItem i, User o) {
		item = i;
		owner = o;
		parent = null;
		children = new Vector<ListTreeNode>();
		allowsChildren = true;
	}

	@Override
	public ListTreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return children.get(childIndex);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return children.size();
	}

	@Override
	public ListTreeNode getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return children.indexOf((ListTreeNode)node);
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return allowsChildren;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return (children.size() == 0);
	}

	@Override
	public Enumeration<ListTreeNode> children() {
		// TODO Auto-generated method stub
		return children.elements();
	}
	
	public void add(ListTreeNode newChild) {
		newChild.parent = this;
		children.addElement(newChild);
	}
	
	public void remove(ListTreeNode childToRemove) {
		children.remove(childToRemove);
	}
	
	public ListItem getItem() {
		return item;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public String toString() {
		if(owner != null) {
			return item.toString() + " (" + owner.toString() + ")";
		} else {
			return item.toString();
		}
	} 

}
