package rbtree;

import java.util.ArrayList;

public class RBTree extends MyBinTree{

	public RBTree() {
		super();
	}
	
	public RBTree(Object e) {
		super(e);
	}
	
	private void restructure(MyRBNode x, MyRBNode y, MyRBNode z) {
		if((int)y.element()<=(int)z.element()) {
			if((int)x.element()<=(int)y.element()) {
				//System.out.println("leftSingle");
				leftSingle(x,y,z);
			}else {
				//System.out.println("leftDouble");
				leftDouble(x,y,z);
			}
		}else if((int)y.element()>(int)z.element()) {
			if((int)x.element()>(int)y.element()) {
				//System.out.println("rightSingle");
				rightSingle(x,y,z);
			}else {
				//System.out.println("leftDouble");
				rightDouble(x,y,z);
			}
		}
	}
	
	private void leftSingle(MyRBNode x, MyRBNode y, MyRBNode z) {
		MyRBNode parent=(MyRBNode) z.parent();
		if(parent==null) {
			this.root=y;
			y.setParent(null);
		}
		else {
		if((int)parent.element()<(int)y.element()) {
			parent.setRight(y);
		}else {
			parent.setLeft(y);
		}
		y.setParent(parent);
		}
		
		z.setParent(y);
		z.setLeft(y.right());
		
		if(y.right()!=null) {
			y.right().setParent(z);
		}
		
		y.setRight(z);
		
		y.setLeft(x);
		x.setParent(y);
		
		//System.out.println("test"+y.element()+" "+z.element());
		y.setColor(Color.BLACK);
		z.setColor(Color.RED);

	
	
	}
	
	private void leftDouble(MyRBNode x, MyRBNode y, MyRBNode z) {
		MyRBNode parent=(MyRBNode) z.parent();
		
		if(parent==null) {
			this.root=x;
			x.setParent(null);
		}else {
			if((int)parent.element()<(int)x.element()) {
				parent.setRight(x);
			}else {
				parent.setLeft(x);
			}
			x.setParent(parent);
		}
		
		y.setRight(x.left());
		if(x.left()!=null) {
		x.left().setParent(y);
		}
		
		y.setParent(x);
		x.setLeft(y);
		
		z.setLeft(x.right());
		if(x.right()!=null) {
		x.right().setParent(z);
		}
		
		z.setParent(x);
		x.setRight(z);
		
		x.setColor(Color.BLACK);
		if(z.getColor()==Color.BLACK) {
			z.setColor(Color.RED);
			}
			else {
				z.setColor(Color.BLACK);
			}
//		System.out.println("LD"+x.left().element()+" "+x.right().element()+" "+y.parent().element()+" "+" "+z.parent().element());
//		System.out.println("test"+z.right().element()+" "+z.left()+z.right().right().element());
//		System.out.println("test"+z.right().left().element());
	}
	
	private void rightSingle(MyRBNode x, MyRBNode y, MyRBNode z) {
		MyRBNode parent=(MyRBNode) z.parent();
		
		if(parent==null) {
			this.root=y;
			y.setParent(null);
		}else {
			if((int)parent.element()<(int)y.element()) {
				parent.setRight(y);
			}else {
				parent.setLeft(y);
			}
			y.setParent(parent);
		}
		
		z.setParent(y);
		z.setRight(y.left());
		
		if(y.left()!=null) {
			y.left().setParent(z);
		}
		
		y.setLeft(z);
		
		y.setRight(x);
		x.setParent(y);
		
		y.setColor(Color.BLACK);
		if(z.getColor()==Color.BLACK) {
		z.setColor(Color.RED);
		}
		else {
			z.setColor(Color.BLACK);
		}
	}
	
	private void rightDouble(MyRBNode x, MyRBNode y, MyRBNode z) {
		MyRBNode parent=(MyRBNode) z.parent();

		if(parent==null) {
			this.root=x;
			x.setParent(null);
		}else {
			if((int)parent.element()<(int)x.element()) {
				parent.setRight(x);
			}else {
				parent.setLeft(x);
			}
			x.setParent(parent);
		}

		y.setLeft(x.right());
		if(x.right()!=null) {
			x.right().setParent(y);
		}

		y.setParent(x);
		x.setRight(y);

		z.setRight(x.left());
		if(x.left()!=null) {
			x.left().setParent(z);
		}

		z.setParent(x);
		x.setLeft(z);
		
		z.setColor(Color.RED);
		x.setColor(Color.BLACK);
		
	}

	private void reColor(MyRBNode z, MyRBNode v, MyRBNode u, MyRBNode w) {
		z.setColor(Color.RED);
		v.setColor(Color.BLACK);
		if(u!=this.root) {
		u.setColor(Color.RED);
		}
		else {
		u.setColor(Color.BLACK);
		}
		w.setColor(Color.BLACK);
	}
	
