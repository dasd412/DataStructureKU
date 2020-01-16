package week5;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E>{

	//클래스의 멤버 변수.
	protected Node<E>root;
	protected int size;
	
	//내부클래스
		protected static class Node<E> implements Position<E>{
 
			private E element;
			private Node<E> parent;
			private Node<E> left;
			private Node<E> right;
			
			
			public Node(E element, Node<E>parent, Node<E>left, Node<E>right) {
				this.element=element;
				this.parent=parent;
				this.left=left;
				this.right=right;
			}
			
			//getter && setter
			@Override
			public E getElement() throws IllegalStateException {
				// TODO Auto-generated method stub
				return this.element;
			}

			public Node<E> getParent() {
				return parent;
			}

			public void setParent(Node<E> parent) {
				this.parent = parent;
			}

			public Node<E> getLeft() {
				return left;
			}

			public void setLeft(Node<E> left) {
				this.left = left;
			}

			public Node<E> getRight() {
				return right;
			}

			public void setRight(Node<E> right) {
				this.right = right;
			}

			public void setElement(E element) {
				this.element = element;
			}	
		}//내부 클래스 끝.
	
	protected Node<E> createNode(E element, Node<E> parent, Node<E> right, Node<E> left){
		return new Node(element, parent, right, left);
	}
		
	public LinkedBinaryTree() {
		this.root=null;
		this.size=0;
	}//클래스의 생성자.
		
	//메소드들
	protected Node<E> validate(Position<E> position)throws IllegalArgumentException{
		if(!(position instanceof Node)) {
			throw new IllegalArgumentException("Not valid position type");
		}
		Node<E> node=(Node<E>)position;//position은 Node보다 상위 분류인 Position클래스에 속하므로, 
		// 더 구체적인 클래스로 바꾸려면 형변환이 필요하다.
		if(node.getParent()==node) {
			throw new IllegalArgumentException("p is no longer in tree");
		}
		return node;
	}//포괄클래스를 구체클래스로 변환하는 메소드.
	
	
	//상속받은 메소드들.
	@Override
	public Position<E> left(Position<E> position) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E>node=validate(position);
		return node.getLeft();
	}

	@Override
	public Position<E> right(Position<E> position) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E>node=validate(position);
		return node.getRight();
	}

	

	@Override
	public Position<E> root() {
		// TODO Auto-generated method stub
		return this.root;
	}

	@Override
	public Position<E> parent(Position<E> position) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E>node=validate(position);
		
		return node.getParent();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
		return null;
	}

	//추가되는 메소드들.
	public Position<E> addRoot(E element)throws IllegalStateException{
		if(!isEmpty()) {
			throw new IllegalStateException("Tree is not empty");
		}
			Node<E>rootNode=createNode(element, null, null, null);
			this.root=rootNode;
			++this.size;
			return rootNode;
	}
	
	public Position<E> addLeft(Position<E>position, E element)throws IllegalArgumentException{
		//여기서 position은 부모노드의 위치를 뜻한다.
		Node<E>parent=validate(position);
		if(parent.getLeft()!=null) {
			throw new IllegalArgumentException("It already has a left child");
		}
		Node<E>child=createNode(element, parent, null, null);
		parent.setLeft(child);
		++this.size;
		return child;
	}
	
	public Position<E> addRight(Position<E>position, E element)throws IllegalArgumentException{
		Node<E>parent=validate(position);
		if(parent.getRight()!=null) {
			throw new IllegalArgumentException("It already has right child");
		}
		Node<E> child=createNode(element, parent, null, null);
		parent.setRight(child);
		++this.size;
		return child;
	}
	
	public E set(Position<E>position, E element)throws IllegalArgumentException {
		Node<E>node=validate(position);
		E temp=node.getElement();
		node.setElement(element);
		return temp;
	}
	
	public void attach(Position<E>position, LinkedBinaryTree<E>t1, LinkedBinaryTree<E>t2)throws IllegalArgumentException{
		Node<E>node=validate(position);
		if(node.getLeft()==null|node.getRight()==null) {
			throw new IllegalArgumentException("It is not leaf node");
		}
		if(!(t1.isEmpty())) {
			t1.root.parent=node;
			node.setLeft(t1.root);
			t1.root=null;
			++this.size;
		}
		if(!(t2.isEmpty())) {
			t2.root.parent=node;
			node.setRight(t2.root);
			t2.root=null;
			++this.size;
					
		}
	}
	
	public E remove(Position<E>position)throws IllegalArgumentException{
		Node<E>node=validate(position);
	    if(numChildren(position)==2) {
	    	throw new IllegalArgumentException("It has two children");
	    }
	    Node<E> child=(node.getLeft()!=null? node.getLeft():node.getRight());
	    if(child!=null) {
	    	child.setParent(node.getParent());
	    }
	    if(node==root) {
	    	root=child;
	    }
	    else {
	    	Node<E>parent=node.getParent();
	    	if(node==parent.getLeft()) {
	    		parent.setLeft(child);
	    	}
	    	else {
	    		parent.setRight(child);
	    	}
	    }
	    --this.size;
	    E temp=node.getElement();
	    node.setElement(null);
	    node.setRight(null);
	    node.setLeft(null);
	    node.setParent(node);
	    return temp;
	    
	}
	
}//클래스의 끝.
