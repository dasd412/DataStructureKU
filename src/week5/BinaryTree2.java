package week5;

public class BinaryTree2 {

	private class Node {
		private Node right;
		private Node left;
		private Object data;
		private Node parent;
		
		public Node(Object data) {
			this.right=null;
			this.left=null;
			this.data=data;
			this.parent=null;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public Node getParent() {
			return parent;
		}
		public void setParent(Node parent) {
			this.parent = parent;
		}
	}//내부 클래스 끝
	//멤버 변수
	private Node root;
	private int size;
	
	//생성자
	public BinaryTree2() {
		this.root=null;
		this.size=0;
	}
	//메소드
	public Node left(Node v) {
		return v.getLeft();
	}
	
	public Node right(Node v) {
		return v.getRight();
	}
	
	public boolean hasLeft(Node v) {
		return v.getLeft()!=null;
	}
	
	public boolean hasRight(Node v) {
		return v.getRight()!=null;
	}
	
	public int getDepth(Node v) {
		if(v.getParent()==null) {
			return 0;
		}
		else {
			return 1+getDepth(v.getParent());
		}
	}
	
	public int getHeight(Node v) {
		if(v.left==null&&v.right==null) {
			return 0;
		}
		int h=0;
		h=Math.max(h, getHeight(v.left));
		h=Math.max(h, getHeight(v.right));
		return h+1;
	}
	
	public Node addRoot(Object data) {
		Node nodeRoot=new Node(data);
		this.root=nodeRoot;
		this.size++;
		return nodeRoot;
	}
	
    public Node addNode(Object data) {
		Node newNode=new Node(data);
		return newNode;
	}
    
    public Node insertLeft(Node v, Object data) {
    	Node leftChild=new Node(data);
    	v.left=leftChild;
    	leftChild.setParent(v);
    	this.size++;
    	return leftChild;
    }
    
    public Node insertRight(Node v, Object data) {
    	Node rightChild=new Node(data);
    	v.right=rightChild;
    	rightChild.setParent(v);
    	this.size++;
    	return rightChild;
    }
    
    public Object remove(Node v) {
    	Object temp=v.data;
    	
    if(this.root==v) {
    	if(v.left==null&&v.right!=null) {
    		this.root=v.right;
    		v.right.parent=null;
    		v.right=null;
    	}
    	else if(v.left!=null&&v.right==null) {
    		this.root=v.left;
    		v.left.parent=null;
    		v.left=null;
    	}
    	else if(v.left==null&&v.right==null) {
    		this.root=null;
    	}
    }
    	
    	
    	else {
    	 if(v.left==null&&v.right==null) {
    		if(v.getParent().left==v) {
    			v.getParent().left=null;
    		}
    		else {
    			v.getParent().right=null;
    		}
    		v.parent=null;
    	}
    	else if(v.left==null&&v.right!=null) {
    		if(v.getParent().left==v) {
    			v.getParent().left=v.right;
    			v.right.parent=null;
    		}
    		else {
    			v.getParent().right=v.right;
    			v.right.parent=null;
    		}
    		v.right=null;
    		v.parent=null;
    	}
    	else if(v.left!=null&&v.right==null) {
    		if(v.getParent().right==v) {
    			v.getParent().right=v.left;
    			v.left.parent=null;
    		}
    		else {
    			v.getParent().left=v.left;
    			v.left.parent=null;
    		}
    		v.left=null;
    		v.parent=null;
    	}
    	else {
    		return "노드가 2개라서 지울수 없습니다.";
    	}
     }
    --this.size;
    	return temp;
    }
    
    public void attach(Node v, BinaryTree2 t1, BinaryTree2 t2) {
    	if(v.left==null&&v.right==null) {
    		v.left=t1.root;
    		t1.root.setParent(v);
    		v.right=t2.root;
    		t2.root.setParent(v);
    		this.size+=(t1.size+t2.size);
    	}
    	else {
    		return;
    	}
    }
    
    public void inOrderPrint(Node v) {
    	if(hasLeft(v)) {
    		System.out.print("(");
    		inOrderPrint(v.left);
    	}
    	System.out.print(v.data);
    	if(hasRight(v)) {
    		inOrderPrint(v.right);
    		System.out.print(")");
    	}
    }
}//클래스 끝
