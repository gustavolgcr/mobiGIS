package dbScan;


import java.util.ArrayList;


import java.util.List;
import graph.*;

public class GraphBuilder {

	public Graph constructGraph(ArrayList<Vertex> listOfVertices, ArrayList<Edge> listOfEdges) {
		
		Graph g = new Graph();
		List<Vertex> listOfAddedVertices = new ArrayList<Vertex>();
		
    	
    	for(int i = 0; i < listOfVertices.size() ; i++) {
    		Vertex v = new Vertex(listOfVertices.get(i).getIndex(), listOfVertices.get(i).getLatitude(), listOfVertices.get(i).getLongitude(), 
    				listOfVertices.get(i).isClusterFlag());
    		
    		g.addVertex(v);
    		
    		listOfAddedVertices.add(v);
    	}
    	
    	for(int i = 0 ; i < listOfEdges.size() ; i++) {

    		Edge e = new Edge(listOfEdges.get(i).getIndex(), listOfEdges.get(i).getFrom(), listOfEdges.get(i).getTo(), listOfEdges.get(i).getWeight());
 
    		g.addEdge(e);
    	}
		
		return g;
	}

}
