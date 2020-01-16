package dfs;

import java.util.ArrayList;

import graph.Data;
import graph.Edge;
import graph.EdgeListGraph;
import graph.Graph;
import graph.Label;
import graph.Vertex;
import graph.adjacenlisttgraph.AdjacentEdgeListGraph;
import graph.adjacenlisttgraph.AdjacentListVertex;
import graph.adjacentmatrixgraph.AdjacentMatrixGraph;
import graph.adjacentmatrixgraph.MatrixVertex;

public class DFS {
	
	protected StackDFS vStack;
	protected StackDFS eStack;
	
	protected StackDFS cStack;
	
	public DFS(Graph graph) {
		for(int i=0;i<graph.vertices().size();i++) {
			graph.vertices().get(i).setLabel(Label.UNEXPLORED);
		}
		for(int j=0;j<graph.edges().size();j++) {
			graph.edges().get(j).setLabel(Label.UNEXPLORED);
		}
		
	}
	
	public void DFSTravel(EdgeListGraph graph,Vertex vertex)throws IllegalArgumentException  {
		vertex.setLabel(Label.VISITED);
		
		ArrayList<Edge>incidents=null;
		
		if(vertex instanceof AdjacentListVertex) {
			incidents=((AdjacentEdgeListGraph)graph).incidentEdge(vertex);
			for(Edge edge:incidents) {
				if(edge.getLabel()==Label.UNEXPLORED) {
					AdjacentListVertex w=(AdjacentListVertex) ((AdjacentEdgeListGraph)graph).opposite(vertex, edge);
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
		else if(vertex instanceof MatrixVertex) {
			incidents=((AdjacentMatrixGraph)graph).incidentEdge(vertex);
		    
			for(Edge edge:incidents) {
				if(edge.getLabel()==Label.UNEXPLORED) {
					MatrixVertex w=(MatrixVertex) ((AdjacentMatrixGraph)graph).opposite(vertex, edge);
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
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public StackDFS pathFindDFS(EdgeListGraph graph, Vertex v, Vertex z)throws IllegalArgumentException {
		this.vStack=new StackDFS();
		this.eStack=new StackDFS();

		
		pathFinding(graph, v, z);
		
		return this.cStack;
	}
	
	private void pathFinding(EdgeListGraph graph, Vertex v, Vertex z) {
		
		v.setLabel(Label.VISITED);
		vStack.push(v);
		if(v.equals(z)) {
			return;
		}
		
		if(v instanceof AdjacentListVertex) {
			
			
			for(Edge edge:((AdjacentEdgeListGraph)graph).incidentEdge(v)) {
				if(edge.getLabel()==Label.UNEXPLORED) {
					AdjacentListVertex w=(AdjacentListVertex) ((AdjacentEdgeListGraph)graph).opposite(v, edge);
					if(w.getLabel()==Label.UNEXPLORED) {
						edge.setLabel(Label.DISCOVERY);
						this.eStack.push(edge);
						pathFinding(graph, w, z);
						Data route= this.eStack.pop();
						
							System.out.println("path : "+route.getData());
						
						
					}
					else {
						edge.setLabel(Label.BACK);
					}
				}
			}
			this.vStack.pop();
			
		}
		else if(v instanceof MatrixVertex) {
			

			
			for(Edge edge:((AdjacentMatrixGraph)graph).incidentEdge(v)) {
				if(edge.getLabel()==Label.UNEXPLORED) {
					MatrixVertex w=(MatrixVertex) ((AdjacentMatrixGraph)graph).opposite(v, edge);
					if(w.getLabel()==Label.UNEXPLORED) {
						edge.setLabel(Label.DISCOVERY);
						this.eStack.push(edge);
						pathFinding(graph, w, z);
						Data route= this.eStack.pop();
					
							System.out.println("path : "+route.getData());
						
					}
					else {
						edge.setLabel(Label.BACK);
					}
				}
			}
			this.vStack.pop();
		}
	}
	
	public void cycleDFS(Graph graph, Vertex v) {
		this.cStack=new StackDFS();

		
		cycle(graph, v);
	}
	
	private void cycle(Graph graph, Vertex v) {
		v.setLabel(Label.VISITED);
		cStack.push(v);
		
if(v instanceof AdjacentListVertex) {
			
			
			for(Edge edge:((AdjacentEdgeListGraph)graph).incidentEdge(v)) {
				if(edge.getLabel()==Label.UNEXPLORED) {
					AdjacentListVertex w=(AdjacentListVertex) ((AdjacentEdgeListGraph)graph).opposite(v, edge);
					if(w.getLabel()==Label.UNEXPLORED) {
						edge.setLabel(Label.DISCOVERY);
						this.cStack.push(edge);
						cycle(graph,w);
						this.cStack.pop();
						
					}
					else {
						cStack.push(edge);
						StackDFS t=new StackDFS();
						Data o=cStack.pop();
						while(o!=null&&!o.equals(w)) {
							t.push(o);
							o=cStack.pop();
						}
						for(int i=0;i<t.size();i++) {
							System.out.println("Cycle : "+t.pop().getData());
						}
						return;
					}
				}
			}
			this.cStack.pop();
			
		}
		else if(v instanceof MatrixVertex) {
			

			
			for(Edge edge:((AdjacentMatrixGraph)graph).incidentEdge(v)) {
				if(edge.getLabel()==Label.UNEXPLORED) {
					MatrixVertex w=(MatrixVertex) ((AdjacentMatrixGraph)graph).opposite(v, edge);
					if(w.getLabel()==Label.UNEXPLORED) {
						edge.setLabel(Label.DISCOVERY);
						this.cStack.push(edge);
						cycle(graph,w);
						this.cStack.pop();
						
					}
					else {
						cStack.push(edge);
						StackDFS t=new StackDFS();
						Data o=cStack.pop();
						while(o!=null&&!o.equals(w)) {
							t.push(o);
							o=cStack.pop();
						}
						for(int i=0;i<t.size();i++) {
							System.out.println("Cycle : "+t.pop().getData());
						}
						return;
					}
				}
			}
			this.cStack.pop();
		}
	}
}
