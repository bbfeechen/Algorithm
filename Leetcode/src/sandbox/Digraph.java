package sandbox;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Digraph {
	private int V;
	private List<Integer>[] adj;
	
	public Digraph(int V) {
		this.V = V;
		this.adj = new List[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src, int dst) {
		adj[src].add(dst);
	}
	
	public void BFS(int s) {
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");
			Iterator<Integer> itor = adj[s].iterator();
			while(itor.hasNext()) {
				int n = itor.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public void DFS(int s) {
		boolean[] visited = new boolean[V];
		DFSUtil(s, visited);
	}
	
	private void DFSUtil(int s, boolean[] visited) {
		visited[s] = true;
		System.out.print(s + " ");
		
		Iterator<Integer> itor = adj[s].iterator();
		while(itor.hasNext()) {
			int n = itor.next();
			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}
	
	public boolean isCyclic() {
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		for(int i = 0; i < V; i++) {
			if(isCyclicUtil(i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isCyclicUtil(int s, boolean[] visited, boolean[] recStack) {
		if(!visited[s]) {
			visited[s] = true;
			recStack[s] = true;
			Iterator<Integer> itor = adj[s].iterator();
			while(itor.hasNext()) {
				int i = itor.next();
				if(!visited[i] && isCyclicUtil(i, visited, recStack)) {
					return true;
				} else if(recStack[i]) {
					return true;
				}
			}
		}
		recStack[s] = false;
		return false;
	}
	
	public void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	private void topologicalSortUtil(int s, boolean[] visited, Stack<Integer> stack) {
		visited[s] = true;
		Iterator<Integer> itor = adj[s].iterator();
		while(itor.hasNext()) {
			int i = itor.next();
			if(!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		stack.push(s);
	}

	public static void main(String[] args) {
//		Digraph g = new Digraph(4);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
//        System.out.println("Following is Breadth First Traversal "+
//                           "(starting from vertex 2)");
//        g.BFS(2);
//        System.out.println();
//        System.out.println("Following is Depth First Traversal "+
//                "(starting from vertex 2)");
//
//        g.DFS(2);	
		
//		g.addEdge(0, 1);
//	    g.addEdge(0, 2);
//	    g.addEdge(1, 2);
//	    g.addEdge(2, 0);
//	    g.addEdge(2, 3);
//	    g.addEdge(3, 3);
//	 
//	    if(g.isCyclic()) {
//	    	System.out.println("Graph contains cycle");
//	    } else {
//	    	System.out.println("Graph doesn't contain cycle");
//	    }
		
		Digraph g = new Digraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological " +
                           "sort of the given graph");
        g.topologicalSort();
	}
}
