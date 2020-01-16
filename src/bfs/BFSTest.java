package bfs;

import java.util.ArrayList;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import graph.adjacenlisttgraph.AdjacentEdgeListGraph;
import graph.adjacenlisttgraph.AdjacentListVertex;

public class BFSTest {
	public static void main(String[] args) {
		
		AdjacentEdgeListGraph alg=new AdjacentEdgeListGraph();
		AdjacentListVertex a= alg.insertListVertex('a');
		AdjacentListVertex b= alg.insertListVertex('b');
		AdjacentListVertex c= alg.insertListVertex('c');
		AdjacentListVertex d= alg.insertListVertex('d');
		AdjacentListVertex e= alg.insertListVertex('e');
		AdjacentListVertex f= alg.insertListVertex('f');
		
		Edge ab=alg.insertListEdge(a, b, "ab");
		Edge ac=alg.insertListEdge(a, c, "ac");
		Edge ad=alg.insertListEdge(a, d, "ad");
		Edge bc=alg.insertListEdge(b, c, "bc");
		Edge cd=alg.insertListEdge(c, d, "cd");
		Edge be=alg.insertListEdge(b, e, "be");
		Edge ce=alg.insertListEdge(c, e, "ce");
		Edge cf=alg.insertListEdge(c, f, "cf");
		Edge df=alg.insertListEdge(d, f, "df");
		
		
		BFS bfs=new BFS(alg);
		bfs.BFSTravel(alg, a);
		
		ArrayList<Vertex> vertices=alg.vertices();
		for(Vertex vx:vertices) {
			System.out.println("vertex : "+vx.getData()+ " travel : "+vx.getLabel());
		}
		
		ArrayList<Edge> edges=alg.edges();
		for(Edge edge:edges) {
			System.out.println("edge : "+edge.getData()+ " travel : "+edge.getLabel());
		}
	}

}
