package basic;

import java.util.ArrayList;
import java.util.List;

public class DFS {
	private class GraphNode {
		private int label;
		private List<GraphNode> neighbors;
		private GraphNode(int label) {
			this.label = label;
			this.neighbors = new ArrayList<GraphNode>();
		}
	}
	
	public void search(GraphNode node) {
//		boolean[] visited = new boolean[numOfNodes];
		for(int i = 0; i < node.neighbors.size(); i++) {
//			if(!visited[indexOfNode]) {
//				visited[indexOfNode] = true;
				search(node.neighbors.get(i));
//			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
