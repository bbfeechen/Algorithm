package secret;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Problem Description:
//
//This is a follow up of Shortest Word Distance. The only difference is now you 
//are given the list of words and your method will be called repeatedly many times
//with different parameters. How would you optimize it?
//
//Design a class which receives a list of words in the constructor, and implements 
//a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
//
//For example,
//Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//Given word1 = "coding”, word2 = "practice”, return 3.
//Given word1 = "makes", word2 = "coding", return 1.
//
//Note:
//You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

public class Q244_Shortest_Word_Distance_II {
	public static class WordDistance {
	    private Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
	     
	    public WordDistance(String[] words) {
	        fill(words);
	    }
	     
	    private void fill(String[] words) {
	        for (int i = 0; i < words.length; i++) {
	            String word = words[i];
	            if (map.containsKey(word)) {
	                List<Integer> pos = map.get(word);
	                pos.add(i);
	                map.put(word, pos);
	            } else {
	                List<Integer> pos = new ArrayList<Integer>();
	                pos.add(i);
	                map.put(word, pos);
	            }
	        }
	    }
	 
	    public int shortest(String word1, String word2) {
	        int minDistance = Integer.MAX_VALUE;
	         
	        List<Integer> posA = map.get(word1);
	        List<Integer> posB = map.get(word2);
	         
	        for (int i : posA) {
	            for (int j : posB) {
	                minDistance = Math.min(minDistance, Math.abs(i - j));
	            }
	        }
	         
	        return minDistance;
	    }
	}

	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		WordDistance wordDistance = new WordDistance(words);
		String word1 = "practice", word2 = "coding";
		System.out.println(wordDistance.shortest(word1, word2));
		String anotherWord1 = "makes", anotherWord2 = "coding";
		System.out.println(wordDistance.shortest(anotherWord1, anotherWord2));
	}
}
