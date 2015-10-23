package secret;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
//word1 and word2 may be the same and they represent two individual words in the list.
//
//For example,
//
//Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//Given word1 = "makes", word2 = "coding", return 1. Given word1 = "makes", word2 = "makes", return 3.
//
//Note:
//
//You may assume word1 and word2 are both in the list.

public class Q245_Shortest_Word_Distance_III {
	public static int shortestWordDistance(List<String> list, String word1, String word2) {
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		for(int i = 0; i < list.size(); i++) {
			String word = list.get(i);
			if(!map.containsKey(word)) {
				map.put(word, new ArrayList<Integer>());
			}
			map.get(word).add(i);
		}
		
		int min = Integer.MAX_VALUE;
		List<Integer> l1 = map.get(word1);
		List<Integer> l2 = map.get(word2);
		for(int a : l1) {
			for(int b : l2) {
				int dist = Math.abs(a - b);
				min = Math.min(dist, min);
			}
		}
		return min;
	}

	public static void main(String[] args) {
		String word1 = "practice";
		String word2 = "coding";
		List<String> list = new ArrayList<String>();
		list.add("practice");
		list.add("makes");
		list.add("perfect");
		list.add("coding");
		list.add("makes");
		System.out.println(shortestWordDistance(list, word1, word2));
	}
}
