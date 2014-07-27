package dbScan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReaderGraph {
	
	void ReadFile(ArrayList<ArrayList<Double>> rawData) {

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
					vertex.add(Double.parseDouble(split0[0]));
					vertex.add(Double.parseDouble(split0[1]));

					split1 = splitAux[1].split(",");	
					vertex.add(Double.parseDouble(split1[0]));
					vertex.add(Double.parseDouble(split1[1]));

				} else {

					split0 = textOfFile.split(",");

					vertex.add(Double.parseDouble(split0[0]));
					vertex.add(Double.parseDouble(split0[1]));

				} 

				rawData.add(vertex);

			} while ((textOfFile = br.readLine()) != null);

			br.close();

		} catch (IOException e) {
			
			System.out.println("Qual foi o erro? " + e);
		
		}

	}

}
