package rbtree;

public class MyRBNode extends MyBinNode{

	private Color color;
	
	public MyRBNode() {
		super();
	}
	
	public MyRBNode(Object e) {
		super(e);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
