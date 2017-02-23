package edu.pitt.todolist.model;

import java.util.Enumeration;
import java.util.Vector;

import javax.swing.tree.TreeNode;

/**
 * <h1>ListTreeNode</h1>
 * This class creates an object that incorperates the ListIitem and User into one Node for the tree.
 * @author Noah Scholfield
 */
public class ListTreeNode implements TreeNode {
	private ListItem item;
	private User owner;
	private ListTreeNode parent;
	private Vector<ListTreeNode> children;
	private boolean allowsChildren;

	/**
	 * Creates a new ListTreeNode with just a description and no User associated with it.
	 * @param  description The desired description of the ListTreeNode.
	 */
	public ListTreeNode(String description) {
		item = new ListItem(-1, description, null);
		owner = null;
		parent = null;
		children = new Vector<ListTreeNode>();
		allowsChildren = true;
	}

	/**
	 * Creates a new ListTreeNode that has a ListItem and a User associated with it.
	 * @param  i The ListItem object to associate with this ListTreeNode.
	 * @param  o The User object to make the owner of this ListTreeNode.
	 */
	public ListTreeNode(ListItem i, User o) {
		item = i;
		owner = o;
		parent = null;
		children = new Vector<ListTreeNode>();
		allowsChildren = true;
	}

	/**
	 * Gives the child at the requested index.
	 * @param  childIndex The index of the requested child.
	 * @return The child at the requested index.
	 */
	@Override
	public ListTreeNode getChildAt(int childIndex) {
		return children.get(childIndex);
	}

	/**
	 * Gives the number of children the ListTreeNode has.
	 * @return The number of children this ListTreeNode has.
	 */
	@Override
	public int getChildCount() {
		return children.size();
	}

	/**
	 * Gives the parent of the ListTreeNode.
	 * @return The parent ListTreeNode of this ListTreeNode.
	 */
	@Override
	public ListTreeNode getParent() {
		return parent;
	}

	/**
	 * Gives the index of the passed child ListTreeNode.
	 * @param  node The child ListTreeNode you want to know the index of.
	 * @return The index of the requested child ListTreeNode.
	 */
	@Override
	public int getIndex(TreeNode node) {
		return children.indexOf((ListTreeNode)node);
	}

	/**
	 * Says whether this ListTreeNode allows children to be added.
	 * @return Whether this ListTreeNode allows children to be added.
	 */
	@Override
	public boolean getAllowsChildren() {
		return allowsChildren;
	}

	/**
	 * Says whether this ListTreeNode is a leaf.
	 * @return Whether this ListTreeNode is a leaf.
	 */
	@Override
	public boolean isLeaf() {
		return (children.size() == 0);
	}

	/**
	 * Gives all the children of this ListTreeNode as an Enumeration.
	 * @return All the children of this ListTreeNode.
	 */
	@Override
	public Enumeration<ListTreeNode> children() {
		return children.elements();
	}

	/**
	 * Adds a new child to this ListTreeNode.
	 * @param newChild The child ListTreeNode you want to add.
	 */
	public void add(ListTreeNode newChild) {
		newChild.parent = this;
		children.addElement(newChild);
	}

	/**
	 * Removes the specified child from this ListTreeNode.
	 * @param childToRemove The child ListTreeNode you want to remove.
	 */
	public void remove(ListTreeNode childToRemove) {
		children.remove(childToRemove);
	}

	/**
	 * Gives the ListItem associated with this ListTreeNode.
	 * @return The ListItem associated with this ListTreeNode.
	 */
	public ListItem getItem() {
		return item;
	}

	/**
	 * Gives the User assoicated with this ListTreeNode.
	 * @return The User assoicated with this ListTreeNode.
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * Used to display the each ListTreeNode in the JTree.
	 * @return The item description and owner if it exists.
	 */
	public String toString() {
		if(owner != null) {
			return item.toString() + " (" + owner.toString() + ")";
		} else {
			return item.toString();
		}
	}

}
