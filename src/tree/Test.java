package tree;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyTree<String>tree=new MyTree<String>();
		tree.addRoot("Make Money Fast!");
		MyNode<String> one=tree.addNode("1.Motivations");
		MyNode<String> two=tree.addNode("2.Methods");
		tree.addNode("Reference");
		tree.addChild(one, "1.1 Greed");
		tree.addChild(one, "1.2. Avidity");
		tree.addChild(two, "2.1.Stock Fraud");
		tree.addChild(two, "2.2 Ponzi Scheme");
		tree.addChild(two, "2.3 Bank Robbery");
		
	
		tree.preOrder(tree.root());
		
		System.out.println("-------------------------");
	
		MyTree<ProgramData>tree1=new MyTree<ProgramData>();
		tree1.addRoot(new ProgramData("cs16/",""));
		MyNode<ProgramData> h=tree1.addNode(new ProgramData("homeworks/",""));
		MyNode<ProgramData> p=tree1.addNode(new ProgramData("programs/",""));
		tree1.addNode(new ProgramData("todo.txt","1k"));
		tree1.addChild(h, new ProgramData("h1.doc","3k"));
		tree1.addChild(h, new ProgramData("h1nc.doc","2k"));
		tree1.addChild(p, new ProgramData("DDR.java","10k"));
		tree1.addChild(p, new ProgramData("Stocks.java","25k"));
		tree1.addChild(p, new ProgramData("Robot.java","20k"));
		
     	tree1.postOrder(tree1.root());

	}

}
