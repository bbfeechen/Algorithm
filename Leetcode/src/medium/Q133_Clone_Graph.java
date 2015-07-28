package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Q133_Clone_Graph {
	public static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		public UndirectedGraphNode(int label) {
			this.label = label;
		}
	}
	
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        
        while(!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            int size = curr.neighbors.size();
            for(int i = 0; i < size; i++) {
                UndirectedGraphNode neighbor = curr.neighbors.get(i);
                if(!map.containsKey(neighbor)) {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, neighborCopy);
                    queue.offer(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return nodeCopy;
    }
	
	public static void main(String[] args) {

	}
}
