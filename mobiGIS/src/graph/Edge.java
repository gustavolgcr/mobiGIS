package graph;

public class Edge {

	private int index, from, to;
	private double weight;
	
	public Edge(int index, int from, int to, double weight) {
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
