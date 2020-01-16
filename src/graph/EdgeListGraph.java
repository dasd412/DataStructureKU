package graph;

import java.util.ArrayList;
import java.util.List;

import graph.adjacenlisttgraph.AdjacentListVertex;

public class EdgeListGraph implements Graph{

	protected List<Vertex> vertices;
	protected List<Edge> edges;
	protected int vertexCount;
	protected int edgeCount;
	
	public EdgeListGraph() {
		this.vertices=new ArrayList<Vertex>();
		this.edges=new ArrayList<Edge>();
		this.vertexCount=0;
		this.edgeCount=0;
	}
	
	public ArrayList<Vertex> vertices(){
		return (ArrayList<Vertex>) this.vertices;
	}
	
	public ArrayList<Edge> edges(){
		return (ArrayList<Edge>) this.edges;
	}
	
    public ArrayList<Vertex> endVertices(Edge edge){
    	ArrayList<Vertex>endPoints=new ArrayList<>(2);
    	endPoints.add(edge.getOrigin());
        endPoints.add(edge.getDestination());
        return endPoints;
    }
    
    public Vertex replace(Vertex vertex, Object e) {
    	vertex.setData(e);
    	return vertex;
    }
	
    public Edge replace(Edge edge, Object e) {
    	edge.setData(e);
    	return edge;
    }
    
    public Vertex insertVertex(Object e) {
    	Vertex vertex=new Vertex(e);
    	vertices.add(vertex);
    	vertex.setReference(vertices.get(vertexCount));
    	this.vertexCount++;
    	
    	return vertex;
    }
    
    public Edge insertEdge(Vertex origin, Vertex destination, Object e) {
    	Edge edge=new Edge(e,origin, destination);
    	edges.add(edge);
    	edge.setReference(edges.get(edgeCount));
    	this.edgeCount++;
    	
    	return edge;
    }
    
    public Object removeEdge(Edge edge) {
    	Object temp=edge.getData();
    	edges.remove(edge);
    	this.edgeCount--;
    	return temp;
    }
	

}
