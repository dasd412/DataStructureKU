package graph;

import java.util.ArrayList;

public interface AdjacentGraph extends Graph{

	
	
	
	
	public ArrayList<Vertex> endVertices(Edge edge);
	
	public boolean areAdjacent(Vertex v, Vertex w);
	
	public Object removeVertex(Vertex vertex);
	
}
