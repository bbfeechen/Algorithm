package sandbox;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private int V;
	private List<Integer>[] adj;
	
	public Graph(int V) {
		this.V = V;
		this.adj = new List[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src, int dst) {
		adj[src].add(dst);
		adj[dst].add(src);
	}
	
	public boolean isCyclic() {
		boolean[] visited = new boolean[V];
		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				if(isCyclicUtil(i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isCyclicUtil(int s, boolean[] visited, int parent) {
		visited[s] = true;
		Iterator<Integer> itor = adj[s].iterator();
		while(itor.hasNext()) {
			int i = itor.next();
			if(!visited[i]) {
				if(isCyclicUtil(i, visited, s)) {
					return true;
				}
			} else if(i != parent) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic()) {
            System.out.println("Graph contains cycle");
        } else { 
            System.out.println("Graph doesn't contains cycle");
        }
 
        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contains cycle");
        }
	}
}
