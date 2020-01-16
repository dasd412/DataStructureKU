package dfs;

import java.util.ArrayList;

import graph.Edge;
import graph.Vertex;
import graph.adjacenlisttgraph.AdjacentEdgeListGraph;
import graph.adjacenlisttgraph.AdjacentListVertex;
import graph.adjacentmatrixgraph.AdjacentMatrixGraph;
import graph.adjacentmatrixgraph.MatrixVertex;

public class DFSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		AdjacentEdgeListGraph aeg=new AdjacentEdgeListGraph();
//		AdjacentListVertex u= aeg.insertListVertex('u');
//		AdjacentListVertex v= aeg.insertListVertex('v');
//		AdjacentListVertex x= aeg.insertListVertex('x');
//		AdjacentListVertex w= aeg.insertListVertex('w');
//		AdjacentListVertex y= aeg.insertListVertex('y');
//		
//		Edge a=aeg.insertListEdge(u, v, 'a');
//		Edge b=aeg.insertListEdge(v, w, 'b');
//		Edge c=aeg.insertListEdge(v, x, 'c');
//		Edge d=aeg.insertListEdge(u, w, 'd');
//		Edge e=aeg.insertListEdge(w, x, 'e');
//		Edge f=aeg.insertListEdge(w, y, 'f');
//		Edge g=aeg.insertListEdge(x, y, 'g');
//		
//		DFS dfs=new DFS(aeg);
//		dfs.DFSTravel(aeg, u);
//		
//		ArrayList<Vertex> vertices=aeg.vertices();
//		for(Vertex vx:vertices) {
//			System.out.println("vertex : "+vx.getData()+ " travel : "+vx.getLabel());
//		}
//		
//		ArrayList<Edge> edges=aeg.edges();
//		for(Edge edge:edges) {
//			System.out.println("edge : "+edge.getData()+ " travel : "+edge.getLabel());
//		}
		System.out.println("Path Finding");
		
		AdjacentMatrixGraph amg=new AdjacentMatrixGraph();
		MatrixVertex a= amg.insertMatrixVertex('a');
		MatrixVertex b= amg.insertMatrixVertex('b');
		MatrixVertex c= amg.insertMatrixVertex('c');
		MatrixVertex d= amg.insertMatrixVertex('d');
		MatrixVertex e= amg.insertMatrixVertex('e');
		
		Edge ab=amg.insertMatrixEdge(a, b, "ab");
		Edge bc=amg.insertMatrixEdge(b, c, "bc");
		Edge ca=amg.insertMatrixEdge(c, a, "ca");
		Edge cd=amg.insertMatrixEdge(c, d, "cd");
		Edge da=amg.insertMatrixEdge(d, a, "da");
		Edge ce=amg.insertMatrixEdge(e, c,"ce");
		
		
		DFS dfs=new DFS(amg);
		dfs.pathFindDFS(amg, a, e);
		
		System.out.println("Cycle Finding");
		
		AdjacentMatrixGraph amgs=new AdjacentMatrixGraph();
		MatrixVertex aa= amgs.insertMatrixVertex('a');
		MatrixVertex bb= amgs.insertMatrixVertex('b');
		MatrixVertex cc= amgs.insertMatrixVertex('c');
		MatrixVertex dd= amgs.insertMatrixVertex('d');
		
		Edge Ab=amgs.insertMatrixEdge(aa, bb, "ab");
		Edge Bc=amgs.insertMatrixEdge(bb, cc, "bc");
		Edge Cd=amgs.insertMatrixEdge(cc, dd, "cd");
		Edge Da=amgs.insertMatrixEdge(dd, bb, "db");
		
		dfs.cycleDFS(amgs, aa);
		
	}

}
