package dbScan;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<ArrayList<Double>> rawDataPoints = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> rawDataGraph = new ArrayList<ArrayList<Double>>();
		ArrayList<StreetVertex> listOfVertices = new ArrayList<StreetVertex>();
		ArrayList<StreetEdge> listOfEdges = new ArrayList<StreetEdge>();

		//Reading pointsToCluster.txt
		FileReaderPoint fileReaderPoint = new FileReaderPoint();
		fileReaderPoint.ReadFile(rawDataPoints);
		
		for(int j = 0 ; j<rawDataPoints.size() ; j++) {
			
			System.out.println(rawDataPoints.get(j).get(0) + ", " + rawDataPoints.get(j).get(1) + ", " + rawDataPoints.get(j).get(2) + ", " + 
					rawDataPoints.get(j).get(3) + ", " + rawDataPoints.get(j).get(4) + ", " + rawDataPoints.get(j).get(5) + ", " + 
					rawDataPoints.get(j).get(6));
			
		}		
		
//		FileReaderGraph fileReaderGraph = new FileReaderGraph();
//
//		fileReaderGraph.ReadFile(rawDataGraph);
//
//		PreProcessing listOfStreetVertices = new PreProcessing();	
//
//		listOfVertices = listOfStreetVertices.vertexNormalization(rawDataGraph);
//
//		listOfEdges = listOfStreetVertices.edgeNormalization(rawDataGraph, listOfVertices);
//
//		for(int i = 0 ; i < listOfEdges.size() ; i++) {
//			System.out.println("EdgeID: " + listOfEdges.get(i).getEdgeID() + ". From: " + listOfEdges.get(i).getFrom() + 
//					". To: " + listOfEdges.get(i).getTo());
//		}
//		
//		GraphPlotter g = new GraphPlotter();
//
//		g.graphPlotter(listOfVertices, listOfEdges);

	}

}
