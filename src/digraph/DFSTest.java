package digraph;

import java.util.ArrayList;

import dfs.DFS;
import graph.Edge;
import graph.Vertex;
import graph.adjacenlisttgraph.AdjacentListVertex;


public class DFSTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DigraphAL graph=new DigraphAL();
		AdjacentListVertex a= graph.insertListVertex('a');
		AdjacentListVertex b= graph.insertListVertex('b');
		AdjacentListVertex c= graph.insertListVertex('c');
		AdjacentListVertex d= graph.insertListVertex('d');
		AdjacentListVertex s= graph.insertListVertex('s');
		
		Edge ac=graph.insertDirectedEdge(a, c, "ac");
		Edge as=graph.insertDirectedEdge(s, a, "sa");
		Edge ad=graph.insertDirectedEdge(a, d, "ad");
		Edge dc=graph.insertDirectedEdge(d, c, "dc");
		Edge cs=graph.insertDirectedEdge(c, s, "cs");
		Edge sd=graph.insertDirectedEdge(s, d, "sd");
		Edge sb=graph.insertDirectedEdge(s, b, "sb");
		Edge bd=graph.insertDirectedEdge(b, d, "bd");
		
		DigraphDFS dfs=new DigraphDFS(graph);
		dfs.DFSTravel(graph, s);
		
		ArrayList<Vertex> vertices=graph.vertices();
		for(Vertex vx:vertices) {
			System.out.println("vertex : "+vx.getData()+ " travel : "+vx.getLabel());
		}
		
		ArrayList<Edge> edges=graph.edges();
		for(Edge edge:edges) {
			System.out.println("edge : "+edge.getData()+ " travel : "+edge.getLabel());
		}
	}

}
