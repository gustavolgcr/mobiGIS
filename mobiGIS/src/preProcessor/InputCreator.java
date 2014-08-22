package preProcessor;

import graph.Edge;
import graph.Vertex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InputCreator {

	public static void main(String[] args) {

		ArrayList<ArrayList<Double>> rawPointsToCluster = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> rawGrafoRedeDeRuas = new ArrayList<ArrayList<Double>>();

		ArrayList<Vertex> listOfVertices = new ArrayList<Vertex>();
		ArrayList<Edge> listOfEdges = new ArrayList<Edge>();

		//Reading pointsToCluster.txt
		FileReader fileReader = new FileReader();
		fileReader.pointsToClusterReader(rawPointsToCluster);

		//Reading grafoRedeDeRuas.txt
		fileReader.grafoRedeDeRuasReader(rawGrafoRedeDeRuas);

		
		
		PreProcessing processor = new PreProcessing();
		
		//List of Vertices: VertexID Latitude Longitude ClusterFlag
		listOfVertices = processor.vertexNormalization(rawGrafoRedeDeRuas, rawPointsToCluster);

		try {

			StringBuilder storage = new StringBuilder();


			for (int j = 0; j < listOfVertices.size(); j++) {

				storage.append(String.valueOf(listOfVertices.get(j).getIndex() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfVertices.get(j).getLatitude() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfVertices.get(j).getLongitude() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfVertices.get(j).isClusterFlag() ));
				storage.append("\n");

			}

			File file = new File("src/listOfVerticesTest.txt");

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(storage.toString());
			bw.close();

			System.out.println("Done creating listOfVerticesTest.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}		


		
		listOfEdges = processor.edgeNormalization(rawGrafoRedeDeRuas, listOfVertices, rawPointsToCluster);

		try {

			StringBuilder storage = new StringBuilder();


			for (int j = 0; j < listOfEdges.size(); j++) {

				storage.append(String.valueOf(listOfEdges.get(j).getIndex() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfEdges.get(j).getFrom() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfEdges.get(j).getTo() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfEdges.get(j).getWeight() ));
				storage.append("\n");

			}

			File file = new File("src/listOfEdgesTest.txt");

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(storage.toString());
			bw.close();

			System.out.println("Done creating listOfEdgesTest.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}