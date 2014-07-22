package dbScan;

import java.util.ArrayList;

public class PreProcessing {

	ArrayList<StreetVertex> vertices = new ArrayList<StreetVertex>();

	
	public ArrayList<StreetVertex> vertexNormalization(ArrayList<ArrayList<Double>> listOfVertices){
		
		for(int i = 0; i < listOfVertices.size(); i++) {
			
			StreetVertex streetVertex = new StreetVertex();
	
			for(int j = 0 ; j < vertices.size(); j++) {
				
				if(listOfVertices.get(i).get(0) == listOfVertices.get(j).get(0) &&
						listOfVertices.get(i).get(1) == listOfVertices.get(j).get(1)) {
					
				} else {
					
					streetVertex.setIndex(i);
					streetVertex.setLat(listOfVertices.get(i).get(0));
					streetVertex.setLon(listOfVertices.get(i).get(1));
				}
				
			}
			
			vertices.add(streetVertex);
			
		}
		
		return vertices;
		
	}
	
}
