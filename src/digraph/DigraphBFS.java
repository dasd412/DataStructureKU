package digraph;

import java.util.LinkedList;

import bfs.BFS;
import graph.Edge;
import graph.Graph;
import graph.Incident;
import graph.Label;
import graph.Opposite;
import graph.Vertex;
import graph.adjacenlisttgraph.AdjacentListVertex;


public class DigraphBFS extends BFS{

	public DigraphBFS(Graph graph) {
		super(graph);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void BFSTravel(Graph graph, Vertex s) throws IllegalArgumentException{
		LinkedList<Vertex> queue=new LinkedList<Vertex>();
		queue.addLast(s);
		s.setLabel(Label.VISITED);
	
		
		
		Incident incident=null;
		
		if(s instanceof AdjacentListVertex && graph instanceof DigraphAL) {
			incident=(DigraphAL)graph;
		}else {
			throw new IllegalArgumentException("It is only for DALG");
		}
		
		
		
		while(!queue.isEmpty()) {
			
	

			while(!queue.isEmpty()) {
				
				LinkedList<Vertex> temp=new LinkedList<Vertex>();
				
				for(Vertex v:queue) {
					for(Edge e:incident.incidentEdge(v)) {
						if(e.getLabel()==Label.UNEXPLORED) {
							Vertex w=((DigraphAL)graph).opposite(v, e);
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
