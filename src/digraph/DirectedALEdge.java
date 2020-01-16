package digraph;

import graph.Vertex;
import graph.adjacenlisttgraph.AdjacentEdge;

public class DirectedALEdge extends AdjacentEdge implements DirectedEdge{

    protected boolean isDirected=true;
	
	public DirectedALEdge(Object data, Vertex origin, Vertex desti) {
		super(data, origin, desti);
		this.isDirected=true;
		// TODO Auto-generated constructor stub
	}

	public boolean isDirected() {
		return isDirected;
	}

	
}
