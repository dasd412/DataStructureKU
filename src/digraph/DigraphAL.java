package digraph;

import java.util.ArrayList;

import graph.Edge;
import graph.Vertex;
import graph.adjacenlisttgraph.AdjacentEdge;
import graph.adjacenlisttgraph.AdjacentEdgeListGraph;
import graph.adjacenlisttgraph.AdjacentListVertex;

public class DigraphAL extends AdjacentEdgeListGraph implements Direction{

	
	public DigraphAL() {
		super();
	}
	
	public ArrayList<Edge> incidentOutgoingEdge(Vertex vertex)throws ClassCastException {
		// TODO Auto-generated method stub
		ArrayList<Edge>incidentEdges=((AdjacentListVertex)vertex).getAdjacentEdges();
		ArrayList<Edge>incidentOutgoingEdges=new ArrayList<>();
		
		for(Edge edge:incidentEdges) {
			if(edge.getOrigin().equals(vertex)) {
				incidentOutgoingEdges.add(edge);
			}
		}
		return incidentOutgoingEdges;
	}

	
	@Override
	public Vertex opposite(Vertex vertex, Edge edge) {
		// TODO Auto-generated method stub
      return edge.getDestination();
	}
	
	@Override
	public ArrayList<Vertex> endVertices(Edge edge){
		ArrayList<Vertex>vertices=new ArrayList<Vertex>(2);
		vertices.add(edge.getOrigin());
		vertices.add(edge.getDestination());
		return vertices;
	}
	@Override
	public Edge insertEdge(Vertex origin, Vertex destination, Object e) throws IllegalStateException{
		throw new IllegalStateException("As it is directed graph... dont't use this method...");
	}
	
	@Override
	public AdjacentEdge insertListEdge(Vertex origin, Vertex destination, Object e)throws IllegalStateException {
	throw new IllegalStateException("As it is directed graph... dont't use this method...");
	}
	
	
	@Override
	public boolean isDirected(Edge edge) {
		// TODO Auto-generated method stub
		if(edge instanceof DirectedEdge) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Edge insertDirectedEdge(Vertex origin, Vertex destination, Object e) {
		// TODO Auto-generated method stub
		Edge de=new DirectedALEdge(e,origin,destination);
		
		((AdjacentListVertex)origin).getAdjacentEdges().add(de);
		((AdjacentListVertex)destination).getAdjacentEdges().add(de);
		
		((DirectedALEdge)de).setAdjacentOrigin((AdjacentEdge) ((AdjacentListVertex)origin).getAdjacentEdges().get(((AdjacentListVertex)origin).getAdjacentEdges().size()-1));
		((DirectedALEdge)de).setAdjacentDestination((AdjacentEdge) ((AdjacentListVertex)destination).getAdjacentEdges().get(((AdjacentListVertex)destination).getAdjacentEdges().size()-1));
		
		super.edges.add(de);
		de.setReference(super.edges.get(edgeCount));
		super.edgeCount++;
		
		
		
		return de;
	}

}
