package graph.adjacenlisttgraph;

import java.util.ArrayList;

import graph.Edge;
import graph.Vertex;

public class AdjacentListVertex extends Vertex{

	private ArrayList<Edge>adjacentEdges;
	
	
	public AdjacentListVertex(Object data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.adjacentEdges=new ArrayList<>();
	}


	public ArrayList<Edge> getAdjacentEdges() {
		return adjacentEdges;
	}


	public void setAdjacentEdges(ArrayList<Edge> adjacentEdges) {
		this.adjacentEdges = adjacentEdges;
	}
	
	

	
}
