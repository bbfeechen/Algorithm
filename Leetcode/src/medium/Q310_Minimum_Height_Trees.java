package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q310_Minimum_Height_Trees {
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if(n <= 0) {
            return result;
        }
        if(n == 1) {
            result.add(0);
            return result;
        }
        
        Set<Integer>[] neighbors = new HashSet[n];
        Set<Integer> visited = new HashSet<Integer>();
        int[] degree = new int[n];
        for(int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            if(neighbors[v] == null) {
                neighbors[v] = new HashSet<Integer>();
            }
            if(neighbors[w] == null) {
                neighbors[w] = new HashSet<Integer>();
            }
            neighbors[v].add(w);
            neighbors[w].add(v);
            degree[v]++;
            degree[w]++;
        }
        
        List<Integer> leaves = new ArrayList<Integer>();
        for(int i = 0; i < degree.length; i++) {
            if(degree[i] == 1) {
                leaves.add(i);
            }
        }
        while(visited.size() < n - 2) {
            List<Integer> nextLevel = new ArrayList<Integer>();
            for(int i = 0; i < leaves.size(); i++) {
                int leaf = leaves.get(i);
                visited.add(leaf);
                Set<Integer> nodesNextToLeaf = neighbors[leaf];
                for(int node : nodesNextToLeaf) {
                    if(!visited.contains(node)) {
                        degree[node]--;
                        if(degree[node] == 1) {
                            nextLevel.add(node);
                        }
                    }
                }
            }
            leaves = nextLevel;
        }
        return leaves;
    }

	public static void main(String[] args) {
		int n = 6;
		int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		List<Integer> result = findMinHeightTrees(n, edges);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}
