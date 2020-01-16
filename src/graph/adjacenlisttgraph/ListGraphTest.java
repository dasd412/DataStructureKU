package graph.adjacenlisttgraph;

import java.util.ArrayList;

import graph.Edge;
import graph.Vertex;
import graph.adjacentmatrixgraph.MatrixVertex;

public class ListGraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AdjacentEdgeListGraph aeg=new AdjacentEdgeListGraph();
		AdjacentListVertex u= aeg.insertListVertex('u');
		AdjacentListVertex v= aeg.insertListVertex('v');
		AdjacentListVertex x= aeg.insertListVertex('x');
		AdjacentListVertex w= aeg.insertListVertex('w');
		AdjacentListVertex y= aeg.insertListVertex('y');
		
		Edge a=aeg.insertListEdge(u, v, 'a');
		Edge b=aeg.insertListEdge(v, w, 'b');
		Edge c=aeg.insertListEdge(v, x, 'c');
		Edge d=aeg.insertListEdge(u, w, 'd');
		Edge e=aeg.insertListEdge(w, x, 'e');
		Edge f=aeg.insertListEdge(w, y, 'f');
		Edge g=aeg.insertListEdge(x, y, 'g');
		
//		ArrayList<Vertex> vertices=aeg.vertices();
//		for(Vertex vx:vertices) {
//			System.out.println("vertex : "+vx.getData());
//		}
//		
//		ArrayList<Edge> edges=aeg.edges();
//		for(Edge edge:edges) {
//			System.out.println("edge : "+edge.getData());
//		}
		
		ArrayList<Vertex> endPoints=aeg.endVertices(e);
		for(Vertex vx:endPoints) {
			System.out.println("endPoints : "+vx.getData());
		}
		
//		ArrayList<Edge>incident=aeg.incidentEdge(v);
//		for(Edge edge:incident) {
//			System.out.println("incidentEdges : "+edge.getData());
//		}
		
		System.out.println("opposite : "+aeg.opposite(v, a).getData());
		
		System.out.println("areAdjacent : "+aeg.areAdjacent(v, y));
	
	
		AdjacentListVertex z =aeg.insertListVertex('z');
		Edge h =aeg.insertListEdge(x, z, 'h');
		aeg.removeEdge(f);
		
		
		
		
		
		aeg.removeVertex(w);//d&b removal needed; 
	
		ArrayList<Vertex> vertices=aeg.vertices();
		for(Vertex vx:vertices) {
			System.out.println("vertex : "+vx.getData());
		}
		
		ArrayList<Edge> edges=aeg.edges();
		for(Edge edge:edges) {
			System.out.println("edge : "+edge.getData());
		}
		
		ArrayList<Edge>incident=aeg.incidentEdge(w);
		for(Edge edge:incident) {
			System.out.println("incidentEdges : "+edge.getData());
		}
		
	}

}
