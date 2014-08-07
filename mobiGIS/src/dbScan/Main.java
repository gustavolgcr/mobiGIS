package dbScan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class Main {

	public static void main(String[] args) {


		ArrayList<Vertex> listOfVertices = new ArrayList<Vertex>();
		ArrayList<Edge> listOfEdges = new ArrayList<Edge>();
		FileReader reader = new FileReader();

		System.out.println("Loading 'listOfVertices' and 'listOfEdges'.");
		listOfVertices = reader.listOfVerticesReader();
		listOfEdges = reader.listOfEdgesReader();

		System.out.println("Creating a graph with 'listOfVertices' and 'listOfEdges'.");				
		Graph g = new Graph(listOfVertices, listOfEdges);

		System.out.println("Running DBScan...");
		DBScan dbscan = new DBScan();
		dbscan.applyDBScan(g);

		for(int i = 0 ; i < dbscan.listOfResults.size() ; i++) {
			for(int j=0 ; j < dbscan.listOfResults.get(i).size() ; j++){

				System.out.println(dbscan.listOfResults.get(i).get(j));
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