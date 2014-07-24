package dbScan;

import java.util.ArrayList;

import java.awt.Dimension;
import javax.swing.JFrame;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;

import edu.uci.ics.jung.graph.impl.DirectedSparseGraph;

public class GraphPlotter {

	public DirectedSparseGraph graphPlotter(ArrayList<StreetVertex> listOfVertices, ArrayList<StreetEdge>listOfEdges){
		
		DirectedSparseGraph g = new DirectedSparseGraph();
		
		for(int i = 0; i < listOfVertices.size(); i++) {
			
			g.addVertex(listOfVertices.get(i));
			
		}
		
//	    g.addVertex("Vertex1");
//	    g.addVertex("Vertex2");
//	    g.addVertex("Vertex3");
//	    g.addEdge("Edge1", "Vertex1", "Vertex2");
//	    g.addEdge("Edge2", "Vertex1", "Vertex3");
//	    g.addEdge("Edge3", "Vertex3", "Vertex1");
	    VisualizationImageServer vs = new VisualizationImageServer(new CircleLayout(g), new Dimension(800, 800));
    
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(vs);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
		
		return g;
	}
	
}