	private MyRBNode nextNode(MyRBNode v) {
		MyRBNode nextNode=null;
		
		ArrayList<MyRBNode>list=new ArrayList<>();
		inOrderTraversal(v, list);
		for(int i=0;i<list.size();i++) {
			if(list.get(i).element().equals(v.element())) {
				nextNode=list.get(i+1);
				break;
			}
		}
		return nextNode;
	}
	
	private void inOrderTraversal(MyRBNode v, ArrayList<MyRBNode> list) {
		if(v.left()!=null) {
			inOrderTraversal((MyRBNode) v.left(),list);
		}
		list.add(v);
		if(v.right()!=null) {
			inOrderTraversal((MyRBNode) v.right(),list);
		}
	}

	
	public void inOrderPrint(MyRBNode v) {
		if(v.left()!=null) {
//			System.out.println("testE"+v.element());
//			System.out.println("test"+v.left().element());
			inOrderPrint((MyRBNode) v.left());
		}
		System.out.println("Element"+v.element()+"color"+v.getColor());

//		if(v.parent()!=null) {
//			System.out.println("parent"+v.parent().element());
//		}
//		if(v.left()!=null) {
//			System.out.println("left"+v.left().element());
//		}
//		if(v.right()!=null) {
//			System.out.println("right"+v.right().element());
//		}
		if(v.right()!=null) {
			inOrderPrint((MyRBNode) v.right());
		}
		
	}
	
