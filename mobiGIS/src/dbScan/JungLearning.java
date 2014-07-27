//package dbScan;
//
//import java.awt.Dimension;
//
//import javax.swing.JFrame;
//
//import edu.uci.ics.jung.algorithms.layout.CircleLayout;
//import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
//import edu.uci.ics.jung.graph.DirectedSparseGraph;
//import edu.uci.ics.jung.visualization.VisualizationImageServer;
//
//public class JungLearning {
//	public static void main(String[] args) {
//		DirectedSparseGraph g = new DirectedSparseGraph();
//		g.addVertex("Vertex1");
//		g.addVertex("Vertex2");
//		g.addVertex("Vertex3");
//		g.addVertex("Vertex4");
//		g.addVertex("Vertex5");
//		g.addVertex("Vertex6");
//		g.addVertex("Vertex7");
//		g.addVertex("Vertex8");
//		g.addVertex("Vertex9");
//		g.addVertex("Vertex10");
//		g.addVertex("Vertex11");
//		g.addVertex("Vertex12");
//		g.addVertex("Vertex13");
//		g.addVertex("Vertex14");
//		g.addVertex("Vertex15");
//		g.addVertex("Vertex16");
//		g.addEdge("Edge1", "Vertex1", "Vertex2");
//		g.addEdge("Edge2", "Vertex1", "Vertex3");
//		g.addEdge("Edge3", "Vertex3", "Vertex1");
//		VisualizationImageServer vs =
//				new VisualizationImageServer(
//
//						new ISOMLayout(g), new Dimension(1024, 800));
//
//		JFrame frame = new JFrame();
//		frame.getContentPane().add(vs);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.pack();
//		frame.setVisible(true);
//	}
//}