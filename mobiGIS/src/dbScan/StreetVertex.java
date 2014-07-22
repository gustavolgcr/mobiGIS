package dbScan;

import edu.uci.ics.jung.graph.impl.DirectedSparseVertex;

public class StreetVertex extends DirectedSparseVertex {
	
	private int index;
	private double lat, lon;
	
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

	

}
