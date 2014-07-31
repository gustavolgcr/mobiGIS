package dbScan;

import graph.Edge;
import graph.Vertex;

import java.util.ArrayList;

public class PreProcessing {

	ArrayList<Vertex> listOfVertices = new ArrayList<Vertex>();
	ArrayList<Edge> listOfEdges = new ArrayList<Edge>();
	
	int counter = 0;

	public ArrayList<Edge> edgeNormalization(ArrayList<ArrayList<Double>> rawGrafoRedeDeRuas, 
			ArrayList<Vertex> listOfVertices, ArrayList<ArrayList<Double>> rawPointsToCluster) {

		int counterEdgeID = 0;

		for(int i = 0; i < rawGrafoRedeDeRuas.size(); i++) {

			Edge edge = new Edge(0, 0, 0, 0.0);
			double p1=0.0, p2=0.0, q1=0.0, q2=0.0;

			if(rawGrafoRedeDeRuas.get(i).size() > 2) {

				counterEdgeID++;
				edge.setIndex(counterEdgeID);
				

				for(int j = 0; j < listOfVertices.size(); j++) {
					
					if(Double.compare(rawGrafoRedeDeRuas.get(i).get(0), listOfVertices.get(j).getLongitude()) == 0 && 
							Double.compare(rawGrafoRedeDeRuas.get(i).get(1), listOfVertices.get(j).getLatitude()) == 0) {

						edge.setFrom(listOfVertices.get(j).getIndex());
						p1=listOfVertices.get(j).getLatitude();
						p2=listOfVertices.get(j).getLongitude();
					}

				}

				for(int j = 0; j < listOfVertices.size(); j++) {
					//Essa comparacao esta ok!
					if(Double.compare(rawGrafoRedeDeRuas.get(i).get(2), listOfVertices.get(j).getLongitude()) == 0 && 
							Double.compare(rawGrafoRedeDeRuas.get(i).get(3), listOfVertices.get(j).getLatitude()) == 0) {

						edge.setTo(listOfVertices.get(j).getIndex());
						q1=listOfVertices.get(j).getLatitude();
						q2=listOfVertices.get(j).getLongitude();

					}

				}

			}
			
			edge.setWeight(Math.sqrt((p1-q1)*(p1-q1)+(p2-q2)*(p2-q2)));
			listOfEdges.add(edge);

		}

		int counter = listOfEdges.size();
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
				if(Double.compare(rawPointsToCluster.get(i).get(3), listOfVertices.get(j).getLatitude()) == 0 
						&& Double.compare(rawPointsToCluster.get(i).get(2), listOfVertices.get(j).getLongitude()) == 0) {

					fromOfPoint = listOfVertices.get(j).getIndex();

				}
			}

			//Comparando o TO = OK
			for(int j=0 ; j < listOfVertices.size();j++) {
				if(Double.compare(rawPointsToCluster.get(i).get(4), listOfVertices.get(j).getLongitude()) == 0 
						&& Double.compare(rawPointsToCluster.get(i).get(5), listOfVertices.get(j).getLatitude()) == 0) {

					toOfPoint = listOfVertices.get(j).getIndex();

				}
			}

			//Comparando o MID = OK
			for(int j=0 ; j < listOfVertices.size();j++) {
				if(Double.compare(rawPointsToCluster.get(i).get(0), listOfVertices.get(j).getLongitude()) == 0 
						&& Double.compare(rawPointsToCluster.get(i).get(1), listOfVertices.get(j).getLatitude()) == 0) {

					midOfPoint = listOfVertices.get(j).getIndex();

				}
			}

			for(int j = 0 ; j < listOfEdges.size() ; j++){
				if(fromOfPoint == listOfEdges.get(j).getFrom() && toOfPoint == listOfEdges.get(j).getTo()) {

					Edge edge = new Edge(0, 0, 0, 0.0);
					edge.setIndex(counter);
					
					counter++;
					edge.setFrom(fromOfPoint);
					
					for(int k=0 ; k < listOfVertices.size();k++) {
						if(fromOfPoint == listOfVertices.get(k).getIndex()) {

							p1=listOfVertices.get(k).getLatitude();
							p2=listOfVertices.get(k).getLongitude();

						}
					}
					
					for(int k=0 ; k < listOfVertices.size();k++) {
						if(midOfPoint == listOfVertices.get(k).getIndex()) {

							q1=listOfVertices.get(k).getLatitude();
							q2=listOfVertices.get(k).getLongitude();

						}
					}
					
					edge.setTo(midOfPoint);
					edge.setWeight(Math.sqrt((p1-q1)*(p1-q1)+(p2-q2)*(p2-q2)));
					
					

					// Double check this counter
					Edge edgeAux = new Edge(0, 0, 0, 0.0);
					edgeAux.setIndex(counter);
					
					counter++;
					edgeAux.setFrom(midOfPoint);
				
					
					for(int k=0 ; k < listOfVertices.size();k++) {
						if(midOfPoint == listOfVertices.get(k).getIndex()) {

							p1=listOfVertices.get(k).getLatitude();
							p2=listOfVertices.get(k).getLongitude();

						}
					}
					
					for(int k=0 ; k < listOfVertices.size();k++) {
						if(toOfPoint == listOfVertices.get(k).getIndex()) {

							q1=listOfVertices.get(k).getLatitude();
							q2=listOfVertices.get(k).getLongitude();

						}
					}
					
					edgeAux.setTo(toOfPoint);
					edgeAux.setWeight(Math.sqrt((p1-q1)*(p1-q1)+(p2-q2)*(p2-q2)));
					

					listOfEdges.remove(j);

					listOfEdges.add(edge);
					listOfEdges.add(edgeAux);
				}
			}

		}

		return listOfEdges;

	}

	public ArrayList<Vertex> vertexNormalization(ArrayList<ArrayList<Double>> rawGrafoRedeDeRuas, 
			ArrayList<ArrayList<Double>> rawPointsToCluster) {

		for(int i = 0; i < rawGrafoRedeDeRuas.size(); i++) {

			boolean flagRepeated = false;
			Vertex vertex = new Vertex(0, 0.0, 0.0, false);

			for(int j = 0 ; j < i; j++) {

				if( Double.compare(rawGrafoRedeDeRuas.get(i).get(0), rawGrafoRedeDeRuas.get(j).get(0)) == 0 
						&& Double.compare(rawGrafoRedeDeRuas.get(i).get(1), rawGrafoRedeDeRuas.get(j).get(1)) == 0 ) {

					flagRepeated = true;

				}

			}

			if(flagRepeated == false) {

				vertex.setIndex(i);
				vertex.setLongitude(rawGrafoRedeDeRuas.get(i).get(0));
				vertex.setLatitude(rawGrafoRedeDeRuas.get(i).get(1));
				vertex.setClusterFlag(false);
				
				counter = i;

				listOfVertices.add(vertex);

			}

		}

		counter++;

		for(int i = 0 ; i < rawPointsToCluster.size(); i++) {
			
			Vertex vertex = new Vertex(0, 0.0, 0.0, false);

			vertex.setIndex(counter+i);
			vertex.setLatitude(rawPointsToCluster.get(i).get(1));
			vertex.setLongitude(rawPointsToCluster.get(i).get(0));
			vertex.setClusterFlag(true);

			listOfVertices.add(vertex);
			
		}

		return listOfVertices;

	}

}
