package dbScan;

import java.util.ArrayList;

public class PreProcessing {

	ArrayList<Point> pointsInfo = new ArrayList<Point>();
	ArrayList<StreetVertex> verticesInfo = new ArrayList<StreetVertex>();
	ArrayList<StreetEdge> edgesInfo = new ArrayList<StreetEdge>();
	
	int counter = 0;

	public ArrayList<StreetEdge> edgeNormalization(ArrayList<ArrayList<Double>> rawGrafoRedeDeRuas, 
			ArrayList<StreetVertex> listOfVertices, ArrayList<ArrayList<Double>> rawPointsToCluster) {

		int counterEdgeID = 0;

		for(int i = 0; i < rawGrafoRedeDeRuas.size(); i++) {

			StreetEdge streetEdges = new StreetEdge();
			double p1=0.0, p2=0.0, q1=0.0, q2=0.0;

			if(rawGrafoRedeDeRuas.get(i).size() > 2) {

				counterEdgeID++;
				streetEdges.setEdgeID(counterEdgeID);

				for(int j = 0; j < listOfVertices.size(); j++) {
					//Essa comparacao esta ok!
					if(Double.compare(rawGrafoRedeDeRuas.get(i).get(0), listOfVertices.get(j).getLon()) == 0 && 
							Double.compare(rawGrafoRedeDeRuas.get(i).get(1), listOfVertices.get(j).getLat()) == 0) {

						streetEdges.setFrom(listOfVertices.get(j).getIndex());
						p1=listOfVertices.get(j).getLat();
						p2=listOfVertices.get(j).getLon();
					}

				}

				for(int j = 0; j < listOfVertices.size(); j++) {
					//Essa comparacao esta ok!
					if(Double.compare(rawGrafoRedeDeRuas.get(i).get(2), listOfVertices.get(j).getLon()) == 0 && 
							Double.compare(rawGrafoRedeDeRuas.get(i).get(3), listOfVertices.get(j).getLat()) == 0) {

						streetEdges.setTo(listOfVertices.get(j).getIndex());
						q1=listOfVertices.get(j).getLat();
						q2=listOfVertices.get(j).getLon();

					}

				}

			}

			streetEdges.setWeight(Math.sqrt((p1-q1)*(p1-q1)+(p2-q2)*(p2-q2)));

			edgesInfo.add(streetEdges);

		}

		int counter = edgesInfo.size();
		int fromOfPoint = 0;
		int toOfPoint = 0;
		int midOfPoint = 0;
		double p1 = 0;
		double q1 = 0;
		double p2 = 0;
		double q2 = 0;

		for(int i=0; i < rawPointsToCluster.size();i++){

			//Comparando o FROM = OK
			for(int j=0 ; j < listOfVertices.size();j++) {
				if(Double.compare(rawPointsToCluster.get(i).get(3), listOfVertices.get(j).getLat()) == 0 
						&& Double.compare(rawPointsToCluster.get(i).get(2), listOfVertices.get(j).getLon()) == 0) {

					fromOfPoint = listOfVertices.get(j).getIndex();

				}
			}

			//Comparando o TO = OK
			for(int j=0 ; j < listOfVertices.size();j++) {
				if(Double.compare(rawPointsToCluster.get(i).get(4), listOfVertices.get(j).getLon()) == 0 
						&& Double.compare(rawPointsToCluster.get(i).get(5), listOfVertices.get(j).getLat()) == 0) {

					toOfPoint = listOfVertices.get(j).getIndex();

				}
			}

			//Comparando o MID = OK
			for(int j=0 ; j < listOfVertices.size();j++) {
				if(Double.compare(rawPointsToCluster.get(i).get(0), listOfVertices.get(j).getLon()) == 0 
						&& Double.compare(rawPointsToCluster.get(i).get(1), listOfVertices.get(j).getLat()) == 0) {

					midOfPoint = listOfVertices.get(j).getIndex();

				}
			}

			for(int j = 0 ; j < edgesInfo.size() ; j++){
				if(fromOfPoint == edgesInfo.get(j).getFrom() && toOfPoint == edgesInfo.get(j).getTo()) {

					StreetEdge streetEdges1 = new StreetEdge();
					streetEdges1.setEdgeID(counter);
					counter++;
					streetEdges1.setFrom(fromOfPoint);
					
					for(int k=0 ; k < listOfVertices.size();k++) {
						if(fromOfPoint == listOfVertices.get(k).getIndex()) {

							p1=listOfVertices.get(k).getLat();
							p2=listOfVertices.get(k).getLon();

						}
					}
					
					for(int k=0 ; k < listOfVertices.size();k++) {
						if(midOfPoint == listOfVertices.get(k).getIndex()) {

							q1=listOfVertices.get(k).getLat();
							q2=listOfVertices.get(k).getLon();

						}
					}
					
					streetEdges1.setTo(midOfPoint);
					streetEdges1.setWeight(Math.sqrt((p1-q1)*(p1-q1)+(p2-q2)*(p2-q2)));



					StreetEdge streetEdges2 = new StreetEdge();
					streetEdges2.setEdgeID(counter);
					counter++;
					streetEdges2.setFrom(midOfPoint);
					
					for(int k=0 ; k < listOfVertices.size();k++) {
						if(midOfPoint == listOfVertices.get(k).getIndex()) {

							p1=listOfVertices.get(k).getLat();
							p2=listOfVertices.get(k).getLon();

						}
					}
					
					for(int k=0 ; k < listOfVertices.size();k++) {
						if(toOfPoint == listOfVertices.get(k).getIndex()) {

							q1=listOfVertices.get(k).getLat();
							q2=listOfVertices.get(k).getLon();

						}
					}
					
					
					
					streetEdges2.setTo(toOfPoint);
					streetEdges2.setWeight(Math.sqrt((p1-q1)*(p1-q1)+(p2-q2)*(p2-q2)));

					edgesInfo.remove(j);

					edgesInfo.add(streetEdges1);
					edgesInfo.add(streetEdges2);
				}
			}

		}

		return edgesInfo;

	}

