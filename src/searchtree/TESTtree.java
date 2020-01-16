package searchtree;

import java.util.ArrayList;

public class TESTtree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BST bst=new BST();
		bst.insert(6);
		bst.insert(2);
		bst.insert(9);		
		bst.insert(1);
		bst.insert(4);
		bst.insert(8);
		bst.insert(9);

		
		
		System.out.println(bst.find(8));
		System.out.println(bst.find(3));
		System.out.println(bst.insert(3));
		System.out.println(bst.insert(7));
		System.out.println(bst.insert(9));
		System.out.println(bst.remove(1));
		System.out.println(bst.remove(4));
		System.out.println(bst.remove(6));
		System.out.println(bst.find(3));
		System.out.println(bst.find(6));
		ArrayList<MyBinNode> list=bst.findAll(9);
		
		for(int i=0;i<list.size();i++) {
			System.out.println("found"+list.get(i));
		}
		
		bst.inOrder(bst.root());
	}

}
