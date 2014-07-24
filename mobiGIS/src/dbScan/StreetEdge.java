package dbScan;

public class StreetEdge {

	int edgeID, from, to;
	double weight;
	
	public int getEdgeID() {
		return edgeID;
	}
	public void setEdgeID(int edgeID) {
		this.edgeID = edgeID;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

}
