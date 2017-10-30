package basic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Digraph {

    private int V;
    private List<Integer> adj[];

    public Digraph(int V) {
        this.V = V;
        this.adj = new LinkedList[V];
        for(int i = 0; i < V ; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void bfs(int v) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            Iterator<Integer> iterator = adj[curr].iterator();
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public void dfs(int v) {
        boolean[] visited = new boolean[V];
        dfs(v, visited);
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> iterator = adj[v].iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (!visited[next]) {
                dfs(next, visited);
            }
        }
    }

    public void topologicalSort() {
        MyStack stack = new MyStack();

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSort(i, visited, stack);

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    private void topologicalSort(int v, boolean visited[], MyStack stack) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSort(i, visited, stack);
        }

        stack.push(new Integer(v));
    }

    public void print() {
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
        Digraph g = new Digraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.print();
        System.out.println("Following is Breadth First Traversal (starting from vertex 2)");
        g.bfs(2);

        System.out.println();
        System.out.println("Following is Depth First Traversal (starting from vertex 2)");
        g.dfs(2);

        g = new Digraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println();
        System.out.println("Following is a Topological sort of the given graph");
        g.topologicalSort();
    }
}
