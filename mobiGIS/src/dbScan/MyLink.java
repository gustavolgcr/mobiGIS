package dbScan;

public class MyLink {
	
	int ID;
	double weight; // should be private for good practice
	

	public MyLink(int ID, double weight) {
		this.ID = ID;
		this.weight = weight;

	} 
	public String toString() { // Always good for debugging
		return "E"+ID;
	}

}
