package digraph;

import java.util.ArrayList;

import graph.Edge;
import graph.Graph;
import graph.Label;
import graph.Vertex;
import graph.adjacenlisttgraph.AdjacentListVertex;

public class DAGs {

	static int n;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DigraphAL graph=new DigraphAL();
		AdjacentListVertex a= graph.insertListVertex('a');
		AdjacentListVertex b= graph.insertListVertex('b');
		AdjacentListVertex c= graph.insertListVertex('c');
		AdjacentListVertex d= graph.insertListVertex('d');
		AdjacentListVertex e= graph.insertListVertex('e');
		
		Edge ac=graph.insertDirectedEdge(a, c, "ac");
		Edge bc=graph.insertDirectedEdge(b, c, "bc");
		Edge cd=graph.insertDirectedEdge(c, d, "cd");
		Edge bd=graph.insertDirectedEdge(b, d, "bd");
		Edge de=graph.insertDirectedEdge(d, e, "de");
		
		
		 n=graph.vertices().size();
		
		for(Vertex v:graph.vertices()) {
			v.setLabel(Label.UNEXPLORED);
		}
		
		for(Edge edge:graph.edges()) {
			edge.setLabel(Label.UNEXPLORED);
		}
		
		for(Vertex v:graph.vertices()) {
			if(v.getLabel()==Label.UNEXPLORED) {
				topologicalDFS(graph,v);
				
			}
		}
		
		ArrayList<Vertex> vertices=graph.vertices();
		for(Vertex vx:vertices) {
			System.out.println("vertex : "+vx.getData()+ " travel : "+vx.getLabel()+"topologicalNumber : "+vx.getTopologicalNumber());
		}
		
		ArrayList<Edge> edges=graph.edges();
		for(Edge edge:edges) {
			System.out.println("edge : "+edge.getData()+ " travel : "+edge.getLabel());
		}
		
	}

	static void topologicalDFS(Graph g, Vertex v) {
		v.setLabel(Label.VISITED);
		
		for(Edge e:((DigraphAL)g).incidentOutgoingEdge(v)) {
			
			if(e.getLabel()==Label.UNEXPLORED) {
				Vertex w=((DigraphAL)g).opposite(v,e);
				
				if(w.getLabel()==Label.UNEXPLORED) {
					e.setLabel(Label.DISCOVERY);
					topologicalDFS(g,w);
				}
				else {
					//doNothing...
				}
				
			}
		}
		v.setTopologicalNumber(n);
		n=n-1;
		
	}
}
