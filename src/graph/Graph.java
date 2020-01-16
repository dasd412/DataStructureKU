package graph;

import java.util.ArrayList;

import graph.adjacenlisttgraph.AdjacentListVertex;

public interface Graph {

	public ArrayList<Vertex> vertices();
	
	public ArrayList<Edge> edges();
	
    public ArrayList<Vertex> endVertices(Edge edge);
    
    public Vertex replace(Vertex vertex, Object e);
	
    public Edge replace(Edge edge, Object e);
    
    public Vertex insertVertex(Object e);
    
    public Edge insertEdge(Vertex origin, Vertex destination, Object e);
    
    public Object removeEdge(Edge edge);
    
   
}
