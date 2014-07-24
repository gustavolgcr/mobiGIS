package dbScan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReaderPoint {


	void ReadFile(ArrayList<ArrayList<Double>> rawDataPoints) {

		String[] split;

		try {
			InputStream is = new FileInputStream("src/pointsToCluster.txt");

			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String textOfFile = br.readLine();

			do {

				ArrayList<Double> vertex = new ArrayList<Double>();

				split = textOfFile.split(",");
				
				System.out.println(split[1]);
				vertex.add(Double.parseDouble(split[1]));
				System.out.println(split[2]);
				vertex.add(Double.parseDouble(split[2]));
				System.out.println(split[3]);
				vertex.add(Double.parseDouble(split[3]));
				System.out.println(split[4]);
				vertex.add(Double.parseDouble(split[4]));
				System.out.println(split[5]);
				vertex.add(Double.parseDouble(split[5]));
				System.out.println(split[6]);
				vertex.add(Double.parseDouble(split[6]));
				System.out.println(split[7]);
				vertex.add(Double.parseDouble(split[7]));
			
				

				rawDataPoints.add(vertex);

			} while ((textOfFile = br.readLine()) != null);

			br.close();

		} catch (IOException e) {
			System.out.println("Qual foi o erro? " + e);
		}

	}
}
