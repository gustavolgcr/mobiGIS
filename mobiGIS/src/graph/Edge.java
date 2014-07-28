package graph;

public class Edge {

	private int index;
	private double from, to, weight;
	
	public Edge(int index, double from, double to, double weight) {
		this.index = index;
		this.from = from;
		this.to = to;
		this.weight = weight;

	} 
	
	// Always good for debugging
	public String toString() { // Always good for debugging
		return "E"+index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public double getFrom() {
		return from;
	}

	public void setFrom(double from) {
		this.from = from;
	}

	public double getTo() {
		return to;
	}

	public void setTo(double to) {
		this.to = to;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
