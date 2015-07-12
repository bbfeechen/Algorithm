package hard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class Q126_Word_Ladder_II {
	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ladder = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        dict.add(start);
        dict.add(end);
        
        bfs(start, end, dict, map, distance);
        
        List<String> path = new ArrayList<String>();
        dfs(start, end, map, distance, path, ladder);
        return ladder;
    }
    
    private static void bfs(String start, String end, Set<String> dict, Map<String, List<String>> map,
        Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);
        for(String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        
        while(!queue.isEmpty()) {
            String curr = queue.poll();
            List<String> nextList = expand(curr, dict);
            for(String next : nextList) {
                map.get(next).add(curr);
                if(!distance.containsKey(next)) {
                    distance.put(next, distance.get(curr) + 1);
                    queue.offer(next);
                }
            }
        }    
    }
    
    private static List<String> expand(String curr, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();
        for(int i = 0; i < curr.length(); i++) {
            for(char ch = 'a'; ch <= 'z'; ch++) {
                if(ch == curr.charAt(i)) {
                    continue;
                }
                String word = curr.substring(0, i) + ch + curr.substring(i + 1);
                if(dict.contains(word)) {
                    expansion.add(word);
                }
            }
        }
        return expansion;
    }
    
    private static void dfs(String start, String curr, Map<String, List<String>> map,
        Map<String, Integer> distance, List<String> path, List<List<String>> ladder) {
        path.add(curr);
        if(curr.equals(start)) {
            Collections.reverse(path);
            ladder.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for(String next : map.get(curr)) {
                if(distance.containsKey(next) && distance.get(curr) == distance.get(next) + 1) {
                    dfs(start, next, map, distance, path, ladder);
                }
            }
        }
        path.remove(path.size() - 1);
    }
    
	public static void main(String[] args) {
		String start = "hit", end = "cog";
		Set<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
		List<List<String>> ladders = findLadders(start, end, dict);
		for(List<String> list : ladders) {
			for(String s : list) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
}
