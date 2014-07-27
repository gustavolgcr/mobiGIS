//package dbScan;
//
//import java.util.ArrayList;
//import java.awt.Dimension;
//
//import javax.swing.JFrame;
//
//import edu.uci.ics.jung.algorithms.layout.CircleLayout;
//import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
//import edu.uci.ics.jung.algorithms.layout.KKLayout;
//import edu.uci.ics.jung.graph.DirectedSparseGraph;
//import edu.uci.ics.jung.visualization.VisualizationImageServer;
//
//
//public class GraphPlotter {
//
//	public void graphPlotter(ArrayList<StreetVertex> listOfVertices, ArrayList<StreetEdge>listOfEdges){
//
//		DirectedSparseGraph g = new DirectedSparseGraph();
//
//		for(int i = 0; i < listOfVertices.size(); i++) {
//
//			g.addVertex(listOfVertices.get(i).toString());
//
//		}
//
//		for(int j = 0; j<listOfEdges.size(); j++) {
//
//			System.out.println(listOfEdges.get(j).getEdgeID() + " " + listOfEdges.get(j).getFrom() + " " + listOfEdges.get(j).getTo());
//
//		}
//
//		for(int j = 0; j<listOfEdges.size(); j++) {
//			g.addEdge(listOfEdges.get(j).getEdgeID(), listOfEdges.get(j).getFrom(), listOfEdges.get(j).getTo());
//		}
//
//		VisualizationImageServer vs =
//				new VisualizationImageServer(
//
//						new KKLayout(g), new Dimension(800, 800));
//
//		JFrame frame = new JFrame();
//		frame.getContentPane().add(vs);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.pack();
//		frame.setVisible(true);
//
//	}
//
//}
