package graph;

import java.util.ArrayList;

public interface Incident {
	public ArrayList<Edge> incidentEdge(Vertex vertex)throws ClassCastException;
	
}
