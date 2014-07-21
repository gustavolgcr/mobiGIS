package dbScan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dbScan.point;

public class fileReader {

	public static double latitudeY(double latitude) {
		return 6378137 * java.lang.Math.log(java.lang.Math
				.tan(java.lang.Math.PI / 4 + 0.5
						* java.lang.Math.toRadians(latitude)));
	}

	public static double longitudeX(double longitude) {
		return 6378137 * java.lang.Math.toRadians(longitude);
	}

	void ReadFile(ArrayList<point> listOfPoints) {

		String[] split;
		

		try {

			InputStream is = new FileInputStream("src/pointsToCluster.txt");

			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String textOfFile = br.readLine();

			while ((textOfFile = br.readLine()) != null) {

				split = textOfFile.split(",");

				point p = new point(0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

				try {
					
					p.setId(Long.parseLong(split[0]));
					
					
					
					String datestr = split[2];
					DateFormat formatter;
					Date date;
					formatter = new SimpleDateFormat("HH:mm:ss");
					date = (Date) formatter.parse(datestr);


					
					if (	date.getHours() > 18 ) {
						
						p.setClusterID(clusterID);
						p.setId(Long.parseLong(split[0]));
						p.setDate(split[1]);
						p.setTime(split[2]);
						p.setX(longitudeX(Double.parseDouble(split[3])));
						p.setY(latitudeY(Double.parseDouble(split[4])));
						p.setTimestamp(Integer.parseInt(split[5]));

						listOfPoints.add(p);
						
					}

					// System.out.println(date.getHours());
				} catch (Exception e) {
				}

				// listOfPoints.add(p);

			}

			br.close();

		} catch (IOException e) {
			System.out.println("Qual foi o erro? " + e);
		}

	}
	
}

gfndjgfdjghdfjhgdfjk
