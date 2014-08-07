package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	public static List<Vertex> listOfVertices = new ArrayList<Vertex>();
	public static List<Edge> listOfEdges = new ArrayList<Edge>();
	
	public Graph(ArrayList<Vertex> listOfVertices, ArrayList<Edge> listOfEdges) {
		
		for(int i = 0; i < listOfVertices.size() ; i++) {
			
			Vertex v = new Vertex(listOfVertices.get(i).getIndex(), listOfVertices.get(i).getLatitude(), listOfVertices.get(i).getLongitude(), listOfVertices.get(i).isClusterFlag());
    		
    		addVertex(v);
		}
		
		for(int i = 0 ; i < listOfEdges.size() ; i++) {

    		Edge e = new Edge(listOfEdges.get(i).getIndex(), listOfEdges.get(i).getFrom(), listOfEdges.get(i).getTo(), listOfEdges.get(i).getWeight());
 
    		addEdge(e);
    	}
		
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
