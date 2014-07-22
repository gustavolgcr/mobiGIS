package dbScan;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Double>> listOfVertices = new ArrayList<ArrayList<Double>>();

		
		FileReaderGraph fileReaderGraph = new FileReaderGraph();
		fileReaderGraph.ReadFile(listOfVertices);
		
		for (int i = 0; i < listOfVertices.size(); i++) {
			
			System.out.print(i);
			
			for (int j = 0; j < listOfVertices.get(i).size(); j++) {
				System.out.print(" " + listOfVertices.get(i).get(j) + " ");
			}
			
			System.out.println(" ");
				
		}
		
	}
	
}