	public MyRBNode insert(Object k) {
		MyRBNode recent=new MyRBNode(k);
		recent.setChildren(new ArrayList(2));
		recent.children().add(0, null);
		recent.children().add(1, null);
		
		
		MyRBNode it=(MyRBNode) this.root;
		MyRBNode parentRB=null;
		
		if(it==null) {
			this.root=recent;
			recent.setColor(Color.BLACK);
			return recent;
		}
		
		
	;
		while(it!=null) {
			parentRB=it;
			
			if((int)it.element()<(int)k) {
				it=(MyRBNode) it.right();
			}else {
				it=(MyRBNode) it.left();
			}
         
		}
		
		
		if((int)parentRB.element()<(int)k) {
			parentRB.children().set(1, recent);
		}else {
			parentRB.children().set(0, recent);
		}
		
		recent.setParent(parentRB);
		MyRBNode temp=recent;
		

		
		
		recent.setColor(Color.RED);

		MyRBNode parent=(MyRBNode) recent.parent();

		if(parent.getColor()==Color.RED) {//double red problem

			while(parent.getColor()==Color.RED&&recent.getColor()==Color.RED) {// while Double red

				
				MyRBNode grandParent=(MyRBNode) parent.parent();
				
				MyRBNode sibling=null;
				
				if(parent==grandParent.left()) {
					sibling=(MyRBNode) grandParent.right();
				}else {
					sibling=(MyRBNode) grandParent.left();
				}

				if(sibling==null||sibling.getColor()==Color.BLACK) {//sibling is null = sibling is black
					//System.out.println("grandParent"+grandParent.element());
					//System.out.println("restructure");
					//System.out.println("test!!"+recent.element()+" "+parent.element()+" "+grandParent.element());
					restructure(recent,parent, grandParent);
					break;
				}else {//sibling color=red
					//another double red problem may occur....
					//System.out.println("recolor");
					reColor(recent, parent, grandParent, sibling);
				}
                

				recent=(MyRBNode) recent.parent().parent();
				parent=(MyRBNode) recent.parent();
				
				if(recent==this.root) {
					break;
				}
			}
		}
//		if(recent.parent()!=null) {
//			System.out.println("parent"+parent.element()+"color"+parent.getColor());
//		}
//		System.out.println("element"+temp.element()+"color"+temp.getColor());
		return temp;
	}

	
	public MyRBNode remove(Object k) {
		MyRBNode removed=null;
		
		MyRBNode it=(MyRBNode) this.root;
		MyRBNode parentRB=null;
		
		if(it==null) {//none exist.
			return null;
		}
		
		while(it!=null) {
			if((int)it.element()==(int)k) {
				break;
			}
			
			else {
				parentRB=it;
				if((int)it.element()>=(int)k) {
                    it=(MyRBNode) it.left();
				}else {
                     it=(MyRBNode) it.right();
				}
			}

		}
		
		if(it==null) {//none exist.
			return null;
		}
		
		removed=it;
		MyRBNode r=null;
		MyRBNode w=null;
	    MyRBNode removedParent=(MyRBNode) removed.parent();
		boolean doubleBlack=false;
		
		if(it.left()==null) {
			w=(MyRBNode) it.left();
			r=(MyRBNode) it.right();
		}
		else {
			w=(MyRBNode) it.right();
			r=(MyRBNode) it.left();
		}
		
		if(removed.getColor()==Color.BLACK&&(r==null||(r!=null&&r.getColor()==Color.BLACK))) {
			doubleBlack=true;
		}
		
		
		
		//it is leaf node
		if(it.left()==null&&it.right()==null) {
			if(parentRB.left()==it) {
				parentRB.setLeft(null);
				
			}else if(parentRB.right()==it) {
				parentRB.setRight(null);
				
			}
			it.setParent(null);
		}
		//it has two child
		else if(it.left()!=null&&it.right()!=null) {
			MyRBNode nextNode=nextNode(it);
			it.setElement(nextNode.element());
			MyRBNode nextParent=(MyRBNode) nextNode.parent();
			
            if(nextParent!=null) {//if nextParent==null => nextNode=root, so just copy rootElement at Node named "it".
			if(nextNode==nextParent.left()) {
				if(nextNode.right()==null&&nextNode.left()==null) {
					nextParent.setLeft(null);
				}else if(nextNode.left()!=null) {
					nextParent.setLeft(nextNode.left());
					nextNode.left().setParent(nextParent);
				}
				else {
					nextParent.setLeft(nextNode.right());
					nextNode.right().setParent(nextParent);
				}
			}
			else {
				if(nextNode.right()==null&&nextNode.left()==null) {
					nextParent.setRight(null);
				}else if(nextNode.right()!=null) {
					nextParent.setRight(nextNode.right());
					nextNode.right().setParent(nextParent);
				}
				else {
					nextParent.setRight(nextNode.left());
					nextNode.left().setParent(nextParent);
				}
			}
			nextNode.setParent(null);
			nextNode.setChildren(null);
            }
		}
		//it has one child
		else if(parentRB!=null){
			if(parentRB.left()==it) {
				if(it.left()!=null) {
					it.left().setParent(parentRB);
					parentRB.setLeft(it.left());
					it.setLeft(null);
				}
				else if(it.right()!=null) {
					it.right().setParent(parentRB);
					parentRB.setLeft(it.right());
					it.setRight(null);
				}
			}
			else if(parentRB.right()==it) {
				if(it.left()!=null) {
                   it.left().setParent(parentRB);
                   parentRB.setRight(it.left());
                   it.setLeft(null);
				}
				else if(it.right()!=null) {
                  it.right().setParent(parentRB);
                  parentRB.setRight(it.right());
                  it.setRight(null);
                  
				}
			}
			it.setParent(null);
		}
		//BST Remove...
		
		if(removed!=this.root&&removed.getColor()==Color.BLACK) {
			
			if(doubleBlack) {//double black occured...
				MyRBNode parent=removedParent;
				
				MyRBNode y;
				boolean adjusted=false;
				
				if(parent.left()==r) {
					y=(MyRBNode) parent.right();
				}else {
					y=(MyRBNode) parent.left();
				}
						
					while((r==null||r.getColor()==Color.BLACK)&&parent!=null&&parent.getColor()==Color.BLACK) {
					   
						if((y!=null&&y.getColor()==Color.BLACK)&&((y.left()!=null)&&((MyRBNode)y.left()).getColor()==Color.RED)||(y.right()!=null)&&((MyRBNode)y.right()).getColor()==Color.RED){
							MyRBNode x;
							MyRBNode z=(MyRBNode) y.parent();
							if(((MyRBNode)y.left()).getColor()==Color.RED){
								x=(MyRBNode) y.left();
							}
							else {
								x=(MyRBNode)y.right();
							}
//							System.out.println("deleteRestructure");
							restructure(x,y,z);
							break;
						}
						else if(y!=null&&y.getColor()==Color.BLACK&&(((y.left()!=null)&&((MyRBNode)y.left()).getColor()==Color.BLACK)&&((y.right()!=null)&&((MyRBNode)y.right()).getColor()==Color.BLACK))) {
						
						//System.out.println("deleteRecolor");
						reColor(removed,r,parent,y);
						if(adjusted==true) {
							break;
						}
						}
						else if(y.getColor()==Color.RED) {
							
							MyRBNode x;
							if(y.left()!=null) {
								x=(MyRBNode) y.left();
							}else {
								x=(MyRBNode) y.right();
							}
							MyRBNode z=(MyRBNode) y.parent();
							//System.out.println("deleteAdjustment");
							restructure(x,y,z);
							
							adjusted=true;
						}
						if(adjusted) {

							//DoNothing... 
						}
						else {
							if(r==null) {
								r=removedParent;
							}
							else {
								r=(MyRBNode) r.parent();
							}
							parent=(MyRBNode) r.parent();

						}
						if(parent!=null) {
							if(parent.left()==r) {
								y=(MyRBNode) parent.right();
							}else {
								y=(MyRBNode) parent.left();
							}
						}

					}
					
					
			}


		}
		else {//not double black...
			if(r!=null) {
				r.setColor(Color.BLACK);
			}
		}
		
		
		return removed;
	}
}
