package dbScan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import preProcessor.FileReader;
import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class Main {

	public static void main(String[] args) {

		ArrayList<Vertex> listOfVertices = new ArrayList<Vertex>();
		ArrayList<Edge> listOfEdges = new ArrayList<Edge>();
		FileReader reader = new FileReader();

		System.out.println("Loading 'listOfVertices' and 'listOfEdges'.");
		
		//Problema esta no listOfVertices
		listOfVertices = reader.listOfVerticesReader();
		listOfEdges = reader.listOfEdgesReader();
		
		
		
		
		
		
//		try {
//
//			StringBuilder storage = new StringBuilder();
//			storage.append("oid;Line");
//			storage.append("\n");
//
//			for (int i = 0; i < listOfEdges.size(); i++) {
//				
//				for(int j=0; j < listOfVertices.size(); j++) {
//					if(listOfEdges.get(i).getFrom() == listOfVertices.get(j).getIndex()) {
//						
//						
//						storage.append(String.valueOf(i+1));
//						storage.append(";LINESTRING(");
//						storage.append(String.valueOf(listOfVertices.get(j).getLongitude()));
//						storage.append(" ");
//						storage.append(String.valueOf(listOfVertices.get(j).getLatitude()));
//						storage.append(", ");
//						break;
//					}
//				}
//				
//				for(int j=0; j < listOfVertices.size(); j++) {
//					if(listOfEdges.get(i).getTo() == listOfVertices.get(j).getIndex()) {
//						
//						storage.append(String.valueOf(listOfVertices.get(j).getLongitude()));
//						storage.append(" ");
//						storage.append(String.valueOf(listOfVertices.get(j).getLatitude()));
//						storage.append(")");
//						break;
//					}
//
//				}
//				storage.append("\n");
//			}
//
//			
//
//			File file = new File("src/qgisEntryEdges.txt");
//
//			// if file doesn't exists, then create it
//			if (!file.exists()) {
//
//				file.createNewFile();
//
//			}
//
//			FileWriter fw = new FileWriter(file.getAbsoluteFile());
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.write(storage.toString());
//			bw.close();
//
//			System.out.println("Done qgisEntryEdges.txt");
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		System.out.println("Creating a graph with 'listOfVertices' and 'listOfEdges'.");				
		Graph g = new Graph(listOfVertices, listOfEdges);

		System.out.println("Running DBScan...");
		DBScan dbscan = new DBScan();
		dbscan.applyDBScan(g);

		for(int i = 0 ; i < dbscan.listOfResults.size() ; i++) {
			for(int j=0 ; j < dbscan.listOfResults.get(i).size() ; j++){

				System.out.println("Vertice " + dbscan.listOfResults.get(i).get(j).getIndex() + ". Latitude: " +
										dbscan.listOfResults.get(i).get(j).getLatitude() + ". Longitude: " + dbscan.listOfResults.get(i).get(j).getLongitude() + ".");
				System.out.println("\n");

			}

		}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		try {
//
//			StringBuilder storage = new StringBuilder();
//			storage.append("List of Vertices of the graph");
//			storage.append("\n");
//
//			for (int j = 0; j < g.getVertices().size(); j++) {
//
//				storage.append("V-");
//				storage.append(String.valueOf(g.getVertices().get(j).getIndex() ));
//				storage.append("[");
//				storage.append(String.valueOf(g.getVertices().get(j).getLatitude() ));
//				storage.append(" ");
//				storage.append(String.valueOf(g.getVertices().get(j).getLongitude() ));
//				storage.append(" ");
//
//				if(g.getVertices().get(j).isClusterFlag() == true) {
//
//					storage.append("Clusterizable");
//					storage.append("]");
//
//				} else {
//
//					storage.append("NOT Clusterizable");
//					storage.append("]");
//
//				}
//
//				storage.append(" ");
//
//			}
//
//			storage.append("\n");
//			storage.append("List of Edges of the graph");
//			storage.append("\n");
//
//			for (int j = 0; j < g.getEdges().size(); j++) {
//
//				storage.append("E-");
//				storage.append(String.valueOf(g.getEdges().get(j).getIndex() ));
//				storage.append("[");
//				storage.append(String.valueOf(g.getEdges().get(j).getFrom()));
//				storage.append(" ");
//				storage.append(String.valueOf(g.getEdges().get(j).getTo() ));
//				storage.append(" ");
//				storage.append(String.valueOf(g.getEdges().get(j).getWeight() ));
//				storage.append("]");
//				storage.append(" ");
//
//			}
//
//			File file = new File("/home/gustavolgcr/Desktop/graphTeste.txt");
//
//			// if file doesn't exists, then create it
//			if (!file.exists()) {
//
//				file.createNewFile();
//
//			}
//
//			FileWriter fw = new FileWriter(file.getAbsoluteFile());
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.write(storage.toString());
//			bw.close();
//
//			System.out.println("Done creating graphTeste.txt");
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

}