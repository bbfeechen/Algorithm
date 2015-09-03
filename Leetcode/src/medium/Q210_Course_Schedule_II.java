package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q210_Course_Schedule_II {
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) {
            int[] res = new int[numCourses];
            for(int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int[] pair : prerequisites) {
            if(map.containsKey(pair[0])) {
                map.get(pair[0]).add(pair[1]);
            } else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(pair[1]);
                map.put(pair[0], set);
            }
        }
        
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<Integer> order = new ArrayList<Integer>();
        
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(!findOrderDFS(map, visited, visiting, order, i)) {
                    return new int[0];
                }
            }
        }
        
        int[] arrayOrder = new int[numCourses];
        Set<Integer> nopre = new HashSet<Integer>();
        if(order.size() < numCourses) {
            for(int i = 0; i < numCourses; i++) {
                if(!order.contains(i)) {
                    nopre.add(i);
                }
            }
        }
        order.addAll(nopre);
        for(int i = 0; i < numCourses; i++) {
            arrayOrder[i] = order.get(i);
        }
        return arrayOrder;
    }
    
    private static boolean findOrderDFS(Map<Integer, Set<Integer>> map, boolean[] visited, 
        boolean[] visiting, List<Integer> order, int i) {
        if(visiting[i]) {
            return false;
        }
        
        visiting[i] = true;
        if(map.containsKey(i)) {
            for(int j : map.get(i)) {
                if(!visited[j]) {
                    if(!findOrderDFS(map, visited, visiting, order, j)) {
                        return false;
                    }
                }
            }
        }
        visiting[i] = false;
        visited[i] = true;
        order.add(i);
        return true;
    }

	public static void main(String[] args) {
		int[] order = findOrder(4, new int[][] {{1,0}, {2,0}, {3,1}, {3,2}});
		for(int i : order) {
			System.out.print(i + " ");
		}
	}

}
