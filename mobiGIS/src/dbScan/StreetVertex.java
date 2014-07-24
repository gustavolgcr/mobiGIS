package dbScan;



//public class StreetVertex extends DirectedSparseVertex {
public class StreetVertex {

	private int index;
	private double lat, lon;
	private boolean clusterFlag;

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public boolean getClusterFlag() {
		return clusterFlag;
	}
	public void setClusterFlag(boolean clusterFlag) {
		this.clusterFlag = clusterFlag;
	}
	
}
