package dbScan;

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

		PreProcessing processor = new PreProcessing();
		
		//Reading pointsToCluster.txt
		FileReader fileReader = new FileReader();
		fileReader.pointsToClusterReader(rawPointsToCluster);

		try {

			StringBuilder storage = new StringBuilder();

			for (int j = 0; j < rawPointsToCluster.size(); j++) {

				storage.append(String.valueOf(rawPointsToCluster.get(j).get(0) ));
				storage.append(" ");
				storage.append(String.valueOf(rawPointsToCluster.get(j).get(1) ));
				storage.append(" ");
				storage.append(String.valueOf(rawPointsToCluster.get(j).get(2) ));
				storage.append(" ");
				storage.append(String.valueOf(rawPointsToCluster.get(j).get(3) ));
				storage.append(" ");
				storage.append(String.valueOf(rawPointsToCluster.get(j).get(4) ));
				storage.append(" ");
				storage.append(String.valueOf(rawPointsToCluster.get(j).get(5) ));
				storage.append(" ");
				storage.append(String.valueOf(rawPointsToCluster.get(j).get(6) ));
				storage.append("\n");

			}

			File file = new File("src/rawPointsToCluster.txt");

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(storage.toString());
			bw.close();

			System.out.println("Done creating rawPointsToCluster.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}




		//Reading grafoRedeDeRuas.txt
		

		fileReader.grafoRedeDeRuasReader(rawGrafoRedeDeRuas);


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

			System.out.println("Done creating listOfVertices.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		try {
//
//			StringBuilder storage = new StringBuilder();
//
//
//			for (int j = 0; j < listOfVertices.size(); j++) {
//
//				storage.append(String.valueOf(listOfVertices.get(j).getIndex() ));
//				storage.append(" ");
//				storage.append(String.valueOf(listOfVertices.get(j).getLatitude() ));
//				storage.append(" ");
//				storage.append(String.valueOf(listOfVertices.get(j).getLongitude() ));
//				storage.append("\n");
//
//			}
//
//			File file = new File("/Users/gustavolgcr/Desktop/DataPoints.txt");
//
//			// if file doesn't exists, then create it
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//
//			FileWriter fw = new FileWriter(file.getAbsoluteFile());
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.write(storage.toString());
//			bw.close();
//
//			System.out.println("Done creating DataPoints.txt");
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		try {
//
//			StringBuilder storage = new StringBuilder();
//
//			storage.append("1: ");
//			for (int j = 0; j < listOfVertices.size(); j++) {
//
//				if(listOfVertices.get(j).getClusterFlag()==false){
//					storage.append(String.valueOf(listOfVertices.get(j).getIndex() ));
//					storage.append(" ");
//				}		
//
//			}
//			
//			storage.append("\n");
//			storage.append("2: ");
//			
//			for (int j = 0; j < listOfVertices.size(); j++) {
//
//				if(listOfVertices.get(j).getClusterFlag()==true){
//					storage.append(String.valueOf(listOfVertices.get(j).getIndex() ));
//					storage.append(" ");
//				}		
//
//			}
//
//			File file = new File("/Users/gustavolgcr/Desktop/ClusterInfo.txt");
//
//			// if file doesn't exists, then create it
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//
//			FileWriter fw = new FileWriter(file.getAbsoluteFile());
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.write(storage.toString());
//			bw.close();
//
//			System.out.println("Done creating ClusterInfo.txt");
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		
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

			System.out.println("Done creating listOfEdges.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}

//		GraphPlotter g = new GraphPlotter();
//
//		g.graphPlotter(listOfVertices, listOfEdges);

	}

}