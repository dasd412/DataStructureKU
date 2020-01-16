package rbtree;

import java.util.ArrayList;

public class BST extends MyBinTree{

	
	public BST(){
		super();
	}
	
	public BST(Object e) {
		super(e);
	}
	
	private MyBinNode nextNode(MyBinNode v) {
		ArrayList<MyBinNode>list=new ArrayList<>();
		inOrderTraversal(v,list);
		MyBinNode next=null;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals(v)) {
				next=list.get(i+1);
			}
		}
		return next;
	}
	
	
	private void inOrderTraversal(MyBinNode v, ArrayList<MyBinNode> list) {
	
		if(this.hasLeft(v)) {
		inOrderTraversal(v.left(),list);
		}
		list.add(v);
		if(this.hasRight(v)) {
		inOrderTraversal(v.right(),list);
		}
	}
	
	@Override
	public void inOrder(MyBinNode v) {
		if(this.hasLeft(v)) {
		inOrder(v.left());
		}
		
//		if(v.left()!=null) {
//			System.out.println("left"+v.left().element());
//		}
//		if(v.right()!=null) {
//			System.out.println("right"+v.right().element());
//		}
//		if(v.parent()!=null) {
//			System.out.println("parent"+v.parent().element());
//		}
		System.out.println("Element"+v.element());

		if(this.hasRight(v)) {
		inOrder(v.right());
		}
	}
	
	public Object find(Object k) {
		MyBinNode it=this.root();
		while(it!=null) {
			if(it.element().equals(k)) {
				return it.element();
			}
			else {
				if((int)k<(int)it.element()) {
					it=it.left();
				}else {
					it=it.right();
				}
			}
		}

		return null;
	}
	
	public ArrayList<MyBinNode> findAll(Object k) {
		ArrayList<MyBinNode> list=new ArrayList<>();
		inOrderTraversal(this.root(), list);
		
		ArrayList<MyBinNode> foundKeys=new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).element().equals(k)) {
				foundKeys.add(list.get(i));
			}
		}
		
		return foundKeys;
	}
	
	public MyBinNode insert(Object k) {
		MyBinNode it=this.root();
		MyBinNode parent=null;
		
		if(it==null) {
			super.addRoot(k);
			return this.root();
		}
		
		while(it!=null) {
			
			parent=it;
			
			if((int)k<=(int)it.element()) {
				it=it.left();
			}
			else {
				it=it.right();
			}
		}
		
	

		    MyBinNode node=new MyBinNode(k);
		    node.setParent(parent);
		    node.setChildren(new ArrayList(2));
		    node.children().add(0, null);
		    node.children().add(1, null);
		    
			if((int)parent.element()<(int)k) {
				parent.children().set(1, node);
			}else {
			    parent.children().set(0, node);
			}
			
			
			return node;
		
		
	}
	
	public MyBinNode remove(Object k) {
		MyBinNode it=this.root();
		MyBinNode parent=null;
		
		while(it!=null) {
			
			if(it.element().equals(k)) {
				break;
			}
			else {
				parent=it;
				
				if((int)k<=(int)it.element()) {
					it=it.left();
				}
				else {
					it=it.right();
				}
			}
		}
		
		if(it==null) {
			return null;
		}
		else {
			MyBinNode temp=it;
			
			if(it.left()==null&&it.right()==null) {
				
				if(it==parent.left()) {
				   parent.setLeft(null);
				   
				}
				else {
					parent.setRight(null);
				}
				it.setParent(null);
			}
			else if(it.left()!=null&&it.right()!=null) {//two child
				MyBinNode target=nextNode(it);
				it.setElement(target.element());
				
				MyBinNode targetParent=(MyBinNode) target.parent();
				

				if(target==targetParent.left()) {
					if(target.right()==null&&target.left()==null) {
						targetParent.setLeft(null);
					}
					else if(target.left()!=null) {
						targetParent.setLeft(target.left());
						target.left().setParent(targetParent);
					}else {
						targetParent.setLeft(target.right());
						target.right().setParent(targetParent);
					}
					
				}else {
					if(target.right()==null&&target.left()==null) {
						targetParent.setRight(null);
					}
					else if(target.right()!=null) {
						targetParent.setRight(target.right());
						target.right().setParent(targetParent);
					}else {
						targetParent.setRight(target.left());
						target.left().setParent(targetParent);
					}
				}
				target.setParent(null);
				target.setChildren(null);
			}
			else {//one child
			
				if(it==parent.left()) {
					if(it.left()!=null) {
						parent.setLeft(it.left());
						it.left().setParent(parent);
					}
					else {
						parent.setLeft(it.right());
						it.right().setParent(parent);
					}
				}
				else {
					if(it.left()!=null) {
						parent.setRight(it.left());
						it.left().setParent(parent);
					}
					else {
						parent.setRight(it.right());
						it.right().setParent(parent);
					}
				}
				it.setParent(null);
			}
			
			
			return temp;
		}
	}
	
}
