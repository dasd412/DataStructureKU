package digraph;

import graph.Edge;
import graph.Vertex;

public interface Direction {

	public boolean isDirected(Edge edge);
	public Edge insertDirectedEdge(Vertex origin, Vertex destination, Object e);
	
}
