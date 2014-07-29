package dbScan;
import graph.Graph;
import graph.Vertex;
import graph.DijkstraAlgorithm;

import java.util.ArrayList;
import java.util.Iterator;

public class Utility {
	
	public static ArrayList<Vertex> listOfVisitedNodes = new ArrayList<Vertex>();

	// WE MUST CHANGE TO THE DIJKSTRA ALGORITHM
	public static double getDistance(Vertex a, Vertex b, Graph g) {

		
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(g);
		dijkstra.execute(a);
		double distance = dijkstra.getDistance(b);

		return distance;

	}

	public static ArrayList<Vertex> getNeighbours(Vertex v, Graph g) {

		ArrayList<Vertex> neighbours = new ArrayList<Vertex>();
		
		Iterator<Vertex> vertex = DBScan.listOfVertex.iterator();

		while (vertex.hasNext()) {
			
			Vertex w = vertex.next();
			
			if (getDistance(v, w, g) <= DBScan.eps) {
				neighbours.add(w);
			}
		}
		
		return neighbours;
	}

	//Refatorado
	public static void Visited(Vertex v) {
		listOfVisitedNodes.add(v);
	}
	
	//Refatorado
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