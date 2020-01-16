package graph;



public class Edge implements Data{

	private Object data;
	private Edge reference;
	private Vertex origin;
	private Vertex destination;
	private Label label;
	
	
	public Edge(Object data,Vertex origin, Vertex desti) {
		this.data=data;
		this.origin=origin;
		this.destination=desti;
		this.label=Label.UNEXPLORED;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Edge getReference() {
		return reference;
	}

	public void setReference(Edge reference) {
		this.reference = reference;
	}

	public Vertex getOrigin() {
		return origin;
	}

	public void setOrigin(Vertex origin) {
		this.origin = origin;
	}

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
	
	
	
}
