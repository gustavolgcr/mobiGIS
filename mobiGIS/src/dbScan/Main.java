package dbScan;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Double>> rawData = new ArrayList<ArrayList<Double>>();
		
		ArrayList<StreetVertex> listOfVertices = new ArrayList<StreetVertex>();
		ArrayList<StreetEdge> listOfEdges = new ArrayList<StreetEdge>();

		
		FileReaderGraph fileReaderGraph = new FileReaderGraph();
		
		//Porque passar rawData nesse metodo ao inves de receber como retorno do mesmo?
		fileReaderGraph.ReadFile(rawData);
		
		
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
		
		
		
		listOfVertices = listOfStreetVertices.vertexNormalization(rawData);
		
		System.out.println("\tLista de vertices encontrados");
		for(int i = 0; i < listOfVertices.size(); i++) {
			
			System.out.print(listOfVertices.get(i).getIndex() + ", ");
		}
		
		
		listOfEdges = listOfStreetVertices.edgeNormalization(rawData, listOfVertices);		
		
	}
	
}
