package dbScan;

public class MyNode {

	int ID; // good coding practice would have this as private
	double lat, lon;
	boolean clusterFlag;
	
	public MyNode(int ID, double lat, double lon, boolean clusterFlag) {
		this.ID = ID;
		this.lat = lat;
		this.lon = lon;
		this.clusterFlag = clusterFlag;
	}

	public String toString() { // Always a good idea for debuging
		return "V"+ID; // JUNG2 makes good use of these.
	} 
}
