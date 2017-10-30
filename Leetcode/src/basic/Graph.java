package basic;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    private int V;
    private List<Integer> adj[];

    public Graph(int V) {
        this.V = V;
        this.adj = new LinkedList[V];
        for(int i = 0; i < V ; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void print() {
        for(int v = 0; v < V; v++) {
            System.out.print("Adjacency list of vertex " + v);
            System.out.print(" head");
            for(Integer edge : adj[v]) {
                System.out.print(" -> " + edge);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.print();
    }
}
