package yelp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class yelp_randomgraph {
	public static class GraphNode {
		int label;
		List<GraphNode> neighbors;
		public GraphNode(int label) {
			this.label = label;
			this.neighbors = new ArrayList<GraphNode>();
		} 
	}
	
	private Map<GraphNode, List<GraphNode>> graph = new HashMap<GraphNode, List<GraphNode>>();
	
	public static void setEdge(int from, int to) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
