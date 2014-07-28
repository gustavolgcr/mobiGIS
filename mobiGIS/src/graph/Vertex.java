package graph;

public class Vertex {

	private int index;
	private double latitude, longitude;
	private boolean clusterFlag;
	
	public Vertex(int index, double latitude, double longitude, boolean clusterFlag) {
		
		this.index = index;
		this.latitude = latitude;
		this.longitude = longitude;
		this.clusterFlag = clusterFlag;
		
	}

	// Always a good idea for debuging
	public String toString() { 
		return "V"+index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public boolean isClusterFlag() {
		return clusterFlag;
	}

	public void setClusterFlag(boolean clusterFlag) {
		this.clusterFlag = clusterFlag;
	} 
	
	
	
}
