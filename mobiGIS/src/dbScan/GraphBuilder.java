package dbScan;

import java.util.ArrayList;

//import edu.uci.ics.jung.algorithms.filters.KNeighborhoodFilter.EdgeType;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;

public class GraphBuilder {

	

    public DirectedGraph<MyNode, MyLink> constructGraph(ArrayList<StreetVertex> listOfVertices, ArrayList<StreetEdge> listOfEdges) {
    	
    	DirectedGraph<MyNode, MyLink> g = new DirectedSparseMultigraph<MyNode, MyLink>();
    	ArrayList<MyNode> listOfAddedVertices = new ArrayList<MyNode>();
 
    	//Adding nodes
    	for(int i = 0; i < listOfVertices.size() ; i++) {
    		MyNode n = new MyNode(listOfVertices.get(i).getIndex(), listOfVertices.get(i).getLat(), listOfVertices.get(i).getLon(), 
    				listOfVertices.get(i).getClusterFlag());
    		
    		g.addVertex(n);
    		listOfAddedVertices.add(n);
    	}
    	
   
    	
    	for(int i = 0 ; i < listOfEdges.size() ; i++) {

    		MyLink l = new MyLink(listOfEdges.get(i).getEdgeID(), listOfEdges.get(i).getWeight());
 
    		for(int j=0; j<listOfAddedVertices.size();j++){
    			if(listOfEdges.get(i).getFrom() == listOfAddedVertices.get(j).ID) {
    				for(int k=0; k<listOfAddedVertices.size();k++){
    					if(listOfEdges.get(i).getTo() == listOfAddedVertices.get(k).ID) {
    						g.addEdge(l, listOfAddedVertices.get(j), listOfAddedVertices.get(k));
    					}
    				}
    			}
    		}
    		
    	}
    	
    	return g;
    	
    }


}
