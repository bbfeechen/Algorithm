package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Q802_Find_Eventual_Safe_States {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, List<Integer>> rmap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            int[] pair = graph[i];
            if (pair.length == 0) {
                queue.add(i);
                continue;
            }
            int s = i;
            for (int e : pair) {
                if (!rmap.containsKey(e)) {
                    rmap.put(e, new ArrayList<>());
                }
                rmap.get(e).add(s);
            }
        }
        Set<Integer> result = new HashSet<>();
        boolean[] visited = new boolean[graph.length];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (rmap.containsKey(curr)) {
                for (int next : rmap.get(curr)) {
                    if (!queue.contains(next) && !visited[next]) {
                        queue.add(next);
                    }
                }
            }
            visited[curr] = true;
            result.add(curr);
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        System.out.println(eventualSafeNodes(new int[][] {{1,2}, {2,3}, {5}, {0}, {5}, {}, {}}));
    }
}
