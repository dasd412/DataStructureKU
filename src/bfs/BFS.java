package bfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import graph.Edge;
import graph.Graph;
import graph.Incident;
import graph.Label;
import graph.Opposite;
import graph.Vertex;
import graph.adjacenlisttgraph.AdjacentEdgeListGraph;
import graph.adjacenlisttgraph.AdjacentListVertex;
import graph.adjacentmatrixgraph.AdjacentMatrixGraph;
import graph.adjacentmatrixgraph.MatrixVertex;

public class BFS {

	public BFS(Graph graph) {
		for(int i=0;i<graph.vertices().size();i++) {
			graph.vertices().get(i).setLabel(Label.UNEXPLORED);
		}
		for(int j=0;j<graph.edges().size();j++) {
			graph.edges().get(j).setLabel(Label.UNEXPLORED);
		}
	}
	
	public void BFSTravel(Graph graph, Vertex s)throws IllegalArgumentException {
		LinkedList<Vertex> queue=new LinkedList<Vertex>();
		queue.addLast(s);
		s.setLabel(Label.VISITED);
	
		
		
		Incident incident=null;
		
		if(s instanceof AdjacentListVertex) {
			incident=(AdjacentEdgeListGraph)graph;
		}else if(s instanceof MatrixVertex) {
			incident=(AdjacentMatrixGraph)graph;
		}else {
			throw new IllegalArgumentException("It is only for ALG and AMG");
		}
		
		
		
		while(!queue.isEmpty()) {
			
	

			while(!queue.isEmpty()) {
				
				LinkedList<Vertex> temp=new LinkedList<Vertex>();
				
				for(Vertex v:queue) {
					for(Edge e:incident.incidentEdge(v)) {
						if(e.getLabel()==Label.UNEXPLORED) {
							Vertex w=((Opposite)graph).opposite(v, e);
							if(w.getLabel()==Label.UNEXPLORED) {
								e.setLabel(Label.DISCOVERY);
								w.setLabel(Label.VISITED);
								temp.addLast(w);
							}//if
							else {
								e.setLabel(Label.CROSS);
							}
						}//if	
					}//for incident
				}// for queue
				queue.removeAll(queue);
				queue.addAll(temp);
			}

		}
	
	}
}
