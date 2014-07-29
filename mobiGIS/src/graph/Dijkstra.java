package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

	private final List<Vertex> listOfVertices;
	private final List<Edge> listOfEdges;
	private Map<Vertex, Double> distance;
	private Map<Vertex, Vertex> predecessors;
	private Set<Vertex> settledNodes;
	private Set<Vertex> unSettledNodes;

	private final List<Vertex> S = new ArrayList<Vertex>();

	public Dijkstra(Graph graph) {
		// create a copy of the array so that we can operate on this array
		listOfVertices = new ArrayList<Vertex>(graph.getVertices());
		listOfEdges = new ArrayList<Edge>(graph.getEdges());
	}

	public double execute(Vertex origin, Vertex destiny) {

		Vertex target = destiny;
		distance = new HashMap<Vertex, Double>();
		predecessors = new HashMap<Vertex, Vertex>();
		settledNodes = new HashSet<Vertex>();
		unSettledNodes = new HashSet<Vertex>();

		double finalDistance = 0.0;

		distance.put(origin, 0.0);
		settledNodes.add(origin);

		for (int i = 0 ; i < listOfVertices.size() ; i++) {

			if(listOfVertices.get(i).getIndex() != origin.getIndex()) {
				distance.put(listOfVertices.get(i), Double.POSITIVE_INFINITY);
				predecessors.put(listOfVertices.get(i), null);

			}

			unSettledNodes.add(listOfVertices.get(i));

		}

		while(unSettledNodes.size() > 0) {

			Vertex u = getMinimum(unSettledNodes);
			unSettledNodes.remove(u);

			for (int i = 0 ; i < getNeighbors(u).size(); i++) {

				double alternative;

				Vertex v =  getNeighbors(u).get(i);

				alternative = distance.get(u) + getDistance(u, v);

				if(alternative < distance.get(v)) {

					distance.put(v, alternative);

					predecessors.put(v, u);

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

	private Vertex getMinimum(Set<Vertex> vertices) {

		Vertex minimum = null;

		for (Vertex vertex : vertices) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if ( distance.get(vertex) < distance.get(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(int d) {
		return settledNodes.contains(d);
	}

	private List<Vertex> getNeighbors(Vertex node) {

		List<Vertex> neighbors = new ArrayList<Vertex>();

		for (Edge edge : listOfEdges) {


			if (edge.getFrom() == node.getIndex() & !isSettled(edge.getTo())) {

				neighbors.add(node);

			}

		}

		return neighbors;

	}

	private double getDistance(Vertex node, Vertex target) {
		for (Edge edge : listOfEdges) {
			//System.out.println("Comparando " + edge.getFrom() + " com " + node.getIndex() + " e " + edge.getTo() + " com " + target.getIndex());
			if (edge.getFrom() == node.getIndex() && edge.getTo() == target.getIndex()) {
				return edge.getWeight();
			}  
		}
		throw new RuntimeException("Should not happen");
	}

}