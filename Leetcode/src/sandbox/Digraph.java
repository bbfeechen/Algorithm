package sandbox;

import java.util.ArrayList;
import java.util.List;

public class Digraph {
	private int V;
	private List<Integer>[] adj;
	
	public Digraph(int V) {
		this.V = V;
		adj = (List<Integer>[]) new List[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public boolean isCyclic() {
		boolean[] visited = new boolean[V];
		boolean[] recStack= new boolean[V];
		for(int i = 0; i < V; i++)
	    {
	        visited[i] = false;
	        recStack[i] = false;
	    }
	 
	    // Call the recursive helper function to detect cycle in different
	    // DFS trees
	    for(int i = 0; i < V; i++)
	        if (isCyclicUtil(i, visited, recStack))
	            return true;
	 
	    return false;
	}
	
	private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {
		if(visited[v] == false)
	    {
	        // Mark the current node as visited and part of recursion stack
	        visited[v] = true;
	        recStack[v] = true;
	 
	        // Recur for all the vertices adjacent to this vertex
	        for(int i : adj[v])
	        {
	            if ( !visited[i] && isCyclicUtil(i, visited, recStack) )
	                return true;
	            else if (recStack[i])
	                return true;
	        }
	 
	    }
	    recStack[v] = false;  // remove the vertex from recursion stack
	    return false;
	}

	public static void main(String[] args) {
		Digraph g = new Digraph(4);
	    g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    g.addEdge(3, 3);
	 
	    if(g.isCyclic()) {
	        System.out.println("Graph contains cycle");
	    } else {
	    	System.out.println("Graph doesn't contain cycle");
	    }
	}
}
