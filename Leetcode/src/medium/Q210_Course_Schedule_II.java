package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Q210_Course_Schedule_II {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // BFS
        int[] inDegree = new int[numCourses];
        init(prerequisites, inDegree, graph);
        int count = bfs(inDegree, graph, result);
        return count == numCourses ? result : new int[0];

        // DFS
//        boolean[] visited = new boolean[numCourses];
//        boolean[] visiting = new boolean[numCourses];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (!dfs(i, graph, visited, visiting, stack)) {
//                return new int[0];
//            }
//        }
//        int i = 0;
//        while (!stack.isEmpty()) {
//            result[i] = stack.pop();
//            i++;
//        }
//        return result;
    }

    private static void init(int[][] prerequisites, int[] inDegree, List<List<Integer>> graph) {
        for (int[] pair : prerequisites) {
            int from = pair[1];
            int to = pair[0];
            inDegree[to]++;
            graph.get(from).add(to);
        }
    }

    private static boolean dfs(int v, List<List<Integer>> graph, boolean[] visited, boolean[] visiting, Stack<Integer> stack) {
        if (visited[v]) {
            return true;
        }
        if (visiting[v]) {
            return false;
        }
        visiting[v] = true;
        for (int neighbor : graph.get(v)) {
            if (!dfs(neighbor, graph, visited, visiting, stack)) {
                return false;
            }
        }
        visited[v] = true;
        stack.push(v);
        return true;
    }

    private static int bfs(int[] inDegree, List<List<Integer>> graph, int[] result) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int j = 0;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            result[j] = from;
            j++;
            for (int to : graph.get(from)) {
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        return j;
    }

	public static void main(String[] args) {
		int[] order = findOrder(4, new int[][] {{1,0}, {2,0}, {3,1}, {3,2}});
		for(int i : order) {
			System.out.print(i + " ");
		}
	}

}
