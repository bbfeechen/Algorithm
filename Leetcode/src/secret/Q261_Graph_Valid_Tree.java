package secret;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q261_Graph_Valid_Tree {
	public class Solution {
	    public boolean validTree(int n, int[][] edges) {
	         
	        // Create an adj list 
	        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
	        for (int i = 0; i < n; i++) {
	            adjList.add(new ArrayList<Integer>());
	        }
	         
	        for (int[] edge : edges) {
	            adjList.get(edge[1]).add(edge[0]);
	            adjList.get(edge[0]).add(edge[1]);
	        }
	         
	        boolean[] visited = new boolean[n];
	         
	        Queue<Integer> queue = new LinkedList<Integer>();
	        queue.offer(0);
	         
	        while (!queue.isEmpty()) {
	            int vertexId = queue.poll();
	             
	            if (visited[vertexId]) {
	                return false;
	            }
	             
	            visited[vertexId] = true;
	             
	            for (int neighbor : adjList.get(vertexId)) {
	                if (!visited[neighbor]) {
	                    queue.offer(neighbor);
	                }
	            }
	        }
	         
	        // Check the islands
	        for (boolean v : visited) {
	            if (!v) {
	                return false;
	            }
	        }
	         
	        return true;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
