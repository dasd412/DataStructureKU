package tree;

import java.util.ArrayList;


public class MyNode<E> {

	private E element;
	private MyNode<E> parent;
	private ArrayList<MyNode<E>>children;
	
	public MyNode() {
		element=null;
		parent=null;
		children=null;
	}
	
	public MyNode(E e) {
	    element=e;
	}

	public E element() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public MyNode<E> parent() {
		return parent;
	}

	public void setParent(MyNode<E> parent) {
		this.parent = parent;
	}

	public ArrayList<MyNode<E>> children() {
		return children;
	}

	public void setChildren(ArrayList<MyNode<E>> children) {
		this.children = children;
	}
	
	public int degree() {
	
		return this.children.size();
	}
	
	
}
