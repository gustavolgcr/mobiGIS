package dbScan;
import graph.Dijkstra;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Utility {

	public static ArrayList<Vertex> listOfVisitedNodes = new ArrayList<Vertex>();
	
	public static Map<Vertex,Double> distances = new HashMap<Vertex, Double>();

	

	public static Map<Vertex,Double> getDistance(Vertex origin,  Graph g) {
		
		Dijkstra dijkstra = new Dijkstra(g);

		
		return dijkstra.execute(origin);

	}

	public static ArrayList<Vertex> getNeighbours(Vertex v, Graph g) {

		ArrayList<Vertex> neighbours = new ArrayList<Vertex>();
		
		distances = getDistance(v, g);
		
		for (Map.Entry<Vertex, Double> entry : distances.entrySet())
		{
			//Coloquei mais uma comparacao
			if(entry.getValue() <= DBScan.eps && entry.getKey().isClusterFlag()==true) {
				
				neighbours.add(entry.getKey());
			}
			
		    //System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		
		
		
		

		return neighbours;
		
	}

	public static void Visited(Vertex v) {
		listOfVisitedNodes.add(v);
	}
	
	public static boolean isVisited(Vertex v) {
		if(listOfVisitedNodes.contains(v)) {
			return true;
		}
		else {
			return false;
		}
	} 
	
	public static ArrayList<Vertex> Merge(ArrayList<Vertex> a, ArrayList<Vertex> b) {

		Iterator<Vertex> iter = b.iterator();
		while(iter.hasNext()){
			Vertex t = iter.next();
			if(!a.contains(t)){
				a.add(t);
			}
		}
		return a;
	}

	public static Boolean equalVertices(Vertex m , Vertex n) {

		if((m.getLatitude()==n.getLatitude())&&(m.getLongitude()==n.getLongitude()))
			return true;
		else
			return false;
	}	

}