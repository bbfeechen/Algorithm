package geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
	
	public boolean isBipartite(int[][] G, int src) {
		int V = G.length;
		int[] color = new int[V];
		for(int i = 0; i < V; i++) {
			color[i] = -1;
		}
		color[src] = 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(src);
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			for(int v = 0; v < V; v++) {
				if(G[u][v] == 1 && color[v] == -1) {
					color[v] = 1 - color[u];
					queue.add(v);
				} else if(G[u][v] == 1 && color[v] == color[u]) {
					return false;
				}
			}
		}
		return true;
	} 

	public static void main(String[] args) {
		int G[][] = {
				{0, 1, 0, 1},
	            {1, 0, 1, 0},
	            {0, 1, 0, 1},
	            {1, 0, 1, 0}
	        };
        Bipartite b = new Bipartite();
        if (b.isBipartite(G, 0)) {
           System.out.println("Yes");
        } else {
           System.out.println("No");
        }
	}

}
