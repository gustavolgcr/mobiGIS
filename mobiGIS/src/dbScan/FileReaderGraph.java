package dbScan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class FileReaderGraph {

/*	public static double latitudeY(double latitude) {
		return 6378137 * java.lang.Math.log(java.lang.Math
				.tan(java.lang.Math.PI / 4 + 0.5
						* java.lang.Math.toRadians(latitude)));
	}

	public static double longitudeX(double longitude) {
		return 6378137 * java.lang.Math.toRadians(longitude);
	}*/

	
	ArrayList<ArrayList<Double>> listOfVertices = new ArrayList<ArrayList<Double>>();
	
	void ReadFile(ArrayList<ArrayList<Double>> listOfVertices) {

		String[] split0, split1, splitAux;
		
		try {
			InputStream is = new FileInputStream("src/grafoRedeDeRuas.txt");

			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String textOfFile = br.readLine();
			
			while ((textOfFile = br.readLine()) != null) {

				ArrayList<Double> vertex = new ArrayList<Double>();
				
				splitAux = textOfFile.split(";");
				
				split0 = splitAux[0].split(",");
				
				vertex.add(Double.parseDouble(split0[0]));
				vertex.add(Double.parseDouble(split0[1]));
				System.out.println(splitAux[0]);
				
				if(splitAux[1] != null){
									
					split1 = splitAux[1].split(",");
					
					vertex.add(Double.parseDouble(split1[0]));
					vertex.add(Double.parseDouble(split1[1]));
					System.out.println(splitAux[1]);
				} else{
					
				}
				
				
				
				System.out.println("\n\n");

				listOfVertices.add(vertex);

			}

			br.close();

		} catch (IOException e) {
			System.out.println("Qual foi o erro? " + e);
		}

	}
	
}
