package dbScan;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Double>> listOfVertices = new ArrayList<ArrayList<Double>>();
		
		FileReaderGraph fileReaderGraph = new FileReaderGraph();
		fileReaderGraph.ReadFile(listOfVertices);
		
		for (int i = 0; i < listOfVertices.size(); i++) {
		
			System.out.println(i + " " + listOfVertices.get(i).get(0) 
				+ " " + listOfVertices.get(i).get(1) 
				+ " " + listOfVertices.get(i).get(2) 
				+ " " + listOfVertices.get(i).get(3));
				
		}
		
	}
	
}
