package graph.adjacentmatrixgraph;

import graph.Vertex;

public class MatrixVertex extends Vertex{
	
	private int index;

	public MatrixVertex(Object data, int index) {
		super(data);
		this.index=index;
		// TODO Auto-generated constructor stub
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	
	
}
