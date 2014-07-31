package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dbScan.DBScan;

public class Dijkstra {

	private final List<Vertex> listOfVertices;
	private final List<Edge> listOfEdges;
	private Map<Integer, Double> distance;
	private Map<Integer, Vertex> predecessors;
	private Set<Vertex> settledNodes;
	private Set<Vertex> unSettledNodes;

	private final List<Vertex> S = new ArrayList<Vertex>();

	public Dijkstra(Graph graph) {
		// create a copy of the array so that we can operate on this array
		listOfVertices = new ArrayList<Vertex>(graph.getVertices());
		listOfEdges = new ArrayList<Edge>(graph.getEdges());	
		
	}

	public double execute(Vertex origin, Vertex destiny) {

		
		//TODO mudar Vertex para Integer
		Vertex target = destiny;
		distance = new HashMap<Integer, Double>();
		//distance = new HashMap<Vertex, Double>();
		predecessors = new HashMap<Integer, Vertex>();
		//predecessors = new HashMap<Vertex, Vertex>();
		settledNodes = new HashSet<Vertex>();
		unSettledNodes = new HashSet<Vertex>();

		double finalDistance = 0.0;

		// Should I put this here?
		distance.put(origin.getIndex(), 2.0);
		//		settledNodes.add(origin);



		for (int i = 0 ; i < listOfVertices.size() ; i++) {

			if(listOfVertices.get(i).getIndex() != origin.getIndex()) {
				distance.put(listOfVertices.get(i).getIndex(), Double.POSITIVE_INFINITY);
				predecessors.put(listOfVertices.get(i).getIndex(), null);

			}

			unSettledNodes.add(listOfVertices.get(i));

		}

		while(unSettledNodes.size() > 0) {

			// The first vertex will be the 'origin', with distance == 0.0 (see line 38)
			Vertex u = getMinimum(unSettledNodes);
			settledNodes.add(u);
			unSettledNodes.remove(u);

			// 	Added this conditional
			System.out.println("Distancia " + distance.get(u.getIndex()) + " > eps " + DBScan.eps );
			if(distance.get(u.getIndex())>DBScan.eps) {
				
				System.out.println("Brecou");
				//Doubt about this
				break;
			} else {
				System.out.println("Passou");


				for (int i = 0 ; i < getNeighbors(u).size(); i++) {

					double alternative = 0.0;

					alternative = distance.get(u.getIndex()) + getNeighbors(u).get(i).getWeight();
					//alternative = distance.get(u) + getDistance(u, v);

					if(alternative < distance.get(getNeighbors(u).get(i).getTo())) {

						distance.put(getNeighbors(u).get(i).getTo(), alternative);

						predecessors.put(getNeighbors(u).get(i).getTo(), u);

					}

				}

				while(predecessors.get(target) != null) {
					S.add(target);
					target = predecessors.get(target);
				}

			}

			for (int i = 0 ; i < S.size(); i++ ) {

				finalDistance = finalDistance + distance.get(S.get(i));

			}

			return finalDistance;
		}
		//Doubt about this
		return Double.POSITIVE_INFINITY;
	}

	private Vertex getMinimum(Set<Vertex> vertices) {

		Vertex minimum = null;

		for (Vertex vertex : vertices) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if ( distance.get(vertex.getIndex()) < distance.get(minimum.getIndex())) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(int d) {
		return settledNodes.contains(d);
	}

	//TODO Refatorar
	private List<Edge> getNeighbors(Vertex node) {

		List<Edge> neighbors = new ArrayList<Edge>();

		//Vertex neighbor = null;
		
		for(int i = 0; i < DBScan.adjacencyList.get(node.getIndex()).size() ; i++) {
			
			neighbors.add(DBScan.adjacencyList.get(node.getIndex()).get(i));
			
		}

		return neighbors;

	}

	
	//TODO Refatorar
	private double getDistance(Vertex node, Vertex target) {
		
//		System.out.println("Dado " + node.getIndex() + " e " + target.getIndex() + 
//				", peso retornado é: " + DBScan.adjacencyList.get(node.getIndex()).get().getWeight());
		
		return DBScan.adjacencyList.get(node.getIndex()).get(target.getIndex()).getWeight();
		
//		for (Edge edge : listOfEdges) {
//			//System.out.println("Comparando " + edge.getFrom() + " com " + node.getIndex() + " e " + edge.getTo() + " com " + target.getIndex());
//			if (edge.getFrom() == node.getIndex() && edge.getTo() == target.getIndex()) {
//				return edge.getWeight();
//			}  
//		}
//		throw new RuntimeException("Should not happen");
	}

}