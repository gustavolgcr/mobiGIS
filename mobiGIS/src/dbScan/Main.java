package dbScan;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Double>> listOfVertices = new ArrayList<ArrayList<Double>>();
		
		ArrayList<StreetVertex> testeVertex = new ArrayList<StreetVertex>();
		ArrayList<StreetEdge> testeEdge = new ArrayList<StreetEdge>();

		
		FileReaderGraph fileReaderGraph = new FileReaderGraph();
		fileReaderGraph.ReadFile(listOfVertices);
		
//		System.out.println(listOfVertices.size());
//		System.out.println(listOfVertices.get(2).size());
		
		
//		for (int i = 0; i < listOfVertices.size(); i++) {
//			
//			System.out.print(i);
//			
//			for (int j = 0; j < listOfVertices.get(i).size(); j++) {
//				System.out.print(" " + listOfVertices.get(i).get(j) + " ");
//			}
//			
//			System.out.println(" ");
//				
//		}
		
		PreProcessing listOfStreetVertices = new PreProcessing();
		
		
		
		testeVertex = listOfStreetVertices.vertexNormalization(listOfVertices);
		testeEdge = listOfStreetVertices.edgeNormalization(listOfVertices, testeVertex);		
		
	}
	
}
