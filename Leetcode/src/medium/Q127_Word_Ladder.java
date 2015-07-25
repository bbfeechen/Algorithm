package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q127_Word_Ladder {
	public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		wordDict.remove(beginWord);
		int length = 1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				String str = queue.poll();
				for(int j = 0; j < str.length(); j++) {
					for(char k = 'a'; k <= 'z'; k++) {
						if(str.charAt(j) == k) {
							continue;
						}
						String word = replace(str, j, k);
						if(word.equals(endWord)) {
							return length + 1;
						}
						if(wordDict.contains(word)) {
							queue.offer(word);
							wordDict.remove(word);
						}
					}
				} 
			}
			length++;
		}
		return 0;
	}
	
	private static String replace(String str, int j, char k) {
		char[] chars = str.toCharArray();
		chars[j] = k;
		return new String(chars);
	}

	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(ladderLength(start, end, dict));
	}

}
