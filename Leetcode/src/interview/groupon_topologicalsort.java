package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class groupon_topologicalsort {
	static class DirectedGraphNode {
	    int label;
	    ArrayList<DirectedGraphNode> neighbors;
	    DirectedGraphNode(int x) { 
	    	label = x; 
	    	neighbors = new ArrayList<DirectedGraphNode>(); 
	    }
	};
	
	public static ArrayList<DirectedGraphNode> topSort(List<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1); 
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                result.add(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }

	public static void main(String[] args) {
		List<DirectedGraphNode> graph = new ArrayList<DirectedGraphNode>();
		DirectedGraphNode node0 = new DirectedGraphNode(0);
		DirectedGraphNode node1 = new DirectedGraphNode(1);
		DirectedGraphNode node2 = new DirectedGraphNode(2);
		DirectedGraphNode node3 = new DirectedGraphNode(3);
		DirectedGraphNode node4 = new DirectedGraphNode(4);
		DirectedGraphNode node5 = new DirectedGraphNode(5);
		node5.neighbors.add(node0);
		node5.neighbors.add(node2);
		node4.neighbors.add(node0);
		node4.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors.add(node1);
		graph.add(node0);
		graph.add(node1);
		graph.add(node2);
		graph.add(node3);
		graph.add(node4);
		graph.add(node5);
		ArrayList<DirectedGraphNode> result = topSort(graph);
		for(DirectedGraphNode node : result) {
			System.out.print(node.label + " ");
		}
	}
}
