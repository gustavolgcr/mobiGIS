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
				Vertex v = new Vertex(Integer.parseInt(split[0]), Double.parseDouble(split[1]), 
						Double.parseDouble(split[2]), Boolean.parseBoolean(split[3]));
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
						Integer.parseInt(split[2]), Double.parseDouble(split[2]));
				listOfEdges.add(e);

			} while ((textOfFile = br.readLine()) != null);

			br.close();

		} catch (IOException e) {

			System.out.println("Qual foi o erro? " + e);

		}
		
		return listOfEdges;
		
	}

}
