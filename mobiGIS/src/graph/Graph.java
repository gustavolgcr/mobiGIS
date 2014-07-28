package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	List<Vertex> listOfVertices;
	List<Edge> listOfEdges;
	
	public Graph() {
		listOfVertices = new ArrayList<Vertex>();
		listOfEdges = new ArrayList<Edge>();
		
	}
	
	public void addVertex(Vertex v) {
		listOfVertices.add(v);
	}
	
	public void addEdge(Edge e) {
		listOfEdges.add(e);
	}
	
	public List<Vertex> getVertices() {
		return listOfVertices;
	}
	
	public List<Edge> getEdges() {
		return listOfEdges;
	}
	

}
