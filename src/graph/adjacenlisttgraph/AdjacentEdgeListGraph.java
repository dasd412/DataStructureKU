package graph.adjacenlisttgraph;

import java.util.ArrayList;

import graph.AdjacentGraph;
import graph.Edge;
import graph.EdgeListGraph;
import graph.Incident;
import graph.Opposite;
import graph.Vertex;

public class AdjacentEdgeListGraph extends EdgeListGraph implements AdjacentGraph,Incident,Opposite{

	
	public AdjacentEdgeListGraph() {
		super();
	}
	
	public AdjacentListVertex insertListVertex(Object e) {
		AdjacentListVertex v=new AdjacentListVertex(e);
		super.vertices.add(v);
		v.setReference(vertices.get(vertexCount));
		super.vertexCount++;
		
		return v;
	}
	
	public AdjacentEdge insertListEdge(Vertex origin, Vertex destination, Object e)throws ClassCastException {

		AdjacentEdge edge=new AdjacentEdge(e, origin, destination);
		((AdjacentListVertex)origin).getAdjacentEdges().add(edge);
		((AdjacentListVertex)destination).getAdjacentEdges().add(edge);
  
		edge.setAdjacentOrigin((AdjacentEdge) ((AdjacentListVertex)origin).getAdjacentEdges().get(((AdjacentListVertex)origin).getAdjacentEdges().size()-1));
		edge.setAdjacentDestination((AdjacentEdge) ((AdjacentListVertex)destination).getAdjacentEdges().get(((AdjacentListVertex)destination).getAdjacentEdges().size()-1));
		
		super.edges.add(edge);
    	edge.setReference(edges.get(edgeCount));
    	this.edgeCount++;
    	
		return edge;
	}
	@Override
	public ArrayList<Edge> incidentEdge(Vertex vertex)throws ClassCastException {
		// TODO Auto-generated method stub
		ArrayList<Edge>incidentEdges=((AdjacentListVertex)vertex).getAdjacentEdges();
		
		return incidentEdges;
	}

	@Override
	public Vertex opposite(Vertex vertex, Edge edge) {
		// TODO Auto-generated method stub
		Vertex origin=edge.getOrigin();
		Vertex destination=edge.getDestination();
		
		if(origin.equals(vertex)) {
			return destination;
		}
		else {
			return origin;
		}
	}

	@Override
	public boolean areAdjacent(Vertex v, Vertex w) throws ClassCastException{
		// TODO Auto-generated method stub
		ArrayList<Edge>incidentEdges=((AdjacentListVertex)v).getAdjacentEdges();
		AdjacentEdge adjacentEdge;
		boolean areAdjacent=false;
		
		for(int i=0;i<incidentEdges.size();i++) {
			adjacentEdge=(AdjacentEdge) incidentEdges.get(i);
		    if(adjacentEdge.getOrigin().equals(w)||adjacentEdge.getDestination().equals(w)) {
		    	areAdjacent=true;
		    }
		}
		
		return areAdjacent;
	}

	@Override
	public Object removeVertex(Vertex vertex)throws ClassCastException {
		// TODO Auto-generated method stub
		Object temp=vertex.getData();
		ArrayList<Edge>incidentEdges=this.incidentEdge(vertex);
		Edge incidentEdge=null;
		Edge otherReference=null;
		AdjacentListVertex otherVertex=null;
		
		
		
		for(int i=0;i<incidentEdges.size();i++) {
			incidentEdge=((AdjacentListVertex)vertex).getAdjacentEdges().get(i);
			System.out.println("test"+incidentEdge.getData());
			
			if(((AdjacentEdge)incidentEdge).getAdjacentOrigin()==incidentEdge) {
				otherReference=((AdjacentEdge)incidentEdge).getAdjacentDestination();
			    otherVertex=(AdjacentListVertex) incidentEdge.getDestination();
			}else {
				otherReference=((AdjacentEdge)incidentEdge).getAdjacentOrigin();
			    otherVertex=(AdjacentListVertex) incidentEdge.getOrigin();
			}
			//System.out.println("TEST"+otherReference.getData());
			otherVertex.getAdjacentEdges().remove(otherReference);
			super.edges.remove(incidentEdge);
			
			
		}
		
		incidentEdges.removeAll(incidentEdges);//<-point!!
		
		super.vertices.remove(vertex);
		
		return temp;
	}

	@Override
	  public Object removeEdge(Edge edge) throws ClassCastException{
    	Object temp=edge.getData();
    	AdjacentEdge start=((AdjacentEdge)edge).getAdjacentOrigin();
    	AdjacentEdge end=((AdjacentEdge)edge).getAdjacentDestination();
    	
    	AdjacentListVertex origin=(AdjacentListVertex) edge.getOrigin();
    	AdjacentListVertex destination=(AdjacentListVertex) edge.getDestination();
    	
    	origin.getAdjacentEdges().remove(start);
    	destination.getAdjacentEdges().remove(end);
    	
    	
    	edges.remove(edge);
    	this.edgeCount--;
    	
    	
    	return temp;
    }
}