	public ArrayList<StreetVertex> vertexNormalization(ArrayList<ArrayList<Double>> rawGrafoRedeDeRuas, 
			ArrayList<ArrayList<Double>> rawPointsToCluster) {

		for(int i = 0; i < rawGrafoRedeDeRuas.size(); i++) {

			boolean flagRepeated = false;
			StreetVertex streetVertex = new StreetVertex();

			for(int j = 0 ; j < i; j++) {

				if( Double.compare(rawGrafoRedeDeRuas.get(i).get(0), rawGrafoRedeDeRuas.get(j).get(0)) == 0 
						&& Double.compare(rawGrafoRedeDeRuas.get(i).get(1), rawGrafoRedeDeRuas.get(j).get(1)) == 0 ) {

					flagRepeated = true;

				}

			}

			if(flagRepeated == false) {

				streetVertex.setIndex(i);
				streetVertex.setLon(rawGrafoRedeDeRuas.get(i).get(0));
				streetVertex.setLat(rawGrafoRedeDeRuas.get(i).get(1));
				streetVertex.setClusterFlag(false);
				
				counter = i;

				verticesInfo.add(streetVertex);

			}

		}

		counter++;

		for(int i = 0 ; i < rawPointsToCluster.size(); i++) {
			
			StreetVertex streetVertex = new StreetVertex();

			streetVertex.setIndex(counter+i);
			streetVertex.setLat(rawPointsToCluster.get(i).get(1));
			streetVertex.setLon(rawPointsToCluster.get(i).get(0));
			streetVertex.setClusterFlag(true);

			verticesInfo.add(streetVertex);
			
		}

		return verticesInfo;

	}

}
