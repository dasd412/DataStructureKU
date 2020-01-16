package graph;



public class Vertex implements Data{

	private Object data;
	private Vertex reference;
	private Label label;
	private int topologicalNumber;
	
	
	public Vertex(Object data) {
		this.data=data;
		this.label=Label.UNEXPLORED;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Vertex getReference() {
		return reference;
	}

	public void setReference(Vertex reference) {
		this.reference = reference;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public int getTopologicalNumber() {
		return topologicalNumber;
	}

	public void setTopologicalNumber(int topologicalNumber) {
		this.topologicalNumber = topologicalNumber;
	}
	
	
	
	
}
