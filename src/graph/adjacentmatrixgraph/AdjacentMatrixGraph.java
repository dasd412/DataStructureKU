package graph.adjacentmatrixgraph;

import java.util.ArrayList;

import graph.AdjacentGraph;
import graph.Edge;
import graph.EdgeListGraph;
import graph.Incident;
import graph.Opposite;
import graph.Vertex;

public class AdjacentMatrixGraph extends EdgeListGraph implements AdjacentGraph, Incident, Opposite{

	protected MatrixEdge[][] adjacencyMatrix;
	protected int capacity=3;
	protected int matrixSize;
	
	public AdjacentMatrixGraph() {
		super();
		this.adjacencyMatrix=new MatrixEdge[capacity][capacity];
		this.matrixSize=0;
	}
	
	
	
	public MatrixVertex insertMatrixVertex(Object e) {
		if(matrixSize>=capacity) {
			capacity=capacity*2;
			MatrixEdge[][]temp=this.adjacencyMatrix;
			this.adjacencyMatrix=new MatrixEdge[capacity][capacity];

			for(int i=0;i<matrixSize;i++) {
				for(int j=0;j<matrixSize;j++) {
					this.adjacencyMatrix[i][j]=temp[i][j];
				}
			}
		}
		MatrixVertex vertex=new MatrixVertex(e,this.matrixSize);
    	vertices.add(vertex);
    	vertex.setReference(vertices.get(vertexCount));
    	this.vertexCount++;
		matrixSize++;
		
		return vertex;
	}
	
	
	
	public MatrixEdge insertMatrixEdge(Vertex origin, Vertex destination, Object e) {
		MatrixEdge edge=new MatrixEdge(e,origin, destination);
    	edges.add(edge);
    	edge.setReference(edges.get(edgeCount));
    	this.edgeCount++;
		
		int i=((MatrixVertex)origin).getIndex();
		int j=((MatrixVertex)destination).getIndex();
		
		this.adjacencyMatrix[i][j]= edge;
		this.adjacencyMatrix[j][i]= edge;
		
		return edge;
	}
	
	@Override
	public ArrayList<Edge> incidentEdge(Vertex vertex) {
		// TODO Auto-generated method stub
		ArrayList<Edge>edges=new ArrayList<>();
		int index=((MatrixVertex)vertex).getIndex();
		
		for(int i=0;i<matrixSize;i++) {
				if(this.adjacencyMatrix[index][i]!=null) {
					edges.add(this.adjacencyMatrix[index][i]);
				}
		}
		
		return edges;
	}

	@Override
	public Vertex opposite(Vertex vertex, Edge edge) {
		// TODO Auto-generated method stub
		int index=((MatrixVertex)vertex).getIndex();
		MatrixEdge matrixEdge=null;
		boolean exist=false;
		for(int i=0;i<matrixSize;i++) {
			if(this.adjacencyMatrix[index][i]!=null) {
			    matrixEdge=this.adjacencyMatrix[index][i];
			   if(matrixEdge.equals(edge)) {
				   exist=true;
				   break;
			   }
			}
		}
		
		if(exist||matrixEdge!=null) {
			Vertex origin=matrixEdge.getOrigin();
			Vertex destination=matrixEdge.getDestination();
			if(origin.equals(vertex)) {
				return destination;
			}
			else {
				return origin;
			}
		}else {
			return null;
		}
	}

	@Override
	public boolean areAdjacent(Vertex v, Vertex w) {
		// TODO Auto-generated method stub
		int i=((MatrixVertex)v).getIndex();
		int j=((MatrixVertex)w).getIndex();
		return this.adjacencyMatrix[i][j]!=null&&this.adjacencyMatrix[j][i]!=null;
	}

	@Override
	public Object removeVertex(Vertex vertex) {
		// TODO Auto-generated method stub
		Object temp=vertex.getData();
		
		int index=((MatrixVertex)vertex).getIndex();
		
		MatrixEdge edge;
		
		for(int i=0;i<this.matrixSize;i++) {
			edge=null;
			for(int j=0;j<this.matrixSize;j++) {
				if(this.adjacencyMatrix[i][j]!=null&&((i==index)||j==index)){
					edge=this.adjacencyMatrix[i][j];
					super.edges.remove(edge);
					this.adjacencyMatrix[i][j]=null;
				}
			}
		}
		
		super.vertices.remove(vertex);
		
		return temp;
	}

}
