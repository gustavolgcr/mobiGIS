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

	private Map<Vertex, Double> distanceTeste;


	private final List<Vertex> S = new ArrayList<Vertex>();

	public Dijkstra(Graph graph) {
		// create a copy of the array so that we can operate on this array
		listOfVertices = new ArrayList<Vertex>(graph.getVertices());
		listOfEdges = new ArrayList<Edge>(graph.getEdges());	

	}

	public Map<Vertex,Double> execute(Vertex origin) {

		

		//Vertex target = destiny;
		distance = new HashMap<Integer, Double>();

		predecessors = new HashMap<Integer, Vertex>();

		settledNodes = new HashSet<Vertex>();
		unSettledNodes = new HashSet<Vertex>();


		distanceTeste = new HashMap<Vertex, Double>();


		distance.put(origin.getIndex(), 0.0);

		// This size is equal to 70393
		for (int i = 0 ; i < listOfVertices.size() ; i++) {


			if(listOfVertices.get(i).getIndex() != origin.getIndex()) {

				if(listOfVertices.get(i).isClusterFlag() == true) {
					distance.put(listOfVertices.get(i).getIndex(), Double.POSITIVE_INFINITY);
					predecessors.put(listOfVertices.get(i).getIndex(), null);
					
					distanceTeste.put(listOfVertices.get(i), Double.POSITIVE_INFINITY);
				}

					distance.put(listOfVertices.get(i).getIndex(), Double.POSITIVE_INFINITY);
					predecessors.put(listOfVertices.get(i).getIndex(), null);

				

			}

			unSettledNodes.add(listOfVertices.get(i));

		}

//		System.out.println("Enquanto " +unSettledNodes.size()+" >0, faca:");
		while(unSettledNodes.size() > 0) {

			// Pega o primeiro vertice, que tem distancia = 0.0 Logo, e o minimo
//			System.out.println("\tPega o vertice " + getMinimum(unSettledNodes).getIndex() + "para trabalhar e coloca dentro do settledNodes.");
			Vertex u = getMinimum(unSettledNodes);
			
			settledNodes.add(u);

			unSettledNodes.remove(u);



//			System.out.println("Se " + distance.get(u.getIndex()) + " for maior do que " + DBScan.eps);
			if(distance.get(u.getIndex()) > DBScan.eps) {
				//break;

				return distanceTeste;
				
			} else {

				for (int i = 0 ; i < getNeighbors(u).size(); i++) {


					double alternative = 0.0;

					//System.out.println("alternative = " + distance.get(u.getIndex()) + " + " + getNeighbors(u).get(i).getWeight());
					alternative = distance.get(u.getIndex()) + getNeighbors(u).get(i).getWeight();

//					System.out.println("ID: " + getNeighbors(u).get(i).getIndex() + " From: " + getNeighbors(u).get(i).getFrom() + 
//							" To: " + getNeighbors(u).get(i).getTo() + " Weight: " + getNeighbors(u).get(i).getWeight());

//					System.out.println("Alternative = " + distance.get(u.getIndex()) + " + " + getNeighbors(u).get(i).getWeight());

//					System.out.println("Se " + alternative + " for maior do que " + distance.get(getNeighbors(u).get(i).getTo()));

					if(alternative < distance.get(getNeighbors(u).get(i).getTo())) {

						if(u.isClusterFlag() == true){

							
							distanceTeste.put(u, alternative);
							
//							for(int j = 0 ; j<listOfVertices.size(); j++)
//							{
//								//Refatorar
//								if(getNeighbors(u).get(i).getTo()==listOfVertices.get(j).getIndex()) {
//									
//									distanceTeste.put(listOfVertices.get(j), alternative);
//								
//								}
//							
//							}
							
						}
						
						distance.put(getNeighbors(u).get(i).getTo(), alternative);

						predecessors.put(getNeighbors(u).get(i).getTo(), u);

					}

				}
				
//				System.out.println("Teste 1");
//				while(predecessors.get(target) != null) {
//					System.out.println("Teste 2");
//					S.add(target);
//					target = predecessors.get(target);
//				}
//				System.out.println("Teste 3");

			}


		}

		return distanceTeste;
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

			neighbors.add(DBScan.adjacencyList.get( node.getIndex() ).get(i));

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