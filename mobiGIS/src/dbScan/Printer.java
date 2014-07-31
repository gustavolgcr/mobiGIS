package dbScan;

import graph.Edge;
import graph.Vertex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Printer {

	public void listOfVerticesPrinter(ArrayList<Vertex> listOfVertices) {

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
	}

	public void listOfEdgesPrinter (ArrayList<Edge> listOfEdges) {

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
	}

	public void dataPointsPrinter(ArrayList<Vertex> listOfVertices) {

		try {

			StringBuilder storage = new StringBuilder();


			for (int j = 0; j < listOfVertices.size(); j++) {

				storage.append(String.valueOf(listOfVertices.get(j).getIndex() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfVertices.get(j).getLongitude() ));
				storage.append(" ");
				storage.append(String.valueOf(listOfVertices.get(j).getLatitude() ));
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
	}
	public void clusterInfoPrinter (ArrayList<Vertex> listOfVertices) {
				try {
		
					StringBuilder storage = new StringBuilder();
		
					storage.append("1: ");
					for (int j = 0; j < listOfVertices.size(); j++) {
		
						if(listOfVertices.get(j).isClusterFlag()==false){
							storage.append(String.valueOf(listOfVertices.get(j).getIndex() ));
							storage.append(" ");
						}		
		
					}
		
					storage.append("\n");
					storage.append("2: ");
		
					for (int j = 0; j < listOfVertices.size(); j++) {
		
						if(listOfVertices.get(j).isClusterFlag()==true){
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
	}
}
