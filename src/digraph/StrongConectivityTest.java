package digraph;

import java.util.ArrayList;

import graph.Edge;
import graph.Vertex;
import graph.adjacenlisttgraph.AdjacentListVertex;

public class StrongConectivityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		DigraphAL graph=new DigraphAL();
//		AdjacentListVertex a= graph.insertListVertex('a');
//		AdjacentListVertex b= graph.insertListVertex('b');
//		AdjacentListVertex c= graph.insertListVertex('c');
//		AdjacentListVertex d= graph.insertListVertex('d');
//		AdjacentListVertex s= graph.insertListVertex('s');
//		
//		Edge ac=graph.insertDirectedEdge(a, c, "ac");
//		Edge sa=graph.insertDirectedEdge(s, a, "sa");
//		Edge ad=graph.insertDirectedEdge(a, d, "ad");
//		Edge dc=graph.insertDirectedEdge(d, c, "dc");
//		Edge cs=graph.insertDirectedEdge(c, s, "cs");
//		Edge sd=graph.insertDirectedEdge(s, d, "sd");
//		Edge sb=graph.insertDirectedEdge(s, b, "sb");
//		Edge bd=graph.insertDirectedEdge(b, d, "bd");
//		
//		DigraphDFS dfs=new DigraphDFS(graph);
//		dfs.DFSTravel(graph, s);
//		
//		ArrayList<Vertex> vertices=graph.vertices();
//		for(Vertex vx:vertices) {
//			System.out.println("vertex : "+vx.getData()+ " travel : "+vx.getLabel());
//		}
//		
//		ArrayList<Edge> edges=graph.edges();
//		for(Edge edge:edges) {
//			System.out.println("edge : "+edge.getData()+ " travel : "+edge.getLabel());
//		}
		
		DigraphAL reveresedGraph=new DigraphAL();
		AdjacentListVertex a= reveresedGraph.insertListVertex('a');
		AdjacentListVertex b= reveresedGraph.insertListVertex('b');
		AdjacentListVertex c= reveresedGraph.insertListVertex('c');
		AdjacentListVertex d= reveresedGraph.insertListVertex('d');
		AdjacentListVertex s= reveresedGraph.insertListVertex('s');
		
		Edge ca=reveresedGraph.insertDirectedEdge(c, a, "ca");
		Edge as=reveresedGraph.insertDirectedEdge(a, s, "as");
		Edge da=reveresedGraph.insertDirectedEdge(d, a, "da");
		Edge cd=reveresedGraph.insertDirectedEdge(c, d, "cd");
		Edge sc=reveresedGraph.insertDirectedEdge(s, c, "sc");
		Edge ds=reveresedGraph.insertDirectedEdge(d, s, "ds");
		Edge bs=reveresedGraph.insertDirectedEdge(b, s, "bs");
		Edge db=reveresedGraph.insertDirectedEdge(d, b, "db");
		
		DigraphDFS dfs=new DigraphDFS(reveresedGraph);
		dfs.DFSTravel(reveresedGraph, s);
		
		ArrayList<Vertex> vertices=reveresedGraph.vertices();
		for(Vertex vx:vertices) {
			System.out.println("vertex : "+vx.getData()+ " travel : "+vx.getLabel());
		}
		
		ArrayList<Edge> edges=reveresedGraph.edges();
		for(Edge edge:edges) {
			System.out.println("edge : "+edge.getData()+ " travel : "+edge.getLabel());
		}
	}

}
