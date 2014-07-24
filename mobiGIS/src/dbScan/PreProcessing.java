package dbScan;

import java.util.ArrayList;

public class PreProcessing {

	ArrayList<Point> pointsInfo = new ArrayList<Point>();
	ArrayList<StreetVertex> verticesInfo = new ArrayList<StreetVertex>();
	ArrayList<StreetEdge> edgesInfo = new ArrayList<StreetEdge>();

	public ArrayList<StreetEdge> edgeNormalization(ArrayList<ArrayList<Double>> listOfVertices, 
			ArrayList<StreetVertex> verticesInfo) {

		int counterEdgeID = 0;

		for(int i = 0; i < listOfVertices.size(); i++) {

			StreetEdge streetEdges = new StreetEdge();
			double p1=0.0, p2=0.0, q1=0.0, q2=0.0;

			if(listOfVertices.get(i).size() > 2) {

				counterEdgeID++;
				streetEdges.setEdgeID(counterEdgeID);

				for(int j = 0; j < verticesInfo.size(); j++) {

					if(Double.compare(listOfVertices.get(i).get(0), verticesInfo.get(j).getLat()) == 0 && 
							Double.compare(listOfVertices.get(i).get(1), verticesInfo.get(j).getLon()) == 0) {

						streetEdges.setFrom(verticesInfo.get(j).getIndex());
						p1=verticesInfo.get(j).getLat();
						q1=verticesInfo.get(j).getLon();
					}

				}

				for(int j = 0; j < verticesInfo.size(); j++) {

					if(Double.compare(listOfVertices.get(i).get(2), verticesInfo.get(j).getLat()) == 0 && 
							Double.compare(listOfVertices.get(i).get(3), verticesInfo.get(j).getLon()) == 0) {

						streetEdges.setTo(verticesInfo.get(j).getIndex());
						p2=verticesInfo.get(j).getLat();
						q2=verticesInfo.get(j).getLon();

					}

				}

			}

			streetEdges.setWeight(Math.sqrt((p1-q1)*(p1-q1)+(p2-q2)*(p2-q2)));

			edgesInfo.add(streetEdges);

		}

		return edgesInfo;

	}

	public ArrayList<StreetVertex> vertexNormalization(ArrayList<ArrayList<Double>> listOfVertices) {

		for(int i = 0; i < listOfVertices.size(); i++) {

			boolean flagRepeated = false;
			StreetVertex streetVertex = new StreetVertex();

			for(int j = 0 ; j < i; j++) {

				if( Double.compare(listOfVertices.get(i).get(0), listOfVertices.get(j).get(0)) == 0 
						&& Double.compare(listOfVertices.get(i).get(1), listOfVertices.get(j).get(1)) == 0 ) {

					flagRepeated = true;

				}

			}

			if(flagRepeated == false) {
				
				streetVertex.setIndex(i);
				streetVertex.setLat(listOfVertices.get(i).get(0));
				streetVertex.setLon(listOfVertices.get(i).get(1));
				streetVertex.setClusterFlag(false);
				
				verticesInfo.add(streetVertex);

			}

		}

		return verticesInfo;

	}

	public ArrayList<Point> pointNormalization(ArrayList<ArrayList<Double>> listOfPoints,  
			ArrayList<StreetVertex> verticesInfo) {
		
		return pointsInfo;
	}
}
