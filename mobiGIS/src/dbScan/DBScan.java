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

	public static double eps = 100;	//100 metros mas tem que converter pra graus
	public static int minPoints = 50;

	public static List<Vertex> listOfVertex = new ArrayList<Vertex>();
	public static ArrayList<Vertex> listOfNeighbours = new ArrayList<Vertex>();
	public static List<ArrayList<Vertex>> listOfResults = new ArrayList<ArrayList<Vertex>>();

	public static List<ArrayList<Vertex>> applyDBScan( Graph g ) {

		listOfVertex = g.getVertices();

		listOfResults.clear();
		Utility.listOfVisitedNodes.clear();



		// Starts to analyze all available points
		//		while (g.getVertices().size() > index) {

		for(int i = 0; i < g.getVertices().size() ; i++) {

			if(g.getVertices().get(i).isClusterFlag() == true) {
				//TODO Os indices dos nossos vertices nao estao em sequencia. Mudar isso
				Vertex v = g.getVertices().get(i);


				//			System.out.println("Vertice 'v' analizado (" + v.getIndex() + "): " + v.getLatitude() + ", " + v.getLongitude());

				if (!Utility.isVisited(v)) {

					Utility.Visited(v);

					// Colocar um sysout aqui para verificar o listOfVisited

					listOfNeighbours = Utility.getNeighbours(v,g);

					// Imprime lista de visinhos do ponto 'p' que está sendo analisado
					// baseado no eps passado por parametro no inicio do código

					//				for(int i = 0 ; i < listOfNeighbours.size() ; i++) {
					//					System.out.println(listOfNeighbours.get(i).getX());
					//				}

					if (listOfNeighbours.size() >= minPoints) {
						

						for(int j = 0 ; j < listOfNeighbours.size() ; j++) {
						//while (listOfNeighbours.size() > index2) {
							Vertex w = listOfNeighbours.get(j);
							if (!Utility.isVisited(w)) {
								Utility.Visited(w);
								ArrayList<Vertex> listOfNeighbours2 = Utility.getNeighbours(w,g);
								if (listOfNeighbours2.size() >= minPoints) {
									listOfNeighbours = Utility.Merge(listOfNeighbours, listOfNeighbours2);
								}
							}

							
						}

						//					System.out.println("N" + listOfNeighbours.size());


						//					for (int i = 0; i < listOfResults.size(); i++) {
						//						
						//						for (int j = 0; j < listOfResults.get(i).size(); j++) {
						//							System.out.println(listOfResults.get(i).get(j).getClusterID());
						//							
						//						}
						//					}

						listOfResults.add(listOfNeighbours);

					}
				}
			}
		}

		//		for (int i = 0; i < listOfResults.size(); i++) {
		//			System.out.println("Exibindo pontos do Cluster " + i + "\n");
		//			for (int j = 0; j < listOfResults.get(i).size(); j++) {
		//				System.out.println("Cluste " + i + ". X: "
		//						+ listOfResults.get(i).get(j).getX() + " Y: "
		//						+ listOfResults.get(i).get(j).getY() + "\n");
		//			}
		//
		//		}



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

			// if file doesnt exists, then create it
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

		//		for (int i = 0; i < listOfResults.size(); i++) {
		//			System.out.print((i+1) + ": ");
		//			for (int j = 0; j < listOfResults.get(i).size(); j++) {
		//				System.out.print(listOfResults.get(i).get(j).getClusterID() + " ");
		//			}
		//			System.out.println("\n");
		//		}



		return listOfResults;

	}
}
