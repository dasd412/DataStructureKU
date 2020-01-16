package graph;

import java.util.ArrayList;

public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EdgeListGraph elg=new EdgeListGraph();
		Vertex u=elg.insertVertex('u');
		Vertex v=elg.insertVertex('v');
		Vertex x=elg.insertVertex('x');
		Vertex w=elg.insertVertex('w');
		Vertex y=elg.insertVertex('y');
		
		Edge a=elg.insertEdge(u, v, 'a');
		Edge b=elg.insertEdge(v, w, 'b');
		Edge c=elg.insertEdge(v, x, 'c');
		Edge d=elg.insertEdge(u, v, 'd');
		Edge e=elg.insertEdge(w, x, 'e');
		Edge f=elg.insertEdge(w, y, 'f');
		Edge g=elg.insertEdge(x, y, 'g');
		
		ArrayList<Vertex> vertices=elg.vertices();
		for(Vertex vx:vertices) {
			System.out.println("vertex : "+vx.getData());
		}
		
		ArrayList<Edge> edges=elg.edges();
		for(Edge edge:edges) {
			System.out.println("edge : "+edge.getData());
		}
		
		ArrayList<Vertex> endPoints=elg.endVertices(e);
		for(Vertex vx:endPoints) {
			System.out.println("endPoints : "+vx.getData());
		}
	}

}
