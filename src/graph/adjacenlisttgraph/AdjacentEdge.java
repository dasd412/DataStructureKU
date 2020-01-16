package graph.adjacenlisttgraph;

import graph.Edge;
import graph.Vertex;

public class AdjacentEdge extends Edge{
	
	protected AdjacentEdge adjacentOrigin;
	protected AdjacentEdge adjacentDestination;

	public AdjacentEdge(Object data, Vertex origin, Vertex desti) {
		super(data, origin, desti);
		
		// TODO Auto-generated constructor stub
	}

	public AdjacentEdge getAdjacentOrigin() {
		return adjacentOrigin;
	}

	public void setAdjacentOrigin(AdjacentEdge adjacentOrigin) {
		this.adjacentOrigin = adjacentOrigin;
	}

	public AdjacentEdge getAdjacentDestination() {
		return adjacentDestination;
	}

	public void setAdjacentDestination(AdjacentEdge adjacentDestination) {
		this.adjacentDestination = adjacentDestination;
	}
	

	
	
}
