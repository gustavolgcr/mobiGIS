package dbScan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import edu.uci.ics.jung.graph.DirectedGraph;
import graph.Graph;

public class Main {

	public static void main(String[] args) {

		ArrayList<ArrayList<Double>> rawPointsToCluster = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> rawGrafoRedeDeRuas = new ArrayList<ArrayList<Double>>();
		ArrayList<StreetVertex> listOfVertices = new ArrayList<StreetVertex>();
		ArrayList<StreetEdge> listOfEdges = new ArrayList<StreetEdge>();

		PreProcessing processor = new PreProcessing();

		//Reading pointsToCluster.txt
		FileReaderPoint fileReaderPoint = new FileReaderPoint();
		fileReaderPoint.ReadFile(rawPointsToCluster);

		//Reading grafoRedeDeRuas.txt
		FileReaderGraph fileReaderGraph = new FileReaderGraph();

		fileReaderGraph.ReadFile(rawGrafoRedeDeRuas);


		//List of Vertices: VertexID Latitude Longitude ClusterFlag
		listOfVertices = processor.vertexNormalization(rawGrafoRedeDeRuas, rawPointsToCluster);

		try {

			StringBuilder storage = new StringBuilder();


			for (int j = 0; j < listOfVertices.size(); j++) {

				storage.append(String.valueOf(listOfVertices.get(j).getIndex() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfVertices.get(j).getLat() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfVertices.get(j).getLon() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfVertices.get(j).getClusterFlag() ));
				storage.append("\n");

			}

			File file = new File("/home/gustavolgcr/Desktop/listOfVertices.txt");

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(storage.toString());
			bw.close();

			System.out.println("Done creating listOfVertices.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			StringBuilder storage = new StringBuilder();


			for (int j = 0; j < listOfVertices.size(); j++) {

				storage.append(String.valueOf(listOfVertices.get(j).getIndex() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfVertices.get(j).getLon() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfVertices.get(j).getLat() ));
				storage.append("\n");

			}

			File file = new File("/home/gustavolgcr/Desktop/DataPoints.txt");

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(storage.toString());
			bw.close();

			System.out.println("Done creating DataPoints.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			StringBuilder storage = new StringBuilder();

			storage.append("1: ");
			for (int j = 0; j < listOfVertices.size(); j++) {

				if(listOfVertices.get(j).getClusterFlag()==false){
					storage.append(String.valueOf(listOfVertices.get(j).getIndex() ));
					storage.append(" ");
				}		

			}

			storage.append("\n");
			storage.append("2: ");

			for (int j = 0; j < listOfVertices.size(); j++) {

				if(listOfVertices.get(j).getClusterFlag()==true){
					storage.append(String.valueOf(listOfVertices.get(j).getIndex() ));
					storage.append(" ");
				}		

			}

			File file = new File("/home/gustavolgcr/Desktop/ClusterInfo.txt");

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(storage.toString());
			bw.close();

			System.out.println("Done creating ClusterInfo.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}

		listOfEdges = processor.edgeNormalization(rawGrafoRedeDeRuas, listOfVertices, rawPointsToCluster);

		try {

			StringBuilder storage = new StringBuilder();


			for (int j = 0; j < listOfEdges.size(); j++) {

				storage.append(String.valueOf(listOfEdges.get(j).getEdgeID() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfEdges.get(j).getFrom() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfEdges.get(j).getTo() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfEdges.get(j).getWeight() ));
				storage.append("\n");

			}

			File file = new File("/home/gustavolgcr/Desktop/listOfEdges.txt");

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(storage.toString());
			bw.close();

			System.out.println("Done creating listOfEdges.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}

		GraphBuilder graphBuilder = new GraphBuilder();

//		DirectedGraph<MyNode, MyLink> g;
//
//		g = graphBuilder.constructGraph(listOfVertices, listOfEdges);
		
		Graph g;
		
		g = graphBuilder.constructGraph2(listOfVertices, listOfEdges);
		
		System.out.println("DBScan vai comecar agora.");
		DBScan dbscan = new DBScan();
		dbscan.applyDBScan(g);
		
		for(int i = 0 ; i < dbscan.listOfResults.size() ; i++) {
			for(int j=0 ; j < dbscan.listOfResults.get(i).size() ; j++){
				System.out.println(dbscan.listOfResults.get(i).get(j));
				System.out.println("\n");
			}
			
			
		}

		try {

			StringBuilder storage = new StringBuilder();
			storage.append("List of Vertices of the graph");
			storage.append("\n");
			
			for (int j = 0; j < g.getVertices().size(); j++) {

				
				storage.append("V-");
				storage.append(String.valueOf(g.getVertices().get(j).getIndex() ));
				storage.append("[");
				storage.append(String.valueOf(g.getVertices().get(j).getLatitude() ));
				storage.append(" ");
				storage.append(String.valueOf(g.getVertices().get(j).getLongitude() ));
				storage.append(" ");
				
				if(g.getVertices().get(j).isClusterFlag() == true) {
					storage.append("Clusterizable");
					storage.append("]");
				} else {
					storage.append("NOT Clusterizable");
					storage.append("]");
				}
				
				storage.append(" ");

			}
			
			storage.append("\n");
			storage.append("List of Edges of the graph");
			storage.append("\n");
			
			for (int j = 0; j < g.getEdges().size(); j++) {
				
				storage.append("E-");
				storage.append(String.valueOf(g.getEdges().get(j).getIndex() ));
				storage.append("[");
				storage.append(String.valueOf(g.getEdges().get(j).getFrom()));
				storage.append(" ");
				storage.append(String.valueOf(g.getEdges().get(j).getTo() ));
				storage.append(" ");
				storage.append(String.valueOf(g.getEdges().get(j).getWeight() ));
				storage.append("]");
				storage.append(" ");

			}
			
//			storage.append(g.toString());
//			storage.append("\n");

			File file = new File("/home/gustavolgcr/Desktop/graphTeste.txt");

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(storage.toString());
			bw.close();

			System.out.println("Done creating graphTeste.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
