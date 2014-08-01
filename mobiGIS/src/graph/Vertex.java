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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (clusterFlag ? 1231 : 1237);
		result = prime * result + index;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (clusterFlag != other.clusterFlag)
			return false;
		if (index != other.index)
			return false;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		return true;
	} 
	
	
	
	
}
