package graph.adjacentmatrixgraph;

import java.util.ArrayList;

import graph.Edge;
import graph.Vertex;

public class MatrixGraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AdjacentMatrixGraph amg=new AdjacentMatrixGraph();
		MatrixVertex u= amg.insertMatrixVertex('u');
		MatrixVertex v= amg.insertMatrixVertex('v');
		MatrixVertex x= amg.insertMatrixVertex('x');
		MatrixVertex w= amg.insertMatrixVertex('w');
		MatrixVertex y= amg.insertMatrixVertex('y');
		
		Edge a=amg.insertMatrixEdge(u, v, 'a');
		Edge b=amg.insertMatrixEdge(v, w, 'b');
		Edge c=amg.insertMatrixEdge(v, x, 'c');
		Edge d=amg.insertMatrixEdge(u, w, 'd');
		Edge e=amg.insertMatrixEdge(w, x, 'e');
		Edge f=amg.insertMatrixEdge(w, y, 'f');
		Edge g=amg.insertMatrixEdge(x, y, 'g');
		
//		ArrayList<Vertex> vertices=amg.vertices();
//		for(Vertex vx:vertices) {
//			System.out.println("vertex : "+vx.getData());
//		}
//		
//		ArrayList<Edge> edges=amg.edges();
//		for(Edge edge:edges) {
//			System.out.println("edge : "+edge.getData());
//		}
//		
		ArrayList<Vertex> endPoints=amg.endVertices(e);
		for(Vertex vx:endPoints) {
			System.out.println("endPoints : "+vx.getData());
		}
		
//		ArrayList<Edge>incident=amg.incidentEdge(v);
//		for(Edge edge:incident) {
//			System.out.println("incidentEdges : "+edge.getData());
//		}
		
		System.out.println("opposite : "+amg.opposite(v, a).getData());
		
		System.out.println("areAdjacent : "+amg.areAdjacent(v, y));
		
		MatrixVertex z =amg.insertMatrixVertex('z');
		Edge h =amg.insertMatrixEdge(x, z, 'h');
		
		amg.removeEdge(f);
		amg.removeVertex(w);
	
		ArrayList<Vertex> vertices=amg.vertices();
		for(Vertex vx:vertices) {
			System.out.println("vertex : "+vx.getData());
		}
		
		ArrayList<Edge> edges=amg.edges();
		for(Edge edge:edges) {
			System.out.println("edge : "+edge.getData());
		}
		ArrayList<Edge>incident=amg.incidentEdge(v);
		for(Edge edge:incident) {
			System.out.println("incidentEdges : "+edge.getData());
		}
	}

}
