package dbScan;

import graph.Edge;
import graph.Vertex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReader {
	
	private static double latitudeY(double latitude) {
		return 6378137 * java.lang.Math.log(java.lang.Math
				.tan(java.lang.Math.PI / 4 + 0.5
						* java.lang.Math.toRadians(latitude)));
	}

	private static double longitudeX(double longitude) {
		return 6378137 * java.lang.Math.toRadians(longitude);
	}
	
	private static double distancia(double longitudeX, double latitudeX, double longitudeY, double latitudeY) {
		
		double distancia;
		
		distancia = Math.sqrt( (longitudeY-longitudeY)*(longitudeY-longitudeY) + 
				(latitudeY-latitudeX)*(latitudeY-latitudeX));
		
		return distancia;
	}
	
	void grafoRedeDeRuasReader(ArrayList<ArrayList<Double>> rawData) {
		 
		String[] split0, split1, splitAux;

		try {
			
			InputStream is = new FileInputStream("src/grafoRedeDeRuas.txt");

			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String textOfFile = br.readLine();

			do {

				ArrayList<Double> vertex = new ArrayList<Double>();

				if (textOfFile.contains(";")) {

					splitAux = textOfFile.split(";");

					split0 = splitAux[0].split(",");
					vertex.add(longitudeX(Double.parseDouble(split0[0])));
					vertex.add(latitudeY(Double.parseDouble(split0[1])));

					split1 = splitAux[1].split(",");	
					vertex.add(longitudeX(Double.parseDouble(split1[0])));
					vertex.add(latitudeY(Double.parseDouble(split1[1])));

				} else {

					split0 = textOfFile.split(",");

					vertex.add(longitudeX(Double.parseDouble(split0[0])));
					vertex.add(latitudeY(Double.parseDouble(split0[1])));

				} 

				rawData.add(vertex);

			} while ((textOfFile = br.readLine()) != null);

			br.close();

		} catch (IOException e) {
			
			System.out.println("Qual foi o erro? " + e);
		
		}
 
 	}

	void pointsToClusterReader(ArrayList<ArrayList<Double>> rawDataPoints) {

		String[] split;

		try {

			InputStream is = new FileInputStream("src/pointsToCluster.txt");

			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String textOfFile = br.readLine();

			do {

				
				ArrayList<Double> vertex = new ArrayList<Double>();

				split = textOfFile.split(",");

				vertex.add(longitudeX(Double.parseDouble(split[1])));	//Longitude do ponto
				vertex.add(latitudeY(Double.parseDouble(split[2])));	//Latitude do ponto
				vertex.add(longitudeX(Double.parseDouble(split[3])));	//Longitude vertice origem
				vertex.add(latitudeY(Double.parseDouble(split[4])));	//Latitude vertice origem
				vertex.add(longitudeX(Double.parseDouble(split[5])));	//Longitude vertice destino
				vertex.add(latitudeY(Double.parseDouble(split[6])));	//Latitude vertice destino
				
				
				
				vertex.add(distancia( longitudeX(Double.parseDouble(split[3])), latitudeY(Double.parseDouble(split[4])),
						longitudeX(Double.parseDouble(split[5])), latitudeY(Double.parseDouble(split[6])) ));	//Distancia que o ponto está do vertice de origem

				rawDataPoints.add(vertex);

			} while ((textOfFile = br.readLine()) != null);

			br.close();

		} catch (IOException e) {

			System.out.println("Qual foi o erro? " + e);

		}

	}
	
	public ArrayList<Vertex> listOfVerticesReader() {

		String[] split;

		ArrayList<Vertex> listOfVertices = new ArrayList<Vertex>();

		try {

			InputStream is = new FileInputStream("src/listOfVertices.txt");

			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String textOfFile = br.readLine();

			do {

				split = textOfFile.split(" ");
				Vertex v = new Vertex(Integer.parseInt(split[0]), longitudeX(Double.parseDouble(split[1])), 
						latitudeY(Double.parseDouble(split[2])), Boolean.parseBoolean(split[3]));
				listOfVertices.add(v);

			} while ((textOfFile = br.readLine()) != null);

			br.close();

		} catch (IOException e) {

			System.out.println("Qual foi o erro? " + e);

		}
		
		return listOfVertices;
		
	}
	
	public ArrayList<Edge> listOfEdgesReader() {

		String[] split;

		ArrayList<Edge> listOfEdges = new ArrayList<Edge>();

		try {

			InputStream is = new FileInputStream("src/listOfEdges.txt");

			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String textOfFile = br.readLine();

			do {

				split = textOfFile.split(" ");
				Edge e = new Edge(Integer.parseInt(split[0]), Integer.parseInt(split[1]), 
						Integer.parseInt(split[2]), Double.parseDouble(split[3]));
				listOfEdges.add(e);

			} while ((textOfFile = br.readLine()) != null);

			br.close();

		} catch (IOException e) {

			System.out.println("Qual foi o erro? " + e);

		}
		
		return listOfEdges;
		
	}

}
