package secret;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q269_Alien_Dictionary {
	public static String alienOrder(String[] words) {
        // step 1-- construct graph
        // step 2 -- construct order
        // step 3 -- traverse graph
         
        //Initialize graph 
        HashMap<Character, HashSet<Character>> map = new HashMap<Character, HashSet<Character>>();
        for(int i = 0; i < words.length; i++){
            //Note:We need to go through all characters, not only the first character.
            for(int j = 0; j < words[i].length(); j++){
                if(!map.containsKey(words[i].charAt(j))){
                    map.put(words[i].charAt(j), new HashSet<Character>());
                }
            }
            if(i > 0){
               order(map, words[i-1], words[i]); 
            } 
        }
        //Traverse to find Order
        return topSort(map);
    }
     
    public static String topSort(HashMap<Character, HashSet<Character>> graph){
        Queue<Character> queue = new LinkedList<Character>();
        Map<Character, Integer> indegree = new HashMap<Character, Integer>();
        StringBuilder sb = new StringBuilder();
 
        //Build indegree graph
        for(char c: graph.keySet()){
            for(char a : graph.get(c)){
                int count = indegree.containsKey(a)?indegree.get(a)+1:1;
                indegree.put(a,count);
            }
        }
        //Find the indegree zero -- smallest character
        for(char c: graph.keySet()){
            if(!indegree.containsKey(c)){
                queue.offer(c);
            }
        }
         
        while(!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);
            for(char a: graph.get(c)){
                indegree.put(a, indegree.get(a)-1);
                if(indegree.get(a) == 0){
                    queue.offer(a);
                }
            }
        }
         
        for(int a: indegree.values()){
            if(a != 0){
                return "";
            }
        }
         
        return sb.toString();
    }
     
    public static void order(HashMap<Character, HashSet<Character>> map, String prev, String curr){
        int minlength = Math.min(prev.length(), curr.length());
        for(int i = 0; i< minlength; i++){
            char p = prev.charAt(i);
            char c = curr.charAt(i);
            if(p != c){
                if(!map.get(p).contains(c)){
                    map.get(p).add(c);
                }
                break;
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
