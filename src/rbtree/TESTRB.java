package rbtree;

public class TESTRB {
	public static void main(String[] args) {

		RBTree tree=new RBTree();
		for(int i=0;i<32;i++) {
			int randNum=(int)((Math.random()*100)+1);
			tree.insert(randNum);
		}

		System.out.println("inOrder");
		tree.inOrderPrint((MyRBNode) tree.root);
		System.out.println();
		
		System.out.println("remove start");
		for(int i=0;i<16;i++) {
			int randNum=(int)((Math.random()*100)+1);
			System.out.println(randNum);
			tree.remove(randNum);
		}
		


		
		System.out.println("inOrder");
		tree.inOrderPrint((MyRBNode) tree.root);
		
	}
	
	
}
