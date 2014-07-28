package dbScan;

import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.uci.ics.jung.graph.DirectedGraph;
import graph.Graph;
import graph.Vertex;

public class DBScan {

	public static double eps = 100;	//100 metros mas tem que converter pra graus
	public static int minPoints = 50;
	
//	public static ArrayList<Point> listOfPoints = new ArrayList<Point>();
	public static List<Vertex> listOfVertex = new ArrayList<Vertex>();
//	public static ArrayList<Point> listOfNeighbours = new ArrayList<Point>();
	public static ArrayList<Vertex> listOfNeighbours = new ArrayList<Vertex>();
	// Doubt on this "List of ArrayList"
	public static List<ArrayList<Point>> listOfResults = new ArrayList<ArrayList<Point>>();

	public static List<ArrayList<Point>> applyDBScan( Graph g ) {
		
		
		
		listOfResults.clear();
		Utility.listOfVisitedPoints.clear();

		int index = 0;

//		Starts to analyze all available points
		while (g.getVertices().size() > index) {

			Vertex v = g.getVertices().get(index);
		

//			System.out.println("Ponto 'p' analizado (" + index + "): " + p.getX() + ", " + p.getY());

			
			if (!Utility.isVisited(v)) {
				Utility.Visited(v);
				
//				Colocar um sysout aqui para verificar o listOfVisited
				
				listOfNeighbours = Utility.getNeighbours(p);
				
//				Imprime lista de visinhos do ponto 'p' que está sendo analisado
//				baseado no eps passado por parametro no inicio do código
				
//				for(int i = 0 ; i < listOfNeighbours.size() ; i++) {
//					System.out.println(listOfNeighbours.get(i).getX());
//				}

				if (listOfNeighbours.size() >= minPoints) {
					int index2 = 0;
					
					while (listOfNeighbours.size() > index2) {
						Point r = listOfNeighbours.get(index2);
						if (!Utility.isVisited(r)) {
							Utility.Visited(r);
							ArrayList<Point> listOfNeighbours2 = Utility
									.getNeighbours(r);
							if (listOfNeighbours2.size() >= minPoints) {
								listOfNeighbours = Utility.Merge(
										listOfNeighbours, listOfNeighbours2);
							}
						}

						index2++;
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
			index++;
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
				
					storage.append(String.valueOf(listOfResults.get(i).get(j).getClusterID()));
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
		
		
//		
//		for (int i = 0; i < listOfResults.size(); i++) {
//			System.out.print((i+1) + ": ");
//			for (int j = 0; j < listOfResults.get(i).size(); j++) {
//				System.out.print(listOfResults.get(i).get(j).getClusterID() + " ");
//			}
//			System.out.println("\n");
//		}
		
		
		
		return listOfResults;

	}

	public static void main(String[] args) {

		//TODO COLOCAR EM UM MAPA COM O OPENJUMP
		
		// Importing points from the "points.txt" file
		FileReader fr = new FileReader();
		fr.ReadFile(listOfPoints);

//		for (int i = 0; i < listOfPoints.size(); i++) {
//			System.out.println(i + " "
//				+ listOfPoints.get(i).getX() + " "
//					+ listOfPoints.get(i).getY());
//		}
		
		try {
			 
			StringBuilder storage = new StringBuilder();
			
			
			for (int i = 0; i < listOfPoints.size(); i++) {

				storage.append(String.valueOf(listOfPoints.get(i).getClusterID()));
				storage.append(" ");
				storage.append(String.valueOf(listOfPoints.get(i).getX()));
				storage.append(" ");
				storage.append(String.valueOf(listOfPoints.get(i).getY()));
				storage.append("\n");
				
			}
			
			File file = new File("/Users/gustavolgcr/Desktop/pontos.txt");
 
			// if file doesn't exists, then create it
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

		applyDBScan();

	}
}
