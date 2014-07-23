package dbScan;

import java.util.ArrayList;



public class PreProcessing {

	ArrayList<StreetVertex> vertices = new ArrayList<StreetVertex>();

	
	public ArrayList<StreetVertex> vertexNormalization(ArrayList<ArrayList<Double>> listOfVertices){

		for(int i = 0; i < listOfVertices.size(); i++) {
			
			boolean flagRepeated = false;
			StreetVertex streetVertex = new StreetVertex();
			
			for(int j = 0 ; j < i; j++) {
//				System.out.println("Comparando " + listOfVertices.get(i).get(0) + " com " + listOfVertices.get(j).get(0) + " e "
//						+ listOfVertices.get(i).get(1) + " com " + listOfVertices.get(j).get(1));
				
				if( Double.compare(listOfVertices.get(i).get(0), listOfVertices.get(j).get(0)) == 0 
						&& Double.compare(listOfVertices.get(i).get(1), listOfVertices.get(j).get(1)) == 0 ) {
					
					flagRepeated = true;
					
				}
				
			}
			
			if(flagRepeated == false){
				streetVertex.setIndex(i);
				streetVertex.setLat(listOfVertices.get(i).get(0));
				streetVertex.setLon(listOfVertices.get(i).get(1));
				vertices.add(streetVertex);
//				System.out.println("\t\tAdding vertex " + streetVertex.getIndex() + ". Latitude: " + streetVertex.getLat()
//						+ ". Longitude: " + streetVertex.getLon() + ".");
			}
			

			
		}
		
		int size = 0;
		
		size = vertices.size();
		
		System.out.println(size);
		
		return vertices;
		
	}

	
}
