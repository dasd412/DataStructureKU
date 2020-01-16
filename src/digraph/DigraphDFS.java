package digraph;

import java.util.ArrayList;

import dfs.DFS;
import graph.Edge;
import graph.EdgeListGraph;
import graph.Graph;
import graph.Label;
import graph.Vertex;
import graph.adjacenlisttgraph.AdjacentEdgeListGraph;
import graph.adjacenlisttgraph.AdjacentListVertex;
import graph.adjacentmatrixgraph.AdjacentMatrixGraph;
import graph.adjacentmatrixgraph.MatrixVertex;

public class DigraphDFS extends DFS{

	public DigraphDFS(Graph graph) {
		super(graph);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void DFSTravel(EdgeListGraph graph,Vertex vertex)throws IllegalArgumentException  {
		vertex.setLabel(Label.VISITED);
		
		ArrayList<Edge>incidents=null;
		
		if(vertex instanceof AdjacentListVertex) {
			incidents=((DigraphAL)graph).incidentEdge(vertex);
			for(Edge edge:incidents) {
				if(edge.getLabel()==Label.UNEXPLORED) {
					AdjacentListVertex w=(AdjacentListVertex) ((DigraphAL)graph).opposite(vertex, edge);
				    if(w.getLabel()==Label.UNEXPLORED) {
				    	edge.setLabel(Label.DISCOVERY);
				    	DFSTravel(graph,w);
				    }
				    else {
				    	edge.setLabel(Label.BACK);
				    }
				
				}
			}
		}
		
	}
}
