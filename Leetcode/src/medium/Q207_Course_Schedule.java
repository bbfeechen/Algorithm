package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q207_Course_Schedule {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) {
            return true;
        }
     
        int len = prerequisites.length;

        //track visited courses
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
     
        // use the map to store what courses depend on a course 
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int[] pair: prerequisites){
            if(map.containsKey(pair[0])){
                map.get(pair[0]).add(pair[1]);
            }else{
                Set<Integer> l = new HashSet<Integer>();
                l.add(pair[1]);
                map.put(pair[0], l);
            }
        }
     
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]) {
                if(!canFinishDFS(map, visited, visiting, i)) {
                    return false;
                }
            }
        }
     
        return true;
    }
     
    private static boolean canFinishDFS(Map<Integer, Set<Integer>> map, 
    		boolean[] visited, boolean[] visiting, int i) {
        if(visiting[i]) { 
            return false;
        }
        visiting[i] = true;
        
        if(map.containsKey(i)){
            for(int j: map.get(i)){
                if(!visited[j]) {
                    if(!canFinishDFS(map, visited, visiting, j)) {
                        return false;
                    }
                }
            }
        }
        
        visiting[i] = false;
        visited[i] = true;
        return true;
    }

	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][] {{1, 0}}));
	}
}
