package dbScan;

import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class DBScan {

	public static double eps = 0.000001;	//Isso está em graus. temos que reconsiderar
	public static int minPoints = 20;
	public static List<Vertex> listOfClusterizableVertices = new ArrayList<Vertex>();
	public static ArrayList<Vertex> listOfNeighbours = new ArrayList<Vertex>();
	public static List<ArrayList<Vertex>> listOfResults = new ArrayList<ArrayList<Vertex>>();

	public static Map<Integer, List<Edge>> adjacencyList = new HashMap<Integer, List<Edge>>();
	
	long start, end, diff;

	public List<ArrayList<Vertex>> applyDBScan(Graph g) {

//		System.out.println("AQUIIIIIIIIIIIII");
//		System.out.println(g.getEdges().get(136505).getWeight());
		
		listOfResults.clear();
		Utility.listOfVisitedNodes.clear();
		
		//TODO Read again this adjacencyList
		// Creating the adjacencyList
		for(Vertex v : g.getVertices()){
			adjacencyList.put(v.getIndex(), new ArrayList<Edge>());
		}	
		for(Edge e : g.getEdges()){	
			List<Edge> neighbors = adjacencyList.get(e.getFrom());
			neighbors.add(e);
		}

		// Creating the listOfClusterizableVertices.
		// This list will tell us which vertex should be clusterized and which shouldn't
		for(int i = 0 ; i<g.getVertices().size() ; i++) {
			if(g.getVertices().get(i).isClusterFlag() == true) {
				listOfClusterizableVertices.add(g.getVertices().get(i));
			}
		}

		// For all vertices in the listOfClusterizableVertices, lets check if it is part of a cluster
		for(int i=0; i<listOfClusterizableVertices.size(); i++) {

			System.out.println("Analizando o vértice " + listOfClusterizableVertices.get(i).getIndex() + ".");
			Vertex v = listOfClusterizableVertices.get(i);

			if (!Utility.isVisited(v)) {
				System.out.println("Teste 1");
				Utility.Visited(v);
				System.out.println("Teste 2");
				System.out.println("Pegaremos seus vizinhos.");
				//Proxima linha esta demorando muito
				listOfNeighbours = Utility.getNeighbours(v,g);
				
				System.out.println("Lista do(s) " + listOfNeighbours.size() +" vizinhos de " + listOfClusterizableVertices.get(i).getIndex() + " encontrados:");
				for(int k=0; k<listOfNeighbours.size();k++) {
					System.out.println(listOfNeighbours.get(k).getIndex());
				}
				
				System.out.println("Teste 3");
				if (listOfNeighbours.size() >= minPoints) {
					System.out.println("Teste 4");
					for(int j=0; j<listOfNeighbours.size(); j++) {
						System.out.println("Teste 5");
						Vertex w = listOfNeighbours.get(j);
						if (!Utility.isVisited(w)) {
							System.out.println("Teste 6");
							Utility.Visited(w);
							
							//Proxima linha esta demorando muito
							ArrayList<Vertex> listOfNeighbours2 = Utility.getNeighbours(w,g);
							
							System.out.println("Teste 7");
							if (listOfNeighbours2.size() >= minPoints) {
								System.out.println("Teste 8");
								listOfNeighbours = Utility.Merge(listOfNeighbours, listOfNeighbours2);
								System.out.println("Teste 9");
							}
						}

					}

					listOfResults.add(listOfNeighbours);

				}
			}

		}

		try {

			StringBuilder storage = new StringBuilder();


			for (int i = 0; i < listOfResults.size(); i++) {
				int aux2 = i+1;

				storage.append(String.valueOf(aux2));
				storage.append(": ");

				for (int j = 0; j < listOfResults.get(i).size(); j++) {
					//This getIndex() looks weird...
					storage.append(String.valueOf( listOfResults.get(i).get(j).getIndex() ));
					storage.append(" ");

				}
				storage.append("\n");
			}

			File file = new File("/home/gustavolgcr/Desktop/clusters.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(storage.toString());
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listOfResults;

	}
}
