package sandbox;


public class DisjoinSet {
	class Edge {
		int src;
		int dst;
		Edge() {
			this.src = 0;
			this.dst = 0;
		}
		Edge(int src, int dst) {
			this.src = src;
			this.dst = dst;
		}
	}
	
	private int V;
	private int E;
	private Edge[] edge;
	
	public DisjoinSet(int V, int E) {
		this.V = V;
		this.E = E;
		this.edge = new Edge[E];
		for(int i = 0; i < E; i++) {
			edge[i] = new Edge();
		}
	}
	
	public int find(int[] parent, int i) {
		if(parent[i] == -1) {
			return i;
		}
		return find(parent, parent[i]);
	}
	
	public void union(int[] parent, int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}
	
	public boolean isCyclic() {
		int[] parent = new int[V];
		for(int i = 0; i < V; i++) {
			parent[i] = -1;
		}
		for(int i = 0; i < E; i++) {
			int x = find(parent, edge[i].src);
			int y = find(parent, edge[i].dst);
			if(x == y) {
				return true;
			}
			union(parent, x, y);
		}
		return false;
	}

	public static void main(String[] args) {
		DisjoinSet graph = new DisjoinSet(3,3);
		 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dst = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dst = 2;
 
        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dst = 2;
 
        if (graph.isCyclic()) {
            System.out.println( "Graph contains cycle" );
        } else {
            System.out.println( "Graph doesn't contain cycle" );
        }
	}
}
