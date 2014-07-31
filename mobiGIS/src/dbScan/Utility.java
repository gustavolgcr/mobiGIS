package dbScan;
import graph.Dijkstra;
import graph.Graph;
import graph.Vertex;
import java.util.ArrayList;
import java.util.Iterator;

public class Utility {

	public static ArrayList<Vertex> listOfVisitedNodes = new ArrayList<Vertex>();

	public static double getDistance(Vertex origin, Vertex destiny, Graph g) {
		
		Dijkstra dijkstra = new Dijkstra(g);

		
		return dijkstra.execute(origin, destiny);

	}

	public static ArrayList<Vertex> getNeighbours(Vertex v, Graph g) {

		ArrayList<Vertex> neighbours = new ArrayList<Vertex>();

		Iterator<Vertex> vertex = DBScan.listOfClusterizableVertices.iterator();

		while (vertex.hasNext()) {

			Vertex w = vertex.next();
			
			System.out.println("Vamos verificar se o vertice " + v.getIndex() + " tem como 'vizinho' o vertice " + w.getIndex());
			
			if (getDistance(v, w, g) <= DBScan.eps) {
				
				neighbours.add(w);
		
			}
		
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