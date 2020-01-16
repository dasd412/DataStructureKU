package searchtree;

public class MyAVL extends BST {

	public MyAVL() {
		super();
	}
	
	public MyAVL(Object e) {
		super(e);
	}
	
	
	private int height(MyBinNode v) {
		if(v==null) {
			return 0;
		}
		
		return 1+Math.max(height(v.left()), height(v.right()));
	}
	
	private void restructure(MyBinNode x, MyBinNode y, MyBinNode z) {


		if((int)y.element()<=(int)z.element()) {
			if((int)x.element()<=(int)y.element()) {
				//System.out.println("leftSingle");
				leftSingle(x,y,z);
			}else {
				//System.out.println("leftDouble");
				leftDouble(x,y,z);
			}
		}

		if((int)z.element()<(int)y.element()) {
			if((int)y.element()<(int)x.element()) {
				//System.out.println("rightSingle");
				rightSingle(x,y,z);
			}else {
				//System.out.println("rightDouble");
				rightDouble(x,y,z);
			}
		}


	}
	
	private void leftSingle(MyBinNode x, MyBinNode y, MyBinNode z) {

		MyBinNode parent=(MyBinNode)z.parent();
		if(parent==null) {
			super.root=y;
			y.setParent(null);
		}else {
			y.setParent(parent);
			if((int)parent.element()<(int)y.element()) {//<-><->
				parent.setRight(y);
			}else {
				parent.setLeft(y);
			}
		}
		
		z.setParent(y);
		z.setLeft(y.right());
		
		if(y.right()!=null) {
			y.right().setParent(z);
		}
		
		y.setRight(z);
		
		y.setLeft(x);
		x.setParent(y);
		
		//System.out.println("LS"+z.parent().element()+" "+y.right().element()+" "+x.parent().element()+" "+y.parent().element()+" "+y.left().element());
	}

	private void rightSingle(MyBinNode x, MyBinNode y, MyBinNode z) {

		MyBinNode parent=(MyBinNode) z.parent();
		if(parent==null) {
			//case of RootNode
			super.root=y;
			y.setParent(null);
		}
		else {
			y.setParent(parent);
			if((int)parent.element()<(int)y.element()){//<-><->
				parent.setRight(y);
			}else {
				parent.setLeft(y);
			}
		}
		
		z.setParent(y);
		z.setRight(y.left());
		
		if(y.left()!=null) {
			y.left().setParent(z);
		}
		
		y.setLeft(z);
		
		y.setRight(x);
		x.setParent(y);
	}

	private void leftDouble(MyBinNode x, MyBinNode y, MyBinNode z) {

		MyBinNode parent=(MyBinNode) z.parent();
		if(parent==null) {
			super.root=x;
			x.setParent(null);
		}else {
			x.setParent(parent);
		    if((int)parent.element()<(int)x.element()) {
		    	parent.setRight(x);
		    }else {
		    	parent.setLeft(x);
		    }
		}

		y.setRight(x.left());
		
		if(x.left()!=null) {
			x.left().setParent(y);
		}
		
		x.setLeft(y);
		y.setParent(x);
		

		z.setLeft(x.right());
		
		
		if(x.right()!=null) {
			x.right().setParent(z);
		}
		
		
		x.setRight(z);
		z.setParent(x);
		
		//System.out.println("LD"+x.left().element()+" "+x.right().element()+" "+y.parent().element()+" "+" "+z.parent().element());
		
	}
	private void rightDouble(MyBinNode x, MyBinNode y, MyBinNode z) {

		MyBinNode parent=(MyBinNode) z.parent();
		if(parent==null) {
			super.root=x;
			x.setParent(null);
		}else {
			x.setParent(parent);
			if((int)parent.element()<(int)x.element()) {
				parent.setRight(x);
			}else {
				parent.setLeft(x);
			}
		}
		

		y.setLeft(x.right());
		if(x.right()!=null) {
			x.right().setParent(y);
		}
		
		x.setRight(y);
		y.setParent(x);
		

		z.setRight(x.left());
		if(x.left()!=null) {
			x.left().setParent(z);
		}
		
		
		x.setLeft(z);
		z.setParent(x);
		
		
	}
	
	
	@Override
	public MyBinNode insert(Object k) {
		MyBinNode recent=super.insert(k);
		
		if(recent==null) {//<->
			return null;
		}
		
		MyBinNode temp=recent;//<->
		MyBinNode x=null;
		MyBinNode y=null;
		MyBinNode z=null;//firstUnbalanced
		
		while(true) {
			x=temp;
			
			if(x.parent()!=null) {//<->
				y=(MyBinNode) x.parent();
			}else {
				y=null;
			}
			
			if(y.parent()!=null) {//<->
				z=(MyBinNode) y.parent();
			}
			else {
				z=null;
			}
			
			if(y==null||z==null) {
				break;
			}
			
			boolean isUnbalanced=Math.abs(height(z.left())-height(z.right()))>1;
			
			
			if(isUnbalanced) {
				restructure(x,y,z);
				
				break;
			}
			
			
			temp=(MyBinNode) temp.parent();//<->
		}
		
		
		return recent;
	}
	
	@Override
	public MyBinNode remove(Object k) {
		MyBinNode removed=super.remove(k);
		
		if(removed==null) {
			return null;
		}
		
		MyBinNode w=(MyBinNode) removed.parent();
		MyBinNode x=null;
		MyBinNode y=null;
		MyBinNode z=null;
		
		
		
		while(w!=null) {//<-><->
			

			if(Math.abs(height(w.left())-height(w.right()))>1) {
				if((int)removed.element()<(int)w.element()) {
					y=w.right();
					x=y.right();
				}
				else {
					y=w.left();
					x=y.left();
				}
				z=w;
				restructure(x,y,z);
				
			}
			
			w=(MyBinNode) w.parent();
		}
		
		
		return removed;
	}
}
