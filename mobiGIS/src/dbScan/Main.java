package dbScan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import edu.uci.ics.jung.graph.DirectedGraph;

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

			File file = new File("/Users/gustavolgcr/Desktop/listOfVertices.txt");

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

			File file = new File("/Users/gustavolgcr/Desktop/listOfEdges.txt");

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
	   
		DirectedGraph<MyNode, MyLink> g;
		
		g = graphBuilder.constructGraph(listOfVertices, listOfEdges);
		

		
		try {

			StringBuilder storage = new StringBuilder();

			storage.append(g.toString());
			storage.append("\n");

			File file = new File("/Users/gustavolgcr/Desktop/graph.txt");

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(storage.toString());
			bw.close();

			System.out.println("Done creating graph.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
