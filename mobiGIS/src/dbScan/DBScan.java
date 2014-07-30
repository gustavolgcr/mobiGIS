package dbScan;

import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import edu.uci.ics.jung.graph.DirectedGraph;
import graph.Graph;
import graph.Vertex;

public class DBScan {

	public static double eps = 10;	//Isso está em graus. temos que reconsiderar
	public static int minPoints = 5;

	public static List<Vertex> listOfClusterizableVertices = new ArrayList<Vertex>();
	public static List<Vertex> listOfVertices = new ArrayList<Vertex>();
	public static ArrayList<Vertex> listOfNeighbours = new ArrayList<Vertex>();
	public static List<ArrayList<Vertex>> listOfResults = new ArrayList<ArrayList<Vertex>>();

	public static List<ArrayList<Vertex>> applyDBScan(Graph g) {

		//Do we really need this variable?
		listOfVertices = g.getVertices();


		for(int i = 0 ; i<g.getVertices().size() ; i++) {
			if(g.getVertices().get(i).isClusterFlag() == true) {
				listOfClusterizableVertices.add(g.getVertices().get(i));
			}
		}

		listOfResults.clear();
		Utility.listOfVisitedNodes.clear();

		for(int i = 0; i < listOfClusterizableVertices.size() ; i++) {

			System.out.println("\tAnalizando o vértice " + listOfClusterizableVertices.get(i).getIndex());
			Vertex v = listOfClusterizableVertices.get(i);

			if (!Utility.isVisited(v)) {

				Utility.Visited(v);

				// Give eps for getNeighbours as a parameter
				listOfNeighbours = Utility.getNeighbours(v,g);

				if (listOfNeighbours.size() >= minPoints) {


					for(int j = 0 ; j < listOfNeighbours.size() ; j++) {

						Vertex w = listOfNeighbours.get(j);
						if (!Utility.isVisited(w)) {
							Utility.Visited(w);
							ArrayList<Vertex> listOfNeighbours2 = Utility.getNeighbours(w,g);
							if (listOfNeighbours2.size() >= minPoints) {
								listOfNeighbours = Utility.Merge(listOfNeighbours, listOfNeighbours2);
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

			File file = new File("/Users/gustavolgcr/Desktop/clusters.txt");

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
