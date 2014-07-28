package dbScan;
import graph.Vertex;

import java.util.ArrayList;
import java.util.Iterator;

public class Utility {

//	public static ArrayList<Point> listOfVisitedPoints = new ArrayList<Point>();
	
	public static ArrayList<Vertex> listOfVisitedNodes = new ArrayList<Vertex>();

	public static double getDistance(Vertex a, Vertex b) {

		double dx = a.getX() - b.getX();
		double dy = a.getY() - b.getY();

		double distance = Math.sqrt(dx * dx + dy * dy);

		return distance;

	}

	public static ArrayList<Vertex> getNeighbours(Vertex v) {

		
		ArrayList<Vertex> neighbours = new ArrayList<Vertex>();
		
		Iterator<Vertex> vertex = DBScan.listOfVertex.iterator();

		while (vertex.hasNext()) {
			
			Vertex w = vertex.next();
			
			if (getDistance(v, w) <= DBScan.eps) {
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
	
	public static ArrayList<Point> Merge(ArrayList<Point> a, ArrayList<Point> b) {
		
		Iterator<Point> iter = b.iterator();
		while(iter.hasNext()){
			Point t = iter.next();
			if(!a.contains(t)){
				a.add(t);
			}
		}
		return a;
	}
	
	public static Boolean equalPoints(Point m , Point n) {
		if((m.getX()==n.getX())&&(m.getY()==n.getY()))
			return true;
		else
			return false;
	}	

}