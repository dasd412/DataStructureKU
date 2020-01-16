package tree;

import java.util.ArrayList;
import java.util.List;

public class MyTree<E> {
	private MyNode<E> root;
	private int size=0;
	private List<Integer>forPostOrder=new ArrayList<Integer>();
	
	public MyTree() {
		this.root=null;
		this.size=0;
	}
	
	public MyTree(E e) {
		this.root=new MyNode<E>(e);
		this.root.setChildren(new ArrayList<MyNode<E>>());
		this.size++;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}

	public MyNode root() {
		// TODO Auto-generated method stub
		return this.root;
	}

	public ArrayList<MyNode<E>> children(MyNode<E> v) {
		// TODO Auto-generated method stub
		return v.children();
	}

	public boolean isExternal(MyNode<E> v) {
		//External node= node without child node;
		// TODO Auto-generated method stub
		return (v.children()==null);
	}

	public MyNode<E> addRoot(E e) {
		// TODO Auto-generated method stub
		

		MyNode<E> newRoot=new MyNode<E>(e);
		newRoot.setChildren(new ArrayList<MyNode<E>>());
		newRoot.setParent(null);
		this.root=newRoot;
		++this.size;
		return newRoot;
	}

	public MyNode<E> addNode(E e) {

		// TODO Auto-generated method stub
	    MyNode<E> rootChild=new MyNode<E>(e);
	    rootChild.setChildren(new ArrayList<MyNode<E>>());
	    this.root.children().add(rootChild);
	    rootChild.setParent(root);
		++this.size;
		return rootChild;
	}

	public MyNode<E> addChild(MyNode<E> v, E e) {
		// TODO Auto-generated method stub
	
		MyNode<E> childNode=new MyNode<E>(e);
		childNode.setChildren(new ArrayList<MyNode<E>>());
	    v.children().add(childNode);
	    childNode.setParent(v);
	    ++this.size;
		return childNode;
	}

	public MyNode<E> addChild(MyNode<E> v, int i, E e) {
		
		// TODO Auto-generated method stub
		
		MyNode<E> childNode=new MyNode<E>(e);
		childNode.setChildren(new ArrayList<MyNode<E>>());
		v.children().add(i, childNode);
		childNode.setParent(v);
		++this.size;
		return childNode;
	}

	public MyNode<E> setChild(MyNode<E> v, int i, E e) {
		// TODO Auto-generated method stub

		MyNode<E> childSet=new MyNode<E>(e);
		childSet.setChildren(new ArrayList<MyNode<E>>());
		v.children().set(i, childSet);
		return childSet;
	}

	public MyNode<E> removeChild(MyNode<E> v, int i) {
		// TODO Auto-generated method stub
		MyNode<E> removed=(MyNode<E>) v.children().get(i);
		v.children().remove(i);
		--this.size;
		return removed;
	}
	
	private int depth(MyNode<E> v) {
		if(v==root()) {
			return 0;
		}
		else {
			return 1+depth(v.parent());
		}
	}
	
	public void preOrder(MyNode<E> v) {
		int depth=depth(v);
		for(int i=0;i<depth;i++) {
			System.out.print("  ");
		}
		System.out.println(v.element());
		for(Object c:v.children()) {
			MyNode<E> child=(MyNode<E>)c;
			preOrder(child);
		}
	}
	
	public void postOrder(MyNode<ProgramData> v) {
		
		int result=0;
		for(MyNode<ProgramData> child:v.children()) {
			
			postOrder(child);
			
			result+=calculateFile(child);
			
		}
		
		 if(v.element().getFileSize().equals("")) {
			 if(v==root()) {
				 System.out.println(v.element().getFileName()+"="+(totalFile()+result)+"KB");
			 }
			 else {
				System.out.println(v.element().getFileName()+"="+result+"KB");
				forPostOrder.add(result);
			 }
		}
		 
			
		 
	}
	
	private int totalFile() {
		int sum=0;
		 for(int i=0;i<forPostOrder.size();i++) {
			 
			 sum+=forPostOrder.get(i);
			 
		 }
		 return sum;
	}
	private int calculateFile(MyNode<ProgramData> v) {
		
		String fileSize=v.element().getFileSize();
		if(fileSize.equals("")) {
			return 0;
		}
		else {
		fileSize=fileSize.replaceAll("[^0-9]", "");
		int calc=Integer.parseInt(fileSize);
		
		return calc;
		}
	}
}

