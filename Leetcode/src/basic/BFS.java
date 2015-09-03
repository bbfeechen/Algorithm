package basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	private class GraphNode {
		private int label;
		private List<GraphNode> neighbors;
		private GraphNode(int label) {
			this.label = label;
			this.neighbors = new ArrayList<GraphNode>();
		}
	}
	
	public void search(GraphNode node) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		//boolean[] visited = new boolean[numOfNodes];
		queue.offer(node);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				GraphNode curr = queue.poll();
				for(int j = 0; j < curr.neighbors.size(); j++) {
//					if(!visited[indexOfNode]) {
//					    visited[indexOfNode] = true;
					    search(curr.neighbors.get(j));
//					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
